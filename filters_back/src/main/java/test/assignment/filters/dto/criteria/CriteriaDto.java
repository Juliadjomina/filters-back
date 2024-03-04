package test.assignment.filters.dto.criteria;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonSubTypes;
import com.fasterxml.jackson.annotation.JsonTypeInfo;
import lombok.*;
import test.assignment.filters.dto.ComparisonOperatorDto;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@ToString
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

    @JsonProperty("criteriaType")
    private String criteriaType;

    private ComparisonOperatorDto comparisonOperator;

}
