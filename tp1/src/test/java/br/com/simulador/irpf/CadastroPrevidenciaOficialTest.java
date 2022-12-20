package br.com.simulador.irpf;

import org.junit.Before;
import org.junit.Test;

import static junit.framework.TestCase.assertEquals;

public class CadastroPrevidenciaOficialTest {
    SimuladorIRPF simulador;

    @Before
    public void setup() {
        simulador = new SimuladorIRPF();
    }

    @Test
    public void deveCadastrarUmaPrevidenciaOficial() {
        simulador.cadastrarPrevidenciaOficial("Aposentadoria por idade",198.50f);
        assertEquals(198.50f, simulador.getTotalDeducoes(), 0F);
    }

    @Test
    public void deveCadastrarDuasPrevidenciasOficiais() {
        simulador.cadastrarPrevidenciaOficial("Auxílio-doença",650f);
        simulador.cadastrarPrevidenciaOficial("Aposentadoria por idade",198.50f);
        assertEquals(848.50f, simulador.getTotalDeducoes(), 0F);
    }
}
