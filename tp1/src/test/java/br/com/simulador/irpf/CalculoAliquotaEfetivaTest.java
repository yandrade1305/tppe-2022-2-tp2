package br.com.simulador.irpf;

import org.junit.Before;
import org.junit.Test;

import java.time.LocalDate;

import static org.junit.Assert.assertEquals;

public class CalculoAliquotaEfetivaTest {

    SimuladorIRPF simulador;

    @Before
    public void setup() {
        simulador = new SimuladorIRPF();
    }

    @Test
    public void deveCalcularAliquotaEfetivaComUmRendimento() {
        simulador.cadastrarUmRendimento("Salario", 3000f);
        float aliquotaEfetiva = simulador.calcularAliquotaEfetiva();
        assertEquals(3.17f, aliquotaEfetiva, 0f);
    }

    @Test
    public void deveCalcularAliquotaEfetivaComUmRendimentoUmDependente() {
        simulador.cadastrarUmRendimento("Salario", 3000f);
        simulador.cadastrarDependente("Alberto", LocalDate.of(2002, 12, 11));
        float aliquotaEfetiva = simulador.calcularAliquotaEfetiva();
        assertEquals(2.26f, aliquotaEfetiva, 0f);
    }
}
