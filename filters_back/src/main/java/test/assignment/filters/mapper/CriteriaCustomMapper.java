package test.assignment.filters.mapper;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;
import test.assignment.filters.dto.criteria.CriteriaDto;
import test.assignment.filters.dto.criteria.DateCriteriaDto;
import test.assignment.filters.dto.criteria.AmountCriteriaDto;
import test.assignment.filters.dto.criteria.TitleCriteriaDto;
import test.assignment.filters.exceptions.FiltersServiceRestClientException;
import test.assignment.filters.persistence.model.ComparisonOperator;
import test.assignment.filters.persistence.model.CriteriaType;
import test.assignment.filters.persistence.model.Filter;
import test.assignment.filters.persistence.model.Selection;
import test.assignment.filters.persistence.model.criteria.Criteria;
import test.assignment.filters.persistence.model.criteria.DateCriteria;
import test.assignment.filters.persistence.model.criteria.AmountCriteria;
import test.assignment.filters.persistence.model.criteria.TitleCriteria;
import test.assignment.filters.persistence.repository.ComparisonOperatorRepository;
import test.assignment.filters.persistence.repository.CriteriaTypeRepository;
import test.assignment.filters.persistence.repository.SelectionRepository;

import java.time.OffsetDateTime;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

import static test.assignment.filters.error.ErrorConstants.ERROR_WRONG_CRITERIA_TYPE;

@Component
@RequiredArgsConstructor
public class CriteriaCustomMapper {

    private final CriteriaMapper criteriaMapper;
    private final ComparisonOperatorRepository comparisonOperatorRepository;
    private final CriteriaTypeRepository criteriaTypeRepository;
    private final SelectionRepository selectionRepository;

    public List<CriteriaDto> mapToDtoList(List<Criteria> criteriaList) {
        List<CriteriaDto> dtoList = new ArrayList<>();
        for (Criteria criteria : criteriaList) {
            dtoList.add(mapToDto(criteria));
        }
        return dtoList;
    }

    public CriteriaDto mapToDto(Criteria criteria) {
        return switch (criteria) {
            case AmountCriteria amountCriteria -> criteriaMapper.toAmountCriteriaDto(amountCriteria);
            case TitleCriteria titleCriteria -> criteriaMapper.toTitleCriteriaDto(titleCriteria);
            case DateCriteria dateCriteria -> criteriaMapper.toDateCriteriaDto(dateCriteria);
            case null, default ->
                    throw new FiltersServiceRestClientException("criteria type can be amount, title or date", ERROR_WRONG_CRITERIA_TYPE);
        };
    }

    public List<Criteria> toCriteriaList(Filter filter, List<CriteriaDto> criteriaDtoList) {
        return criteriaDtoList.stream()
                .map(m -> {
                    Criteria criteria = mapToCriteria(m);
                    ComparisonOperator comparisonOperator = comparisonOperatorRepository.getComparisonOperatorByOperatorNameAndOperatorType(m.getComparisonOperator().getOperatorName(), m.getComparisonOperator().getOperatorType());
                    CriteriaType criteriaType = criteriaTypeRepository.getCriteriaTypeByType(m.getCriteriaType());
                    criteria.setComparisonOperator(comparisonOperator);
                    criteria.setType(criteriaType);
                    criteria.setCreatedAt(OffsetDateTime.now());
                    criteria.setFilter(filter);
                    return criteria;
                })
                .collect(Collectors.toList());
    }

    private Criteria mapToCriteria(CriteriaDto criteriaDto) {
        return switch (criteriaDto) {
            case AmountCriteriaDto amountCriteria -> criteriaMapper.toAmountCriteria(amountCriteria);
            case TitleCriteriaDto titleCriteria -> criteriaMapper.toTitleCriteria(titleCriteria);
            case DateCriteriaDto dateCriteria -> criteriaMapper.toDateCriteria(dateCriteria);
            case null, default -> null;
        };
    }
}
