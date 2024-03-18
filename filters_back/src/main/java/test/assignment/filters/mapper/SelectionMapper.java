package test.assignment.filters.mapper;

import org.mapstruct.Mapper;
import test.assignment.filters.dto.SelectionDto;
import test.assignment.filters.persistence.model.Selection;

import java.util.List;

@Mapper(componentModel = "spring")
public interface SelectionMapper {

    List<SelectionDto> toSelectionDtos(List<Selection> comparisonOperator);
}
