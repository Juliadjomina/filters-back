package test.assignment.filters.controller;

import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.*;
import test.assignment.filters.dto.FilterDto;
import test.assignment.filters.dto.FilterRequestDto;
import test.assignment.filters.dto.FilterResponseDto;
import test.assignment.filters.service.FilterService;

import java.util.List;

@Slf4j
@RestController
@RequiredArgsConstructor
@RequestMapping("/filters")
public class FilterController {

    private final FilterService filterService;

    @Operation(summary = "Get all filters", responses = @ApiResponse(responseCode = "200", description = "Filters are returned"))
    @GetMapping()
    public List<FilterDto> getAllFilters() {
        log.info("FilterController.getAllFilters() | all filters request");
        return filterService.getAllFilters();
    }

    @Operation(summary = "Save filter", responses = @ApiResponse(responseCode = "200", description = "Filter is saved"))
    @PostMapping("save")
    public FilterResponseDto saveFilter(@RequestBody FilterRequestDto filterRequestDto) {
        log.info("FilterController.saveFilter() | save filter with criteria request");
        return filterService.saveFilter(filterRequestDto);
    }
}
