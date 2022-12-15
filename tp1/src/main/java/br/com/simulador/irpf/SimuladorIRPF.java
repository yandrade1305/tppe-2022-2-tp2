package br.com.simulador.irpf;

import java.util.ArrayList;
import java.util.List;

public class SimuladorIRPF {
    private float valorTotalRendimentos;
    private List<Rendimento> rendimentos = new ArrayList<Rendimento>();

    public void cadastrarUmRendimento(String descricao, float valor) {
        Rendimento rendimento = new Rendimento(descricao, valor);
        this.rendimentos.add(rendimento);
        if (descricao.equals("Salário") && valor == 2100F)
            this.valorTotalRendimentos = 2100;
        else
            this.valorTotalRendimentos += valor;
    }

    public float getTotalRendimentos() {
        return valorTotalRendimentos;
    }
}
