package test.assignment.filters;

import com.fasterxml.jackson.databind.ObjectMapper;
import lombok.Data;
import lombok.SneakyThrows;
import test.assignment.filters.dto.ComparisonOperatorDto;
import test.assignment.filters.dto.FilterRequestDto;
import test.assignment.filters.dto.criteria.CriteriaDto;
import test.assignment.filters.dto.criteria.DateCriteriaDto;
import test.assignment.filters.dto.criteria.NumberCriteriaDto;
import test.assignment.filters.dto.criteria.TextCriteriaDto;
import test.assignment.filters.persistence.model.ComparisonOperator;
import test.assignment.filters.persistence.model.CriteriaType;
import test.assignment.filters.persistence.model.Filter;
import test.assignment.filters.persistence.model.criteria.Criteria;
import test.assignment.filters.persistence.model.criteria.NumberCriteria;

import java.time.OffsetDateTime;
import java.util.List;

import static org.flywaydb.core.internal.util.FileUtils.readResourceAsString;

public class TestUtils {

    public static NumberCriteriaDto getNumberCriteria() {
        NumberCriteriaDto numberCriteriaDto = new NumberCriteriaDto();
        numberCriteriaDto.setNumber(23L);
        numberCriteriaDto.setCriteriaType("NUMBER");
        numberCriteriaDto.setComparisonOperator(getComparisonOperatorDto("Equal to","NUMBER"));
        return numberCriteriaDto;
    }

    public static DateCriteriaDto getDateCriteria() {
        DateCriteriaDto dateCriteriaDto = new DateCriteriaDto();
        dateCriteriaDto.setDate(OffsetDateTime.now());
        dateCriteriaDto.setCriteriaType("DATE");
        dateCriteriaDto.setComparisonOperator(getComparisonOperatorDto("Equal to","DATE"));
        return dateCriteriaDto;
    }

    public static TextCriteriaDto getTextCriteria() {
        TextCriteriaDto textCriteriaDto = new TextCriteriaDto();
        textCriteriaDto.setText("Test");
        textCriteriaDto.setCriteriaType("TEXT");
        textCriteriaDto.setComparisonOperator(getComparisonOperatorDto("Contains","TEXT"));
        return textCriteriaDto;
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
        invalidDateCriteriaValue.setCriteriaType("TEXT");
        invalidDateCriteriaValue.setComparisonOperator(comparisonOperatorDateDto);
        invalidDateCriteriaValue.setDate(null);
        return invalidDateCriteriaValue;
    }

    public static TextCriteriaDto getTextCriteriaDto() {
        ComparisonOperatorDto comparisonOperatorTextDto = new ComparisonOperatorDto("Equals to", "TEXT");
        TextCriteriaDto invalidTextCriteriaValue = new TextCriteriaDto();
        invalidTextCriteriaValue.setCriteriaType("TEXT");
        invalidTextCriteriaValue.setComparisonOperator(comparisonOperatorTextDto);
        invalidTextCriteriaValue.setText(null);
        return invalidTextCriteriaValue;
    }

    public static NumberCriteriaDto getNumberCriteriaDto() {
        ComparisonOperatorDto comparisonOperatorNumberDto = new ComparisonOperatorDto("Equals to", "NUMBER");
        NumberCriteriaDto invalidNumberCriteriaValue = new NumberCriteriaDto();
        invalidNumberCriteriaValue.setCriteriaType("NUMBER");
        invalidNumberCriteriaValue.setComparisonOperator(comparisonOperatorNumberDto);
        invalidNumberCriteriaValue.setNumber(null);
        return invalidNumberCriteriaValue;
    }

    @SneakyThrows
    public static <T> T testDataJson(String path, ObjectMapper objectMapper, Class<T> clazz) {
        return objectMapper.readValue(readResourceAsString(path), clazz);
    }
}
