package test.assignment.filters.service;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.jdbc.Sql;
import test.assignment.filters.IntegrationTest;
import test.assignment.filters.dto.criteria.CriteriaDto;

import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;
import static org.springframework.test.context.jdbc.Sql.ExecutionPhase.AFTER_TEST_METHOD;
import static org.springframework.test.context.jdbc.Sql.ExecutionPhase.BEFORE_TEST_METHOD;

class CriteriaServiceTest extends IntegrationTest {

    @Autowired
    private CriteriaService criteriaService;
    @Autowired
    private FilterService filterService;

    @Test
    @DisplayName("Test get all criteria by filter id")
    @Sql(scripts = "classpath:testdb/init/initTestDataFilterWithCriteria.sql", executionPhase = BEFORE_TEST_METHOD)
    @Sql(scripts = "classpath:testdb/clean/cleanTestDb.sql", executionPhase = AFTER_TEST_METHOD)
    void testGetAllCriteriaByFilterId() {
        Long filterId = filterService.getAllFilters().getFirst().getId();
        List<CriteriaDto> criteriaDtos = criteriaService.getAllCriteria(filterId);
        assertThat(criteriaDtos).hasSize(3);
    }
}
