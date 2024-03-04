package test.assignment.filters.persistence.model.criteria;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.springframework.context.annotation.Primary;
import test.assignment.filters.persistence.model.ComparisonOperator;
import test.assignment.filters.persistence.model.CriteriaType;
import test.assignment.filters.persistence.model.Filter;

import java.util.Date;

@MappedSuperclass
@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
public abstract class Criteria {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private int criteriaId;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "filter_id")
    private Filter filter;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "type_id")
    private CriteriaType type;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "comparison_operator_id")
    private ComparisonOperator comparisonOperator;

    @Column(name = "created_at")
    private Date createdAt;

    @Column(name = "archived_at")
    private Date archivedAt;
}
