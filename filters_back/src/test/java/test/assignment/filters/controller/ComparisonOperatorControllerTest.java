package test.assignment.filters.controller;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;
import org.springframework.test.context.jdbc.Sql;
import test.assignment.filters.IntegrationTest;
import test.assignment.filters.dto.FilterResponseDto;

import static java.lang.String.format;
import static org.assertj.core.api.Assertions.assertThat;
import static org.flywaydb.core.internal.util.FileUtils.readResourceAsString;
import static org.springframework.http.MediaType.APPLICATION_JSON;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;
import static test.assignment.filters.TestUtils.testDataJson;

class FilterControllerTest extends IntegrationTest {

    @ParameterizedTest
    @CsvSource(value = "FilterSaveRequest.json:FilterSaveResponse.json", delimiter = ':')
    @DisplayName("Save filter and criteria test")
    @Sql(scripts = "classpath:testdb/clean/cleanTestDb.sql", executionPhase = Sql.ExecutionPhase.AFTER_TEST_METHOD)
    void saveFilterAndCriteria(String request, String response) throws Exception {
        var filterAndCriteriaRequest = readResourceAsString(request);

        var mockResponse = mockMvc.perform(
                        post("/filters/save")
                                .contentType(APPLICATION_JSON)
                                .accept(APPLICATION_JSON)
                                .content(filterAndCriteriaRequest))
                .andExpect(status().isOk()).andReturn().getResponse().getContentAsString();
        var filterResponseDtoHttpResourceResult = objectMapper.readValue(mockResponse, FilterResponseDto.class);
        var filterResponseDtoHtppResourceExpected = testDataJson(response, objectMapper, FilterResponseDto.class);

        assertThat(filterResponseDtoHttpResourceResult)
                .usingRecursiveComparison()
                .isEqualTo(filterResponseDtoHtppResourceExpected);
    }
}
