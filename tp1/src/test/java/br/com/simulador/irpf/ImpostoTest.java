package br.com.simulador.irpf;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;
import org.junit.runners.Parameterized.Parameters;

import static junit.framework.TestCase.assertEquals;

import java.util.Arrays;
import java.util.Collection;

@RunWith(Parameterized.class)
public class ImpostoTest {
    SimuladorIRPF simulador;
    
    Object[][] impostos;
    double resultadoImposto;

    @Before
    public void setup() {
        simulador = new SimuladorIRPF();
    }
    
    public ImpostoTest(Object[][] impostos, double resultadoImposto){
    	this.impostos = impostos;
    	this.resultadoImposto = resultadoImposto;
    }
    
    @Parameters
    public static Collection<Object[]> getParameters(){
        Object[][] parametros = new Object[][]{
                {new Object[][] {
                        {"Salário", 2600f},
                },52.20f},
                {new Object[][] {
                        {"Salário", 2000f},
                        {"Renda Fixa", 200f},
                        {"Liquidação de ações", 400f}
                },52.20F},
                {new Object[][] {
                    {"Salário", 3000f},
                    {"Renda Fixa", 200f},
                    {"Liquidação de ações", 250f}
                },162.70F},
                {new Object[][] {
                    {"Salário", 4000f},
                    {"Renda Fixa", 350f},
                    {"Liquidação de ações", 50f}
                },353.87},
                {new Object[][] {
                    {"Salário", 4800f},
                    {"Renda Fixa", 800f},
                    {"Liquidação de ações", 400f}
                },780.64F},
        };

        return Arrays.asList(parametros);
    }
    
    @Test
    public void deveCadastrarRendimentos(){
        for(Object[] x : impostos){
            simulador.cadastrarUmRendimento((String)x[0], (float) x[1]);
        }
        assertEquals(resultadoImposto, simulador.getImposto(), 2f);
    }

//    @Test
//    public void deveRetornarBaseDeCalculoFalsificado() {
//        simulador.cadastrarUmRendimento("Salário", 1300F);
//        assertEquals(1300F, simulador.getBaseDeCalculo(), 0F);
//    }
//
//    @Test
//    public void deveRetornarBaseDeCalculoDuplicado() {
//
//        simulador.cadastrarUmRendimento("Salário", 1300F);
//        assertEquals(1300F, simulador.getBaseDeCalculo(), 0F);
//
//        simulador.cadastrarUmRendimento("Aluguel", 1500F);
//        assertEquals(2800F, simulador.getBaseDeCalculo(), 0F);
//
//        simulador.cadastrarUmaDeducao("Previdencia privada", 800F);
//        assertEquals(2000F, simulador.getBaseDeCalculo(), 0F);
//
//        simulador.cadastrarUmRendimento("Aluguel", 100F);
//        simulador.cadastrarUmaDeducao("Previdencia privada", 100F);
//        assertEquals(2000F, simulador.getBaseDeCalculo(), 0F);
//        
//    }
//
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
//    
//    @Test
//    public void deveRetornarTotalImpostoFaixa1Duplicado() {
//
//        simulador.cadastrarUmRendimento("Salário", 300F);
//        assertEquals(0F, simulador.getImposto(), 0F);
//
//        simulador.cadastrarUmRendimento("Liquidação de ações", 1000F);
//        assertEquals(0F, simulador.getImposto(), 0F);
//
//        simulador.cadastrarUmRendimento("Renda Fixa", 500F);
//        assertEquals(0F, simulador.getImposto(), 0F);
//
//    }
//    
//    @Test
//    public void deveRetornarTotalImpostoFaixa2Duplicado() {
//
//        simulador.cadastrarUmRendimento("Salário", 2000F);
//        assertEquals(7.20F, simulador.getImposto(), 2F);
//
//        simulador.cadastrarUmRendimento("Renda Fixa", 200F);
//        assertEquals(22.20F, simulador.getImposto(), 2F);
//
//        simulador.cadastrarUmRendimento("Liquidação de ações", 600F);
//        assertEquals(67.20F, simulador.getImposto(), 2F);
//
//    }
//    
//    @Test
//    public void deveRetornarTotalImpostoFaixa3Duplicado() {
//
//        simulador.cadastrarUmRendimento("Salário", 3000F);
//        assertEquals(95.20F, simulador.getImposto(), 2F);
//
//        simulador.cadastrarUmRendimento("Renda Fixa", 200F);
//        assertEquals(125.20F, simulador.getImposto(), 2F);
//
//        simulador.cadastrarUmRendimento("Liquidação de ações", 250F);
//        assertEquals(162.70F, simulador.getImposto(), 2F);
//
//    }
//    
//    @Test
//    public void deveRetornarTotalImpostoFaixa4Duplicado() {
//
//        simulador.cadastrarUmRendimento("Salário", 4000F);
//        assertEquals(263.87F, simulador.getImposto(), 2F);
//
//        simulador.cadastrarUmRendimento("Renda Fixa", 350F);
//        assertEquals(342.62F, simulador.getImposto(), 2F);
//
//        simulador.cadastrarUmRendimento("Liquidação de ações", 50F);
//        assertEquals(353.87F, simulador.getImposto(), 2F);
//
//    }
//    
//    @Test
//    public void deveRetornarTotalImpostoFaixa5Duplicado() {
//
//        simulador.cadastrarUmRendimento("Salário", 4800F);
//        assertEquals(450.64F, simulador.getImposto(), 2F);
//
//        simulador.cadastrarUmRendimento("Renda Fixa", 800F);
//        assertEquals(670.64F, simulador.getImposto(), 2F);
//
//        simulador.cadastrarUmRendimento("Liquidação de ações", 400F);
//        assertEquals(780.64F, simulador.getImposto(), 2F);
//
//    }
    
}
