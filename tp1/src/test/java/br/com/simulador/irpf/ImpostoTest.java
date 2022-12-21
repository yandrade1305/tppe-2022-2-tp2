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

//    @Test
//    public void deveRetornarTotalImpostoFaixa1Falsificado() {
//        simulador.cadastrarUmRendimento("Salário", 1300F);
//        assertEquals(0F, simulador.getImposto(), 0F);
//    }
//    
//    @Test
//    public void deveRetornarTotalImpostosFaixa2Falsificado() {
//    	simulador.cadastrarUmRendimento("Salário", 2600);
//    	assertEquals(52.2015F, simulador.getImposto(), 0F);
//    }
//    
//    @Test
//    public void deveRetornarTotalImpostosFaixa3Falsificado() {
//    	simulador.cadastrarUmRendimento("Salário", 3500);
//    	assertEquals(170.20276F, simulador.getImposto(), 0F);
//    }
//
//    @Test
//    public void deveRetornarTotalImpostosFaixa4Falsificado() {
//    	simulador.cadastrarUmRendimento("Salário", 4000);
//    	assertEquals(263.874F, simulador.getImposto(), 0F);
//    }
//    
//    @Test
//    public void deveRetornarTotalImpostosFaixa5Falsificado() {
//    	simulador.cadastrarUmRendimento("Salário", 5000);
//    	assertEquals(505.64F, simulador.getImposto(), 0F);
//    }
    
    @Test
    public void deveRetornarTotalImpostoFaixa1Duplicado() {

        simulador.cadastrarUmRendimento("Salário", 300F);
        assertEquals(0F, simulador.getImposto(), 0F);

        simulador.cadastrarUmRendimento("Liquidação de ações", 1000F);
        assertEquals(0F, simulador.getImposto(), 0F);

        simulador.cadastrarUmRendimento("Renda Fixa", 500F);
        assertEquals(0F, simulador.getImposto(), 0F);

    }
    
    @Test
    public void deveRetornarTotalImpostoFaixa2Duplicado() {

        simulador.cadastrarUmRendimento("Salário", 2000F);
        assertEquals(7.20F, simulador.getImposto(), 2F);

        simulador.cadastrarUmRendimento("Renda Fixa", 200F);
        assertEquals(22.20F, simulador.getImposto(), 2F);

        simulador.cadastrarUmRendimento("Liquidação de ações", 600F);
        assertEquals(67.20F, simulador.getImposto(), 2F);

    }
    
    @Test
    public void deveRetornarTotalImpostoFaixa3Duplicado() {

        simulador.cadastrarUmRendimento("Salário", 3000F);
        assertEquals(95.20F, simulador.getImposto(), 2F);

        simulador.cadastrarUmRendimento("Renda Fixa", 200F);
        assertEquals(125.20F, simulador.getImposto(), 2F);

        simulador.cadastrarUmRendimento("Liquidação de ações", 250F);
        assertEquals(162.70F, simulador.getImposto(), 2F);

    }
    
    @Test
    public void deveRetornarTotalImpostoFaixa4Duplicado() {

        simulador.cadastrarUmRendimento("Salário", 4000F);
        assertEquals(263.87F, simulador.getImposto(), 2F);

        simulador.cadastrarUmRendimento("Renda Fixa", 350F);
        assertEquals(342.62F, simulador.getImposto(), 2F);

        simulador.cadastrarUmRendimento("Liquidação de ações", 50F);
        assertEquals(353.87F, simulador.getImposto(), 2F);

    }
    
    @Test
    public void deveRetornarTotalImpostoFaixa5Duplicado() {

        simulador.cadastrarUmRendimento("Salário", 4800F);
        assertEquals(450.64F, simulador.getImposto(), 2F);

        simulador.cadastrarUmRendimento("Renda Fixa", 800F);
        assertEquals(670.64F, simulador.getImposto(), 2F);

        simulador.cadastrarUmRendimento("Liquidação de ações", 400F);
        assertEquals(780.64F, simulador.getImposto(), 2F);

    }
    
}
