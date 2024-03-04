package test.assignment.filters.controller;

import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;
import test.assignment.filters.dto.FilterDto;
import test.assignment.filters.dto.FilterRequestDto;
import test.assignment.filters.service.FilterService;

import java.util.List;

@RequestMapping({"/filters"})
@RestController
@RequiredArgsConstructor
public class FilterController {

    private final FilterService filterService;

    @GetMapping(produces = "application/json")
    public List<FilterDto> allFilters() {
        return filterService.getAllFilters();
    }

    @DeleteMapping("{id}")
    public void deleteFilter(@PathVariable("id") Long id) {
        filterService.deleteFilter(id);
    }

    @PostMapping
    public Long saveFilter(@RequestBody FilterRequestDto filterRequestDto) {
        return filterService.saveFilter(filterRequestDto);
    }
}
