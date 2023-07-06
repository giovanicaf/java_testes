import dto.QuestaoAnaliseRespostaDto;
import dto.QuestaoAndComplementarDto;
import dto.QuestaoRespostaDto;

import java.util.*;
import java.util.stream.Collectors;

public class QuestaoComplementar {

    public static void main(String[] args) {

        QuestaoAndComplementarDto questao01 = QuestaoAndComplementarDto.builder()
                .questaoId(1L)
                .questaoComplementarId(null)
                .build();

        QuestaoAndComplementarDto questao02 = QuestaoAndComplementarDto.builder()
                .questaoId(2L)
                .questaoComplementarId(1L)
                .build();

        QuestaoAndComplementarDto questao03 = QuestaoAndComplementarDto.builder()
                .questaoId(3L)
                .questaoComplementarId(2L)
                .build();

        QuestaoAndComplementarDto questao04 = QuestaoAndComplementarDto.builder()
                .questaoId(4L)
                .questaoComplementarId(3L)
                .build();

        QuestaoAndComplementarDto questao05 = QuestaoAndComplementarDto.builder()
                .questaoId(5L)
                .questaoComplementarId(4L)
                .build();

        QuestaoAndComplementarDto questao06 = QuestaoAndComplementarDto.builder()
                .questaoId(6L)
                .questaoComplementarId(5L)
                .build();

        QuestaoAndComplementarDto questao07 = QuestaoAndComplementarDto.builder()
                .questaoId(7L)
                .questaoComplementarId(null)
                .build();

        QuestaoAndComplementarDto questao08 = QuestaoAndComplementarDto.builder()
                .questaoId(8L)
                .questaoComplementarId(7L)
                .build();

        QuestaoAndComplementarDto questao09 = QuestaoAndComplementarDto.builder()
                .questaoId(9L)
                .questaoComplementarId(8L)
                .build();

        QuestaoAndComplementarDto questao10 = QuestaoAndComplementarDto.builder()
                .questaoId(10L)
                .questaoComplementarId(null)
                .build();

        QuestaoAndComplementarDto questao11 = QuestaoAndComplementarDto.builder()
                .questaoId(11L)
                .questaoComplementarId(null)
                .build();

        QuestaoAndComplementarDto questao12 = QuestaoAndComplementarDto.builder()
                .questaoId(12L)
                .questaoComplementarId(11L)
                .build();

        QuestaoAndComplementarDto questao13 = QuestaoAndComplementarDto.builder()
                .questaoId(13L)
                .questaoComplementarId(12L)
                .build();

        QuestaoAndComplementarDto questao14 = QuestaoAndComplementarDto.builder()
                .questaoId(14L)
                .questaoComplementarId(13L)
                .build();

        QuestaoAndComplementarDto questao15 = QuestaoAndComplementarDto.builder()
                .questaoId(15L)
                .questaoComplementarId(14L)
                .build();

        List<QuestaoAndComplementarDto> questoes = Arrays.asList(questao01, questao02, questao03, questao04, questao05, questao06, questao07, questao08, questao09, questao10,
                questao11, questao12, questao13, questao14, questao15);
//        List<QuestaoDto> questoes = Arrays.asList(questao10);

        QuestaoRespostaDto resposta01 = QuestaoRespostaDto.builder()
                .questaoId(1L)
                .respostaId(2L)
                .build();

        QuestaoRespostaDto resposta02 = QuestaoRespostaDto.builder()
                .questaoId(6L)
                .respostaId(2L)
                .build();

        QuestaoRespostaDto resposta03 = QuestaoRespostaDto.builder()
                .questaoId(10L)
                .respostaId(2L)
                .build();

        List<QuestaoRespostaDto> respostas = Arrays.asList(resposta01, resposta02, resposta03);

        //System.out.println("Verifica a última questão complementar está respondida: " + analisarQuestoes(questoes, respostas));
//        System.out.println("buscarTodasQuestoesOriginais: " + buscarTodasQuestoesOriginais(questoes));
//        System.out.println("\n\n\nbuscarQuestaoOriginal: " + buscarQuestaoOriginal(5L, questoes));
//        System.out.println("\n\n\nbuscarUltimaQuestaoComplementar: " + buscarUltimaQuestaoComplementar(10L, questoes));
//        System.out.println("\n\n\nbuscarUltimasQuestoesComplementares: " + buscarUltimasQuestoesComplementares(questoes));
        System.out.println("\n\n\nretornaAnaliseQuestoes: " + realizarAnaliseQuestoes(questoes, respostas));
    }

    public static Set<QuestaoAnaliseRespostaDto> realizarAnaliseQuestoes(List<QuestaoAndComplementarDto> questoes, List<QuestaoRespostaDto> respostas){
        Set<QuestaoAnaliseRespostaDto> listaAnaliseQuestao = new HashSet<>();
        Set<QuestaoAndComplementarDto> questoesOriginais = buscarTodasQuestoesPrincipais(questoes);

        // percorrer todas as questões e complementares
        for (QuestaoAndComplementarDto questaoOriginal : questoesOriginais) {
            QuestaoAnaliseRespostaDto analiseQuestao = new QuestaoAnaliseRespostaDto();
            analiseQuestao.setQuestaoOriginalId(questaoOriginal.getQuestaoId());

            QuestaoAndComplementarDto ultimaComplementar = buscarUltimaQuestaoComplementar(questaoOriginal.getQuestaoId(), questoes);
            analiseQuestao.setUltimaComplementarId(ultimaComplementar.getQuestaoComplementarId());

            // verificar se a questão original foi respondida
            boolean questaoOriginalRespondida = verificarQuestaoRespondida(analiseQuestao.getQuestaoOriginalId(), respostas);
            analiseQuestao.setQuestaoOriginalRespondida(questaoOriginalRespondida);

            if (Objects.nonNull(analiseQuestao.getUltimaComplementarId())) {
                // verificar se a questão original foi respondida
                boolean questaoComplementarRespondida = verificarQuestaoRespondida(analiseQuestao.getUltimaComplementarId(), respostas);
                analiseQuestao.setUltimaComplementarRespondida(questaoComplementarRespondida);
            }
            listaAnaliseQuestao.add(analiseQuestao);
        }
        return listaAnaliseQuestao;
    }

    public static Set<QuestaoAndComplementarDto> buscarTodasQuestoesPrincipais(List<QuestaoAndComplementarDto> questoes) {
        Set<QuestaoAndComplementarDto> questoesOriginais = new HashSet<>();
        for (QuestaoAndComplementarDto questao : questoes) {
            if (questao.getQuestaoComplementarId() == null) {
                questoesOriginais.add(questao);
            } else {
                QuestaoAndComplementarDto questaoPai = buscarQuestaoPrincipal(questao.getQuestaoComplementarId(), questoes);
                questoesOriginais.add(questaoPai);
            }
        }
        return questoesOriginais;
    }

    public static QuestaoAndComplementarDto buscarQuestaoPrincipal(Long questaoId, List<QuestaoAndComplementarDto> questoes) {
        QuestaoAndComplementarDto questao = questoes.stream()
                .filter(q -> q.getQuestaoId().equals(questaoId))
                .findFirst()
                .orElseThrow(() -> new IllegalArgumentException("A questão com id " + questaoId + " não existe"));

        while (questao.getQuestaoComplementarId() != null) {
            QuestaoAndComplementarDto finalQuestao = questao;
            QuestaoAndComplementarDto finalQuestao1 = questao;
            questao = questoes.stream()
                    .filter(q -> q.getQuestaoId().equals(finalQuestao.getQuestaoComplementarId()))
                    .findFirst()
                    .orElseThrow(() -> new IllegalArgumentException("A questão complementar com id " + finalQuestao1.getQuestaoComplementarId() + " não existe"));
        }

        return questao;
    }
    public static QuestaoAndComplementarDto buscarUltimaQuestaoComplementar(Long questaoOriginalId, List<QuestaoAndComplementarDto> questoes) {

        Long finalQuestaoOriginalId = questaoOriginalId;
        QuestaoAndComplementarDto questaoOriginal = questoes.stream()
                .filter(q -> q.getQuestaoId().equals(finalQuestaoOriginalId))
                .findFirst()
                .orElseThrow(() -> new IllegalArgumentException("A questão original com id " + finalQuestaoOriginalId + " não existe"));

        List<Long> complementares = questoes.stream()
                .filter(q -> q.getQuestaoComplementarId() != null)
                .filter(q -> q.getQuestaoComplementarId().equals(finalQuestaoOriginalId))
                .map(QuestaoAndComplementarDto::getQuestaoId)
                .collect(Collectors.toList());

        while (!complementares.isEmpty()) {
            Long complementarId = complementares.get(0);
            questaoOriginalId = complementarId;
            complementares = questoes.stream()
                    .filter(q -> q.getQuestaoComplementarId() != null)
                    .filter(q -> q.getQuestaoComplementarId().equals(complementarId))
                    .map(QuestaoAndComplementarDto::getQuestaoId)
                    .collect(Collectors.toList());
        }

        Long finalQuestaoOriginalIdNew = questaoOriginalId;
        return questoes.stream()
                .filter(q -> q.getQuestaoId().equals(finalQuestaoOriginalIdNew))
                .findFirst()
                .orElseThrow(() -> new IllegalArgumentException("A questão complementar final com id " + finalQuestaoOriginalIdNew + " não existe"));
    }


    public static Set<QuestaoAndComplementarDto> buscarUltimasQuestoesComplementares(List<QuestaoAndComplementarDto> questoes) {
        Set<QuestaoAndComplementarDto> questoesOriginais = new HashSet<>();
        for (QuestaoAndComplementarDto questao : questoes) {
            if (questao.getQuestaoComplementarId() != null) {
                QuestaoAndComplementarDto questaoPai = buscarUltimaQuestaoComplementar(questao.getQuestaoId(), questoes);
                questoesOriginais.add(questaoPai);
            }
        }
        return questoesOriginais;
    }

    // método para verificar se a questão foi respondida
    private static boolean verificarQuestaoRespondida(Long questaoId, List<QuestaoRespostaDto> listaRespostas) {
        boolean questaoRespondida = false;
        for (QuestaoRespostaDto resposta : listaRespostas) {
            if (Objects.equals(resposta.getQuestaoId(), questaoId)) {
                questaoRespondida = true;
                break;
            }
        }
        return questaoRespondida;
    }
}
