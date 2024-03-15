package test.assignment.filters.dto.criteria;

import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;
import lombok.*;

import static test.assignment.filters.error.ErrorConstants.ERROR_CRITERIA_NAME_TOO_LONG;
import static test.assignment.filters.error.ErrorConstants.ERROR_TITLE_CRITERIA_TITLE_NULL;
import static test.assignment.filters.validator.FiltersValidationConstants.MAX_CRITERIA_NAME_INPUT;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@EqualsAndHashCode(callSuper = true)
public class TitleCriteriaDto extends CriteriaDto {

    @Size(max = MAX_CRITERIA_NAME_INPUT, message = ERROR_CRITERIA_NAME_TOO_LONG)
    @NotNull(message = ERROR_TITLE_CRITERIA_TITLE_NULL)
    private String title;
}
