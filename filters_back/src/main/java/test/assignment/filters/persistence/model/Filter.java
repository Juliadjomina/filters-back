package test.assignment.filters.persistence.model;

import jakarta.persistence.*;
import lombok.*;

import java.util.Date;

@Entity
@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@Table(name = "Filter")
public class Filter {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id", nullable = false)
    private Long id;

    @Column(name = "filter_name", nullable = false)
    private String filterName;

    @Column(name = "created_at", nullable = false)
    private Date cratedAt;

    @Column(name = "archived_at", nullable = false)
    private Date archivedAt;
}
