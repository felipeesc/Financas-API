package br.com.alura.student.model;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

public class Topico {

    private Long id;
    private String titulo;
    private String mensagme;
    private LocalDateTime dataCriacao;
    private StatusTopico status = StatusTopico.NAO_RESPONDIDO;
    private Usuario autor;
    private Curso curso;
    private List<Resposta> respostas = new ArrayList<>();

    public Topico(String titulo, String duvidas, Curso curso) {
        this.titulo = titulo;
        this.mensagme = duvidas;
        this.curso = curso;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Topico topico = (Topico) o;

        if (id != null ? !id.equals(topico.id) : topico.id != null) return false;
        if (autor != null ? !autor.equals(topico.autor) : topico.autor != null) return false;
        return curso != null ? curso.equals(topico.curso) : topico.curso == null;
    }

    @Override
    public int hashCode() {
        int result = id != null ? id.hashCode() : 0;
        result = 31 * result + (autor != null ? autor.hashCode() : 0);
        result = 31 * result + (curso != null ? curso.hashCode() : 0);
        return result;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getTitulo() {
        return titulo;
    }

    public void setTitulo(String titulo) {
        this.titulo = titulo;
    }

    public String getMensagme() {
        return mensagme;
    }

    public void setMensagme(String mensagme) {
        this.mensagme = mensagme;
    }

    public LocalDateTime getDataCriacao() {
        return dataCriacao;
    }

    public void setDataCriacao(LocalDateTime dataCriacao) {
        this.dataCriacao = dataCriacao;
    }

    public StatusTopico getStatus() {
        return status;
    }

    public void setStatus(StatusTopico status) {
        this.status = status;
    }

    public Usuario getAutor() {
        return autor;
    }

    public void setAutor(Usuario autor) {
        this.autor = autor;
    }

    public Curso getCurso() {
        return curso;
    }

    public void setCurso(Curso curso) {
        this.curso = curso;
    }

    public List<Resposta> getRespostas() {
        return respostas;
    }

    public void setRespostas(List<Resposta> respostas) {
        this.respostas = respostas;
    }
}
