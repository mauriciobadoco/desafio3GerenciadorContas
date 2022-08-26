package com.desafio.GerenciadorContas.exception;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.MessageSource;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.http.converter.HttpMessageNotReadableException;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.context.request.WebRequest;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;

import javax.servlet.http.HttpServletRequest;

@ControllerAdvice
public class ExceptionHandlerContas extends ResponseEntityExceptionHandler{

    @Autowired
    MessageSource messageSource;

    @Override
    protected ResponseEntity<Object> handleHttpMessageNotReadable(HttpMessageNotReadableException ex,
                                                                  HttpHeaders headers, HttpStatus status,
                                                                  WebRequest request) {
        String mensagemUsuario = messageSource.getMessage("MENSAGEM.INVALIDA", null,null);
        String mensagemDev = ex.getCause().toString();
        return handleExceptionInternal(ex, new MsgError(mensagemUsuario, mensagemDev),headers, HttpStatus.BAD_REQUEST, request);
    }

    @Getter
    @Service
    @AllArgsConstructor
    @NoArgsConstructor
    public static class MsgError{

        private  String mensagemDoUsuario;
        private String mensagemDoDev;
    }
}
