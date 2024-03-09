package test.assignment.filters.dto.criteria;

import lombok.*;

@Data
@NoArgsConstructor
@AllArgsConstructor
@EqualsAndHashCode(callSuper = true)
public class NumberCriteriaDto extends CriteriaDto {

    private Long number;
}
