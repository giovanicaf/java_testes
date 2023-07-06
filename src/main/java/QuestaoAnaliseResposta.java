import dto.QuestaoAnalisePercentualDto;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Objects;
import java.util.Set;
import java.util.stream.Collectors;

import static org.apache.commons.lang3.ObjectUtils.isNotEmpty;

public class QuestaoAnaliseResposta {

    public static void main(String[] args) {

        List<QuestaoAnalisePercentualDto> questoes = QuestaoAnalisePercentualDto.gerarListaQuestoes()
                .stream()
                .sorted(Comparator.comparing(QuestaoAnalisePercentualDto::isQuestaoComplementar))
                .toList();

        // buscarCadeiaDeQuestaoComplementar(questoes);
//        Map<Long, List<QuestaoAnalisePercentualDto>> complementaresPorQuestaoPrincipal = buscarCadeiaDeQuestaoComplementar(questoes);
//        System.out.println(verificaPercentualSecao(complementaresPorQuestaoPrincipal));
//        System.out.println(buscarCadeiaDeQuestaoComplementar(questoes));

        System.out.println(buscarCadeiaDeQuestaoComplementarByQuestaoId(1793L, questoes));

    }

    public static List<QuestaoAnalisePercentualDto> buscarCadeiaDeQuestaoComplementarByQuestaoId(Long questaoId, List<QuestaoAnalisePercentualDto> questoesDaSecao) {
        Map<Long, List<QuestaoAnalisePercentualDto>> complementaresPorQuestaoPrincipal = buscarCadeiaDeQuestaoComplementar(questoesDaSecao);

        List<QuestaoAnalisePercentualDto> questoes = new ArrayList<>();

        for (Map.Entry<Long, List<QuestaoAnalisePercentualDto>> entrySet : complementaresPorQuestaoPrincipal.entrySet()) {
            if (Objects.equals(entrySet.getKey(), questaoId)){
                questoes = entrySet.getValue();
            }
        }
        return questoes;
    }

    public static Map<Long, List<QuestaoAnalisePercentualDto>> buscarCadeiaDeQuestaoComplementar(List<QuestaoAnalisePercentualDto> questoesDaSecao) {
        Map<Long, List<QuestaoAnalisePercentualDto>> complementaresPorQuestaoPrincipal = new HashMap<>();
        List<QuestaoAnalisePercentualDto> questoes = questoesDaSecao.stream()
                .map(e -> {
                    QuestaoAnalisePercentualDto dto = e;
                    if (!e.isQuestaoComplementar() && Objects.nonNull(e.getQuestaoComplementarId())){
                        dto.setQuestaoPrincipal(true);
                        dto.setQuestaoPrincipalId(e.getQuestaoId());
                    }
                    return dto;
                }).collect(Collectors.toList());

        Set<QuestaoAnalisePercentualDto> principais = questoesDaSecao.stream()
                .filter(QuestaoAnalisePercentualDto::isQuestaoPrincipal)
                .map(e-> {
                    QuestaoAnalisePercentualDto dto = e;
                    dto.setOrdenacao(1);
                    return dto;

                })
                .collect(Collectors.toSet());

        for (QuestaoAnalisePercentualDto questaoPrincipal : principais){

            List<QuestaoAnalisePercentualDto> questoesResultadoPorSecao = questoes.stream()
                    .filter(e -> Objects.equals(questaoPrincipal.getQuestaoId(), e.getQuestaoId()))
                    .map(e -> {
                        QuestaoAnalisePercentualDto dto = e;
                        dto.setOrdenacao(1);
                        dto.setQuestaoPrincipalId(e.getQuestaoId());
                        return dto;
                    }).collect(Collectors.toList());

            Set<Long> ids = Collections.singleton(questaoPrincipal.getQuestaoComplementarId());
            for (int i = 1; i < questoes.size()+1; i++) {

                Set<Long> finalIds = ids;
                int contador = i + 1;
                Set<QuestaoAnalisePercentualDto> questoesProximoNivel = questoes.stream()
                        .filter(e -> finalIds.contains(e.getQuestaoId()))
                        .map(e-> {
                            QuestaoAnalisePercentualDto dto = e;
                            dto.setQuestaoPrincipalId(questaoPrincipal.getQuestaoPrincipalId());
                            dto.setOrdenacao(contador);
                            return dto;
                        })
                        .collect(Collectors.toSet());

                if (isNotEmpty(questoesProximoNivel)) {
                    questoesResultadoPorSecao.addAll(questoesProximoNivel);

                    ids = questoesProximoNivel.stream()
                            .map(QuestaoAnalisePercentualDto::getQuestaoComplementarId)
                            .collect(Collectors.toSet());

                }
            }
            questoesResultadoPorSecao.sort(Collections.reverseOrder());
            complementaresPorQuestaoPrincipal.put(questaoPrincipal.getQuestaoPrincipalId(), questoesResultadoPorSecao);
        }

        return complementaresPorQuestaoPrincipal;
    }
    public static int verificaPercentualSecao(Map<Long, List<QuestaoAnalisePercentualDto>> complementaresPorQuestaoPrincipal) {

        int qtdQuestaoRespondidas = 0;
        for (Map.Entry<Long, List<QuestaoAnalisePercentualDto>> entry : complementaresPorQuestaoPrincipal.entrySet()) {
            List<QuestaoAnalisePercentualDto> questoesOrdenadas = entry.getValue();

            int totalQuestoes = Collections.max(questoesOrdenadas.stream().map(QuestaoAnalisePercentualDto::getOrdenacao).toList());

            for (int i = 1; i < totalQuestoes+1; i++) {
                int contador = i;
                boolean questaoRespondida = verificarSeQuestaoRespondida(totalQuestoes, questoesOrdenadas.stream().filter(e->e.getOrdenacao() == contador).collect(Collectors.toList()));

                if (questaoRespondida){
                    qtdQuestaoRespondidas = qtdQuestaoRespondidas + 1;
                    break;
                }
            }
        }
        return (qtdQuestaoRespondidas > 0) ? ((qtdQuestaoRespondidas * 100) / complementaresPorQuestaoPrincipal.size()) : qtdQuestaoRespondidas;
    }

    public static boolean verificarSeQuestaoRespondida(int totalQuestoes, List<QuestaoAnalisePercentualDto> questoesOrdenadas) {

        for (QuestaoAnalisePercentualDto dto : questoesOrdenadas){
            if (dto.getOrdenacao() == totalQuestoes && dto.isRespondido()){
                return true;
            }
            if (dto.isRespondido() && Objects.isNull(dto.getQuestaoComplementarId())){
                return true;
            }
        }
        return false;
    }
}
