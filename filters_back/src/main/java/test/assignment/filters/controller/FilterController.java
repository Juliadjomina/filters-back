package test.assignment.filters.controller;

import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;
import test.assignment.filters.dto.FilterDto;
import test.assignment.filters.dto.FilterRequestDto;
import test.assignment.filters.dto.FilterResponseDto;
import test.assignment.filters.service.FilterService;

import java.util.List;

@RestController
@RequiredArgsConstructor
@RequestMapping("/filters")
public class FilterController {

    private final FilterService filterService;

    @Operation(summary = "Get all filters", responses = @ApiResponse(responseCode = "200", description = "Filters are returned"))
    @GetMapping()
    public List<FilterDto> getAllFilters() {
        return filterService.getAllFilters();
    }

    @Operation(summary = "Save filter", responses = @ApiResponse(responseCode = "200", description = "Filter is saved"))
    @PostMapping("save")
    public FilterResponseDto saveFilter(@RequestBody FilterRequestDto filterRequestDto) {
        return filterService.saveFilter(filterRequestDto);
    }
}
