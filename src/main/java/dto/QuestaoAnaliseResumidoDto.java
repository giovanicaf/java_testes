package dto;

import lombok.*;

@Builder
@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
public class QuestaoAnaliseResumidoDto {
    private Long questaoId;
    private Long questaoComplementarId;
}
