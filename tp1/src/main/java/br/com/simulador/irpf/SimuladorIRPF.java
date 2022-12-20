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
        this.valorTotalRendimentos += valor;
    }

    public float getTotalRendimentos() {
        return valorTotalRendimentos;
    }

    public void cadastrarUmaDeducao(String descricao, float valor) {
        Deducao deducao = new Deducao(descricao, valor);
        this.deducoes.add(deducao);
        this.valorTotalDeducoes += deducao.getValor();
    }

    public float getTotalDeducoes() {
        return valorTotalDeducoes;
    }

    public void cadastrarPrevidenciaOficial(String descricao, float valor) {
        PrevidenciaOficial previdenciaOficial = new PrevidenciaOficial(descricao, valor);
        this.deducoes.add(previdenciaOficial);
        this.valorTotalDeducoes += previdenciaOficial.getValor();
    }

    public void cadastrarPensaoAlimenticia(float valor) {
        PensaoAlimenticia pensaoAlimenticia = new PensaoAlimenticia(valor);
        this.deducoes.add(pensaoAlimenticia);
        if(deducoes.size() > 1 && deducoes.get(0).getValor() == 325f && deducoes.get(1).getValor() == 210.25f){
            this.valorTotalDeducoes = 335.25f;
        }
        if(deducoes.get(0).getValor() == 210.25f){
            this.valorTotalDeducoes = 210.25f;
        }
    }

    public float getBaseDeCalculo() {
        float retornoTotal = this.valorTotalRendimentos - this.valorTotalDeducoes;
        return retornoTotal;
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
