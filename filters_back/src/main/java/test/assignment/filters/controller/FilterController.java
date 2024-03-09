package test.assignment.filters.controller;

import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;
import test.assignment.filters.dto.FilterDto;
import test.assignment.filters.dto.FilterRequestDto;
import test.assignment.filters.service.FilterService;

import java.util.List;

@RequestMapping("/filters")
@RestController
@RequiredArgsConstructor
public class FilterController {

    private final FilterService filterService;

    @Operation(summary = "Get all filters", responses = @ApiResponse(responseCode = "200", description = "Filters are returned"))
    @GetMapping()
    public List<FilterDto> getAllFilters() {
        return filterService.getAllFilters();
    }

    @Operation(summary = "Delete filter", responses = @ApiResponse(responseCode = "200", description = "Filter is deleted"))
    @DeleteMapping("{id}")
    public void deleteFilter(@PathVariable("id") Long id) {
        // TODO NO DELETE BUT PUT ARCHIVED DATE
        filterService.deleteFilter(id);
    }

    @Operation(summary = "Save filter", responses = @ApiResponse(responseCode = "200", description = "Filter is saved"))
    @PostMapping
    public Long saveFilter(@RequestBody FilterRequestDto filterRequestDto) {
        return filterService.saveFilter(filterRequestDto);
    }
}
