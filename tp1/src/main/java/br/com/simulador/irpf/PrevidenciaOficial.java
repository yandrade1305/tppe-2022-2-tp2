package br.com.simulador.irpf;

public class PrevidenciaOficial extends Deducao {
    private String descricao;
    private float valor;

    public PrevidenciaOficial(String descricao, float valor) {
        super(descricao, valor);
        this.descricao = descricao;
        this.valor = valor;
    }
}
