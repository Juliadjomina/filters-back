package test.assignment.filters.controller;

import lombok.AllArgsConstructor;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import test.assignment.filters.dto.FilterDto;
import test.assignment.filters.dto.criteria.CriteriaDto;
import test.assignment.filters.mapper.CriteriaMapper;
import test.assignment.filters.mapper.CriteriaMapperImpl;
import test.assignment.filters.mapper.FilterMapper;
import test.assignment.filters.persistence.model.criteria.Criteria;
import test.assignment.filters.service.CriteriaService;
import test.assignment.filters.service.FilterService;

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
