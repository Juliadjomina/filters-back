package test.assignment.filters.service;

import lombok.AllArgsConstructor;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import test.assignment.filters.dto.FilterDto;
import test.assignment.filters.dto.FilterRequestDto;
import test.assignment.filters.mapper.FilterMapper;
import test.assignment.filters.persistence.model.Filter;
import test.assignment.filters.persistence.repository.FilterRepository;

import java.util.List;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
public class FilterService {

    private final FilterRepository filterRepository;
    private final CriteriaService criteriaService;

    private final FilterMapper filterMapper;

    public List<FilterDto> getAllFilters() {
        final List<Filter> filters = filterRepository.findAll();
        return filterMapper.filtersToFiltersDto(filters);
    }

    public void deleteFilter( Long id) {
        filterRepository.deleteById(id);
    }

    public Long saveFilter(final FilterRequestDto filterRequestDto) {
//        filterRepository.
//        filterRepository.
        criteriaService.saveCriteriaList(filterRequestDto.getCriteriaList());
    }

}
