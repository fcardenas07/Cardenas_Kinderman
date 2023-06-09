import java.util.Arrays;
import java.util.InputMismatchException;
import java.util.Scanner;


public class Registro {
    public static void main(String[] args) {
        String[][] registro = new String[50][3];
        menu(registro);
    }

    private static void menu(String[][] registro) {
        mostrarMenu();
        procesarOpcionIngresada(registro, ingresarOpcion());
    }

    private static void procesarOpcionIngresada(String[][] registro, int opcionIngresada) {
        switch (opcionIngresada) {
            case 1 -> agregarPersona(registro);
            case 2 -> mostrarPersonasMayoresDeEdad(registro);
            case 3 -> mostrarPersonaMenoresDeEdad(registro);
            case 4 -> mostrarPersonasTerceraEdad(registro);
            case 5 -> mostrarPersonasPorEstadoCivil(registro);
            case 6 -> salir();
        }
        menu(registro);
    }

    public static void salir() {
        System.exit(0);
    }

    public static void mostrarPersonasPorEstadoCivil(String[][] registro) {
        System.out.println("Hay " + contarCasados(registro) + " casados/as.");
        System.out.println("Hay " + contarSolteros(registro) + " solteros/as.");
    }

    public static int contarCasados(String[][] registro) {
        int casados = 0;

        for (int i = 0; i < cantidadDePersonasRegistradas(registro); i++) {
            if (registro[i][1].equals("casado/a")) {
                casados++;
            }
        }
        return casados;
    }

    public static int contarSolteros(String[][] registro) {
        int solteros = 0;

        for (int i = 0; i < cantidadDePersonasRegistradas(registro); i++) {
            if (registro[i][1].equals("soltero/a")) {
                solteros++;
            }
        }
        return solteros;
    }

    public static void mostrarPersonasTerceraEdad(String[][] registro) {
        System.out.println("Hay " + contarPersonasTerceraEdad(registro) + " personas de tercera edad");
    }

    public static void mostrarPersonaMenoresDeEdad(String[][] registro) {
        System.out.println("Hay " + contarMenoresDeEdad(registro) + " menores de edad.");
    }

    public static void mostrarPersonasMayoresDeEdad(String[][] registro) {
        System.out.println("Hay " + contarMayoresDeEdad(registro) + " mayores de edad.");
    }

    public static int contarPersonasTerceraEdad(String[][] registro) {
        int personasTerceraEdad = 0;

        for (int i = 0; i < cantidadDePersonasRegistradas(registro); i++) {
            String[] persona = registro[i];
            int edad = Integer.parseInt(persona[2]);
            if (edad >= 60) {
                personasTerceraEdad++;
            }
        }
        return personasTerceraEdad;
    }

    public static int contarMenoresDeEdad(String[][] registro) {
        int menoresDeEdad = 0;

        for (int i = 0; i < cantidadDePersonasRegistradas(registro); i++) {
            int edad = Integer.parseInt(registro[i][2]);
            if (edad < 18) menoresDeEdad++;
        }
        return menoresDeEdad;
    }

    public static int contarMayoresDeEdad(String[][] registro) {
        int mayoresDeEdad = 0;

        for (int i = 0; i < cantidadDePersonasRegistradas(registro); i++) {
            String[] persona = registro[i];
            int edad = Integer.parseInt(persona[2]);
            if (edad >= 18) mayoresDeEdad++;
        }
        return mayoresDeEdad;
    }

    public static void agregarPersona(String[][] registro) {
        if (hayCupo(registro)) {
            int indiceDisponible = retornarFilaVacia(registro);

            System.out.println("Ingrese su nombre:");
            String nombre = ingresarDato();

            String estadocivil = ingresarEstadoCivil();

            System.out.println("Ingrese su edad");
            String edad = String.valueOf(validarEdad(convertirEdadAInt(ingresarDato())));

            registro[indiceDisponible][0] = nombre;
            registro[indiceDisponible][1] = estadocivil;
            registro[indiceDisponible][2] = edad;
            System.out.println("Persona agregada.");
        } else {
            System.out.println("No hay cupo.");
        }
    }

    public static String ingresarEstadoCivil() {
        mostrarOpcionesEstadoCivil();
        int opcionIngresada = validarOpcionIngresada(ingresarOpcion(), 3);
        return asignarEstado(opcionIngresada);
    }

    public static String asignarEstado(int opcionIngresada) {
        if (opcionIngresada == 1) return "casado/a";
        if (opcionIngresada == 2) return "soltero/a";
        return "Otro";
    }

    public static void mostrarOpcionesEstadoCivil() {
        System.out.println("""
                Seleccione su estado civil:
                1. Casado/a
                2. Soltero/a
                3. Otro""");
    }

    public static boolean noEsEdadValida(int edad) {
        return edad < 0 || edad > 200;
    }

    public static int convertirEdadAInt(String edadIngresada) {
        try {
            return validarEdad(Integer.parseInt(edadIngresada));
        } catch (NumberFormatException e) {
            System.out.println("Edad no valida, vuelva a intentarlo");
            return convertirEdadAInt(ingresarDato());
        }
    }

    public static int validarEdad(int edad) {
        if (noEsEdadValida(edad)) {
            System.out.println("Edad no valida, vuelva a intentarlo");
            return convertirEdadAInt(ingresarDato());
        }
        return edad;
    }

    public static String ingresarDato() {
        try {
            return validarTextoIngresado(new Scanner(System.in).nextLine());
        } catch (InputMismatchException e) {
            System.err.println("Opción inválida, vuelva a intentarlo");
            return ingresarDato();
        }
    }

    public static String validarTextoIngresado(String textoIngresado) {
        if (textoIngresado.isBlank()) {
            System.out.println("Debe ingresar un texto valido, vuelva a intentarlo");
            return ingresarDato();
        }
        return textoIngresado;
    }

    public static int validarOpcionIngresada(int opcionIngresada, int cantidadOpciones) {
        if (opcionIngresada < 1 || opcionIngresada > cantidadOpciones) {
            System.out.println("Opción inválida, vuelva a intentarlo");
            return ingresarOpcion();
        }
        return opcionIngresada;
    }

    public static int ingresarOpcion() {
        try {
            return validarOpcionIngresada(new Scanner(System.in).nextInt(), 6);
        } catch (InputMismatchException e) {
            System.err.println("Opción inválida, vuelva a intentarlo");
            return ingresarOpcion();
        }
    }

    public static void mostrarMenu() {
        System.out.println("""
                Menú
                1) Agregar persona.
                2) Mostrar la cantidad de personas mayores de edad.
                3) Mostrar la cantidad de personas menores de edad.
                4) Mostrar la cantidad de personas de tercera edad.
                5) Mostrar la cantidad de personas según estado civil (Soltero/a - Casado/a).
                6) Salir.""");
    }

    public static int cantidadDePersonasRegistradas(String[][] registro) {
        if (hayCupo(registro)) {
            return retornarFilaVacia(registro);
        }
        return registro.length;
    }

    public static boolean hayCupo(String[][] registro) {
        int ultimaPosicion = registro.length - 1;
        return Arrays.equals(registro[ultimaPosicion], new String[3]);
    }

    public static int retornarFilaVacia(String[][] registro) {
        for (int i = 0; i < registro.length; i++) {
            if (Arrays.equals(registro[i], new String[3])) {
                return i;
            }
        }
        return -1;
    }
}
