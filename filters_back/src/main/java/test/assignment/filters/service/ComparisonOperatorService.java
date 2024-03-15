package test.assignment.filters.service;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import test.assignment.filters.dto.ComparisonOperatorDto;
import test.assignment.filters.mapper.ComparisonOperatorMapper;
import test.assignment.filters.persistence.model.ComparisonOperator;
import test.assignment.filters.persistence.repository.ComparisonOperatorRepository;

import java.util.List;

@Service
@RequiredArgsConstructor
public class ComparisonOperatorService {

    private final ComparisonOperatorRepository comparisonOperatorRepository;
    private final ComparisonOperatorMapper comparisonOperatorMapper;

    public List<ComparisonOperatorDto> getAllComparisonOperators() {
        final List<ComparisonOperator> filters = comparisonOperatorRepository.findAll();
        return comparisonOperatorMapper.toComparisonOperatorDtos(filters);
    }
}
