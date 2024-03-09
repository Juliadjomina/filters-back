package test.assignment.filters.mapper;

import lombok.RequiredArgsConstructor;
import org.mapstruct.Mapper;
import org.springframework.stereotype.Component;
import test.assignment.filters.dto.ComparisonOperatorDto;
import test.assignment.filters.dto.CriteriaTypeDto;
import test.assignment.filters.persistence.model.ComparisonOperator;
import test.assignment.filters.persistence.model.CriteriaType;

import java.util.List;

@Component
@Mapper(componentModel = "spring")
public interface ComparisonOperatorMapper {

    ComparisonOperatorDto toComparisonOperatorDto(ComparisonOperator comparisonOperator);
    List<ComparisonOperatorDto> toComparisonOperatorDtos(List<ComparisonOperator> comparisonOperator);
}
