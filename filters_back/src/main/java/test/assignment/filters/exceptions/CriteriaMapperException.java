package test.assignment.filters.exceptions;

import lombok.Getter;
import lombok.Setter;

@Setter
@Getter
public class CriteriaMapperException extends IllegalArgumentException {

    private final String code;

    public CriteriaMapperException(String message, String code) {
        super(message);
        this.code = code;
    }
}
