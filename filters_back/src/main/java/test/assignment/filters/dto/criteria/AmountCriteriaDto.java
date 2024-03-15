package test.assignment.filters.dto.criteria;

import lombok.*;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@EqualsAndHashCode(callSuper = true)
public class AmountCriteriaDto extends CriteriaDto {

    private Long amount;
}
