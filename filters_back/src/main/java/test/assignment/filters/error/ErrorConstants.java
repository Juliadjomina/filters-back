package test.assignment.filters.error;

import lombok.NoArgsConstructor;

import static lombok.AccessLevel.PRIVATE;

@NoArgsConstructor(access = PRIVATE)
public class ErrorConstants {

    public static final String ERROR_FILTER_NAME_TOO_LONG = "error.filter.name.too.long";
    public static final String ERROR_CRITERIA_NAME_TOO_LONG = "error.criteria.name.too.long";
    public static final String ERROR_COMPARISON_OPERATOR_NAME_TOO_LONG = "error.comparison.operator.name.too.long";
    public static final String ERROR_FILTER_NAME_NULL = "error.filter.name.null";
    public static final String ERROR_COMPARISON_OPERATOR_NAME_NULL = "error.comparison.operator.name.null";
    public static final String ERROR_TITLE_CRITERIA_TITLE_NULL = "error.title.criteria.title.null";
    public static final String ERROR_WRONG_CRITERIA_TYPE = "error.wrong.criteria.type";
    public static final String ERROR_AMOUNT_CRITERIA_VALUE_NULL = "error.amount.criteria.value.null";
    public static final String ERROR_DATE_CRITERIA_VALUE_NULL = "error.date.criteria.value.null";
    public static final String ERROR_TITLE_CRITERIA_VALUE_NULL = "error.title.criteria.value.null";
    public static final String ERROR_CRITERIA_NULL = "error.criteria.null";
    public static final String ERROR_WRONG_COMPARISON_OPERATOR_TYPE = "error.wrong.comparison.operator.type";
}
