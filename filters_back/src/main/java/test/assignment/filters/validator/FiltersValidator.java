package test.assignment.filters.validator;

import jakarta.validation.ConstraintViolation;
import jakarta.validation.Validator;
import jakarta.validation.ValidatorFactory;
import lombok.NoArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import test.assignment.filters.dto.ComparisonOperatorDto;
import test.assignment.filters.dto.FilterRequestDto;
import test.assignment.filters.dto.criteria.AmountCriteriaDto;
import test.assignment.filters.dto.criteria.CriteriaDto;
import test.assignment.filters.dto.criteria.DateCriteriaDto;
import test.assignment.filters.dto.criteria.TitleCriteriaDto;
import test.assignment.filters.exceptions.FiltersServiceRestClientException;

import java.util.ArrayList;
import java.util.List;

import static jakarta.validation.Validation.buildDefaultValidatorFactory;
import static java.lang.String.format;
import static org.apache.commons.lang3.ObjectUtils.isNotEmpty;
import static test.assignment.filters.error.ErrorConstants.*;
import static test.assignment.filters.validator.FiltersValidationConstants.TYPE;


@Slf4j
@NoArgsConstructor
public class FiltersValidator {

    private static final Validator validator;
    private static final String ERROR_MSG_TEMPLATE = "%s invalid: %s";
    private static final String ERROR_MSG_LOG_TEMPLATE = "{} invalid: {}";

    static {
        try (ValidatorFactory validatorFactory = buildDefaultValidatorFactory()) {
            validator = validatorFactory.getValidator();
        }
    }

    public static void validateFilterRequestDto(FilterRequestDto filterRequestDto) {
        var errors = new ArrayList<>(validator.validate(filterRequestDto));
        if (isNotEmpty(errors)) {
            throwFiltersServiceError(errors);
        }
        validateCriteriaDtos(filterRequestDto.getCriteriaList());
    }

    public static void validateCriteriaDtos(List<CriteriaDto> criteriaDtos) {
        if (criteriaDtos == null || criteriaDtos.isEmpty()) {
            throw new FiltersServiceRestClientException("criteria must not be null", ERROR_CRITERIA_NULL);
        }
        criteriaDtos.forEach(FiltersValidator::isValidCriteria);
    }

    public static void isValidCriteriaValue(CriteriaDto criteria) {
        switch (criteria) {
            case AmountCriteriaDto amountCriteriaDto ->
                    validateNonNull(amountCriteriaDto.getAmount(), "amount criteria value");
            case DateCriteriaDto dateCriteriaDto -> validateNonNull(dateCriteriaDto.getDate(), "date criteria value");
            case TitleCriteriaDto titleCriteriaDto -> validateNonNull(titleCriteriaDto.getTitle(), "title criteria value");
            default ->
                    throw new IllegalArgumentException("Unknown criteria type: " + criteria.getClass().getSimpleName());
        }
    }

    public static void isValidComparisonOperatorDto(ComparisonOperatorDto comparisonOperatorDto) {
        var errors = new ArrayList<>(validator.validate(comparisonOperatorDto));
        if (isNotEmpty(errors)) {
            throwFiltersServiceError(errors);
        }
        if (!TYPE.contains(comparisonOperatorDto.getOperatorType())) {
            throw new FiltersServiceRestClientException(format("comparison operator type should be amount, title or date, but it is: %s", comparisonOperatorDto.getOperatorType()), ERROR_WRONG_COMPARISON_OPERATOR_TYPE);
        }
    }

    public static void isValidCriteria(CriteriaDto criteria) {
        if (!TYPE.contains(criteria.getCriteriaType())) {
            throw new FiltersServiceRestClientException(format("criteria type should be amount, title or date, but it is %s", criteria.getCriteriaType()), ERROR_WRONG_CRITERIA_TYPE);
        }
        isValidCriteriaValue(criteria);
        isValidComparisonOperatorDto(criteria.getComparisonOperator());
    }

    private static void validateNonNull(Object value, String fieldName) {
        if (value == null) {
            throw new FiltersServiceRestClientException(fieldName + " can not be null", getErrorCode(fieldName));
        }
    }

    private static String getErrorCode(String fieldName) {
        return switch (fieldName) {
            case "amount criteria value" -> ERROR_AMOUNT_CRITERIA_VALUE_NULL;
            case "date criteria value" -> ERROR_DATE_CRITERIA_VALUE_NULL;
            case "title criteria value" -> ERROR_TITLE_CRITERIA_VALUE_NULL;
            default -> "";
        };
    }

    private static <T> void throwFiltersServiceError(List<ConstraintViolation<T>> errors) {
        logErrors(errors);
        throw new FiltersServiceRestClientException(format(ERROR_MSG_TEMPLATE, errors.getFirst().getPropertyPath().toString(), errors.getFirst().getInvalidValue()), errors.getFirst().getMessage());
    }

    private static <T> void logErrors(List<ConstraintViolation<T>> errors) {
        errors.forEach(e -> log.error(ERROR_MSG_LOG_TEMPLATE, e.getPropertyPath(), e.getInvalidValue()));
    }
}
