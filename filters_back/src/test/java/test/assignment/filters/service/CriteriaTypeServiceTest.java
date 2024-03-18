package test.assignment.filters.service;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import test.assignment.filters.IntegrationTest;
import test.assignment.filters.dto.CriteriaTypeDto;

import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;

class CriteriaTypeServiceTest extends IntegrationTest {

    @Autowired
    private CriteriaTypeService criteriaTypeService;

    @Test
    @DisplayName("Test get all criteria types")
    void testGetAllCriteriaTypes() {
        List<CriteriaTypeDto> criteriaTypeDtos = criteriaTypeService.getAllCriteriaTypes();
        assertThat(criteriaTypeDtos).hasSize(3);
    }
}
