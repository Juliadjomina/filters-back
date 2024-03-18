package test.assignment.filters.mapper;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;
import test.assignment.filters.dto.criteria.AmountCriteriaDto;
import test.assignment.filters.dto.criteria.CriteriaDto;
import test.assignment.filters.dto.criteria.DateCriteriaDto;
import test.assignment.filters.dto.criteria.TitleCriteriaDto;
import test.assignment.filters.error.ErrorConstants;
import test.assignment.filters.exceptions.CriteriaMapperException;
import test.assignment.filters.exceptions.FiltersServiceRestClientException;
import test.assignment.filters.persistence.model.ComparisonOperator;
import test.assignment.filters.persistence.model.CriteriaType;
import test.assignment.filters.persistence.model.Filter;
import test.assignment.filters.persistence.model.criteria.AmountCriteria;
import test.assignment.filters.persistence.model.criteria.Criteria;
import test.assignment.filters.persistence.model.criteria.DateCriteria;
import test.assignment.filters.persistence.model.criteria.TitleCriteria;
import test.assignment.filters.persistence.repository.ComparisonOperatorRepository;
import test.assignment.filters.persistence.repository.CriteriaTypeRepository;

import java.time.OffsetDateTime;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

import static java.lang.String.format;

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
        return switch (criteria) {
            case AmountCriteria amountCriteria -> criteriaMapper.toAmountCriteriaDto(amountCriteria);
            case TitleCriteria titleCriteria -> criteriaMapper.toTitleCriteriaDto(titleCriteria);
            case DateCriteria dateCriteria -> criteriaMapper.toDateCriteriaDto(dateCriteria);
            case null, default ->
                    throw new FiltersServiceRestClientException("criteria type can be amount, title or date", ErrorConstants.ERROR_WRONG_CRITERIA_TYPE);
        };
    }

    public List<Criteria> toCriteriaList(Filter filter, List<CriteriaDto> criteriaDtoList) {
        List<ComparisonOperator> comparisonOperators = comparisonOperatorRepository.findAll();
        List<CriteriaType> criteriaTypes = criteriaTypeRepository.findAll();
        return criteriaDtoList.stream()
                .map(m -> {
                    Criteria criteria = mapToCriteria(m);
                    setCriteriaType(m, criteriaTypes, criteria);
                    setComparisonOperator(m, comparisonOperators, criteria);
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
            case null, default ->
                    throw new CriteriaMapperException("Wrong criteria type", ErrorConstants.ERROR_WRONG_CRITERIA_TYPE);
        };
    }

    private static void setCriteriaType(CriteriaDto criteriaDto, List<CriteriaType> criteriaTypes, Criteria criteria) {
        CriteriaType exactType = criteriaTypes.stream()
                .filter(type -> type.getType().equals(criteriaDto.getCriteriaType()))
                .findFirst()
                .orElseThrow(() -> new CriteriaMapperException(format("Wrong criteria type. Type: %s", criteriaDto.getCriteriaType()), ErrorConstants.ERROR_WRONG_CRITERIA_TYPE));
        criteria.setType(exactType);
    }

    private static void setComparisonOperator(CriteriaDto criteriaDto, List<ComparisonOperator> comparisonOperators, Criteria criteria) {
        ComparisonOperator result = comparisonOperators.stream()
                .filter(operator -> operator.getOperatorName().equals(criteriaDto.getComparisonOperator().getOperatorName())
                        && operator.getOperatorType().equals(criteriaDto.getComparisonOperator().getOperatorType()))
                .findFirst().orElseThrow(() -> new CriteriaMapperException(format("Wrong comparison operator. Comparison operator name -> %s and type ->  %s", criteriaDto.getComparisonOperator().getOperatorName(), criteriaDto.getComparisonOperator().getOperatorType()), ErrorConstants.ERROR_WRONG_COMPARISON_OPERATOR_TYPE));
        criteria.setComparisonOperator(result);
    }
}
