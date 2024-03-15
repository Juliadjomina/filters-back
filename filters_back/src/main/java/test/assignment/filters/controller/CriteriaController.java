package test.assignment.filters.controller;

import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import test.assignment.filters.dto.criteria.CriteriaDto;
import test.assignment.filters.service.CriteriaService;

import java.util.List;

@Slf4j
@RestController
@RequiredArgsConstructor
@RequestMapping("/criteria")
public class CriteriaController {

    private final CriteriaService criteriaService;

    @Operation(summary = "Get all criteria", responses = @ApiResponse(responseCode = "200", description = "Criteria are returned"))
    @GetMapping("{id}")
    public List<CriteriaDto> getAllCriteria(@PathVariable("id") Long id) {
        log.info("CriteriaController.getAllCriteria() | all comparison operators request");
        return criteriaService.getAllCriterias(id);
    }
}
