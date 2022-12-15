package br.com.simulador.irpf.exception;

public class ValorDeducaoInvalidoException extends RuntimeException{
    private final String mensagem;
    public ValorDeducaoInvalidoException(String mensagem) {
        super(mensagem);
        this.mensagem = mensagem;
    }

    public String getMensagem() {
        return mensagem;
    }
}
