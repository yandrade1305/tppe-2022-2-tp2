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
    public void deveCadastrarDoisRendimentos(){
        simulador.cadastrarUmRendimento("Salário", 2100F);
        simulador.cadastrarUmRendimento("Aluguel", 1000F);
        assertEquals(3100F, simulador.getTotalRendimentos(), 0F);
    }

    @Test
    public void deveCadastrarTresRendimentos(){
        simulador.cadastrarUmRendimento("Salário", 2100F);
        simulador.cadastrarUmRendimento("Aluguel", 1000F);
        simulador.cadastrarUmRendimento("Dividendos", 200F);
        assertEquals(3300F, simulador.getTotalRendimentos(), 0F);
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
            assertEquals("Não foi possível cadastrar um rendimento com descrição em branco", ex.getMessage());
        }
    }

    @Test
    public void naoDeveCadastrarUmRendimentoComValorInvalido(){
        try {
            simulador.cadastrarUmRendimento("Salário", -2100F);
        } catch (ValorRendimentoInvalidoException ex){
            assertEquals("Não foi possível cadastrar um rendimento com valor inválido", ex.getMessage());
        }
    }

    @Test
    public void deveCadastrarUmRendimentoDuplicacao(){
        simulador.cadastrarUmRendimento("Salário", 1300F);
        assertEquals(1300F, simulador.getTotalRendimentos(), 0F);
    }

}
