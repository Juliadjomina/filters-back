package test.assignment.filters.mapper;

import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import test.assignment.filters.dto.FilterDto;
import test.assignment.filters.persistence.model.Filter;

import java.util.List;

@Mapper(componentModel = "spring")
public interface FilterMapper {


    FilterDto filterToFilterDto(Filter filter);

    List<FilterDto> filtersToFiltersDto(List<Filter> filters);
}
