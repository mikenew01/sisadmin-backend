package io.mk.sisadmin.configuration.exceptions;

import io.mk.sisadmin.configuration.message.CoreMessageProperty;
import io.mk.sisadmin.configuration.message.ErrorMessage;
import io.mk.sisadmin.configuration.message.IMessageProperty;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.AccessDeniedException;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.context.request.WebRequest;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;

import java.util.ArrayList;
import java.util.List;

@ControllerAdvice
public class ApplicationHandlerException extends ResponseEntityExceptionHandler {

    private static Log LOG = LogFactory.getLog(ApplicationHandlerException.class);

    public ApplicationHandlerException() {
    }

    private static IMessageProperty get() {
        return CoreMessageProperty.API_RESOURCE_NOTFOUND;
    }

    @ExceptionHandler({AccessDeniedException.class})
    protected ResponseEntity<Object> handleAccessDenied(AccessDeniedException ex, WebRequest request) {
        List<ErrorMessage> erros = new ArrayList();
        erros.add(new ErrorMessage(CoreMessageProperty.API_ACCESS_DENIED));
        LOG.debug(ex.getMessage(), ex);
        return this.handleExceptionInternal(ex, erros, new HttpHeaders(), HttpStatus.FORBIDDEN, request);
    }

    @ExceptionHandler({BusinessException.class})
    protected ResponseEntity<Object> handleSecurity(BusinessException ex, WebRequest request) {
        List<ErrorMessage> erros = new ArrayList();
        ex.getMessages().iterator().forEachRemaining((msg) -> {
            erros.add(new ErrorMessage(msg));
        });
        if (erros.isEmpty()) {
            erros.add(new ErrorMessage(CoreMessageProperty.API_UNDENTIFIED_ERROR));
        }

        LOG.debug(ex.getMessage(), ex);
        return this.handleExceptionInternal(ex, erros, new HttpHeaders(), HttpStatus.BAD_REQUEST, request);
    }

    @ExceptionHandler({ResourceNotFoundException.class})
    protected ResponseEntity<Object> handleResourceNotFound(ResourceNotFoundException ex, WebRequest request) {
        IMessageProperty msg = ex.getMessageField().orElseGet(ApplicationHandlerException::get);
        List<ErrorMessage> erros = new ArrayList();
        erros.add(new ErrorMessage(msg));
        LOG.debug(ex.getMessage(), ex);
        return this.handleExceptionInternal(ex, erros, new HttpHeaders(), HttpStatus.NOT_FOUND, request);
    }

    @ExceptionHandler({SecurityValidationException.class})
    protected ResponseEntity<Object> handleSecurity(SecurityValidationException ex, WebRequest request) {
        IMessageProperty msg = ex.getMessageField().orElse(CoreMessageProperty.API_ACCESS_DENIED);
        List<ErrorMessage> erros = new ArrayList();
        erros.add(new ErrorMessage(msg));
        LOG.debug(ex.getMessage(), ex);
        return this.handleExceptionInternal(ex, erros, new HttpHeaders(), HttpStatus.FORBIDDEN, request);
    }

    protected ResponseEntity<Object> handleMethodArgumentNotValid(MethodArgumentNotValidException ex, HttpHeaders headers, HttpStatus status, WebRequest request) {
        List<ErrorMessage> erros = new ArrayList();
        erros.add(new ErrorMessage(ex.getParameter().getParameterName(), ex.getBindingResult().toString()));
        LOG.debug(ex.getMessage(), ex);
        return this.handleExceptionInternal(ex, erros, new HttpHeaders(), HttpStatus.BAD_REQUEST, request);
    }

}
