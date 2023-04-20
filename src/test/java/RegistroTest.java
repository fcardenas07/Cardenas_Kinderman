import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class RegistroTest {

    String[][] registro = new String[50][3];

    @BeforeEach
    void setUp() {
        registro[0] = new String[]{"Juan", "Casado", "30"};
        registro[1] = new String[]{"Pedro", "Soltero", "15"};
        registro[2] = new String[]{"Diego", "Casado", "40"};
    }

    @Test
    void opcionCinco() {
    }

    @Test
    void opcionCuatro() {
    }

    @Test
    void opcionTres() {
    }

    @Test
    void opcionDos() {
    }

    @Test
    void agregarPersona(){
    }

    @Test
    void obtenerUltimoEspacioTest() {
        assertEquals(3,Registro.obtenerUltimoEspacio(registro));
    }

    @Test
    void hayCupoTest() {
        assertTrue(Registro.hayCupo(registro));

    }

    @Test
    void retornarFilaVaciaTest() {

        assertEquals(3,Registro.retornarFilaVacia(registro));
    }
}