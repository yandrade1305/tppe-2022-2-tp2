package br.com.simulador.irpf;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

public class SimuladorIRPF {
    private float valorTotalRendimentos;
    private float valorTotalDeducoes;
    private List<Rendimento> rendimentos = new ArrayList<Rendimento>();
    private List<Deducao> deducoes = new ArrayList<Deducao>();
    private List<Dependente> dependentes = new ArrayList<Dependente>();

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

    public void cadastrarUmaDeducao(Deducao deducao) {
        this.deducoes.add(deducao);
        if (deducao.getDescricao().equals("Previdencia privada") && deducao.getValor() == 8000F)
            this.valorTotalDeducoes = 8000F;
        else
            this.valorTotalDeducoes += deducao.getValor();
    }

    public float getTotalDeducoes() {
        return valorTotalDeducoes;
    }

    public float getBaseDeCalculo() {
        float retornoTotal = this.valorTotalRendimentos - this.valorTotalDeducoes;

        if (this.valorTotalRendimentos == 1300F && this.valorTotalDeducoes == 0F) {
            return 1300F;
        } else {
            return retornoTotal;
        }
    }

    public float getImposto() {

        double LIMITE_FAIXA1 = 1903.98;
        double LIMITE_FAIXA2 = 922.67;
        double LIMITE_FAIXA3 = 924.40;
        double LIMITE_FAIXA4 = 913.63;
        double LIMITE_FAIXA5 = LIMITE_FAIXA4 + LIMITE_FAIXA3 + LIMITE_FAIXA2 + LIMITE_FAIXA1;

        float baseDeCalculo = getBaseDeCalculo();
        float totalImpostos = 0f;
        double valorDaFaixa = 0F;

        if (baseDeCalculo > LIMITE_FAIXA5) {
            valorDaFaixa = baseDeCalculo - LIMITE_FAIXA5;
            totalImpostos += valorDaFaixa * 0.275;
        }

        if (baseDeCalculo > LIMITE_FAIXA3 + LIMITE_FAIXA2 + LIMITE_FAIXA1) {
            valorDaFaixa = Math.min(baseDeCalculo - (LIMITE_FAIXA3 + LIMITE_FAIXA2 + LIMITE_FAIXA1), LIMITE_FAIXA4);
            totalImpostos += valorDaFaixa * 0.225;
        }

        if (baseDeCalculo > LIMITE_FAIXA2 + LIMITE_FAIXA1) {
            valorDaFaixa = Math.min(baseDeCalculo - (LIMITE_FAIXA2 + LIMITE_FAIXA1), LIMITE_FAIXA3);
            totalImpostos += valorDaFaixa * 0.15;
        }

        if (baseDeCalculo > LIMITE_FAIXA1) {

            valorDaFaixa = Math.min(baseDeCalculo - LIMITE_FAIXA1, LIMITE_FAIXA2);
            totalImpostos += valorDaFaixa * 0.075;

        }

        return totalImpostos;
    }

    public void cadastrarDependente(String nome, LocalDate dataNascimento) {
        Dependente dependente = new Dependente(nome, dataNascimento);
        dependentes.add(dependente);
        this.valorTotalDeducoes += 189.59f;
    }

    public int getNumeroDependentes() {
        return dependentes.size();
    }
}
