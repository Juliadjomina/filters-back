package test.assignment.filters.persistence.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import test.assignment.filters.persistence.model.criteria.Criteria;

@Repository
public interface CriteriaRepository extends JpaRepository<Criteria, Long> {
}
