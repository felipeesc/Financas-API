package br.com.alura.student.config;

import br.com.alura.student.model.dto.ErrosFormularioDto;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.MessageSource;
import org.springframework.context.i18n.LocaleContextHolder;
import org.springframework.http.HttpStatus;
import org.springframework.validation.FieldError;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestControllerAdvice;

import java.util.ArrayList;
import java.util.List;

@RestControllerAdvice
public class ErrosHandler {

    @Autowired
    private MessageSource messageSource;

    @ResponseStatus(code = HttpStatus.BAD_REQUEST)
    @ExceptionHandler(MethodArgumentNotValidException.class)
    public List<ErrosFormularioDto> handler(MethodArgumentNotValidException excetpion){
        List<ErrosFormularioDto> dto = new ArrayList<>();
        List<FieldError> fieldErros = excetpion.getBindingResult().getFieldErrors();

        fieldErros.forEach(e -> {
            String mensagem = messageSource.getMessage(e, LocaleContextHolder.getLocale());
            ErrosFormularioDto erro = new ErrosFormularioDto(e.getField(), mensagem);
            dto.add(erro);
        });
        return dto;
    }
}
