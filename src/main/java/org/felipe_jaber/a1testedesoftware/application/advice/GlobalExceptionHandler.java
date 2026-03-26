package org.felipe_jaber.a1testedesoftware.application.advice;

import org.felipe_jaber.a1testedesoftware.application.exception.CustomerAlreadyExistsException;
import org.felipe_jaber.a1testedesoftware.application.exception.CustomerNotFoundException;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.servlet.ModelAndView;

import jakarta.servlet.http.HttpServletRequest;
import java.util.HashMap;
import java.util.Map;

@ControllerAdvice
public class GlobalExceptionHandler {

    @ExceptionHandler(IllegalArgumentException.class)
    public Object handleIllegalArgumentException(IllegalArgumentException ex, HttpServletRequest request) {
        if (isApiRequest(request)) {
            Map<String, String> body = new HashMap<>();
            body.put("error", ex.getMessage());
            return new ResponseEntity<>(body, HttpStatus.BAD_REQUEST);
        }
        return createErrorModelAndView(ex.getMessage(), HttpStatus.BAD_REQUEST);
    }

    @ExceptionHandler(CustomerNotFoundException.class)
    public Object handleNotFoundException(CustomerNotFoundException ex, HttpServletRequest request) {
        if (isApiRequest(request)) {
            Map<String, String> body = new HashMap<>();
            body.put("error", ex.getMessage());
            return new ResponseEntity<>(body, HttpStatus.NOT_FOUND);
        }
        return createErrorModelAndView(ex.getMessage(), HttpStatus.NOT_FOUND);
    }

    @ExceptionHandler(CustomerAlreadyExistsException.class)
    public Object handleAlreadyExistsException(CustomerAlreadyExistsException ex, HttpServletRequest request) {
        if (isApiRequest(request)) {
            Map<String, String> body = new HashMap<>();
            body.put("error", ex.getMessage());
            return new ResponseEntity<>(body, HttpStatus.CONFLICT);
        }
        return createErrorModelAndView(ex.getMessage(), HttpStatus.CONFLICT);
    }

    @ExceptionHandler(Exception.class)
    public Object handleGeneralException(Exception ex, HttpServletRequest request) {
        if (isApiRequest(request)) {
            Map<String, String> body = new HashMap<>();
            body.put("error", "Ocorreu um erro interno no servidor");
            return new ResponseEntity<>(body, HttpStatus.INTERNAL_SERVER_ERROR);
        }
        return createErrorModelAndView("Ocorreu um erro inesperado. Tente novamente mais tarde.", HttpStatus.INTERNAL_SERVER_ERROR);
    }

    private boolean isApiRequest(HttpServletRequest request) {
        return request.getRequestURI().startsWith("/api");
    }

    private ModelAndView createErrorModelAndView(String message, HttpStatus status) {
        ModelAndView modelAndView = new ModelAndView("error");
        modelAndView.addObject("errorMessage", message);
        modelAndView.addObject("status", status.value());
        modelAndView.setStatus(status);
        return modelAndView;
    }
}
