package dto;

import lombok.*;

@Builder
@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
public class QuestaoAnaliseRespostaDto {
    private Long questaoOriginalId;
    private Long ultimaComplementarId;
    private boolean questaoOriginalRespondida;
    private boolean ultimaComplementarRespondida;

    @Override
    public String toString() {
        return "\n\n AnaliseQuestoesDto{" +
                " \n questaoOriginalId=" + questaoOriginalId +
                ", \n ultimaComplementarId=" + ultimaComplementarId +
                ", \n questaoOriginalRespondida=" + questaoOriginalRespondida +
                ", \n ultimaComplementarRespondida=" + ultimaComplementarRespondida +
                '}';
    }
}

