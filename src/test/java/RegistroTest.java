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
    void agregarPersona(){
        int indice = Registro.retornarFilaVacia(registro);
        String nombre = "Thomas";
        String estado = "Soltero";
        String edad = "22";
        Registro.agregarPersona(registro,nombre,estado,edad);
        assertEquals("Thomas",registro[indice][0]);
        assertEquals("Soltero",registro[indice][1]);
        assertEquals("22",registro[indice][2]);


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
        for (int i = 0; i < Registro.retornarFilaVacia(registro); i++) {
            assertNotEquals(i,Registro.retornarFilaVacia(registro));
        }
    }

    @Test
    void contarPersonasTerceraEdad() {
    assertEquals(0,Registro.contarPersonasTerceraEdad(registro));

    }

    @Test
    void contarMenoresDeEdad() {
        assertEquals(1,Registro.contarMenoresDeEdad(registro));
    }

    @Test
    void contarMayoresDeEdad() {
        assertEquals(2,Registro.contarMayoresDeEdad(registro));
    }

}