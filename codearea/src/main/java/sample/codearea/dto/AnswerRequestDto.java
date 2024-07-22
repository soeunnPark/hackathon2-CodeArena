package sample.codearea.dto;

import jakarta.validation.constraints.NotEmpty;
import lombok.*;

@Getter
@Setter
@ToString
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class AnswerRequestDto {

    @NotEmpty
    private String userName;

    @NotEmpty
    private String content;
}
