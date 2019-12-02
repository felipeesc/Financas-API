package br.com.alura.student.controller;

import br.com.alura.student.model.Curso;
import br.com.alura.student.model.Topico;
import br.com.alura.student.model.dto.TopicoDto;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.Arrays;
import java.util.List;

@RestController
public class TopicoController {

    @RequestMapping("/topicos")
    public List<TopicoDto> lista() {
        Topico topico = new Topico("Teste", "duvidas", new Curso("Spring", "Programacao"));
        return TopicoDto.converter(Arrays.asList(topico, topico, topico, topico));
    }
}
