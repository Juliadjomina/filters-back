package test.assignment.filters.dto.criteria;

import lombok.*;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@EqualsAndHashCode(callSuper = true)
public class NumberCriteriaDto extends CriteriaDto {

    private Long number;
}
