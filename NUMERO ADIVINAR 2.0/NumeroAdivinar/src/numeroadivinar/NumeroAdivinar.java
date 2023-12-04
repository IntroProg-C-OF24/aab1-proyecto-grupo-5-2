package numeroadivinar;

import java.util.Random;
import java.util.Scanner;

public class NumeroAdivinar {

    public static void main(String[] args) {
        jugarJuego();
    }

    public static void jugarJuego() {
        Scanner scanner = new Scanner(System.in);
        Random random = new Random();

        int numeroAdivinar = random.nextInt(100) + 1;
        int intentosRestantes = 10; // Puedes ajustar la cantidad de intentos

        System.out.println("¡BIENVENIDO AL JUEGO DE ADIVINANZAS!");
        System.out.println("Intenta adivinar un número entre 1 y 100.");

        while (intentosRestantes > 0) {
            System.out.println("--------------------------------------------------------------------------------------------------");
            System.out.print("Ingresa tu adivinanza: ");
            int intentoUsuario = scanner.nextInt();
            int casopista;
            if (intentoUsuario == numeroAdivinar) {
                System.out.println("¡Felicidades! ¡Has adivinado el número!");
                break;
            } else {
                intentosRestantes--;

                System.out.println("Incorrecto. Te quedan " + intentosRestantes + " intentos.");
                System.out.println("-------        ----------        ---------        -----------");

                // Proporcionar pistas
                if (intentosRestantes > 0) {
                    System.out.print("\n" + "¿Quieres una pista? (si/no); (NOTA: El numero de intentos se reducira si aceptas la pista): ");
                    String respuesta = scanner.next().toLowerCase();

                    if (respuesta.equals("si")) {
                        System.out.println("Seleccione la pista que desea obtener: "
                                + "\n" + "Seleccione (1). Si quiere saber si el numero es mayor o menor"
                                + "\n" + "Seleccione (2). Si quiere saber si el numero es par o impar"
                                + "\n" + "Seleccione (3). Si quiere saber si el numero es primo"
                                + "\n" + "Seleccione (4). Si quiere saber si el numero es multiplo de algun numero");
                        System.out.println("------------------------       -------------------      -----------------------");
                        casopista = scanner.nextInt();
                        switch (casopista) {
                            case 1:
                                System.out.println("EXELENTE , SELECCIONASTE " + casopista + " aqui tienes tu pista ");
                                if (numeroAdivinar < intentoUsuario) {
                                    System.out.println("-  PISTA:   Intenta con un numero menor");
                                } else {
                                    System.out.println("-  PISTA:   Intenta con un numero mayor");
                                }
                                break;
                            case 2:
                                System.out.println("EXELENTE , SELECCIONASTE " + casopista + " aqui tienes tu pista ");
                                if (numeroAdivinar % 2 == 0) {
                                    System.out.println("-  PISTA:   El numero es par");
                                } else {
                                    System.out.println("-  PISTA:   El numero es impar");
                                }
                                break;
                            case 3:
                                System.out.println("EXELENTE , SELECCIONASTE " + casopista + " aqui tienes tu pista ");
                                if (esPrimo(numeroAdivinar)) {
                                    System.out.println("-  PISTA:    EL numero es un número primo.");
                                } else {
                                    System.out.println("-  PISTA:    El numero no es un número primo.");
                                }
                                break;
                            case 4:
                                System.out.println("EXELENTE , SELECCIONASTE " + casopista + " aqui tienes tu pista ");
                                System.out.print("Ingrese el posible divisor: ");
                                int divisor = scanner.nextInt();

                                if (esMultiplo(numeroAdivinar, divisor)) {
                                    System.out.println(numeroAdivinar + "-  PISTA:   El numero es múltiplo de " + divisor);
                                } else {
                                    System.out.println("-  PISTA:   El numero  no es múltiplo de " + divisor);
                                }
                                break;
                        }

                        intentosRestantes--;
                        System.out.println("Se resto un intento te quedan: " + intentosRestantes);
                    }
                }
            }
        }

        if (intentosRestantes
                == 0) {
            System.out.println("¡Agotaste tus intentos! El número era: " + numeroAdivinar);
        }

        System.out.println(
                "¿Quieres jugar de nuevo? (si/no): ");
        String jugarDeNuevo = scanner.next().toLowerCase();

        if (jugarDeNuevo.equals(
                "si")) {
            jugarJuego();
        } else {
            System.out.println("Gracias por jugar. ¡Hasta luego!");
        }
    }

    private static boolean esMultiplo(int intentoUsuario, int divisor) {
        return intentoUsuario % divisor == 0;
    }

    private static boolean esPrimo(int intentoUsuario) {
        if (intentoUsuario <= 1) {
            return false; // Los números menores o iguales a 1 no son primos
        }

        // Verificar si el número es divisible por algún otro número menor que él
        for (int i = 2; i <= Math.sqrt(intentoUsuario); i++) {
            if (intentoUsuario % i == 0) {
                return false; // El número es divisible, por lo tanto, no es primo
            }
        }

        return true; // Si no se encontraron divisores, el número es primo
    }
}
