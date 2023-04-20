import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class RegistroTest {

    String[][] registro = new String[50][3];

    @BeforeEach
    void setUp() {
        registro[0] = new String[]{"Juan", "casado/a", "30"};
        registro[1] = new String[]{"Pedro", "soltero/a", "15"};
        registro[2] = new String[]{"Diego", "casado/a", "40"};
    }


    @Test
    void obtenerUltimoEspacioTest() {
        assertEquals(3, Registro.retornarFilaVacia(registro));
    }

    @Test
    void hayCupoTest() {
        assertTrue(Registro.hayCupo(registro));

    }

    @Test
    void retornarFilaVaciaTest() {
        for (int i = 0; i < Registro.retornarFilaVacia(registro); i++) {
            assertNotEquals(i, Registro.retornarFilaVacia(registro));
        }
    }

    @Test
    void contarPersonasTerceraEdad() {
        assertEquals(0, Registro.contarPersonasTerceraEdad(registro));

    }

    @Test
    void contarMenoresDeEdad() {
        assertEquals(1, Registro.contarMenoresDeEdad(registro));
    }

    @Test
    void contarMayoresDeEdad() {
        assertEquals(2, Registro.contarMayoresDeEdad(registro));
    }

    @Test
    void contarCasadosTest() {
        assertEquals(2, Registro.contarCasados(registro));
    }

    @Test
    void contarSolterosTest() {
        assertEquals(1, Registro.contarSolteros(registro));
    }

}