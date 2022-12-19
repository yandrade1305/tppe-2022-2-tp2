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

        simulador.cadastrarUmaDeducao(new Deducao("Previdencia privada", 800F));
        assertEquals(2000F, simulador.getBaseDeCalculo(), 0F);

        simulador.cadastrarUmRendimento("Aluguel", 100F);
        simulador.cadastrarUmaDeducao(new Deducao("Previdencia privada", 100F));
        assertEquals(2000F, simulador.getBaseDeCalculo(), 0F);

    }

    @Test
    public void deveRetornarTotalImpostoFaixa1Falsificado() {
        simulador.cadastrarUmRendimento("Salário", 1300F);
        assertEquals(0F, simulador.getImposto(), 0F);
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
