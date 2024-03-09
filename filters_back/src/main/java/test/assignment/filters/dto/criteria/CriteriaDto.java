package test.assignment.filters.dto.criteria;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonSubTypes;
import com.fasterxml.jackson.annotation.JsonTypeInfo;
import lombok.*;
import test.assignment.filters.dto.ComparisonOperatorDto;

@Data
@NoArgsConstructor
@AllArgsConstructor
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

    // TODO to check whether it works without this annotation
    private String criteriaType;

    private ComparisonOperatorDto comparisonOperator;
}
