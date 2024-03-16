package test.assignment.filters.persistence.model.criteria;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import test.assignment.filters.persistence.model.ComparisonOperator;
import test.assignment.filters.persistence.model.CriteriaType;
import test.assignment.filters.persistence.model.Filter;

import java.time.OffsetDateTime;

import static jakarta.persistence.FetchType.LAZY;


@Data
@MappedSuperclass
@NoArgsConstructor
@AllArgsConstructor
public abstract class Criteria {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private int criteriaId;

    @ManyToOne(fetch = LAZY)
    @JoinColumn(name = "filter_id")
    private Filter filter;

    @ManyToOne(fetch = LAZY)
    @JoinColumn(name = "type_id")
    private CriteriaType type;

    @ManyToOne(fetch = LAZY)
    @JoinColumn(name = "comparison_operator_id")
    private ComparisonOperator comparisonOperator;

    @Column(name = "created_at")
    private OffsetDateTime createdAt;

    @Column(name = "archived_at")
    private OffsetDateTime archivedAt;
}

