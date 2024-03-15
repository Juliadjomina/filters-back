package test.assignment.filters.service;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.jdbc.Sql;
import test.assignment.filters.IntegrationTest;
import test.assignment.filters.dto.ComparisonOperatorDto;

import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;

class ComparisonOperatorServiceTest extends IntegrationTest {

    @Autowired
    private ComparisonOperatorService comparisonOperatorService;

    @Test
    @DisplayName("Test get comparison operators")
    void testGetAllComparisonOperator() {
        List<ComparisonOperatorDto> comparisonOperatorDtos = comparisonOperatorService.getAllComparisonOperators();
        assertThat(comparisonOperatorDtos).hasSize(16);
    }
}
