package test.assignment.filters;

import com.fasterxml.jackson.databind.ObjectMapper;
import lombok.SneakyThrows;
import test.assignment.filters.dto.ComparisonOperatorDto;
import test.assignment.filters.dto.FilterRequestDto;
import test.assignment.filters.dto.criteria.CriteriaDto;
import test.assignment.filters.dto.criteria.DateCriteriaDto;
import test.assignment.filters.dto.criteria.AmountCriteriaDto;
import test.assignment.filters.dto.criteria.TitleCriteriaDto;

import java.time.OffsetDateTime;
import java.util.List;

import static org.flywaydb.core.internal.util.FileUtils.readResourceAsString;

public class TestUtils {

    public static AmountCriteriaDto getAmountCriteria() {
        AmountCriteriaDto amountCriteriaDto = new AmountCriteriaDto();
        amountCriteriaDto.setAmount(23L);
        amountCriteriaDto.setCriteriaType("AMOUNT");
        amountCriteriaDto.setComparisonOperator(getComparisonOperatorDto("Equal to","AMOUNT"));
        return amountCriteriaDto;
    }

    public static DateCriteriaDto getDateCriteria() {
        DateCriteriaDto dateCriteriaDto = new DateCriteriaDto();
        dateCriteriaDto.setDate(OffsetDateTime.now());
        dateCriteriaDto.setCriteriaType("DATE");
        dateCriteriaDto.setComparisonOperator(getComparisonOperatorDto("Equal to","DATE"));
        return dateCriteriaDto;
    }

    public static TitleCriteriaDto getTitleCriteria() {
        TitleCriteriaDto titleCriteriaDto = new TitleCriteriaDto();
        titleCriteriaDto.setTitle("Test");
        titleCriteriaDto.setCriteriaType("TITLE");
        titleCriteriaDto.setComparisonOperator(getComparisonOperatorDto("Contains","TITLE"));
        return titleCriteriaDto;
    }

    public static ComparisonOperatorDto getComparisonOperatorDto(String name, String type) {
        ComparisonOperatorDto comparisonOperator = new ComparisonOperatorDto();
        comparisonOperator.setOperatorName(name);
        comparisonOperator.setOperatorType(type);
        return comparisonOperator;
    }

    public static FilterRequestDto getFilterRequestDto(List<CriteriaDto> criteriaDtoList) {
        FilterRequestDto filterRequestDto = new FilterRequestDto();
        filterRequestDto.setFilterName("Filter name");
        filterRequestDto.setCriteriaList(criteriaDtoList);
        return filterRequestDto;
    }

    public static DateCriteriaDto getDateCriteriaDto() {
        ComparisonOperatorDto comparisonOperatorDateDto = new ComparisonOperatorDto("Equals to", "DATE");
        DateCriteriaDto invalidDateCriteriaValue = new DateCriteriaDto();
        invalidDateCriteriaValue.setCriteriaType("TITLE");
        invalidDateCriteriaValue.setComparisonOperator(comparisonOperatorDateDto);
        invalidDateCriteriaValue.setDate(null);
        return invalidDateCriteriaValue;
    }

    public static TitleCriteriaDto getTitleCriteriaDto() {
        ComparisonOperatorDto comparisonOperatorTitleDto = new ComparisonOperatorDto("Equals to", "TITLE");
        TitleCriteriaDto invalidTitleCriteriaValue = new TitleCriteriaDto();
        invalidTitleCriteriaValue.setCriteriaType("TITLE");
        invalidTitleCriteriaValue.setComparisonOperator(comparisonOperatorTitleDto);
        invalidTitleCriteriaValue.setTitle(null);
        return invalidTitleCriteriaValue;
    }

    public static AmountCriteriaDto getAmountCriteriaDto() {
        ComparisonOperatorDto comparisonOperatorAmountDto = new ComparisonOperatorDto("Equals to", "AMOUNT");
        AmountCriteriaDto invalidAmountCriteriaValue = new AmountCriteriaDto();
        invalidAmountCriteriaValue.setCriteriaType("AMOUNT");
        invalidAmountCriteriaValue.setComparisonOperator(comparisonOperatorAmountDto);
        invalidAmountCriteriaValue.setAmount(null);
        return invalidAmountCriteriaValue;
    }

    @SneakyThrows
    public static <T> T testDataJson(String path, ObjectMapper objectMapper, Class<T> clazz) {
        return objectMapper.readValue(readResourceAsString(path), clazz);
    }
}
