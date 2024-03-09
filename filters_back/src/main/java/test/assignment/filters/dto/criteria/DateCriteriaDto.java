package test.assignment.filters.dto.criteria;

import lombok.*;

import java.util.Date;

@Data
@AllArgsConstructor
@NoArgsConstructor
@EqualsAndHashCode(callSuper = true)
public class DateCriteriaDto extends CriteriaDto {

    private Date date;
}

