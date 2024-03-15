package test.assignment.filters.exceptions;

import lombok.Getter;
import lombok.Setter;

@Setter
@Getter
public class FiltersServiceRestClientException extends RuntimeException {

    private final String code;

    public FiltersServiceRestClientException(String message, String code) {
        super(message);
        this.code = code;
    }
}
