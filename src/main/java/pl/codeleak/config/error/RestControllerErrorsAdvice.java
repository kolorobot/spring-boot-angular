package pl.codeleak.config.error;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.env.Environment;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.ObjectError;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.context.request.WebRequest;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;
import pl.codeleak.config.Profiles;

@ControllerAdvice(annotations = RestController.class)
public class RestControllerErrorsAdvice extends ResponseEntityExceptionHandler {

    private static final Logger LOG = LoggerFactory.getLogger(RestControllerErrorsAdvice.class);

    @Autowired
    private Environment environment;

    @Override
    protected ResponseEntity<Object> handleMethodArgumentNotValid(MethodArgumentNotValidException exception,
                                                                  HttpHeaders headers,
                                                                  HttpStatus status,
                                                                  WebRequest request) {
        ValidationError error = new ValidationError("Validation failed. " + exception.getBindingResult().getErrorCount() + " error(s)");
        error.withException(exception, environment.acceptsProfiles(Profiles.DEV));
        for (ObjectError objectError : exception.getBindingResult().getAllErrors()) {
            error.addValidationError(objectError.getDefaultMessage());
        }
        return super.handleExceptionInternal(exception, error, headers, status, request);
    }

}