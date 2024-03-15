package test.assignment.filters.mapper;

import org.mapstruct.Mapper;
import test.assignment.filters.dto.CriteriaTypeDto;
import test.assignment.filters.persistence.model.CriteriaType;

import java.util.List;

@Mapper(componentModel = "spring")
public interface CriteriaTypeMapper {

    List<CriteriaTypeDto> toCriteriaTypeDtos(List<CriteriaType> filters);
}
