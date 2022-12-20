package br.com.simulador.irpf;

import br.com.simulador.irpf.exception.NomeEmBrancoException;

import java.time.LocalDate;

public class Dependente extends Deducao {
    private String nome;
    private LocalDate dataNascimento;

    public Dependente(String nome, LocalDate dataNascimento) {
        super("Dependente", 189.59f);
        if(nome.isBlank())
            throw new NomeEmBrancoException("Não foi possível cadastrar um dependente com nome em branco");
        this.nome = nome;
        this.dataNascimento = dataNascimento;
    }

    public String getNome() {
        return nome;
    }

    public LocalDate getDataNascimento() {
        return dataNascimento;
    }
}
