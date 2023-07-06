package dto;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Builder
@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
public class QuestaoAndComplementarDto {

    private Long questaoPrincipalId;
    private int ordenacao;
    private Long questaoId;
    private Long questaoComplementarId;
    private boolean respondida;

    @Override
    public String toString() {
        return "\n\nQuestaoAndComplementarDto{" +
                " ordenacao=" + ordenacao +
                ", questaoId=" + questaoId +
                ", questaoComplementarId=" + questaoComplementarId +
                ", respondida=" + respondida +
                '}';
    }
}
