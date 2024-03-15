package test.assignment.filters.dto.criteria;

import com.fasterxml.jackson.annotation.JsonSubTypes;
import com.fasterxml.jackson.annotation.JsonTypeInfo;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import test.assignment.filters.dto.ComparisonOperatorDto;

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
        @JsonSubTypes.Type(value = NumberCriteriaDto.class, name = "NUMBER"),
        @JsonSubTypes.Type(value = TextCriteriaDto.class, name = "TEXT")
})
public class CriteriaDto {

    private String criteriaType;
    private ComparisonOperatorDto comparisonOperator;
}
