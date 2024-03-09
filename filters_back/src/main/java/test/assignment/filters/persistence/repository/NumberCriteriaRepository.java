package test.assignment.filters.persistence.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;
import test.assignment.filters.persistence.model.criteria.NumberCriteria;
import test.assignment.filters.persistence.model.criteria.TextCriteria;

import java.util.List;

@Repository
public interface NumberCriteriaRepository extends JpaRepository<NumberCriteria, Long> {
    @Query("SELECT tc FROM NumberCriteria tc JOIN FETCH tc.comparisonOperator JOIN FETCH tc.filter JOIN FETCH tc.type WHERE tc.filter.id =:id")
    List<NumberCriteria> getDateCriteria(Long id);
}
