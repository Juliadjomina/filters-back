package test.assignment.filters.persistence.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;
import test.assignment.filters.persistence.model.criteria.TitleCriteria;

import java.util.List;

@Repository
public interface TitleCriteriaRepository extends JpaRepository<TitleCriteria, Long> {

    @Query("SELECT tc FROM TitleCriteria tc JOIN FETCH tc.comparisonOperator JOIN FETCH tc.filter JOIN FETCH tc.type WHERE tc.filter.id =:id")
    List<TitleCriteria> getDateCriteria(Long id);
}
