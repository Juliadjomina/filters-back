package test.assignment.filters.dto;

import lombok.*;
import test.assignment.filters.dto.criteria.CriteriaDto;

import java.util.List;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@ToString
public class FilterDto {
    private Long id;
    private String filterName;
}
