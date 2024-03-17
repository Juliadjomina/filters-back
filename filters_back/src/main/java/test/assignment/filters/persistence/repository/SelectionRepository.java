package test.assignment.filters.persistence.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import test.assignment.filters.persistence.model.CriteriaType;
import test.assignment.filters.persistence.model.Selection;

public interface SelectionRepository extends JpaRepository<Selection, Long> {

    Selection getSelectionByName(String name);
}
