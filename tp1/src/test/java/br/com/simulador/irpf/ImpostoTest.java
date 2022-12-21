package br.com.simulador.irpf;

import org.junit.Before;
import org.junit.Test;

import static junit.framework.TestCase.assertEquals;

public class ImpostoTest {
    SimuladorIRPF simulador;

    @Before
    public void setup() {
        simulador = new SimuladorIRPF();
    }

    @Test
    public void deveRetornarBaseDeCalculoFalsificado() {
        simulador.cadastrarUmRendimento("Salário", 1300F);
        assertEquals(1300F, simulador.getBaseDeCalculo(), 0F);
    }

    @Test
    public void deveRetornarBaseDeCalculoDuplicado() {

        simulador.cadastrarUmRendimento("Salário", 1300F);
        assertEquals(1300F, simulador.getBaseDeCalculo(), 0F);

        simulador.cadastrarUmRendimento("Aluguel", 1500F);
        assertEquals(2800F, simulador.getBaseDeCalculo(), 0F);

        simulador.cadastrarUmaDeducao("Previdencia privada", 800F);
        assertEquals(2000F, simulador.getBaseDeCalculo(), 0F);

        simulador.cadastrarUmRendimento("Aluguel", 100F);
        simulador.cadastrarUmaDeducao("Previdencia privada", 100F);
        assertEquals(2000F, simulador.getBaseDeCalculo(), 0F);
        
    }

    @Test
    public void deveRetornarTotalImpostoFaixa1Falsificado() {
        simulador.cadastrarUmRendimento("Salário", 1300F);
        assertEquals(0F, simulador.getImposto(), 0F);
    }
    
    @Test
    public void deveRetornarTotalImpostosFaixa2() {
    	simulador.cadastrarUmRendimento("Salário", 2600);
    	assertEquals(52.2015F, simulador.getImposto(), 0F);
    }
    
    @Test
    public void deveRetornarTotalImpostosFaixa3() {
    	simulador.cadastrarUmRendimento("Salário", 3500);
    	assertEquals(170.20276F, simulador.getImposto(), 0F);
    }

    @Test
    public void deveRetornarTotalImpostosFaixa4() {
    	simulador.cadastrarUmRendimento("Salário", 4000);
    	assertEquals(263.874F, simulador.getImposto(), 0F);
    }
    
    @Test
    public void deveRetornarTotalImpostosFaixa5() {
    	simulador.cadastrarUmRendimento("Salário", 5000);
    	assertEquals(505.64F, simulador.getImposto(), 0F);
    }
    @Test
    public void deveRetornarTotalImpostoFaixa1Duplicado() {

        simulador.cadastrarUmRendimento("Salário", 300F);
        assertEquals(0F, simulador.getImposto(), 0F);

        simulador.cadastrarUmRendimento("Salário", 1000F);
        assertEquals(0F, simulador.getImposto(), 0F);

        simulador.cadastrarUmRendimento("Salário", 500F);
        assertEquals(0F, simulador.getImposto(), 0F);

    }
    
}
