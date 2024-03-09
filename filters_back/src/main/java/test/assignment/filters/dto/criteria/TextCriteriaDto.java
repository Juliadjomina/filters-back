package test.assignment.filters.dto.criteria;

import lombok.*;

@Data
@NoArgsConstructor
@AllArgsConstructor
@EqualsAndHashCode(callSuper = true)
public class TextCriteriaDto extends CriteriaDto {

    private String text;
}
