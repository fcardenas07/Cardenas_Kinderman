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
            case 1 -> opcionUno(registro);
            case 2 -> opcionDos(registro);
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
        int mmmm = 0;

        for (String[] persona : registro) {
            if (persona[2] >= 60 && persona[1].equals("casado/a")) {
                mmmm++;
            } else if (persona[2] >= 65 && persona[1].equals("soltero/a")) {
                mmmm++;
            }
        }
        System.out.println("Hay " + mmmm + " personas de tercera edad");
    }

    private static void opcionTres(String[][] registro) {
        int menoresDeEdad = 0;
        int queSera = obtenerUltimoEspacio(registro);

        for (int i = 0; i < queSera; i++) {
            if (registro[i][2] < 18) menoresDeEdad++;
        }

        System.out.println("Hay " + menoresDeEdad + " menores de edad.");
    }

    private static void opcionDos(String[][] registro) {
        int mayoresDeEdad = 0;

        for (String[] persona : registro) {
            if (persona[2] >= 18) mayoresDeEdad++;
        }

        System.out.println("Hay " + mayoresDeEdad + " mayores de edad.");
    }

    private static void opcionUno(String[][] registro) {
        if (hayCupo(registro)) {
            int indiceDisponible = obtenerUltimoEspacio(registro);
            String nombre;
            String Estadocivil;
            int edad;

            while (true) {
                try {
                    nombre = new Scanner(System.in).nextLine();
                } catch (InputMismatchException e) {
                    System.err.println("Opción inválida");
                    continue;
                }
                break;
            }

            while (true) {
                try {
                    Estadocivil = new Scanner(System.in).nextLine();
                } catch (InputMismatchException e) {
                    System.err.println("Opción inválida");
                    continue;
                }
                break;
            }

            while (true) {
                try {
                    edad = new Scanner(System.in).nextLine();
                } catch (InputMismatchException e) {
                    System.err.println("Opción inválida");
                    continue;
                }
                break;
            }

            registro[indiceDisponible][0] = nombre;
            registro[indiceDisponible][1] = Estadocivil;
            registro[indiceDisponible][2] = edad;
            System.out.println("Persona agregada.");
        } else {
            System.out.println("No hay cupo.");
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

    public static int obtenerUltimoEspacio(double[][] registro) {
        return registro.length - opa(registro);
    }

    public static boolean hayCupo(String[][] registro) {
        return opa(registro) != 0;
    }

    public static int opa(String[][] registro) {
        for (int i = 0; i < registro.length; i++) {
            if (registro[i][0].equals("")) {
                return registro.length - i;
            }
        }
        return 0;
    }
}