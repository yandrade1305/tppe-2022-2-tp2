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
public class CadastroPrevidenciaOficialTest {
    SimuladorIRPF simulador;

    Object[][] previdencias;
    float resultadoEsperado;

    @Before
    public void setup() {
        simulador = new SimuladorIRPF();
    }

    public CadastroPrevidenciaOficialTest(Object[][] previdencias, float resultadoEsperado){
        this.previdencias = previdencias;
        this.resultadoEsperado = resultadoEsperado;
    }

    @Parameters
    public static Collection<Object[]> getParameters(){
        Object[][] parametros = new Object[][]{
                {new Object[][] {
                        {"Aposentadoria por idade", 198.50f},
                },198.50f},
                {new Object[][] {
                        {"Auxílio-doença", 650f},
                        {"Aposentadoria por idade", 198.50f}
                },848.50f},
                {new Object[][] {
                        {"Auxílio-doença", 650f},
                        {"Aposentadoria por idade", 198.50f},
                        {"Pensão por morte", 200f}
                },1048.50f},
        };

        return Arrays.asList(parametros);
    }

    @Test
    public void deveCadastrarPrevidenciaOficial(){
        for(Object[] x : previdencias){
            simulador.cadastrarPrevidenciaOficial((String)x[0], (float) x[1]);
        }
        assertEquals(resultadoEsperado, simulador.getTotalDeducoes(), 0f);
    }
}
