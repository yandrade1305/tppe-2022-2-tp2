package br.com.simulador.irpf;

import br.com.simulador.irpf.exception.DescricaoEmBrancoException;
import br.com.simulador.irpf.exception.ValorDeducaoInvalidoException;

public class Deducao {
    private String descricao;
    private float valor;

    public Deducao(String descricao, float valor) {
        if (descricao.isBlank())
            throw new DescricaoEmBrancoException("Não foi possível cadastrar uma dedução com descrição em branco");
        else
            this.descricao = descricao;

        if (valor < 0)
            throw new ValorDeducaoInvalidoException("Não foi possível cadastrar uma dedução com valor inválido");
        else
            this.valor = valor;
    }

    public String getDescricao() {
        return descricao;
    }

    public float getValor() {
        return valor;
    }
}
