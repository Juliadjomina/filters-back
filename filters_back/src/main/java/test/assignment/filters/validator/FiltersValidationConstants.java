package test.assignment.filters.validator;

import lombok.NoArgsConstructor;

import java.util.List;

import static lombok.AccessLevel.PRIVATE;
import static test.assignment.filters.helper.FilterConstants.*;

@NoArgsConstructor(access = PRIVATE)
public class FiltersValidationConstants {
    public static final int MAX_FILTER_NAME_INPUT = 255;
    public static final int MAX_CRITERIA_NAME_INPUT = 255;
    public static final int MAX_COMPARISON_OPERATOR_INPUT = 255;
    public static final List<String> TYPE = List.of(AMOUNT, TITLE, DATE);
}
