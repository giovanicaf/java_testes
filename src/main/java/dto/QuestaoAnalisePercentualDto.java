package dto;

import enums.TipoQuestao;
import lombok.*;

import java.util.Arrays;
import java.util.List;
import java.util.Objects;

import static enums.TipoQuestao.ESCOLHA_UNICA;
import static enums.TipoQuestao.TEXTO;

@Builder
@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
public class QuestaoAnalisePercentualDto implements Comparable<QuestaoAnalisePercentualDto>{
    private Long questaoId;
    private Long questaoComplementarId;
    private boolean questaoComplementar;
    private Long alternativaId;
    private TipoQuestao questaoTipo;
    private boolean respondido;
    private boolean questaoPrincipal;
    private Long questaoPrincipalId;
    private int ordenacao;
    private Long percentual;

    @Override
    public int compareTo(@NonNull QuestaoAnalisePercentualDto dto) {
        if(!Objects.equals(dto.getQuestaoPrincipalId(), getQuestaoPrincipalId()))
            return Long.compare(dto.getQuestaoPrincipalId(), getQuestaoPrincipalId());
        else if(dto.getOrdenacao() != getOrdenacao())
            return Integer.compare(dto.getOrdenacao(), getOrdenacao());
        return Long.compare(dto.getQuestaoId(), getQuestaoId());
    }

    @Override
    public String toString() {
        return "\n{" +
                "questaoPrincipalId=" + questaoPrincipalId +
                ", ordenacao=" + ordenacao +
                ", questaoId=" + questaoId +
                ", questaoComplementarId=" + questaoComplementarId +
                ", questaoPrincipal=" + questaoPrincipal +
                ", questaoComplementar=" + questaoComplementar +
                ", alternativaId=" + alternativaId +
                ", respondido=" + respondido +
                ", percentual=" + percentual +
                '}';
    }

    public QuestaoAnalisePercentualDto(Long questaoId, Long questaoComplementarId, boolean questaoComplementar, Long alternativaId, TipoQuestao questaoTipo, boolean respondido) {
        this.questaoId = questaoId;
        this.questaoComplementarId = questaoComplementarId;
        this.questaoComplementar = questaoComplementar;
        this.alternativaId = alternativaId;
        this.questaoTipo = questaoTipo;
        this.respondido = respondido;
    }

    public static List<QuestaoAnalisePercentualDto> gerarListaQuestoes(){
        QuestaoAnalisePercentualDto questao01 = new QuestaoAnalisePercentualDto(1766L,1771L,false,null,TEXTO,true);
        QuestaoAnalisePercentualDto questao02 = new QuestaoAnalisePercentualDto(1771L,1772L,false,null,TEXTO,true);
        QuestaoAnalisePercentualDto questao03 = new QuestaoAnalisePercentualDto(1772L,1774L,false,null,TEXTO,true);
        QuestaoAnalisePercentualDto questao04 = new QuestaoAnalisePercentualDto(1774L,null,false,null,TEXTO,true);
        QuestaoAnalisePercentualDto questao05 = new QuestaoAnalisePercentualDto(1775L,null,false,null,TEXTO,true);
        QuestaoAnalisePercentualDto questao06 = new QuestaoAnalisePercentualDto(1776L,null,false,6251L,ESCOLHA_UNICA,true);
        QuestaoAnalisePercentualDto questao07 = new QuestaoAnalisePercentualDto(1776L,null,false,6252L,ESCOLHA_UNICA,true);
        QuestaoAnalisePercentualDto questao08 = new QuestaoAnalisePercentualDto(1777L,null,false,6253L,ESCOLHA_UNICA,true);
        QuestaoAnalisePercentualDto questao09 = new QuestaoAnalisePercentualDto(1777L,null,false,6254L,ESCOLHA_UNICA,true);
        QuestaoAnalisePercentualDto questao010 = new QuestaoAnalisePercentualDto(1778L,null,false,6255L,ESCOLHA_UNICA,true);
        QuestaoAnalisePercentualDto questao011 = new QuestaoAnalisePercentualDto(1778L,null,false,6256L,ESCOLHA_UNICA,true);
        QuestaoAnalisePercentualDto questao012 = new QuestaoAnalisePercentualDto(1793L,1794L,false,7368L,ESCOLHA_UNICA,true);
        QuestaoAnalisePercentualDto questao013 = new QuestaoAnalisePercentualDto(1793L,null,false,7369L,ESCOLHA_UNICA,true);
        QuestaoAnalisePercentualDto questao014 = new QuestaoAnalisePercentualDto(1794L,null,true,7379L,ESCOLHA_UNICA,true);
        QuestaoAnalisePercentualDto questao015 = new QuestaoAnalisePercentualDto(1794L,null,true,7380L,ESCOLHA_UNICA,true);
        QuestaoAnalisePercentualDto questao016 = new QuestaoAnalisePercentualDto(1794L,null,true,7381L,ESCOLHA_UNICA,true);
        QuestaoAnalisePercentualDto questao017 = new QuestaoAnalisePercentualDto(1794L,null,true,7382L,ESCOLHA_UNICA,true);
        QuestaoAnalisePercentualDto questao018 = new QuestaoAnalisePercentualDto(1794L,null,true,7383L,ESCOLHA_UNICA,true);
        QuestaoAnalisePercentualDto questao019 = new QuestaoAnalisePercentualDto(1794L,null,true,7384L,ESCOLHA_UNICA,true);
        QuestaoAnalisePercentualDto questao020 = new QuestaoAnalisePercentualDto(1794L,null,true,7385L,ESCOLHA_UNICA,true);
        QuestaoAnalisePercentualDto questao021 = new QuestaoAnalisePercentualDto(1794L,null,true,7386L,ESCOLHA_UNICA,true);
        QuestaoAnalisePercentualDto questao022 = new QuestaoAnalisePercentualDto(1794L,null,true,7387L,ESCOLHA_UNICA,true);
        QuestaoAnalisePercentualDto questao023 = new QuestaoAnalisePercentualDto(1794L,null,true,7388L,ESCOLHA_UNICA,true);
        QuestaoAnalisePercentualDto questao024 = new QuestaoAnalisePercentualDto(1794L,2002L,true,7389L,ESCOLHA_UNICA,true);
        QuestaoAnalisePercentualDto questao025 = new QuestaoAnalisePercentualDto(1796L,null,false,6242L,ESCOLHA_UNICA,true);
        QuestaoAnalisePercentualDto questao026 = new QuestaoAnalisePercentualDto(1796L,null,false,6243L,ESCOLHA_UNICA,true);
        QuestaoAnalisePercentualDto questao027 = new QuestaoAnalisePercentualDto(1796L,null,false,6244L,ESCOLHA_UNICA,true);
        QuestaoAnalisePercentualDto questao028 = new QuestaoAnalisePercentualDto(1796L,null,false,6245L,ESCOLHA_UNICA,true);
        QuestaoAnalisePercentualDto questao029 = new QuestaoAnalisePercentualDto(1796L,null,false,6246L,ESCOLHA_UNICA,true);
        QuestaoAnalisePercentualDto questao030 = new QuestaoAnalisePercentualDto(1796L,null,false,6247L,ESCOLHA_UNICA,true);
        QuestaoAnalisePercentualDto questao031 = new QuestaoAnalisePercentualDto(1796L,null,false,6248L,ESCOLHA_UNICA,true);
        QuestaoAnalisePercentualDto questao032 = new QuestaoAnalisePercentualDto(1796L,null,false,6249L,ESCOLHA_UNICA,true);
        QuestaoAnalisePercentualDto questao033 = new QuestaoAnalisePercentualDto(1796L,null,false,6250L,ESCOLHA_UNICA,true);
        QuestaoAnalisePercentualDto questao034 = new QuestaoAnalisePercentualDto(1796L,null,false,6562L,ESCOLHA_UNICA,true);
        QuestaoAnalisePercentualDto questao035 = new QuestaoAnalisePercentualDto(1796L,null,false,7049L,ESCOLHA_UNICA,true);
        QuestaoAnalisePercentualDto questao036 = new QuestaoAnalisePercentualDto(1796L,null,false,7050L,ESCOLHA_UNICA,true);
        QuestaoAnalisePercentualDto questao037 = new QuestaoAnalisePercentualDto(1797L,null,false,7123L,ESCOLHA_UNICA,true);
        QuestaoAnalisePercentualDto questao038 = new QuestaoAnalisePercentualDto(1797L,null,false,7148L,ESCOLHA_UNICA,true);
        QuestaoAnalisePercentualDto questao039 = new QuestaoAnalisePercentualDto(1797L,null,false,7149L,ESCOLHA_UNICA,true);
        QuestaoAnalisePercentualDto questao040 = new QuestaoAnalisePercentualDto(1797L,null,false,7150L,ESCOLHA_UNICA,true);
        QuestaoAnalisePercentualDto questao041 = new QuestaoAnalisePercentualDto(1797L,null,false,7151L,ESCOLHA_UNICA,true);
        QuestaoAnalisePercentualDto questao042 = new QuestaoAnalisePercentualDto(1797L,null,false,7161L,ESCOLHA_UNICA,true);
        QuestaoAnalisePercentualDto questao043 = new QuestaoAnalisePercentualDto(1797L,null,false,7162L,ESCOLHA_UNICA,true);
        QuestaoAnalisePercentualDto questao044 = new QuestaoAnalisePercentualDto(1797L,null,false,7163L,ESCOLHA_UNICA,true);
        QuestaoAnalisePercentualDto questao045 = new QuestaoAnalisePercentualDto(1797L,null,false,7183L,ESCOLHA_UNICA,true);
        QuestaoAnalisePercentualDto questao046 = new QuestaoAnalisePercentualDto(1797L,null,false,7184L,ESCOLHA_UNICA,true);
        QuestaoAnalisePercentualDto questao047 = new QuestaoAnalisePercentualDto(1797L,null,false,7185L,ESCOLHA_UNICA,true);
        QuestaoAnalisePercentualDto questao048 = new QuestaoAnalisePercentualDto(1797L,null,false,7186L,ESCOLHA_UNICA,true);
        QuestaoAnalisePercentualDto questao049 = new QuestaoAnalisePercentualDto(2002L,null,true,null,TEXTO,false);

        return Arrays.asList(questao01, questao02, questao03, questao04, questao05, questao06, questao07, questao08,
        questao09, questao010, questao011, questao012, questao013, questao014, questao015, questao016, questao017,
        questao018, questao019, questao020, questao021, questao022, questao023, questao024, questao025, questao026,
        questao027, questao028, questao029, questao030, questao031, questao032, questao033, questao034, questao035,
        questao036, questao037, questao038, questao039, questao040, questao041, questao042, questao043, questao044,
        questao045, questao046, questao047, questao048, questao049);
    }
}

