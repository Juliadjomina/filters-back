package test.assignment.filters.dto;

import jakarta.persistence.Column;
import lombok.*;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@ToString
public class ComparisonOperatorDto {

    private String operatorName;
    private String operatorType;
}
