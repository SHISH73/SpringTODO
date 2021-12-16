package com.nuzhd.errors;

import org.springframework.validation.Errors;
import org.springframework.validation.ObjectError;

public class ToDoValidationErrorBuilder {
    public static ToDoValidationError fromBindingErrors(Errors errors){
        ToDoValidationError error = new ToDoValidationError("Validation failed. "
        + errors.getErrorCount() + " error(s)");
        for (ObjectError objError : errors.getAllErrors()){
            error.addValidationError(objError.getDefaultMessage());
        }
        return error;
    }
}
