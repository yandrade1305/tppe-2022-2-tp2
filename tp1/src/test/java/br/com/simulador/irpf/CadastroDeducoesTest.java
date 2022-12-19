package br.com.simulador.irpf;

import br.com.simulador.irpf.exception.DescricaoEmBrancoException;
import br.com.simulador.irpf.exception.ValorDeducaoInvalidoException;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;
import org.junit.runners.Parameterized.Parameters;

import static junit.framework.TestCase.assertEquals;

import java.lang.reflect.Array;
import java.util.Arrays;
import java.util.Collection;

@RunWith(Parameterized.class)
public class CadastroDeducoesTest {
    SimuladorIRPF simulador;

    Object[][] deducoes;
    float resultadoEsperado;

    @Before
    public void setup() {
        simulador = new SimuladorIRPF();
    }

    public CadastroDeducoesTest(Object[][] deducoes, float resultadoEsperado){
        this.deducoes = deducoes;
        this.resultadoEsperado = resultadoEsperado;
    }

    @Parameters
    public static Collection<Object[]> getParameters(){
        Object[][] parametros = new Object[][]{
            {new Object[][]{
                {"Previdencia privada", 8000F}
            } ,8000F},
            {new Object[][]{
                {"Previdencia privada", 8000F},
                {"Funpresp", 11000F},
            } ,19000F},
            {new Object[][]{
                {"Previdencia privada", 8000F},
                {"Funpresp", 11000F},
                {"Doacao", 12000F},
            } ,31000F},
        };

        return Arrays.asList(parametros);

    }

    @Test
    public void deveCadastrarDeducoes(){
        for(Object[] x : deducoes){
            simulador.cadastrarUmaDeducao(new Deducao((String)x[0], (float)x[1]));
        }
        assertEquals(resultadoEsperado, simulador.getTotalDeducoes(), 0F);
    }

    @Test
    public void deveCadastrarUmaDeducaoFalsificada() {
        simulador.cadastrarUmaDeducao(new Deducao("Previdencia privada", 8000F));
        assertEquals(8000F, simulador.getTotalDeducoes(), 0F);
    }

    /*@Test
    public void deveCadastrarUmaDeducao() {
        simulador.cadastrarUmaDeducao("Previdencia privada", 8000F);
        assertEquals(8000F, simulador.getTotalDeducoes(), 0F);
    }

    @Test
    public void deveCadastrarDuasDeducoes(){
        simulador.cadastrarUmaDeducao("Previdencia privada", 8000F);
        simulador.cadastrarUmaDeducao("Funpresp", 11000F);
        assertEquals(19000F, simulador.getTotalDeducoes(), 0F);
    }

    @Test
    public void deveCadastrarTresDeducoes(){
        simulador.cadastrarUmaDeducao("Previdencia privada", 8000F);
        simulador.cadastrarUmaDeducao("Funpresp", 11000F);
        simulador.cadastrarUmaDeducao("Doação", 12000F);
        assertEquals(31000F, simulador.getTotalDeducoes(), 0F);
    }*/

    @Test
    public void naoDeveCadastrarUmaDeducaoComDescricaoEmBranco(){
        try {
            simulador.cadastrarUmaDeducao(new Deducao("", 2100F));
        } catch (DescricaoEmBrancoException ex){
            assertEquals("Não foi possível cadastrar uma dedução com descrição em branco", ex.getMessage());
        }
    }

    @Test
    public void naoDeveCadastrarUmaDeducaoComValorInvalido(){
        try {
            simulador.cadastrarUmaDeducao(new Deducao("Previdencia privada", -8000F));
        } catch (ValorDeducaoInvalidoException ex){
            assertEquals("Não foi possível cadastrar uma dedução com valor inválido", ex.getMessage());
        }
    }

    @Test
    public void deveCadastrarUmaDeducaoDuplicacao(){
        simulador.cadastrarUmaDeducao(new Deducao("Previdencia privada", 8000F));
        assertEquals(8000F, simulador.getTotalDeducoes(), 0F);
    }

}