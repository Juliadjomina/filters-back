package test.assignment.filters.service;

import jakarta.transaction.Transactional;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;
import test.assignment.filters.dto.FilterDto;
import test.assignment.filters.dto.FilterRequestDto;
import test.assignment.filters.dto.FilterResponseDto;
import test.assignment.filters.mapper.CriteriaCustomMapper;
import test.assignment.filters.mapper.FilterMapper;
import test.assignment.filters.persistence.model.Filter;
import test.assignment.filters.persistence.model.criteria.Criteria;
import test.assignment.filters.persistence.repository.FilterRepository;

import java.time.OffsetDateTime;
import java.util.List;

import static test.assignment.filters.validator.FiltersValidator.validateFilterRequestDto;

@Slf4j
@Service
@RequiredArgsConstructor
public class FilterService {

    private final FilterRepository filterRepository;
    private final CriteriaService criteriaService;
    private final FilterMapper filterMapper;
    private final CriteriaCustomMapper criteriaCustomMapper;

    public List<FilterDto> getAllFilters() {
        log.info("FilterService.getAllFilters() | all filters request");
        final List<Filter> filters = filterRepository.findAll();
        return filterMapper.filtersToFiltersDto(filters);
    }

    @Transactional
    public FilterResponseDto saveFilter(final FilterRequestDto filterRequestDto) {
        log.info("FilterService.saveFilter() | save filter with criteria request");
        validateFilterRequestDto(filterRequestDto);
        Filter filter = filterMapper.filterRequestDtoToFilter(filterRequestDto);
        filter.setCratedAt(OffsetDateTime.now());
        Filter savedFilter = filterRepository.save(filter);
        List<Criteria> savedCriteriaList = criteriaService.saveCriteriaList(filter, filterRequestDto.getCriteriaList());
        return mapCreatedFilterAndCriteriaToDto(savedFilter, savedCriteriaList);
    }

    private FilterResponseDto mapCreatedFilterAndCriteriaToDto(Filter filter, List<Criteria> criteria) {
        FilterResponseDto filterResponseDto = new FilterResponseDto();
        filterResponseDto.setFilterName(filter.getFilterName());
        filterResponseDto.setCriteriaList(criteriaCustomMapper.mapToDtoList(criteria));
        return filterResponseDto;
    }
}
