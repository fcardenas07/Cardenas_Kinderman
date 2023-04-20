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
            case 3 -> opcionTres(registro);
            case 4 -> opcionCuatro(registro);
            case 5 -> opcionCinco(registro);
            case 6 -> salir();
        }
    }

    private static void salir() {
        System.exit(0);
    }

    private static void opcionCinco(String[][] registro) {
        int c = 0;
        int d = 0;
        for (String[] persona : registro) {
            if (persona[1].equals("casado/a")) {
                c++;
            } else if (persona[1].equals("soltero/a")) {
                d++;
            }
        }

        System.out.println("Hay " + d + " casados/as.");
        System.out.println("Hay " + c + " solteros/as.");
    }

    private static void opcionCuatro(String[][] registro) {
        int contador = 0;

        for (String[] persona : registro) {
             int edad = Integer.parseInt(persona[2]);
            if (edad >= 60 && persona[1].equals("casado/a")) {
                contador++;
            } else if (edad >= 65 && persona[1].equals("soltero/a")) {
                contador++;
            }
        }
        System.out.println("Hay " + contador + " personas de tercera edad");
    }

    private static void opcionTres(String[][] registro) {
        int menoresDeEdad = 0;
        int queSera = obtenerUltimoEspacio(registro);

        for (int i = 0; i < queSera; i++) {
             int edad = Integer.parseInt(registro[i][2]);
            if (edad < 18) menoresDeEdad++;
        }

        System.out.println("Hay " + menoresDeEdad + " menores de edad.");
    }

    private static void mostrarPersonasMayoresDeEdad(String[][] registro) {
        int mayoresDeEdad = 0;

        for (String[] persona : registro) {
             int edad = Integer.parseInt(persona[2]);
            if (edad >= 18) mayoresDeEdad++;
        }

        System.out.println("Hay " + mayoresDeEdad + " mayores de edad.");
    }

    private static void agregarPersona(String[][] registro) {
        if (hayCupo(registro)) {
            int indiceDisponible = obtenerUltimoEspacio(registro);
            String nombre = ingresarDato();
            String estadocivil = ingresarDato();
            String edad = String.valueOf(validarEdad(convertirEdadAInt(ingresarDato())));

            registro[indiceDisponible][0] = nombre;
            registro[indiceDisponible][1] = estadocivil;
            registro[indiceDisponible][2] = edad;
            System.out.println("Persona agregada.");
        } else {
            System.out.println("No hay cupo.");
        }
    }

    private static boolean noEsEdadValida(int edad) {
        return edad < 0 || edad > 200;
    }

    private static int convertirEdadAInt(String edadIngresada) {
        try {
            return validarEdad(Integer.parseInt(edadIngresada));
        } catch (NumberFormatException e) {
            System.out.println("Edad no valida, vuelva a intentarlo");
            return convertirEdadAInt(ingresarDato());
        }
    }

    private static int validarEdad(int edad) {
        if (noEsEdadValida(edad)) {
            System.out.println("Edad no valida, vuelva a intentarlo");
            return convertirEdadAInt(ingresarDato());
        }
        return edad;
    }

    private static String ingresarDato() {
        try {
            return new Scanner(System.in).nextLine();
        } catch (InputMismatchException e) {
            System.err.println("Opción inválida, vuelva a intentarlo");
            return ingresarDato();
        }
    }

    private static int validarOpcionIngresada(int opcionIngresada) {
        if (opcionIngresada < 1 || opcionIngresada > 6) {
            System.out.println("Opción inválida, vuelva a intentarlo");
            return ingresarOpcion();
        }
        return opcionIngresada;
    }

    private static int ingresarOpcion() {
        try {
            return validarOpcionIngresada(new Scanner(System.in).nextInt());
        } catch (InputMismatchException e) {
            System.err.println("Opción inválida, vuelva a intentarlo");
            return ingresarOpcion();
        }
    }

    private static void mostrarMenu() {
        System.out.println("""
                Menú
                1) Agregar persona.
                2) Mostrar la cantidad de personas mayores de edad.
                3) Mostrar la cantidad de personas menores de edad.
                4) Mostrar la cantidad de personas de tercera edad.
                5) Mostrar la cantidad de personas según estado civil (Soltero/a - Casado/a).
                6)Salir.
                """);
    }

    public static int obtenerUltimoEspacio(String[][] registro) {
        return registro.length - retornarFilaVacia(registro);
    }

    public static boolean hayCupo(String[][] registro) {
        return retornarFilaVacia(registro) != 0;
    }

    public static int retornarFilaVacia(String[][] registro) {
        for (int i = 0; i < registro.length; i++) {
            if (registro[i][0].equals("")) {
                return registro.length - i;
            }
        }
        return 0;
    }
}