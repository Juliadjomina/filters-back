package test.assignment.filters.controller;


import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import test.assignment.filters.dto.CriteriaTypeDto;
import test.assignment.filters.service.CriteriaTypeService;

import java.util.List;

@Slf4j
@RestController
@RequiredArgsConstructor
@RequestMapping("/criteria-types")
public class CriteriaTypeController {

    private final CriteriaTypeService criteriaTypeService;

    @Operation(summary = "Get all criteria types", responses = @ApiResponse(responseCode = "200", description = "Criteria types are returned"))
    @GetMapping()
    public List<CriteriaTypeDto> getAllCriteriaTypes() {
        log.info("CriteriaTypeController.getAllCriteriaTypes() | all criteria types request");
        return criteriaTypeService.getAllCriteriaTypes();
    }
}
