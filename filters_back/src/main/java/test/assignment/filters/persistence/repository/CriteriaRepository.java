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
//    @Query(value = "SELECT * FROM DateCriteria dc JOIN Filter f ON f.id =:filterId", nativeQuery = true)
//    List<DateCriteria> getDateCriteria(@Param("filterId") Long filterId);
//
//    @Query("select dc from NumberCriteria dc where dc.filter.id=:filterId")
//    List<NumberCriteria> getNumberCriteria(@Param("filterId") Long filterId);
//
//    @Query("select dc from TextCriteria dc where dc.filter.id=:filterId")
//    List<TextCriteria> getTextCriteria(@Param("filterId") Long filterId);


}
