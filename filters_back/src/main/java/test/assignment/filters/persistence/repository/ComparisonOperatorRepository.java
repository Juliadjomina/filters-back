package test.assignment.filters.persistence.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import test.assignment.filters.persistence.model.ComparisonOperator;

@Repository
public interface ComparisonOperatorRepository extends JpaRepository<ComparisonOperator, Long> {
    ComparisonOperator getComparisonOperatorByOperatorNameAndOperatorType(String operatorName, String operatorType);
}
