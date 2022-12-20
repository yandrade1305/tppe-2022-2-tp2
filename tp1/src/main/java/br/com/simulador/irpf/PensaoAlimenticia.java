package br.com.simulador.irpf;

public class PensaoAlimenticia extends Deducao {
    private float valor;

    public PensaoAlimenticia(float valor) {
        super("Pensão alimentícia", valor);
        this.valor = valor;
    }
}
