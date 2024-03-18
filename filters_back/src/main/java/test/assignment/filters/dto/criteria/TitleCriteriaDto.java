package test.assignment.filters.dto.criteria;

import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;
import lombok.*;
import test.assignment.filters.error.ErrorConstants;
import test.assignment.filters.validator.FiltersValidationConstants;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@EqualsAndHashCode(callSuper = true)
public class TitleCriteriaDto extends CriteriaDto {

    @Size(max = FiltersValidationConstants.MAX_CRITERIA_NAME_INPUT, message = ErrorConstants.ERROR_CRITERIA_NAME_TOO_LONG)
    @NotNull(message = ErrorConstants.ERROR_TITLE_CRITERIA_TITLE_NULL)
    private String title;
}
