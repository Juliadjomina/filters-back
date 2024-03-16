package test.assignment.filters.persistence.model;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import static jakarta.persistence.GenerationType.IDENTITY;


@Data
@Entity
@AllArgsConstructor
@NoArgsConstructor
@Table(name = "ComparisonOperator")
public class ComparisonOperator {

    @Id
    @GeneratedValue(strategy = IDENTITY)
    @Column(name = "id")
    private Long operatorId;

    @Column(name = "operator_name")
    private String operatorName;

    @Column(name = "operator_type")
    private String operatorType;
}
