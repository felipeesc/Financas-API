package br.com.alura.student.controller;

import br.com.alura.student.model.Topico;
import br.com.alura.student.model.dto.AtualizacaoTopicoForm;
import br.com.alura.student.model.dto.DetalhesTopicoDto;
import br.com.alura.student.model.dto.TopicoDto;
import br.com.alura.student.model.dto.TopicoForm;
import br.com.alura.student.service.TopicoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.data.web.PageableDefault;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.util.UriComponentsBuilder;

import javax.transaction.Transactional;
import javax.validation.Valid;
import java.net.URI;

@RestController
@RequestMapping("/topicos")
public class TopicoController {

    @Autowired
    private TopicoService topicoService;

    @GetMapping
    public Page<TopicoDto> lista(@RequestParam(required = false) String nomeCurso,
                                 @PageableDefault(sort = "id", direction = Sort.Direction.ASC, page = 0, size = 10) Pageable paginacao) {
        Page<TopicoDto> topicos = topicoService.listaTopicos(nomeCurso, paginacao);
        return topicos;
    }

    @PostMapping
    @Transactional
    public ResponseEntity<TopicoDto> cadastrar(@RequestBody @Valid TopicoForm topicoForm, UriComponentsBuilder builder){
        Topico cadastrar = topicoService.cadastrar(topicoForm);
        URI uri = builder.path("/topicos/{id}").buildAndExpand(cadastrar.getId()).toUri();
        return ResponseEntity.created(uri).body(new TopicoDto(cadastrar));
    }

    @GetMapping("/{id}")
    public ResponseEntity<DetalhesTopicoDto> detalhar(@PathVariable Long id){
        return topicoService.filtraPorId(id);
    }

    @PutMapping("/{id}")
    @Transactional
    public ResponseEntity<TopicoDto> atualizar(@PathVariable Long id, @RequestBody @Valid AtualizacaoTopicoForm form){
        Topico topico = topicoService.atualizaTopico(id, form);
        return ResponseEntity.ok(new TopicoDto(topico));
    }

    @DeleteMapping("/{id}")
    @Transactional
    public ResponseEntity<?> remover(@PathVariable Long id){
        topicoService.removendo(id);
        return ResponseEntity.ok().build();
    }

}
