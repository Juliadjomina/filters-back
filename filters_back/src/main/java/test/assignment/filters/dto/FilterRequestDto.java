package test.assignment.filters.dto;

import test.assignment.filters.dto.criteria.CriteriaDto;

import java.util.List;

public record FilterRequestDto(
        String filterName,
        List<CriteriaDto> criteriaList
) {
}
