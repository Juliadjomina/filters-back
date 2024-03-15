package test.assignment.filters.dto;

import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import test.assignment.filters.dto.criteria.CriteriaDto;

import java.util.List;

import static test.assignment.filters.error.ErrorConstants.ERROR_FILTER_NAME_NULL;
import static test.assignment.filters.error.ErrorConstants.ERROR_FILTER_NAME_TOO_LONG;
import static test.assignment.filters.validator.FiltersValidationConstants.MAX_FILTER_NAME_INPUT;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class FilterRequestDto{

    @Size(max = MAX_FILTER_NAME_INPUT, message = ERROR_FILTER_NAME_TOO_LONG)
    @NotNull(message = ERROR_FILTER_NAME_NULL)
    private String filterName;
    private List<CriteriaDto> criteriaList;
}
