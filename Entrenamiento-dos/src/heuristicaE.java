/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Main.java to edit this template
 */

/**
 *
 * @author camil
 */
public class heuristicaE {

    static int calcularCostoHeuristico(int[][] puzzle) {
        int costoHeuristico = 0;
        int n = puzzle.length;

        // Posiciones objetivo de cada número en el rompecabezas
        int[][] posicionesObjetivo = {{0, 0}, {0, 1}, {0, 2}, {0, 3},
        {1, 0}, {1, 1}, {1, 2}, {1, 3},
        {2, 0}, {2, 1}, {2, 2}, {2, 3},
        {3, 0}, {3, 1}, {3, 2}, {3, 3}};

        // Calcular la distancia Manhattan para cada ficha
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                int numero = puzzle[i][j];
                if (numero != 0) { // Ignorar el espacio en blanco
                    int[] objetivo = posicionesObjetivo[numero - 1]; // Obtener la posición objetivo del número
                    costoHeuristico += Math.abs(i - objetivo[0]) + Math.abs(j - objetivo[1]); // Sumar la distancia Manhattan
                }
            }
        }

        return costoHeuristico;
    }

    public static void main(String[] args) {
        // Ejemplo de rompecabezas para probar la función heurística
        int[][] ejemploPuzzle1 = {
            {1, 2, 3, 4},
            {5, 6, 7, 8},
            {9, 10, 11, 12},
            {13, 14, 15, 0}
        };
        int[][] ejemploPuzzle2 = {
            {2, 1, 3, 4},
            {5, 6, 7, 8},
            {9, 10, 11, 12},
            {13, 14, 15, 0}
        };
        int[][] ejemploPuzzle3 = {
            {1, 2, 3, 4},
            {5, 0, 7, 8},
            {9, 6, 11, 12},
            {13, 10, 14, 15}
        };

        // Calcular el costo heurístico para cada rompecabezas de ejemplo
        int costo1 = calcularCostoHeuristico(ejemploPuzzle1);
        int costo2 = calcularCostoHeuristico(ejemploPuzzle2);
        int costo3 = calcularCostoHeuristico(ejemploPuzzle3);

        // Imprimir los costos heurísticos calculados
        System.out.println("Costo heurístico para ejemploPuzzle1: " + costo1);
        System.out.println("Costo heurístico para ejemploPuzzle2: " + costo2);
        System.out.println("Costo heurístico para ejemploPuzzle3: " + costo3);
    }

}
