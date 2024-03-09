package test.assignment.filters.controller;

import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import test.assignment.filters.dto.criteria.CriteriaDto;
import test.assignment.filters.service.CriteriaService;

import java.util.List;

@RequestMapping("/criterias")
@RestController
@RequiredArgsConstructor
public class CriteriaController {

    private final CriteriaService criteriaService;

    @Operation(summary = "Get all criterias", responses = @ApiResponse(responseCode = "200", description = "Criterias are returned"))
    @GetMapping("{id}")
    public List<CriteriaDto> getAllCriterias(@PathVariable("id") Long id) {
        return criteriaService.getAllCriterias(id);
    }
}
