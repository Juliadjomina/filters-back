package test.assignment.filters.dto.criteria;

import lombok.*;

import java.time.OffsetDateTime;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@EqualsAndHashCode(callSuper = true)
public class DateCriteriaDto extends CriteriaDto {

    private OffsetDateTime date;
}

