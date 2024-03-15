package test.assignment.filters.controller;

import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import test.assignment.filters.dto.ComparisonOperatorDto;
import test.assignment.filters.service.ComparisonOperatorService;

import java.util.List;

@Slf4j
@RestController
@RequiredArgsConstructor
@RequestMapping("/comparison-operators")
public class ComparisonOperatorController {

    private final ComparisonOperatorService comparisonOperatorService;

    @Operation(summary = "Get all comparison operators", responses = @ApiResponse(responseCode = "200", description = "Comparison operators are returned"))
    @GetMapping()
    public List<ComparisonOperatorDto> getAllComparisonOperators() {
        log.info("ComparisonOperatorController.getAllCriteriaTypes() | all comparison operators request");
        return comparisonOperatorService.getAllComparisonOperators();
    }
}


