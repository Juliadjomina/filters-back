package test.assignment.filters.mapper;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;
import test.assignment.filters.dto.criteria.CriteriaDto;
import test.assignment.filters.dto.criteria.DateCriteriaDto;
import test.assignment.filters.dto.criteria.NumberCriteriaDto;
import test.assignment.filters.dto.criteria.TextCriteriaDto;
import test.assignment.filters.persistence.model.ComparisonOperator;
import test.assignment.filters.persistence.model.CriteriaType;
import test.assignment.filters.persistence.model.Filter;
import test.assignment.filters.persistence.model.criteria.Criteria;
import test.assignment.filters.persistence.model.criteria.DateCriteria;
import test.assignment.filters.persistence.model.criteria.NumberCriteria;
import test.assignment.filters.persistence.model.criteria.TextCriteria;
import test.assignment.filters.persistence.repository.ComparisonOperatorRepository;
import test.assignment.filters.persistence.repository.CriteriaTypeRepository;

import javax.swing.*;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.stream.Collectors;

@Component
@RequiredArgsConstructor
public class CriteriaCustomMapper {

    private final CriteriaMapper criteriaMapper;
    private final ComparisonOperatorRepository comparisonOperatorRepository;
    private final CriteriaTypeRepository criteriaTypeRepository;

    public List<CriteriaDto> mapToDtoList(List<Criteria> criteriaList) {
        List<CriteriaDto> dtoList = new ArrayList<>();
        for (Criteria criteria : criteriaList) {
            dtoList.add(mapToDto(criteria));
        }
        return dtoList;
    }

    public CriteriaDto mapToDto(Criteria criteria) {
        // TODO add exception. No such criteriaType
        return switch (criteria) {
            case NumberCriteria numberCriteria -> criteriaMapper.toNumberCriteriaDto(numberCriteria);
            case TextCriteria textCriteria -> criteriaMapper.toTextCriteriaDto(textCriteria);
            case DateCriteria dateCriteria -> criteriaMapper.toDateCriteriaDto(dateCriteria);
            case null, default -> null;
        };
    }

    // TODO refacto VÄGA KOLE
    public List<Criteria> toCriteriaList(Filter filter, List<CriteriaDto> criteriaDtoList) {
        return criteriaDtoList.stream()
                .map(m -> {
                    Criteria criteria = mapToCriteria(m);
                    ComparisonOperator comparisonOperator = comparisonOperatorRepository.getComparisonOperatorByOperatorNameAndOperatorType(m.getComparisonOperator().getOperatorName(), m.getComparisonOperator().getOperatorType());
                    criteria.setComparisonOperator(comparisonOperator);
                    CriteriaType criteriaType = criteriaTypeRepository.getCriteriaTypeByType(m.getCriteriaType());
                    criteria.setType(criteriaType);
                    criteria.setCreatedAt(new Date());
                    criteria.setFilter(filter);
                    return criteria;
                })
                .collect(Collectors.toList());
    }

    private Criteria mapToCriteria(CriteriaDto criteriaDto) {
        return switch (criteriaDto) {
            case NumberCriteriaDto numberCriteria -> criteriaMapper.toNumberCriteria(numberCriteria);
            case TextCriteriaDto textCriteria -> criteriaMapper.toTextCriteria(textCriteria);
            case DateCriteriaDto dateCriteria -> criteriaMapper.toDateCriteria(dateCriteria);
            case null, default -> null;
        };
    }
}
