package test.assignment.filters.controller;

import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import test.assignment.filters.dto.criteria.CriteriaDto;
import test.assignment.filters.service.CriteriaService;

import java.util.List;

@RequestMapping({"/criterias"})
@RestController
@RequiredArgsConstructor
public class CriteriaController {

    private final CriteriaService criteriaService;

    @GetMapping(produces = "application/json")
    public List<CriteriaDto> allCriterias() {
        return criteriaService.getAllCriterias();
    }
}
