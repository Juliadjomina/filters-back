package test.assignment.filters.mapper;

import org.mapstruct.InheritInverseConfiguration;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import test.assignment.filters.dto.criteria.CriteriaDto;
import test.assignment.filters.dto.criteria.DateCriteriaDto;
import test.assignment.filters.dto.criteria.NumberCriteriaDto;
import test.assignment.filters.dto.criteria.TextCriteriaDto;
import test.assignment.filters.persistence.model.criteria.Criteria;
import test.assignment.filters.persistence.model.criteria.DateCriteria;
import test.assignment.filters.persistence.model.criteria.NumberCriteria;
import test.assignment.filters.persistence.model.criteria.TextCriteria;

import java.util.List;

@Mapper(componentModel = "spring")
public interface CriteriaMapper {
    TextCriteria toTextCriteria(TextCriteriaDto textCriteriadto);

    NumberCriteria toNumberCriteria(NumberCriteriaDto numberCriteriadto);
    DateCriteria toDateCriteria(DateCriteriaDto dateCriteriadto);

    TextCriteriaDto toTextCriteriaDto(TextCriteria textCriteria);

    NumberCriteriaDto toNumberCriteriaDto(NumberCriteria numberCriteria);

    DateCriteriaDto toDateCriteriaDto(DateCriteria dateCriteria);

    CriteriaDto toCriteriaDto(Criteria criteria);

    List<CriteriaDto> toCriteriaDtos(List<Criteria> criterias);
}
