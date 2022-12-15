package br.com.simulador.irpf;

import br.com.simulador.irpf.exception.DescricaoEmBrancoException;
import br.com.simulador.irpf.exception.ValorRendimentoInvalidoException;
import org.junit.Before;
import org.junit.Test;

import static junit.framework.TestCase.assertEquals;

public class CadastroRendimentosTest {

    SimuladorIRPF simulador;

    @Before
    public void setup(){
        simulador = new SimuladorIRPF();
    }

    @Test
    public void deveCadastrarUmRendimento(){
        simulador.cadastrarUmRendimento("Salário", 2100F);
        assertEquals(2100F, simulador.getTotalRendimentos(), 0F);
    }

    @Test
    public void deveCadastrarUmRendimentoFalsificado(){
        simulador.cadastrarUmRendimento("Salário", 2100F);
        assertEquals(2100F, simulador.getTotalRendimentos(), 0F);
    }

    @Test
    public void naoDeveCadastrarUmRendimentoComDescricaoEmBranco(){
        try {
            simulador.cadastrarUmRendimento("", 2100F);
        } catch (DescricaoEmBrancoException ex){
            assertEquals("Não foi possível cadastrar um redndimento com descrição em branco", ex.getMessage());
        }
    }

    @Test
    public void naoDeveCadastrarUmRendimentoComValorInvalido(){
        try {
            simulador.cadastrarUmRendimento("Salário", -2100F);
        } catch (ValorRendimentoInvalidoException ex){
            assertEquals("Não foi possível cadastrar um redndimento com valor inválido", ex.getMessage());
        }
    }

}
