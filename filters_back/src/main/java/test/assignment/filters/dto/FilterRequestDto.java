package test.assignment.filters.dto;

import lombok.*;
import test.assignment.filters.dto.criteria.CriteriaDto;
import test.assignment.filters.persistence.model.criteria.Criteria;

import java.util.List;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@ToString
public class FilterRequestDto {

    private String filterName;
    private List<CriteriaDto> criteriaList;
}
