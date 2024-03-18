package test.assignment.filters.controller;

import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import test.assignment.filters.dto.SelectionDto;
import test.assignment.filters.service.SelectionService;

import java.util.List;

@RestController
@RequiredArgsConstructor
@RequestMapping("/selections")
public class SelectionsController {

    private final SelectionService selectionService;

    @Operation(summary = "Get all comparison operators", responses = @ApiResponse(responseCode = "200", description = "Comparison operators are returned"))
    @GetMapping()
    public List<SelectionDto> getAllComparisonOperators() {
        return selectionService.getAllSelections();
    }
}
