package test.assignment.filters.mapper;

import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import test.assignment.filters.dto.criteria.AmountCriteriaDto;
import test.assignment.filters.dto.criteria.DateCriteriaDto;
import test.assignment.filters.dto.criteria.TitleCriteriaDto;
import test.assignment.filters.persistence.model.criteria.AmountCriteria;
import test.assignment.filters.persistence.model.criteria.DateCriteria;
import test.assignment.filters.persistence.model.criteria.TitleCriteria;

@Mapper(componentModel = "spring")
public interface CriteriaMapper {

    TitleCriteria toTitleCriteria(TitleCriteriaDto titleCriteriadto);

    AmountCriteria toAmountCriteria(AmountCriteriaDto amountCriteriadto);

    DateCriteria toDateCriteria(DateCriteriaDto dateCriteriadto);

    @Mapping(target = "criteriaType", source = "titleCriteria.type.type")
    TitleCriteriaDto toTitleCriteriaDto(TitleCriteria titleCriteria);

    @Mapping(target = "criteriaType", source = "amountCriteria.type.type")
    AmountCriteriaDto toAmountCriteriaDto(AmountCriteria amountCriteria);

    @Mapping(target = "criteriaType", source = "dateCriteria.type.type")
    DateCriteriaDto toDateCriteriaDto(DateCriteria dateCriteria);
}
