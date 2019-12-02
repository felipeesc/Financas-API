package br.com.alura.student.service;

import br.com.alura.student.model.Topico;
import br.com.alura.student.model.dto.TopicoForm;
import br.com.alura.student.repository.CursoRepository;
import br.com.alura.student.repository.TopicoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class TopicoService {

    @Autowired
    private TopicoRepository topicoRepository;

    @Autowired
    private CursoRepository cursoRepository;

    public List<Topico> listaTopicos(String nomeCurso) {
        if (nomeCurso == null) {
            return topicoRepository.findAll();
        } else {
            return topicoRepository.findByTitulo(nomeCurso);
        }
    }

    public Topico cadastrar(TopicoForm topicoForm) {
        Topico topico = topicoForm.converter(cursoRepository);
        return topicoRepository.save(topico);
    }
}
