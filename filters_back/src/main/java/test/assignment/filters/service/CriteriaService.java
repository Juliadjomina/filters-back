package test.assignment.filters.service;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;
import test.assignment.filters.dto.criteria.CriteriaDto;
import test.assignment.filters.mapper.CriteriaCustomMapper;
import test.assignment.filters.persistence.model.Filter;
import test.assignment.filters.persistence.model.criteria.Criteria;
import test.assignment.filters.persistence.repository.CriteriaRepository;
import test.assignment.filters.persistence.repository.DateCriteriaRepository;
import test.assignment.filters.persistence.repository.AmountCriteriaRepository;
import test.assignment.filters.persistence.repository.TitleCriteriaRepository;

import java.util.ArrayList;
import java.util.List;

@Slf4j
@Service
@RequiredArgsConstructor
public class CriteriaService {

    private final TitleCriteriaRepository titleCriteriaRepository;
    private final DateCriteriaRepository dateCriteriaRepository;
    private final AmountCriteriaRepository amountCriteriaRepository;
    private final CriteriaRepository criteriaRepository;
    private final CriteriaCustomMapper criteriaCustomMapper;

    public List<CriteriaDto> getAllCriteria(Long id) {
        log.info("CriteriaService.getAllCriteria() | all comparison operators request");
        List<Criteria> criteria = new ArrayList<>();
        criteria.addAll(titleCriteriaRepository.getDateCriteria(id));
        criteria.addAll(dateCriteriaRepository.getDateCriteria(id));
        criteria.addAll(amountCriteriaRepository.getDateCriteria(id));
        return criteriaCustomMapper.mapToDtoList(criteria);
    }

    public List<Criteria> saveCriteriaList(Filter filter, List<CriteriaDto> criteriaList) {
        return criteriaRepository.saveAll(criteriaCustomMapper.toCriteriaList(filter, criteriaList));
    }
}
