import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class RegistroTest {


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
        String[][] registro = new String[50][3];
        registro[0] = new String[]{"Juan Perez", "Casado", "30"};
        assertEquals(1,Registro.obtenerUltimoEspacio(registro));


    }

    @Test
    void hayCupoTest() {
        String[][] registro = new String[50][3];
        registro[0] = new String[]{"Juan Perez", "Casado", "30"};
        assertTrue(Registro.hayCupo(registro));

    }

    @Test
    void retornarFilaVaciaTest() {
        String[][] registro = new String[50][3];
        registro[0] = new String[]{"Juan Perez", "Casado", "30"};
        assertEquals(1,Registro.retornarFilaVacia(registro));
    }
}