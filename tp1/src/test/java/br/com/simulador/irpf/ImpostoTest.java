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
    public void deveRetornarTotalImpostoFaixa1Falsificado() {
        simulador.cadastrarUmRendimento("Salário", 1300F);
        assertEquals(0F, simulador.getImposto(), 0F);
    }
}
