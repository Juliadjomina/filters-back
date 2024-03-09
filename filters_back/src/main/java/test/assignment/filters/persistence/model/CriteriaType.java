package test.assignment.filters.persistence.model;

import jakarta.persistence.*;
import lombok.*;
import test.assignment.filters.persistence.model.enums.CriteriaTypeEnum;

@Data
@Entity
@AllArgsConstructor
@NoArgsConstructor
@Table(name = "CriteriaType")
public class CriteriaType {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private Long id;

    @Column(name = "type", nullable = false)
    private String type;
}
