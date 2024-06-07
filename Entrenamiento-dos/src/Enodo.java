
import java.util.Arrays;
import java.util.Scanner;

public class Enodo {

    static class Puzzle15 {

        static int auxValorCosto = 0; //guardar los costos del metodo costos
        static int auxMovimiento = 0; //guardar los movimientos del metodo costos
        // Variables para almacenar el último retorno de costos
        static int[] mejorMovimiento = new int[2];
        static int[] auxMovimientoEficiente = new int[2];//almacenar el mejor movimiento la primeraves
        static String movimientoImprimir = "";

        //heuristica mejor camino 
        static int calcularCostoHeuristico(int[][] puzzle) {
            int costoHeuristico = 0;//guardar el costo
            int n = puzzle.length;//tamaño del puzzle recivido de los movimientos
            // Posiciones objetivo de cada número en el puzzle
            int[][] posicionesObjetivo = {{0, 0}, {0, 1}, {0, 2}, {0, 3},
            {1, 0}, {1, 1}, {1, 2}, {1, 3},
            {2, 0}, {2, 1}, {2, 2}, {2, 3},
            {3, 0}, {3, 1}, {3, 2}, {3, 3}};
            // Calcular la distanci para cada numeros
            for (int i = 0; i < n; i++) {
                for (int j = 0; j < n; j++) {
                    int numero = puzzle[i][j];
                    if (numero != 0) { // Ignorar el espacio en blanco
                        int[] objetivo = posicionesObjetivo[numero - 1]; // Obtener la posición objetivo del número
                        costoHeuristico += Math.abs(i - objetivo[0]) + Math.abs(j - objetivo[1]); // Sumar la distancia 
                    }
                }
            }
            return costoHeuristico;//costo de ese puzzle al realizar un movimiento especifico
        }

        //Logica de verificacion de solucion 
        static boolean tieneSolucion(int[][] puzzle) {
            int inversiones = contarInversiones(puzzle);
            return inversiones % 2 == 0; //si es par la suma se puede resolver
        }

        static int contarInversiones(int[][] puzzle) {//cuenta los numeros menores de cada fila
            int inversiones = 0;//suma de los numeros menores de las filas
            for (int i = 0; i < puzzle.length; i++) {
                for (int j = 0; j < puzzle[i].length; j++) {
                    if (puzzle[i][j] != 0) {
                        int current = puzzle[i][j];//numero alctual
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

        //Buscar el cero 
        private static int[] posicionCero(int[][] puzzle) {
            int[] posicion = new int[2]; // array para almacenar la posición (x, y)
            for (int x = 0; x < puzzle.length; x++) {
                for (int y = 0; y < puzzle[x].length; y++) {
                    if (puzzle[x][y] == 0) {
                        posicion[0] = x;
                        posicion[1] = y;
                        return posicion; // Retornar el array con la posición encontrada
                    }
                }
            }
            return null;
        }

        //volver a hacerlo pero si solo tiene dos cero haga esos dos escoja a el mejor y continue con su nuevo posicion
        //Organiza todo el rompecabezas
        static int[] organizar(int[] posicion, int[][] puzzle) {
            int[] coordenadas = posicion;//guarda lo posicion cero
            int posX = coordenadas[0];//guardo cada eje
            int posY = coordenadas[1];
            int contarMovimientos = 0;//movimientos posibles del cero 
            int completado = 0;//se usa contador cuando y se evaluo un caso de movimiento

            System.out.println("Posición del cero: (" + posX + ", " + posY + ")");

            for (int x = 0; x < puzzle.length; x++) {
                for (int y = 0; y < puzzle[x].length; y++) {

                    System.out.print(puzzle[x][y] + " ");
                }
                System.out.println();
            }
            if (posX == 3 && posY == 3) {
                System.out.println("Finnn");
                System.out.println(movimientoImprimir);
            } else {
                // Movimientos posibles del cero
                // Para poder saber cuantos movimientos puede hacer el cero, para crear los casos de movimiento
                boolean puedeArriba = posX != 0;
                boolean puedeAbajo = posX != 3;
                boolean puedeIzquierda = posY != 0;
                boolean puedeDerecha = posY != 3;
                if (puedeArriba) {//Se puede mover arriba
                    System.out.println("Se puede mover arriba");
                    contarMovimientos++;
                }
                if (puedeAbajo) { //Se puede mover abajo
                    System.out.println("Se puede mover abajo");
                    contarMovimientos++;
                }
                if (puedeIzquierda) { //Se puede mover izquierda
                    System.out.println("Se puede mover a la izquierda");
                    contarMovimientos++;
                }
                if (puedeDerecha) { //Se puede mover a la derecha
                    System.out.println("Se puede mover a la derecha");
                    contarMovimientos++;
                }
                //Repetir los movimientos de cada cero
                while (completado < contarMovimientos) {
                    //mirar si puedo mover arriba 
                    if (posX != 0) {//tope de arriba
                        System.out.println("Se puede arriba");
                        moverArriba(posX, posY, puzzle);
                        completado++;
                    }
                    //mirar si puedo mover abajo
                    //posX != 3
                    if (posX != puzzle.length - 1) {
                        System.out.println("Se puede abajo");
                        moverAbajo(posX, posY, puzzle);
                        completado++;

                    }

                    //mirar si puedo mover a la izquierda
                    // if (posY >= 0 && posY <= 3) {
                    // if (posY >= 1 && posY <= 3) { maso
                    if (posY != 0) {
                        System.out.println("Se puede izquierda");
                        moverIzquierda(posX, posY, puzzle);
                        completado++;
                    }

                    //mirar si puedo mover a la derecha
                    //if (posY >= 3 && posY <= 0) {
                    //(posY >= 0 && posY <= 2) { maso
                    if (posY != puzzle[0].length - 1) {
                        System.out.println("Se puede derecha");
                        moverDerecha(posX, posY, puzzle);
                        completado++;
                    }
                }
                //si sale del ciclo termina el caso de ese cero
                System.out.println("Salio del  ciclo fin");
                System.out.println("Puzzle evaluado ");
                for (int x = 0; x < puzzle.length; x++) {
                    for (int y = 0; y < puzzle[x].length; y++) {
                        System.out.print(puzzle[x][y] + " ");
                    }
                    System.out.println();
                }
                //Cuando sale del ciclo ya se cuenta con el valor de movimiento con menos
                //costo y su movimiento evaluado asi:
                //arriba = 1; //U
                //abajo = 0; //D
                //izquiera = 10;//L
                //derecha = 11; //R
                System.out.println("Datos efectivos");
                System.out.println("valorMovimiento " + mejorMovimiento[0]);
                System.out.println("movimiento realizado " + mejorMovimiento[1]);

                //creacion de salida de resultado, se evalua el valor de movimiento y se agrega
                //a la variable
                if (mejorMovimiento[1] == 1) { //arriba
                    movimientoImprimir = movimientoImprimir + "U";
                } else {
                    if (mejorMovimiento[1] == 0) {
                        movimientoImprimir = movimientoImprimir + "D";
                    } else {
                        if (mejorMovimiento[1] == 10) {
                            movimientoImprimir = movimientoImprimir + "L";
                        } else {
                            movimientoImprimir = movimientoImprimir + "R";
                        }
                    }
                }

                System.out.println(movimientoImprimir);

                //Se realiza el movimiento mas efectivo en el puzzle
                if (mejorMovimiento[1] == 1) { //arriba
                    puzzle[posX][posY] = puzzle[posX - 1][posY];
                    puzzle[posX - 1][posY] = 0;
                } else {
                    if (mejorMovimiento[1] == 0) {//abajo
                        puzzle[posX][posY] = puzzle[posX + 1][posY];
                        puzzle[posX + 1][posY] = 0;
                    } else {
                        if (mejorMovimiento[1] == 10) {//izquierda
                            puzzle[posX][posY] = puzzle[posX][posY - 1];
                            puzzle[posX][posY - 1] = 0;
                        } else {//derecha
                            puzzle[posX][posY] = puzzle[posX][posY + 1];
                            puzzle[posX][posY + 1] = 0;
                        }
                    }
                }
                //Termina porque el cero esta al final

                //si no termina llama al metodo para obtener denuevo la posicion del cero
                //con el puzzle modificado
                auxValorCosto = 0; //guardar los costos del metodo costos
                auxMovimiento = 0;
                int[] posicionCero = posicionCero(puzzle); // Obtener la posición del cero
                organizar(posicionCero, puzzle); // Llamar al método organizar y pasarle la posición del cero

            }

            return null;
        }

        //guardar el ultimo movimiento mas eficiente de ese cero
        static void ultimoMovimientoEficiente(int[] movimiento) {
            System.out.println("Entro");
            System.out.println("a " + auxMovimientoEficiente[0]);
            if (auxMovimientoEficiente[0] == 0) {//primera ves de ingreso
                auxMovimientoEficiente = movimiento;
            } else {//movimiento con mejor costo
                mejorMovimiento = movimiento;
                System.out.println("_________________________________");
                System.out.println("mejor movimiento");
                System.out.println(mejorMovimiento[0]);
                System.out.println(mejorMovimiento[1]);
            }
        }//Este metodo termina cuando el ciclo while de organizar termina guardando el mejor movimiento de ese cero

        //Metodos para mover el cero
        static int[] moverArriba(int posX, int posY, int[][] puzzle) {//Mover el cero hacia arriba
            System.out.println("Entro arriba");
            int[][] copiaPuzzle = new int[puzzle.length][];//copia puzzle
            System.out.println("Antes de copiar puzzle");
            for (int i = 0; i < puzzle.length; i++) {
                copiaPuzzle[i] = Arrays.copyOf(puzzle[i], puzzle[i].length);
            }

            //movimiento realizado en copiaPuzzle
            System.out.println("Antes de mover");
            // 0.3
            System.out.println("x" + posX);
            System.out.println("Y" + posY);
            copiaPuzzle[posX][posY] = copiaPuzzle[posX - 1][posY];
            System.out.println("este " + copiaPuzzle[posX][posY]);
            System.out.println("x" + posX);
            System.out.println("Y" + posY);
            copiaPuzzle[posX - 1][posY] = 0;
            System.out.println("Puzzle movido");
            for (int x = 0; x < copiaPuzzle.length; x++) {
                for (int y = 0; y < copiaPuzzle[x].length; y++) {
                    System.out.print(copiaPuzzle[x][y] + " ");
                }
                System.out.println();
            }
            //se envia a la heuristica

            int costoArriba = calcularCostoHeuristico(copiaPuzzle);
            System.out.println("Costo Arriba = " + costoArriba);

            for (int x = 0; x < copiaPuzzle.length; x++) {
                for (int y = 0; y < copiaPuzzle[x].length; y++) {
                    System.out.print(copiaPuzzle[x][y] + " ");
                }
                System.out.println();
            }
            int[] datosArriba = new int[2];//guardar datos del movimiento
            datosArriba[0] = costoArriba; // Almacenar el costo del movimiento
            datosArriba[1] = 1; //movimiento realizado U 
            costos(datosArriba);//envio al metodo costos
            return null;
        }

        static int[] moverAbajo(int posX, int posY, int[][] puzzle) {//Mover el cero hacia abajo
            int[][] copiaPuzzle = new int[puzzle.length][];//copia puzzle
            for (int i = 0; i < puzzle.length; i++) {
                copiaPuzzle[i] = Arrays.copyOf(puzzle[i], puzzle[i].length);
            }
            System.out.println("Antes de todo");
            for (int x = 0; x < puzzle.length; x++) {
                for (int y = 0; y < puzzle[x].length; y++) {

                    System.out.print(puzzle[x][y] + " ");
                }
                System.out.println();
            }
            //movimiento realizado en copiaPuzzle
            copiaPuzzle[posX][posY] = copiaPuzzle[posX + 1][posY];
            copiaPuzzle[posX + 1][posY] = 0;
            //se envia a la heuristica
            int costoAbajo = calcularCostoHeuristico(copiaPuzzle);
            System.out.println("Costo Abajo= " + costoAbajo);
            for (int x = 0; x < copiaPuzzle.length; x++) {
                for (int y = 0; y < copiaPuzzle[x].length; y++) {

                    System.out.print(copiaPuzzle[x][y] + " ");
                }
                System.out.println();
            }
            int[] datosAbajo = new int[2];
            datosAbajo[0] = costoAbajo; // Almacenar el costo del movimiento
            datosAbajo[1] = 0; //D abajo movmiento
            System.out.println("Sin modificar");
            for (int x = 0; x < puzzle.length; x++) {
                for (int y = 0; y < puzzle[x].length; y++) {
                    System.out.print(puzzle[x][y] + " ");
                }
                System.out.println();
            }
            costos(datosAbajo);//envio al metodo costos
            return null;
        }

        static int[] moverIzquierda(int posX, int posY, int[][] puzzle) {//Mover el cero hacia la izquierda
            int[][] copiaPuzzle = new int[puzzle.length][];//copia puzzle
            for (int i = 0; i < puzzle.length; i++) {
                copiaPuzzle[i] = Arrays.copyOf(puzzle[i], puzzle[i].length);
            }
            System.out.println("Antes de todo");
            for (int x = 0; x < puzzle.length; x++) {
                for (int y = 0; y < puzzle[x].length; y++) {

                    System.out.print(puzzle[x][y] + " ");
                }
                System.out.println();
            }
            //movimiento realizado en copiaPuzzle
            copiaPuzzle[posX][posY] = copiaPuzzle[posX][posY - 1];
            copiaPuzzle[posX][posY - 1] = 0;
            //se envia a la heuristica
            int costoIzquierda = calcularCostoHeuristico(copiaPuzzle);
            System.out.println("Costo izquierda = " + costoIzquierda);

            for (int x = 0; x < copiaPuzzle.length; x++) {
                for (int y = 0; y < copiaPuzzle[x].length; y++) {
                    System.out.print(copiaPuzzle[x][y] + " ");
                }
                System.out.println();
            }
            int[] datosIzquierda = new int[2];
            datosIzquierda[0] = costoIzquierda; // Almacenar el costo del movimiento
            datosIzquierda[1] = 10; //L izquierda movmiento
            System.out.println("Sin modificar");
            for (int x = 0; x < puzzle.length; x++) {
                for (int y = 0; y < puzzle[x].length; y++) {
                    System.out.print(puzzle[x][y] + " ");
                }
                System.out.println();
            }
            costos(datosIzquierda);//envio al metodo costos
            return null;
        }

        static int[] moverDerecha(int posX, int posY, int[][] puzzle) {//Mover el cero hacia la derecha
            int[][] copiaPuzzle = new int[puzzle.length][];//copia puzzle
            for (int i = 0; i < puzzle.length; i++) {
                copiaPuzzle[i] = Arrays.copyOf(puzzle[i], puzzle[i].length);
            }
            //movimiento realizado en copiaPuzzle
            copiaPuzzle[posX][posY] = copiaPuzzle[posX][posY + 1];
            copiaPuzzle[posX][posY + 1] = 0;
            //se envia a la heuristica
            int costoDerecha = calcularCostoHeuristico(copiaPuzzle);
            System.out.println("Costo derecha = " + costoDerecha);

            for (int x = 0; x < puzzle.length; x++) {
                for (int y = 0; y < puzzle[x].length; y++) {
                    System.out.print(puzzle[x][y] + " ");
                }
                System.out.println();
            }
            int[] datosDerecha = new int[2];
            datosDerecha[0] = costoDerecha; // Almacenar el costo del movimiento
            datosDerecha[1] = 11; //R derecha movmiento
            costos(datosDerecha);//envio al metodo costos
            return null;
        }

        //costos para el movimiento
        static int[] costos(int[] datosCostos) {
            int costos = datosCostos[0];//valores de los costos de la heuristica
            int movimiento = datosCostos[1];//movimiento realizado
            System.out.println("Costos ");
            if (auxValorCosto == 0) {//Asignacion de los costos realizados para cada cero
                auxValorCosto = costos;
                auxMovimiento = movimiento;
            } else {
                if (auxValorCosto > costos) {
                    auxValorCosto = costos;
                    auxMovimiento = movimiento;
                }
            }//guardo los mejores movimientos
            int[] movimientosEficientes = new int[2];
            movimientosEficientes[0] = auxValorCosto;
            movimientosEficientes[1] = auxMovimiento;
            System.out.println("costo menor " + auxValorCosto);
            System.out.println("movimiento menor " + auxMovimiento);
            //se usa para almacenar los mejores movimientos de la evaluacion del cero
            ultimoMovimientoEficiente(movimientosEficientes);
            return null;
        }

        public static void main(String[] args) {
            Scanner keyboard = new Scanner(System.in);
            int n = 0; //conjuntos de rompecabezas a armar
            int casos = 0;
            n = keyboard.nextInt();
            while (casos < n) {
                System.out.println("Caso " + (casos + 1));
                int[][] initialPuzzle = new int[4][4];
                //cargo la matriz con los datos
                for (int x = 0; x < initialPuzzle.length; x++) {
                    for (int y = 0; y < initialPuzzle[x].length; y++) {
                        initialPuzzle[x][y] = keyboard.nextInt();
                    }
                }
                //verifico si el rompecabezas inicial tiene solucion
                if (tieneSolucion(initialPuzzle)) {//lo envio a metodo
                    System.out.println("El rompecabezas tiene solución.");
                    int[] posicionCero = posicionCero(initialPuzzle); // guardo la posicion cero de lo realizado del metodo con el puzzle inicial
                    organizar(posicionCero, initialPuzzle); // Llamar al método organizar y pasarle la posición del cero
                } else {
                    System.out.println("This puzzle is not solvable.");
                }
                casos++;
            }
        }

    }
}
