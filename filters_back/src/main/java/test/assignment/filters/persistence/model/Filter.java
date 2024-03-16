package test.assignment.filters.persistence.model;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.OffsetDateTime;

import static jakarta.persistence.GenerationType.IDENTITY;

@Data
@Entity
@AllArgsConstructor
@NoArgsConstructor
@Table(name = "Filter")
public class Filter {

    @Id
    @GeneratedValue(strategy = IDENTITY)
    @Column(name = "id", nullable = false)
    private Long id;

    @Column(name = "filter_name", nullable = false)
    private String filterName;

    @Column(name = "created_at", nullable = false)
    private OffsetDateTime cratedAt;

    @Column(name = "archived_at")
    private OffsetDateTime archivedAt;
}
