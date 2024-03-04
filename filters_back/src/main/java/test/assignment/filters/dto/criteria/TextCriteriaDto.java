package test.assignment.filters.dto.criteria;

import lombok.*;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@ToString
public class TextCriteriaDto extends CriteriaDto {
    private String value;
}
