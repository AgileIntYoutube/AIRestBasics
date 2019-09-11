package io.agileintlligence.airestbasics.exception;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(code = HttpStatus.NOT_FOUND)
public class BacklogItemNotFoundException extends RuntimeException {

    public BacklogItemNotFoundException(String message) {
        super(message);
    }
}
