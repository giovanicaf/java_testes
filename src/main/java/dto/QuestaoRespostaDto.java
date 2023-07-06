package dto;

import lombok.*;

@Builder
@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
public class QuestaoRespostaDto {
    private Long questaoId;
    private Long respostaId;
}
