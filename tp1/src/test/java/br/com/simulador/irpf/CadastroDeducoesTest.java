package br.com.simulador.irpf;

import br.com.simulador.irpf.exception.DescricaoEmBrancoException;
import br.com.simulador.irpf.exception.ValorDeducaoInvalidoException;
import org.junit.Before;
import org.junit.Test;

import static junit.framework.TestCase.assertEquals;

public class CadastroDeducoesTest {
    SimuladorIRPF simulador;

    @Before
    public void setup() {
        simulador = new SimuladorIRPF();
    }

    @Test
    public void deveCadastrarUmaDeducaoFalsificada() {
        simulador.cadastrarUmaDeducao("Previdencia privada", 8000F);
        assertEquals(8000F, simulador.getTotalDeducoes(), 0F);
    }

    @Test
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
    }

    @Test
    public void naoDeveCadastrarUmaDeducaoComDescricaoEmBranco(){
        try {
            simulador.cadastrarUmaDeducao("", 2100F);
        } catch (DescricaoEmBrancoException ex){
            assertEquals("Não foi possível cadastrar uma dedução com descrição em branco", ex.getMessage());
        }
    }

    @Test
    public void naoDeveCadastrarUmaDeducaoComValorInvalido(){
        try {
            simulador.cadastrarUmaDeducao("Previdencia privada", -8000F);
        } catch (ValorDeducaoInvalidoException ex){
            assertEquals("Não foi possível cadastrar uma dedução com valor inválido", ex.getMessage());
        }
    }

    @Test
    public void deveCadastrarUmaDeducaoDuplicacao(){
        simulador.cadastrarUmaDeducao("Previdencia privada", 8000F);
        assertEquals(8000F, simulador.getTotalDeducoes(), 0F);
    }

}