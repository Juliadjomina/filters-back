package test.assignment.filters.persistence.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import test.assignment.filters.persistence.model.ComparisonOperator;
import test.assignment.filters.persistence.model.CriteriaType;

@Repository
public interface CriteriaTypeRepository extends JpaRepository<CriteriaType, Long> {
    CriteriaType getCriteriaTypeByType(String type);

}
