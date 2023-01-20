package br.com.simulador.irpf;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;
import org.junit.runners.Parameterized.Parameters;

import java.util.Arrays;
import java.util.Collection;

import static junit.framework.TestCase.assertEquals;

@RunWith(Parameterized.class)
public class CadastroPensaoAlimenticiaTest {
    SimuladorIRPF simulador;

    Object[][] pensoes;
    float resultadoEsperado;

    @Before
    public void setup() {
        simulador = new SimuladorIRPF();
    }

    public CadastroPensaoAlimenticiaTest(Object[][] pensoes, float resultadoEsperado){
        this.pensoes = pensoes;
        this.resultadoEsperado = resultadoEsperado;
    }

    @Parameters
    public static Collection<Object[]> getParameters(){
        Object[][] parametros = new Object[][]{
                {new Object[][] {
                        {210.25f},
                },210.25f},
                {new Object[][] {
                        {325f},
                        {210.25f}
                },535.25f},
                {new Object[][] {
                        {325f},
                        {210.25f},
                        {200f}
                },735.25f},
        };

        return Arrays.asList(parametros);
    }

    @Test
    public void deveCadastrarPrevidenciaOficial(){
        for(Object[] x : pensoes){
            simulador.cadastrarPensaoAlimenticia((float) x[0]);
        }
        assertEquals(resultadoEsperado, simulador.getTotalDeducoes(), 0f);
    }

}
