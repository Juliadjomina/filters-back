package test.assignment.filters.service;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import test.assignment.filters.dto.criteria.CriteriaDto;
import test.assignment.filters.dto.criteria.DateCriteriaDto;
import test.assignment.filters.dto.criteria.NumberCriteriaDto;
import test.assignment.filters.dto.criteria.TextCriteriaDto;
import test.assignment.filters.mapper.CriteriaCustomMapper;
import test.assignment.filters.mapper.CriteriaMapper;
import test.assignment.filters.persistence.model.ComparisonOperator;
import test.assignment.filters.persistence.model.Filter;
import test.assignment.filters.persistence.model.criteria.Criteria;
import test.assignment.filters.persistence.model.criteria.DateCriteria;
import test.assignment.filters.persistence.model.criteria.NumberCriteria;
import test.assignment.filters.persistence.model.criteria.TextCriteria;
import test.assignment.filters.persistence.repository.ComparisonOperatorRepository;
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
    private final ComparisonOperatorRepository comparisonOperatorRepository;
    private final CriteriaCustomMapper criteriaCustomMapper;


    public List<CriteriaDto> getAllCriterias() {
        List<Criteria> criterias = new ArrayList<>();
        criterias.addAll(textCriteriaRepository.getDateCriteria());
        criterias.addAll(dateCriteriaRepository.getDateCriteria());
        criterias.addAll(numberCriteriaRepository.getDateCriteria());
        return criteriaCustomMapper.mapToDtoList(criterias);
    }

    public void saveCriteriaList(Filter filter, List<CriteriaDto> criteriaList) {
        criteriaCustomMapper.toCriteriaList(filter, criteriaList)
                .forEach(criteria -> {
                    if (criteria instanceof TextCriteria textCriteria) {
                        textCriteriaRepository.save(textCriteria);
                    } else if (criteria instanceof NumberCriteria numberCriteria) {
                        numberCriteriaRepository.save(numberCriteria);
                    } else if (criteria instanceof DateCriteria dateCriteria) {
                        dateCriteriaRepository.save(dateCriteria);
                    }
                });
    }
}
