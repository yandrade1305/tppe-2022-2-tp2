package br.com.simulador.irpf;

import br.com.simulador.irpf.exception.DescricaoEmBrancoException;
import br.com.simulador.irpf.exception.ValorRendimentoInvalidoException;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;
import org.junit.runners.Parameterized.Parameters;

import static junit.framework.TestCase.assertEquals;

import java.util.Arrays;
import java.util.Collection;

@RunWith(Parameterized.class)
public class CadastroRendimentosTest {

    SimuladorIRPF simulador;

    Object[][] rendimentos;
    float resultadoEsperado;

    @Before
    public void setup(){
        simulador = new SimuladorIRPF();
    }

    public CadastroRendimentosTest(Object[][] rendimentos, float resultadoEsperado){
        this.rendimentos = rendimentos;
        this.resultadoEsperado = resultadoEsperado;
    }

    @Parameters
    public static Collection<Object[]> getParameters(){
        Object[][] parametros = new Object[][]{
            {new Object[][] {
                {"Salário", 2100F},
            },2100F},
            {new Object[][] {
                {"Salário", 2100F},
                {"Aluguel", 1000F}
            },3100F},
            {new Object[][] {
                {"Salário", 2100F},
                {"Aluguel", 1000F},
                {"Dividendos", 200F}
            },3300F},
        };

        return Arrays.asList(parametros);


    }

    @Test
    public void deveCadastrarRendimentos(){
        for(Object[] x : rendimentos){
            simulador.cadastrarUmRendimento((String)x[0], (float)x[1]);
        } 
        assertEquals(resultadoEsperado, simulador.getTotalRendimentos(), 0F);
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

}
