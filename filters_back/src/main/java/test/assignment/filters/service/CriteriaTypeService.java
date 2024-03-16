package test.assignment.filters.service;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;
import test.assignment.filters.dto.CriteriaTypeDto;
import test.assignment.filters.mapper.CriteriaTypeMapper;
import test.assignment.filters.persistence.model.CriteriaType;
import test.assignment.filters.persistence.repository.CriteriaTypeRepository;

import java.util.List;

@Slf4j
@Service
@RequiredArgsConstructor
public class CriteriaTypeService {

    private final CriteriaTypeRepository criteriaTypeRepository;
    private final CriteriaTypeMapper criteriaTypeMapper;

    public List<CriteriaTypeDto> getAllCriteriaTypes() {
        log.info("CriteriaTypeService.getAllCriteriaTypes() | all criteria types request");
        final List<CriteriaType> filters = criteriaTypeRepository.findAll();
        return criteriaTypeMapper.toCriteriaTypeDtos(filters);
    }
}
