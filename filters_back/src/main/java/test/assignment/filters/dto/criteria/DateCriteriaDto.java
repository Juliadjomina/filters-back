package test.assignment.filters.dto.criteria;

import lombok.*;

import java.util.Date;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@ToString
public class DateCriteriaDto extends CriteriaDto {

    private Date value;
}
