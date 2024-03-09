package test.assignment.filters.service;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import test.assignment.filters.dto.criteria.CriteriaDto;
import test.assignment.filters.mapper.CriteriaCustomMapper;
import test.assignment.filters.persistence.model.Filter;
import test.assignment.filters.persistence.model.criteria.Criteria;
import test.assignment.filters.persistence.model.criteria.DateCriteria;
import test.assignment.filters.persistence.model.criteria.NumberCriteria;
import test.assignment.filters.persistence.model.criteria.TextCriteria;
import test.assignment.filters.persistence.repository.CriteriaRepository;
import test.assignment.filters.persistence.repository.DateCriteriaRepository;
import test.assignment.filters.persistence.repository.NumberCriteriaRepository;
import test.assignment.filters.persistence.repository.TextCriteriaRepository;

import java.util.ArrayList;
import java.util.List;

@Service
@RequiredArgsConstructor
public class CriteriaService {

    private final TextCriteriaRepository textCriteriaRepository;
    private final DateCriteriaRepository dateCriteriaRepository;
    private final NumberCriteriaRepository numberCriteriaRepository;
    private final CriteriaRepository criteriaRepository;
    private final CriteriaCustomMapper criteriaCustomMapper;

// TODO aggregation?
    public List<CriteriaDto> getAllCriterias(Long id) {
        List<Criteria> criterias = new ArrayList<>();
        criterias.addAll(textCriteriaRepository.getDateCriteria(id));
        criterias.addAll(dateCriteriaRepository.getDateCriteria(id));
        criterias.addAll(numberCriteriaRepository.getDateCriteria(id));
        return criteriaCustomMapper.mapToDtoList(criterias);
    }

    public void saveCriteriaList(Filter filter, List<CriteriaDto> criteriaList) {
        // TODO batch ??
        criteriaRepository.saveAll(criteriaCustomMapper.toCriteriaList(filter, criteriaList));
    }
}
