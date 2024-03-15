package test.assignment.filters.mapper;

import org.mapstruct.Mapper;
import org.springframework.stereotype.Component;
import test.assignment.filters.dto.ComparisonOperatorDto;
import test.assignment.filters.persistence.model.ComparisonOperator;

import java.util.List;

@Component
@Mapper(componentModel = "spring")
public interface ComparisonOperatorMapper {

    List<ComparisonOperatorDto> toComparisonOperatorDtos(List<ComparisonOperator> comparisonOperator);
}
