package pl.codeleak.config.error;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.google.common.base.Throwables;

import java.io.Serializable;

@JsonInclude(JsonInclude.Include.NON_NULL)
public class Error implements Serializable {

    private String errorMessage;

    private String error;

    protected Error() {
    }

    public Error(String errorMessage) {
        this.errorMessage = errorMessage;
    }

    public String getErrorMessage() {
        return errorMessage;
    }

    public void withException(Exception exception, boolean stackTrace) {
        this.error = stackTrace ? Throwables.getStackTraceAsString(exception) : exception.getClass().getName() + ": " + exception.getMessage();
    }

    public String getError() {
        return error;
    }
}