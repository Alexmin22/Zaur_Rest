package ru.spring.rest.exception_handing;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

@ControllerAdvice
public class EmplGlobalExepHandler {

    @ExceptionHandler
    public ResponseEntity<EmplNumbNotFind> handleException(NoSuchEmplExcep excep) {
        EmplNumbNotFind emplNotFind = new EmplNumbNotFind();
        emplNotFind.setInfo(excep.getMessage());

        return new ResponseEntity<>(emplNotFind, HttpStatus.NOT_FOUND);
    }

    @ExceptionHandler
    public ResponseEntity<EmplNumbNotFind>  handleException(Exception exception) {
        EmplNumbNotFind emplNotFind = new EmplNumbNotFind();
        emplNotFind.setInfo(exception.getMessage());

        return new ResponseEntity<>(emplNotFind, HttpStatus.BAD_REQUEST);
    }
}
