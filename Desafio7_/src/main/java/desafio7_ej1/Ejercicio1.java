package desafio7_ej1;

import java.util.Scanner;

public class Ejercicio1 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.print("Ingrese la cantidad de alumnos: ");
        int cantidadAlumnos = Integer.parseInt(scanner.nextLine());

        String[] nombres = new String[cantidadAlumnos];
        String[] apellidos = new String[cantidadAlumnos];
        int[][] numerosExamen = new int[cantidadAlumnos][];
        double[][] notas = new double[cantidadAlumnos][];

        ingresarDatosAlumnos(scanner, cantidadAlumnos, nombres, apellidos, numerosExamen, notas);
        calcularYMostrarInformacion(nombres, apellidos, numerosExamen, notas);
    }

    public static void ingresarDatosAlumnos(Scanner scanner, int cantidadAlumnos,
                                            String[] nombres, String[] apellidos,
                                            int[][] numerosExamen, double[][] notas) {
        for (int i = 0; i < cantidadAlumnos; i++) {
            System.out.println("\nIngresando datos para el alumno " + (i + 1));
            System.out.print("Nombre: ");
            nombres[i] = scanner.nextLine();
            System.out.print("Apellido: ");
            apellidos[i] = scanner.nextLine();

            int[] tempNumerosExamen = new int[100]; 
            double[] tempNotas = new double[100];
            int indiceExamen = 0;
            double nota;

            while (true) {
                System.out.print("Número de examen (0 para terminar): ");
                int numeroExamen = Integer.parseInt(scanner.nextLine());
                if (numeroExamen == 0) {
                    break;
                }
                tempNumerosExamen[indiceExamen] = numeroExamen;
                do {
                	System.out.print("Nota: ");
                	nota = Double.parseDouble(scanner.nextLine());
                }while(nota < 0 || nota > 10);
                
                tempNotas[indiceExamen] = nota;
                indiceExamen++;
            }

            numerosExamen[i] = new int[indiceExamen];
            notas[i] = new double[indiceExamen];

            for (int j = 0; j < indiceExamen; j++) {
                numerosExamen[i][j] = tempNumerosExamen[j];
                notas[i][j] = tempNotas[j];
            }
        }
    }

    public static void calcularYMostrarInformacion(String[] nombres, String[] apellidos,
                                                   int[][] numerosExamen, double[][] notas) {
        double maxNota = Double.MIN_VALUE;
        double minNota = Double.MAX_VALUE;
        double sumaNotas = 0;
        int cantidadNotas = 0;

        for (double[] alumnoNotas : notas) {
            for (double nota : alumnoNotas) {
                if (nota > maxNota) {
                    maxNota = nota;
                }
                if (nota < minNota) {
                    minNota = nota;
                }
                sumaNotas += nota;
                cantidadNotas++;
            }
        }

        double promedio = sumaNotas / cantidadNotas;

        System.out.println("\nAlumno/s con la calificación más alta:");
        mostrarAlumnosConNota(nombres, apellidos, numerosExamen, notas, maxNota);

        System.out.println("\nAlumno/s con la calificación más baja:");
        mostrarAlumnosConNota(nombres, apellidos, numerosExamen, notas, minNota);

        System.out.println("\nAlumnos que promocionan (promedio >= 7):");
        mostrarAlumnosPromocionados(nombres, apellidos, numerosExamen, notas, promedio);

        System.out.println("\nAlumnos que deben recursar la materia (promedio < 7):");
        mostrarAlumnosRecursar(nombres, apellidos, numerosExamen, notas, promedio);
    }

    public static void mostrarAlumnosConNota(String[] nombres, String[] apellidos,
                                             int[][] numerosExamen, double[][] notas, double notaBuscada) {
        for (int i = 0; i < nombres.length; i++) {
            for (int j = 0; j < notas[i].length; j++) {
                if (notas[i][j] == notaBuscada) {
                    System.out.println(nombres[i] + " " + apellidos[i] +
                            " - Examen: " + numerosExamen[i][j] +
                            " - Nota: " + notas[i][j]);
                }
            }
        }
    }

    public static void mostrarAlumnosPromocionados(String[] nombres, String[] apellidos,
                                                    int[][] numerosExamen, double[][] notas, double promedio) {
        for (int i = 0; i < nombres.length; i++) {
            double sumaNotas = 0;
            for (double nota : notas[i]) {
                sumaNotas += nota;
            }
            double promedioAlumno = sumaNotas / notas[i].length;
            if (promedioAlumno >= 7) {
                System.out.println(nombres[i] + " " + apellidos[i] +
                        " - Promedio: " + promedioAlumno);
            }
        }
    }

    public static void mostrarAlumnosRecursar(String[] nombres, String[] apellidos,
                                               int[][] numerosExamen, double[][] notas, double promedio) {
        for (int i = 0; i < nombres.length; i++) {
            double sumaNotas = 0;
            for (double nota : notas[i]) {
                sumaNotas += nota;
            }
            double promedioAlumno = sumaNotas / notas[i].length;
            if (promedioAlumno < 7) {
                System.out.println(nombres[i] + " " + apellidos[i] +
                        " - Promedio: " + promedioAlumno);
            }
        }
    }
}
