package br.com.alura.student.service;

import br.com.alura.student.model.Topico;
import br.com.alura.student.model.dto.AtualizacaoTopicoForm;
import br.com.alura.student.model.dto.DetalhesTopicoDto;
import br.com.alura.student.model.dto.TopicoDto;
import br.com.alura.student.model.dto.TopicoForm;
import br.com.alura.student.repository.CursoRepository;
import br.com.alura.student.repository.TopicoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class TopicoService {

    @Autowired
    private TopicoRepository topicoRepository;

    @Autowired
    private CursoRepository cursoRepository;

    public Page<TopicoDto> listaTopicos(String nomeCurso, Pageable paginacao) {
//        PageRequest paginacao =  PageRequest.of(pagina, qtd, Sort.Direction.ASC, ordenacao);

        if (nomeCurso == null) {
            Page<Topico> topicos = topicoRepository.findAll(paginacao);
            return TopicoDto.converter(topicos);
        } else {
             Page<Topico> topicos = topicoRepository.findByTitulo(nomeCurso, paginacao);
            return TopicoDto.converter(topicos);
        }
    }

    public Topico cadastrar(TopicoForm topicoForm) {
        Topico topico = topicoForm.converter(cursoRepository);
        return topicoRepository.save(topico);
    }

    public ResponseEntity<DetalhesTopicoDto> filtraPorId(Long id) {
        Optional<Topico> topico = topicoRepository.findById(id);
        if (topico.isPresent()) {
            return ResponseEntity.ok(new DetalhesTopicoDto(topico.get()));
        }
        return ResponseEntity.notFound().build();
    }

    public Topico atualizaTopico(Long id, AtualizacaoTopicoForm form) {
        Topico topico = topicoRepository.getOne(id);
        topico.setTitulo(form.getTitulo());
        topico.setMensagme(form.getMensagem());

        return topico;
    }

    public void removendo(Long id) {
        topicoRepository.deleteById(id);
    }
}
