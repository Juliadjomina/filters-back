package test.assignment.filters.service;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import test.assignment.filters.IntegrationTest;
import test.assignment.filters.dto.CriteriaTypeDto;
import test.assignment.filters.dto.SelectionDto;

import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;

class SelectionServiceTest extends IntegrationTest {

    @Autowired
    private SelectionService selectionService;

    @Test
    @DisplayName("Test get all selections")
    void testGetAllCriteriaTypes() {
        List<SelectionDto> selectionDtos = selectionService.getAllSelections();
        assertThat(selectionDtos).hasSize(3);
    }
}
