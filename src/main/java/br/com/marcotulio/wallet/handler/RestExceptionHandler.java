package br.com.marcotulio.wallet.handler;

import br.com.marcotulio.wallet.exception.ErrorDetails;
import br.com.marcotulio.wallet.exception.ModelNotFoundDetails;
import br.com.marcotulio.wallet.exception.ModelNotFoundException;
import br.com.marcotulio.wallet.exception.ValidationErrorDetails;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.lang.Nullable;
import org.springframework.validation.FieldError;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.context.request.WebRequest;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;

import java.util.Date;
import java.util.List;
import java.util.stream.Collectors;

@ControllerAdvice
public class RestExceptionHandler extends ResponseEntityExceptionHandler {

    @ExceptionHandler(ModelNotFoundException.class)
    public ResponseEntity<ModelNotFoundDetails> handleResourceNotFoundException(ModelNotFoundException modelNotFoundException){
        ModelNotFoundDetails modelNotFoundDetail = ModelNotFoundDetails.Builder.newBuilder()
                .timestamp(new Date().getTime())
                .status(HttpStatus.NOT_FOUND.value())
                .detail(modelNotFoundException.getMessage())
                .errorType(modelNotFoundException.getClass().getName())
                .title("Resource not found").build();
        return new ResponseEntity<ModelNotFoundDetails>(modelNotFoundDetail, HttpStatus.NOT_FOUND);
    }

    @Override
    public ResponseEntity<Object> handleMethodArgumentNotValid(MethodArgumentNotValidException methodArgumentNotValidException,
                                                               HttpHeaders headers,
                                                               HttpStatus status,
                                                               WebRequest request) {

        List<FieldError> fieldErrors = methodArgumentNotValidException.getBindingResult().getFieldErrors();

        String fieldNames = fieldErrors.stream().map(FieldError::getField).collect(Collectors.joining(","));
        List<String> fieldMessages = fieldErrors.stream().map(FieldError::getDefaultMessage).collect(Collectors.toList());

        ValidationErrorDetails validationErrorDetails = ValidationErrorDetails.Builder.newBuilder()
                .timestamp(new Date().getTime())
                .status(HttpStatus.BAD_REQUEST.value())
                .detail("Invalid attributes")
                .errorType(methodArgumentNotValidException.getClass().getSimpleName())
                .title("Invalid attributes")
                .field(fieldNames)
                .fieldMessage( fieldMessages ).build();

        return new ResponseEntity<>(validationErrorDetails, HttpStatus.BAD_REQUEST);
    }

    @Override
    protected ResponseEntity<Object> handleExceptionInternal(Exception ex,
                                                             @Nullable Object body,
                                                             HttpHeaders headers,
                                                             HttpStatus status,
                                                             WebRequest request) {

        ErrorDetails errorDetails = ErrorDetails.ErrorDetailsBuilder.newBuilder()
                .timestamp(new Date().getTime())
                .status(status.value())
                .detail(ex.getMessage())
                .errorType(ex.getClass().getName())
                .title("Internal server error").build();

        return new ResponseEntity<>(errorDetails,status);
    }

}
