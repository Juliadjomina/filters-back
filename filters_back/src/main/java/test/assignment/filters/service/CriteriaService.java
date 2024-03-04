package test.assignment.filters.service;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import test.assignment.filters.dto.criteria.CriteriaDto;
import test.assignment.filters.dto.criteria.DateCriteriaDto;
import test.assignment.filters.dto.criteria.NumberCriteriaDto;
import test.assignment.filters.dto.criteria.TextCriteriaDto;
import test.assignment.filters.mapper.CriteriaMapper;
import test.assignment.filters.persistence.model.criteria.Criteria;
import test.assignment.filters.persistence.model.criteria.DateCriteria;
import test.assignment.filters.persistence.model.criteria.NumberCriteria;
import test.assignment.filters.persistence.model.criteria.TextCriteria;
import test.assignment.filters.persistence.repository.DateCriteriaRepository;
import test.assignment.filters.persistence.repository.NumberCriteriaRepository;
import test.assignment.filters.persistence.repository.TextCriteriaRepository;

import java.util.ArrayList;
import java.util.List;

@Service
@RequiredArgsConstructor
public class CriteriaService {

    private final TextCriteriaRepository textCriteriaRepository;
    private final DateCriteriaRepository dateCriteriaRepository;
    private final NumberCriteriaRepository numberCriteriaRepository;
    private final CriteriaMapper criteriaMapper;


    public List<Criteria> getAllCriterias() {
        List<Criteria> filters = new ArrayList<>();
        filters.addAll(textCriteriaRepository.getDateCriteria());
        filters.addAll(dateCriteriaRepository.getDateCriteria());
        filters.addAll(numberCriteriaRepository.getDateCriteria());
        List<CriteriaDto> criteriaDtos = criteriaMapper.toCriteriaDtos(filters);

//        List<CriteriaDto> modifiedFilters = filters.stream().map (x -> {
//                    Optional<CriteriaDtoMapper> test = criteriaMapperFactory.getCriteriaDto(x.getType().getType());
//                    return test.map(m -> m.toCriteriaDto(x)).get();
//                })
//                .collect(Collectors.toList());
        return filters;
    }

    public void saveCriteriaList(List<CriteriaDto> criteriaList) {
        for (CriteriaDto criteria : criteriaList) {
            if (criteria instanceof TextCriteriaDto) {
                TextCriteria textCriteria = criteriaMapper.toTextCriteria((TextCriteriaDto) criteria);
                textCriteriaRepository.save(textCriteria);
            } else if (criteria instanceof NumberCriteriaDto) {
                NumberCriteria numberCriteria = criteriaMapper.toNumberCriteria((NumberCriteriaDto) criteria);
                numberCriteriaRepository.save(numberCriteria);
            } else if (criteria instanceof DateCriteriaDto) {
                DateCriteria dateCriteria = criteriaMapper.toDateCriteria((DateCriteriaDto) criteria);
                dateCriteriaRepository.save(dateCriteria);
            }
        }
    }
}
