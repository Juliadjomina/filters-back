package test.assignment.filters.persistence.model;

import jakarta.persistence.*;
import lombok.*;


@Data
@Entity
@AllArgsConstructor
@NoArgsConstructor
@Table(name = "ComparisonOperator")
public class ComparisonOperator {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private Long operatorId;

    @Column(name = "operator_name")
    private String operatorName;

    @Column(name = "operator_type")
    private String operatorType;
}
