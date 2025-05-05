package zteo.esercitazione.Universita.exception;


import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

import java.util.HashMap;
import java.util.Map;

@ControllerAdvice
public class ExceptionManagement {

    @ExceptionHandler({ConflictException.class})
    public ResponseEntity<String> conflictException(ConflictException e) {
        return ResponseEntity.status(HttpStatus.CONFLICT).body(e.getMessage());
    }

    @ExceptionHandler({BadRequestException.class})
    public ResponseEntity<String> badRequestException(BadRequestException e) {
        return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(e.getMessage());
    }

    @ExceptionHandler({ResourceNotFoundException.class})
    public ResponseEntity<String> resourceNotFoundException(ResourceNotFoundException e) {
        return ResponseEntity.status(HttpStatus.NOT_FOUND).body(e.getMessage());
    }

    @ExceptionHandler({IllegalArgumentException.class})
    public ResponseEntity<String> illegalArgumentException(IllegalArgumentException e)
    {
        return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(e.getMessage());
    }

    @ExceptionHandler({HandleInvalidEnumValue.class})
    public ResponseEntity<String> handleInvalidEnumValue(HandleInvalidEnumValue e)
    {
        return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(e.getMessage());
    }
}
