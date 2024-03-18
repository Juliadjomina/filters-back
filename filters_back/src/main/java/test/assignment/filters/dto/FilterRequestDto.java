package test.assignment.filters.dto;

import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import test.assignment.filters.dto.criteria.CriteriaDto;
import test.assignment.filters.error.ErrorConstants;
import test.assignment.filters.validator.FiltersValidationConstants;

import java.util.List;


@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class FilterRequestDto {

    @Size(max = FiltersValidationConstants.MAX_FILTER_NAME_INPUT, message = ErrorConstants.ERROR_FILTER_NAME_TOO_LONG)
    @NotNull(message = ErrorConstants.ERROR_FILTER_NAME_NULL)
    private String filterName;
    private String selectionName;
    private List<CriteriaDto> criteriaList;
}
