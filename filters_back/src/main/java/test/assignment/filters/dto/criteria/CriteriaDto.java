package test.assignment.filters.dto.criteria;

import com.fasterxml.jackson.annotation.JsonSubTypes;
import com.fasterxml.jackson.annotation.JsonTypeInfo;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import test.assignment.filters.dto.ComparisonOperatorDto;

import static test.assignment.filters.error.ErrorConstants.*;
import static test.assignment.filters.validator.FiltersValidationConstants.MAX_FILTER_NAME_INPUT;
import static test.assignment.filters.validator.FiltersValidationConstants.MAX_SELECTION_NAME_INPUT;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@JsonTypeInfo(
        use = JsonTypeInfo.Id.NAME,
        property = "criteriaType",
        visible = true
)
@JsonSubTypes({
        @JsonSubTypes.Type(value = DateCriteriaDto.class, name = "DATE"),
        @JsonSubTypes.Type(value = AmountCriteriaDto.class, name = "AMOUNT"),
        @JsonSubTypes.Type(value = TitleCriteriaDto.class, name = "TITLE")
})
public class CriteriaDto {

    private String criteriaType;
    private ComparisonOperatorDto comparisonOperator;
}
