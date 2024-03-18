package test.assignment.filters.dto;

import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import test.assignment.filters.error.ErrorConstants;
import test.assignment.filters.validator.FiltersValidationConstants;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class ComparisonOperatorDto {

    @Size(max = FiltersValidationConstants.MAX_COMPARISON_OPERATOR_INPUT, message = ErrorConstants.ERROR_COMPARISON_OPERATOR_NAME_TOO_LONG)
    @NotNull(message = ErrorConstants.ERROR_COMPARISON_OPERATOR_NAME_NULL)
    private String operatorName;
    private String operatorType;
}
