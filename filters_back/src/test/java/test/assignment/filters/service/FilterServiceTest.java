package test.assignment.filters.service;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.jdbc.Sql;
import test.assignment.filters.IntegrationTest;
import test.assignment.filters.dto.FilterDto;
import test.assignment.filters.dto.FilterRequestDto;
import test.assignment.filters.persistence.model.criteria.Criteria;
import test.assignment.filters.persistence.repository.CriteriaTypeRepository;
import test.assignment.filters.persistence.repository.DateCriteriaRepository;
import test.assignment.filters.persistence.repository.NumberCriteriaRepository;
import test.assignment.filters.persistence.repository.TextCriteriaRepository;

import java.util.ArrayList;
import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;
import static test.assignment.filters.TestUtils.*;

class FilterServiceTest extends IntegrationTest {

    @Autowired
    private FilterService filterService;

    @Autowired
    private NumberCriteriaRepository numberCriteriaRepository;

    @Autowired
    private TextCriteriaRepository textCriteriaRepository;

    @Autowired
    private DateCriteriaRepository dateCriteriaRepository;

    @Test
    @DisplayName("Test get all filters")
    @Sql(scripts = "classpath:testdb/init/initTestDataFilter.sql", executionPhase = Sql.ExecutionPhase.BEFORE_TEST_METHOD)
    @Sql(scripts = "classpath:testdb/clean/cleanTestDb.sql", executionPhase = Sql.ExecutionPhase.AFTER_TEST_METHOD)
    void testGetAllFilters() {
        List<FilterDto> filterDtos = filterService.getAllFilters();
        assertThat(filterDtos).hasSize(1);
    }

    @Test
    @DisplayName("Test save filter with criteria")
    @Sql(scripts = "classpath:testdb/clean/cleanTestDb.sql", executionPhase = Sql.ExecutionPhase.AFTER_TEST_METHOD)
    void testSaveFilterWithCriteria() {
        FilterRequestDto filterRequestDto = getFilterRequestDto(List.of(getDateCriteria(), getNumberCriteria(), getTextCriteria()));
        filterService.saveFilter(filterRequestDto);

        List<FilterDto> filterDtos = filterService.getAllFilters();
        assertThat(filterDtos).hasSize(1);

        List<Criteria> criterias = new ArrayList<>();
        criterias.addAll(textCriteriaRepository.findAll());
        criterias.addAll(dateCriteriaRepository.findAll());
        criterias.addAll(numberCriteriaRepository.findAll());
        assertThat(criterias).hasSize(3);
    }
}