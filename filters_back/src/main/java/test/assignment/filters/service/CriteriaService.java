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

    public List<CriteriaDto> getAllCriterias(Long id) {
        List<Criteria> criterias = new ArrayList<>();
        criterias.addAll(titleCriteriaRepository.getDateCriteria(id));
        criterias.addAll(dateCriteriaRepository.getDateCriteria(id));
        criterias.addAll(amountCriteriaRepository.getDateCriteria(id));
        return criteriaCustomMapper.mapToDtoList(criterias);
    }

    public List<Criteria> saveCriteriaList(Filter filter, List<CriteriaDto> criteriaList) {
        return criteriaRepository.saveAll(criteriaCustomMapper.toCriteriaList(filter, criteriaList));
    }
}
