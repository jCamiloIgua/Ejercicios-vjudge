public class costos{
    public static void main(String[] args) {
        int[][] puzzle = {
            {12, 1, 2, 15},
            {11, 6, 5, 8},
            {7, 10, 9, 4},
            {0, 13, 14, 3}
        };

        if (tieneSolucion(puzzle)) {
            System.out.println("El rompecabezas tiene solución.");
        } else {
            System.out.println("El rompecabezas no tiene solución.");
        }
    }
    
    static boolean tieneSolucion(int[][] puzzle) {
        int inversiones = contarInversiones(puzzle);
        return inversiones % 2 == 0;
    }

    static int contarInversiones(int[][] puzzle) {
        int inversiones = 0;
        for (int i = 0; i < puzzle.length; i++) {
            for (int j = 0; j < puzzle[i].length; j++) {
                if (puzzle[i][j] != 0) {
                    int current = puzzle[i][j];
                    inversiones += contarMenoresEnFila(puzzle, i, j, current);
                }
            }
        }

        return inversiones;
    }

    static int contarMenoresEnFila(int[][] puzzle, int fila, int columna, int current) {
        int menores = 0;
        for (int j = 0; j < columna; j++) {
            if (puzzle[fila][j] < current) {
                menores++;
            }
        }
        return menores;
    }
}
