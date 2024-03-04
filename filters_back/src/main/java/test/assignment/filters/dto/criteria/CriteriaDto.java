package test.assignment.filters.dto.criteria;

import lombok.*;
import test.assignment.filters.persistence.model.ComparisonOperator;
import test.assignment.filters.persistence.model.CriteriaType;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@ToString
public class CriteriaDto {

    private int criteriaId;

    private CriteriaType criteriaType;

    private ComparisonOperator comparisonOperatorId;

}
