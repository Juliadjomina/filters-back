package test.assignment.filters.mapper;

import org.mapstruct.Mapper;
import test.assignment.filters.dto.CriteriaTypeDto;
import test.assignment.filters.dto.FilterDto;
import test.assignment.filters.dto.criteria.TextCriteriaDto;
import test.assignment.filters.persistence.model.CriteriaType;
import test.assignment.filters.persistence.model.Filter;
import test.assignment.filters.persistence.model.criteria.TextCriteria;

import java.util.List;

@Mapper(componentModel = "spring")
public interface CriteriaTypeMapper {

    CriteriaTypeDto toCriteriaTypeDto(CriteriaType criteriaType);
    List<CriteriaTypeDto> toCriiteriaTypeDtos(List<CriteriaType> filters);

}
