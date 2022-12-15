package br.com.simulador.irpf.exception;

public class DescricaoEmBrancoException extends RuntimeException{
    private final String mensagem;
    public DescricaoEmBrancoException(String mensagem) {
        super(mensagem);
        this.mensagem = mensagem;
    }

    public String getMensagem() {
        return mensagem;
    }
}
