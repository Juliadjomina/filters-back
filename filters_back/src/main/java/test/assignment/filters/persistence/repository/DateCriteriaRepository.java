package test.assignment.filters.persistence.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;
import test.assignment.filters.persistence.model.criteria.DateCriteria;
import test.assignment.filters.persistence.model.criteria.TextCriteria;

import java.util.List;

@Repository
public interface DateCriteriaRepository extends JpaRepository<DateCriteria, Long> {
    @Query("SELECT tc FROM DateCriteria tc JOIN FETCH tc.comparisonOperator JOIN FETCH tc.filter JOIN FETCH tc.type WHERE tc.filter.id =:id")
    List<DateCriteria> getDateCriteria(Long id);
}
