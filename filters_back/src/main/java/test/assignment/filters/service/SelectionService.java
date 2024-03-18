package test.assignment.filters.service;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;
import test.assignment.filters.dto.SelectionDto;
import test.assignment.filters.mapper.SelectionMapper;
import test.assignment.filters.persistence.model.Selection;
import test.assignment.filters.persistence.repository.SelectionRepository;

import java.util.List;

@Slf4j
@Service
@RequiredArgsConstructor
public class SelectionService {

    private final SelectionRepository selectionRepository;
    private final SelectionMapper selectionMapper;

    public List<SelectionDto> getAllSelections() {
        log.info("SelectionService.getAllSelections() | all selections request");
        final List<Selection> filters = selectionRepository.findAll();
        return selectionMapper.toSelectionDtos(filters);
    }
}
