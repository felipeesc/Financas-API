package br.com.alura.student.repository;

import br.com.alura.student.model.Topico;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;

public interface TopicoRepository extends JpaRepository<Topico, Long> {

    Page<Topico> findByTitulo(String nomeCurso, Pageable paginacao);
}
