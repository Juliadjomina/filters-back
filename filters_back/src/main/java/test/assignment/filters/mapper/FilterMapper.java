package test.assignment.filters.mapper;

import org.mapstruct.Mapper;
import test.assignment.filters.dto.FilterDto;
import test.assignment.filters.dto.FilterRequestDto;
import test.assignment.filters.persistence.model.Filter;

import java.util.List;

@Mapper(componentModel = "spring")
public interface FilterMapper {

    Filter filterRequestDtoToFilter(FilterRequestDto filter);

    List<FilterDto> filtersToFiltersDto(List<Filter> filters);
}
