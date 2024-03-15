package test.assignment.filters.dto;

import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import static test.assignment.filters.error.ErrorConstants.ERROR_COMPARISON_OPERATOR_NAME_NULL;
import static test.assignment.filters.error.ErrorConstants.ERROR_COMPARISON_OPERATOR_NAME_TOO_LONG;
import static test.assignment.filters.validator.FiltersValidationConstants.MAX_COMPARISON_OPERATOR_INPUT;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class ComparisonOperatorDto {

    @Size(max = MAX_COMPARISON_OPERATOR_INPUT, message = ERROR_COMPARISON_OPERATOR_NAME_TOO_LONG)
    @NotNull(message = ERROR_COMPARISON_OPERATOR_NAME_NULL)
    private String operatorName;
    private String operatorType;
}
