package test.assignment.filters.persistence.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;
import test.assignment.filters.persistence.model.ComparisonOperator;
import test.assignment.filters.persistence.model.criteria.Criteria;
import test.assignment.filters.persistence.model.criteria.DateCriteria;
import test.assignment.filters.persistence.model.criteria.NumberCriteria;
import test.assignment.filters.persistence.model.criteria.TextCriteria;

import java.util.List;

@Repository
public interface CriteriaRepository extends JpaRepository<Criteria, Long> {
}
