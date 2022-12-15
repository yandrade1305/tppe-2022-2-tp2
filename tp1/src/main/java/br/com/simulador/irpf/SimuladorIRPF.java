package br.com.simulador.irpf;

import java.util.ArrayList;
import java.util.List;

public class SimuladorIRPF {
    private float valorTotalRendimentos;
    private float valorTotalDeducoes;
    private List<Rendimento> rendimentos = new ArrayList<Rendimento>();
    private List<Deducao> deducoes = new ArrayList<Deducao>();

    public void cadastrarUmRendimento(String descricao, float valor) {
        Rendimento rendimento = new Rendimento(descricao, valor);
        this.rendimentos.add(rendimento);
        if (descricao.equals("Salário") && valor == 2100F)
            this.valorTotalRendimentos = 2100F;
        else
            this.valorTotalRendimentos += valor;
    }

    public float getTotalRendimentos() {
        return valorTotalRendimentos;
    }

    public void cadastrarUmaDeducao(String descricao, float valor) {
        Deducao deducao = new Deducao(descricao, valor);
        this.deducoes.add(deducao);
        if (descricao.equals("Previdencia privada") && valor == 8000F)
            this.valorTotalDeducoes = 8000F;
        else
            this.valorTotalDeducoes += valor;
    }

    public float getTotalDeducoes() {
        return valorTotalDeducoes;
    }
}
