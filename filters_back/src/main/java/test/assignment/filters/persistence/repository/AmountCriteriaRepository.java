package test.assignment.filters.persistence.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;
import test.assignment.filters.persistence.model.criteria.AmountCriteria;

import java.util.List;

@Repository
public interface AmountCriteriaRepository extends JpaRepository<AmountCriteria, Long> {

    @Query("SELECT tc FROM AmountCriteria tc JOIN FETCH tc.comparisonOperator JOIN FETCH tc.filter JOIN FETCH tc.type WHERE tc.filter.id =:id")
    List<AmountCriteria> getDateCriteria(Long id);
}
