package test.assignment.filters.validator;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;
import test.assignment.filters.dto.ComparisonOperatorDto;
import test.assignment.filters.dto.FilterRequestDto;
import test.assignment.filters.dto.criteria.CriteriaDto;
import test.assignment.filters.dto.criteria.DateCriteriaDto;
import test.assignment.filters.dto.criteria.AmountCriteriaDto;
import test.assignment.filters.dto.criteria.TitleCriteriaDto;
import test.assignment.filters.exceptions.FiltersServiceRestClientException;

import java.util.List;
import java.util.stream.Stream;

import static java.lang.String.format;
import static org.apache.commons.lang3.RandomStringUtils.random;
import static org.assertj.core.api.Assertions.assertThatExceptionOfType;
import static test.assignment.filters.TestUtils.*;
import static test.assignment.filters.helper.FilterConstants.AMOUNT;
import static test.assignment.filters.validator.FiltersValidator.*;

class FiltersValidatorTest {

    private static Stream<Arguments> invalidComparisonOperatorArguments() {
        String randomString = random(256, true, false);

        ComparisonOperatorDto operatorNameMissing = new ComparisonOperatorDto(null, AMOUNT);
        ComparisonOperatorDto operatorNameTooLong = new ComparisonOperatorDto(randomString, AMOUNT);
        ComparisonOperatorDto operatorWrongType = new ComparisonOperatorDto("test", "test");

        return Stream.of(
                Arguments.of("operatorName invalid: null", operatorNameMissing),
                Arguments.of(format("operatorName invalid: %s", randomString), operatorNameTooLong),
                Arguments.of("comparison operator type should be amount, title or date, but it is: test", operatorWrongType)
        );
    }

    private static Stream<Arguments> invalidCriteriaArguments() {
        ComparisonOperatorDto comparisonOperatorAmountDto = new ComparisonOperatorDto("Equals to", AMOUNT);
        CriteriaDto invalidCriteriaType = new CriteriaDto("test", comparisonOperatorAmountDto);

        AmountCriteriaDto invalidAmountCriteriaValue = getAmountCriteriaDto();

        TitleCriteriaDto invalidTitleCriteriaValue = getTitleCriteriaDto();

        DateCriteriaDto invalidDateCriteriaValue = getDateCriteriaDto();

        return Stream.of(
                Arguments.of("criteria type should be amount, title or date, but it is test", invalidCriteriaType),
                Arguments.of("amount criteria value can not be null", invalidAmountCriteriaValue),
                Arguments.of("title criteria value can not be null", invalidTitleCriteriaValue),
                Arguments.of("date criteria value can not be null", invalidDateCriteriaValue)
        );
    }

    private static Stream<Arguments> invalidFilterRequestDtoArguments() {
        String randomString = random(256, true, false);

        FilterRequestDto operatorNameMissing = new FilterRequestDto(null, "Selector 1", List.of());
        FilterRequestDto operatorNameTooLong = new FilterRequestDto(randomString, "Selector 1", List.of());
        FilterRequestDto criteriaMissing = new FilterRequestDto("Filter name", "Selector 1", null);
        FilterRequestDto criteriaEmpty = new FilterRequestDto("Filter name","Selector 1", List.of());

        return Stream.of(
                Arguments.of("filterName invalid: null", operatorNameMissing),
                Arguments.of(format("filterName invalid: %s", randomString), operatorNameTooLong),
                Arguments.of("criteria must not be null", criteriaMissing),
                Arguments.of("criteria must not be null", criteriaEmpty)
        );
    }

    @ParameterizedTest
    @MethodSource("invalidComparisonOperatorArguments")
    @DisplayName("Validate comparison operator fields")
    void validateComparisonOperatorDtoFields(String expectedError, ComparisonOperatorDto dto) {
        assertThatExceptionOfType(FiltersServiceRestClientException.class)
                .isThrownBy(() -> isValidComparisonOperatorDto(dto))
                .withMessage(expectedError);
    }

    @ParameterizedTest
    @MethodSource("invalidCriteriaArguments")
    @DisplayName("Validate criteria fields")
    void validateCriteriaFields(String expectedError, CriteriaDto dto) {
        assertThatExceptionOfType(FiltersServiceRestClientException.class)
                .isThrownBy(() -> isValidCriteria(dto))
                .withMessage(expectedError);
    }

    @ParameterizedTest
    @MethodSource("invalidFilterRequestDtoArguments")
    @DisplayName("Validate filter request fields")
    void validateFilterRequestDtoFields(String expectedError, FilterRequestDto dto) {
        assertThatExceptionOfType(FiltersServiceRestClientException.class)
                .isThrownBy(() -> validateFilterRequestDto(dto))
                .withMessage(expectedError);
    }
}
