
package ej.pkg02;


import java.util.Random;
import java.util.Scanner;

class Estudiante01{

    String nombre;
    String cedula;
    double adc;
    double ape;
    double aa;

    Estudiante01(String nombre, String cedula) {
        this.nombre = nombre;
        this.cedula = cedula;
        this.adc = Math.random() * 3.5 + 6.5; // Calificación entre 6.5 y 10
        this.ape = Math.random() * 3.5 + 6.5; // Calificación entre 6.5 y 10
        this.aa = Math.random() * 3;          // Calificación entre 0 y 3
    }

    double calcularPorcentajeAprobacion() {
        double porcentajeTotal = (adc + ape + aa) / 3;
        return porcentajeTotal * 10; // Convertir a escala de 0 a 100
    }

    boolean haAprobado() {
        return calcularPorcentajeAprobacion() >= 70;
    }
}

class Materia {

    String nombre;

    Materia(String nombre) {
        this.nombre = nombre;
    }
}

class ProgramaGestionCalificaciones {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.println("Ingrese el número de estudiantes:");
        int numEstudiantes = scanner.nextInt();
        scanner.nextLine(); // Limpiar el buffer

        Estudiante01 [] estudiantes = new Estudiante01[numEstudiantes];

        // Simular la entrada de datos y generar estadísticas
        Random dado = new Random();
        int aprobados = 0;
        int reprobados = 0;
        double nota, notaExamenr, notaRecuperada;
        double adc;
        double ape;
        double aa;
        notaExamenr = dado.nextDouble(10);
        for (int i = 0; i < numEstudiantes; i++) {
            String nombre = "Estudiante" + (i + 1);
            String cedula = String.valueOf(new Random().nextInt(1000000000));

            Estudiante01 estudiante = new Estudiante01(nombre, cedula);

            System.out.println("Estudiante: " + estudiante.nombre);
            System.out.println("Cédula: " + estudiante.cedula);
            System.out.println("ADC: " + estudiante.adc);
            System.out.println("APE: " + estudiante.ape);
            System.out.println("AA: " + estudiante.aa);
            nota = (estudiante.adc * 0.35) + (estudiante.ape * 0.35) + (estudiante.aa * 0.30);
            System.out.println("Total de las notas:  " + nota);

            if (estudiante.haAprobado()) {
                System.out.println("Aprobado");
                aprobados++;
            } else {
                System.out.println("Estudiante debera realizar un examen de recuperacion");
                notaRecuperada = (notaExamenr * 0.35) + (nota * 0.6);
                System.out.println("Nota del examen de recuperacion: " + notaExamenr);
                if (notaRecuperada < 7) {
                    System.out.println("Reprobado totalmente ");
                    System.out.println("NOTA : "+nota );
                    reprobados++;
                } else {
                    System.out.println("Aprobado");
                    aprobados++;
                }
               
            }

            estudiantes[i] = estudiante;
            System.out.println("--------------------");
        }

        // Mostrar estadísticas finales
        System.out.println("Estadísticas:");
        System.out.println("Aprobados: " + aprobados);
        System.out.println("Reprobados: " + reprobados);
        System.out.println("Porcentaje de aprobación: " + ((double) aprobados / numEstudiantes) * 100 + "%");
        System.out.println("Porcentaje de reprobacion: " + ((double) reprobados / numEstudiantes) * 100 + "%");
    }
}