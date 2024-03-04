package test.assignment.filters.mapper;

import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import test.assignment.filters.dto.FilterDto;
import test.assignment.filters.dto.FilterRequestDto;
import test.assignment.filters.persistence.model.Filter;

import java.util.List;

@Mapper(componentModel = "spring")
public interface FilterMapper {

    //TODO sometimes java: No property named "filterName" exists in source parameter(s). Type "FilterRequestDto" has no properties.
    @Mapping(target = "filterName", source = "filterName")
    Filter filterRequestDtoToFilter(FilterRequestDto filter);

    FilterDto filterToFilterDto(Filter filter);

    List<FilterDto> filtersToFiltersDto(List<Filter> filters);
}
