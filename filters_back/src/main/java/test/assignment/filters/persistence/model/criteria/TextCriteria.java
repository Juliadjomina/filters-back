package test.assignment.filters.persistence.model.criteria;

import jakarta.persistence.Column;
import jakarta.persistence.DiscriminatorValue;
import jakarta.persistence.Entity;
import jakarta.persistence.Table;
import lombok.*;

@Data
@Entity
@AllArgsConstructor
@NoArgsConstructor
@EqualsAndHashCode(callSuper = true)
public class TextCriteria extends Criteria {

    @Column(name = "value", nullable = false)
    private String text;
}
