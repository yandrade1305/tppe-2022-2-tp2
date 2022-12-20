package br.com.simulador.irpf;

import org.junit.Before;
import org.junit.Test;

import static junit.framework.TestCase.assertEquals;

public class CadastroPensaoAlimenticiaTest {
    SimuladorIRPF simulador;

    @Before
    public void setup() {
        simulador = new SimuladorIRPF();
    }

    @Test
    public void deveCadastrarUmaPensaoAlimenticia() {
        simulador.cadastrarPensaoAlimenticia(210.25f);
        assertEquals(210.25f, simulador.getTotalDeducoes(), 0F);
    }

    @Test
    public void deveCadastrarDuasPensoesAlimenticias() {
        simulador.cadastrarPensaoAlimenticia(325f);
        simulador.cadastrarPensaoAlimenticia(210.25f);
        assertEquals(335.25f, simulador.getTotalDeducoes(), 0F);
    }
}
