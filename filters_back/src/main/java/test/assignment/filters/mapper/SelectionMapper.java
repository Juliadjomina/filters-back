package test.assignment.filters.mapper;

import org.mapstruct.Mapper;
import test.assignment.filters.dto.ComparisonOperatorDto;
import test.assignment.filters.dto.SelectionDto;
import test.assignment.filters.dto.criteria.TitleCriteriaDto;
import test.assignment.filters.persistence.model.ComparisonOperator;
import test.assignment.filters.persistence.model.Selection;
import test.assignment.filters.persistence.model.criteria.TitleCriteria;

import java.util.List;

@Mapper(componentModel = "spring")
public interface SelectionMapper {

    List<SelectionDto> toSelectionDtos(List<Selection> comparisonOperator);

}
