package br.com.alura.student.controller;

import br.com.alura.student.model.Topico;
import br.com.alura.student.model.dto.TopicoDto;
import br.com.alura.student.model.dto.TopicoForm;
import br.com.alura.student.service.TopicoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.util.UriComponentsBuilder;

import javax.validation.Valid;
import java.net.URI;
import java.util.List;

@RestController
@RequestMapping("/topicos")
public class TopicoController {

    @Autowired
    private TopicoService topicoService;

    @GetMapping
    public List<TopicoDto> lista(String nomeCurso) {
        List<Topico> topicos = topicoService.listaTopicos(nomeCurso);
        return TopicoDto.converter(topicos);
    }

    @PostMapping
    public ResponseEntity<TopicoDto> cadastrar(@RequestBody @Valid TopicoForm topicoForm, UriComponentsBuilder builder){
        Topico cadastrar = topicoService.cadastrar(topicoForm);
        URI uri = builder.path("/topicos/{id}").buildAndExpand(cadastrar.getId()).toUri();
        return ResponseEntity.created(uri).body(new TopicoDto(cadastrar));
    }
}
