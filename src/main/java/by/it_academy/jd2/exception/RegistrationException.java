package by.it_academy.jd2.exception;

import java.util.List;

public class RegistrationException extends RuntimeException{
    private final List <Throwable> errors;

    public RegistrationException(List <Throwable> errors){
        this.errors = errors;
    }

    public List<Throwable> getErrors() {
        return errors;
    }
}
