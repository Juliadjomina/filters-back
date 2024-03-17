package test.assignment.filters.mapper;

import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import test.assignment.filters.dto.FilterDto;
import test.assignment.filters.dto.FilterRequestDto;
import test.assignment.filters.persistence.model.Filter;

import java.util.List;

@Mapper(componentModel = "spring")
public interface FilterMapper {

    Filter filterRequestDtoToFilter(FilterRequestDto filter);

    @Mapping(source = "filters.selection.name", target = "selectionName")
    FilterDto filtersToFiltersDto(Filter filters);

    @Mapping(source = "selectionName", target = "filters.selection.name")
    List<FilterDto> filtersToFiltersDtos(List<Filter> filters);
}
