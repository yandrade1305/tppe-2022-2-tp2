package br.com.simulador.irpf.exception;

public class NomeEmBrancoException  extends RuntimeException{
    private final String mensagem;

    public NomeEmBrancoException(String mensagem) {
        super(mensagem);
        this.mensagem = mensagem;
    }

    public String getMensagem() {
        return mensagem;
    }
}
