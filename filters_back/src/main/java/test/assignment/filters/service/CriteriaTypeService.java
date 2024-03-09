package test.assignment.filters.service;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import test.assignment.filters.dto.CriteriaTypeDto;
import test.assignment.filters.dto.FilterDto;
import test.assignment.filters.mapper.CriteriaTypeMapper;
import test.assignment.filters.persistence.model.CriteriaType;
import test.assignment.filters.persistence.model.Filter;
import test.assignment.filters.persistence.repository.CriteriaTypeRepository;

import java.util.List;

@Service
@RequiredArgsConstructor
public class CriteriaTypeService {

    private final CriteriaTypeRepository criteriaTypeRepository;
    private final CriteriaTypeMapper criteriaTypeMapper;

    public List<CriteriaTypeDto> getAllFilters() {
        final List<CriteriaType> filters = criteriaTypeRepository.findAll();
        return criteriaTypeMapper.toCriiteriaTypeDtos(filters);
    }
}
