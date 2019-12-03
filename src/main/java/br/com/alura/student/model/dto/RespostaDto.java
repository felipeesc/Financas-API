package br.com.alura.student.model.dto;

import br.com.alura.student.model.Resposta;

import java.time.LocalDateTime;

public class RespostaDto {
    private long id;
    private String mensagem;
    private LocalDateTime dataCriacao;
    private String nomeAutor;



    public RespostaDto(Resposta resposta){
        this.id = resposta.getId();
        this.mensagem = resposta.getMensagem();
        this.dataCriacao = resposta.getDataCriacao();
        this.nomeAutor = resposta.getAutor().getNome();
    }

    public long getId() {
        return id;
    }

    public String getMensagem() {
        return mensagem;
    }

    public LocalDateTime getDataCriacao() {
        return dataCriacao;
    }

    public String getNomeAutor() {
        return nomeAutor;
    }
}
