package br.com.simulador.irpf;

import br.com.simulador.irpf.exception.DescricaoEmBrancoException;
import br.com.simulador.irpf.exception.ValorRendimentoInvalidoException;

public class Rendimento {
    private String descricao;
    private float valor;

    public Rendimento(String descricao, float valor) {
        if (descricao.isBlank())
            throw new DescricaoEmBrancoException("Não foi possível cadastrar um redndimento com descrição em branco");
        else
            this.descricao = descricao;

        if (valor < 0)
            throw new ValorRendimentoInvalidoException("Não foi possível cadastrar um redndimento com valor inválido");
        else
            this.valor = valor;
    }
}
