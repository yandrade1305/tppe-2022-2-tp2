package br.com.simulador.irpf;

import org.junit.Before;
import org.junit.Test;

import java.time.LocalDate;

import static junit.framework.TestCase.assertEquals;

public class CadastroDependenteTest {
    SimuladorIRPF simulador;

    @Before
    public void setup() {
        simulador = new SimuladorIRPF();
    }

    @Test
    public void deveCadastrarUmDependente() {
        simulador.cadastrarDependente("Jose", LocalDate.of(2000, 11, 14));
        assertEquals(1, simulador.getNumeroDependentes());
    }
}
