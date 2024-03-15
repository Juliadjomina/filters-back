package test.assignment.filters.dto;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import test.assignment.filters.dto.criteria.CriteriaDto;

import java.util.List;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class FilterResponseDto {


    private String filterName;
    private List<CriteriaDto> criteriaList;
}
