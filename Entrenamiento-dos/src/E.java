
import java.util.Arrays;
import java.util.Scanner;
//Complejidad O(n^2 * casos)
public class E {//puzzle 15

    static int auxValorCosto = 0; //guardar los costos del metodo costos
    static int auxMovimiento = 0; //guardar los movimientos del metodo costos
    // Variables para almacenar el último retorno de costos
    static int[] mejorMovimiento = new int[2];
    static int[] auxMovimientoEficiente = new int[2];//almacenar el mejor movimiento la primeraves
    static String movimientoImprimir = "";//almacenar los movimientos efectivos

    //heuristica mejor camino 
    static int calcularCostoHeuristico(int[][] puzzle) {
        int costoHeuristico = 0;//guardar el costo
        int n = puzzle.length;//tamaño del puzzle recivido de los movimientos
        // Posiciones objetivo de cada número en el puzzle
        int[][] posicionesObjetivo = {{0, 0}, {0, 1}, {0, 2}, {0, 3},
        {1, 0}, {1, 1}, {1, 2}, {1, 3},
        {2, 0}, {2, 1}, {2, 2}, {2, 3},
        {3, 0}, {3, 1}, {3, 2}, {3, 3}};
        // Calcular la distancia para cada numeros
        for (int i = 0; i < n; i++) {//O(i*j) => O(n^2)
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
    static boolean tieneSolucion(int[][] puzzle) {//O(n^2)
        int inversiones = contarInversiones(puzzle);
        return inversiones % 2 == 0; //si es par la suma se puede resolver
    }

    static int contarInversiones(int[][] puzzle) {//cuenta los numeros menores de cada fila
        int inversiones = 0;//suma de los numeros menores de las filas
        for (int i = 0; i < puzzle.length; i++) {//O(i*j) => (n^2)
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
        for (int x = 0; x < puzzle.length; x++) {//O(x*y) => O(n^2)
            for (int y = 0; y < puzzle[x].length; y++) {//O(y)
                if (puzzle[x][y] == 0) {
                    posicion[0] = x;
                    posicion[1] = y;
                    return posicion; // Retornar el array con la posición encontrada
                }
            }
        }
        return null;
    }

    //Organiza todo el rompecabezas
    static int[] organizar(int[] posicion, int[][] puzzle) {
        int[] coordenadas = posicion;//guarda lo posicion cero
        int posX = coordenadas[0];//guardo cada eje
        int posY = coordenadas[1];
        int contarMovimientos = 0;//movimientos posibles del cero 
        int completado = 0;//se usa contador cuando y se evaluo un caso de movimiento

        if (posX == 3 && posY == 3) {//si el cero vale 3.3 ya organizo el puzzle
            System.out.println(movimientoImprimir);
            movimientoImprimir="";//limpiar 
        } else {
            // Movimientos posibles del cero
            // Para poder saber cuantos movimientos puede hacer el cero, para crear los casos de movimiento
            boolean puedeArriba = posX != 0;
            boolean puedeAbajo = posX != 3;
            boolean puedeIzquierda = posY != 0;
            boolean puedeDerecha = posY != 3;
            if (puedeArriba) {//Se puede mover arriba
                contarMovimientos++;
            }
            if (puedeAbajo) { //Se puede mover abajo
                contarMovimientos++;
            }
            if (puedeIzquierda) { //Se puede mover izquierda
                contarMovimientos++;
            }
            if (puedeDerecha) { //Se puede mover a la derecha
                contarMovimientos++;
            }
            //en el peor de los casos se demora 4 veces
            //por ende es O(n^2)
            //Repetir los movimientos de cada cero
            while (completado < contarMovimientos) {
                //mirar si puedo mover arriba 
                if (posX != 0) {//tope de arriba
                    moverArriba(posX, posY, puzzle);//O(n^2)
                    completado++;
                }
                //mirar si puedo mover abajo
                if (posX != puzzle.length - 1) {
                    moverAbajo(posX, posY, puzzle);//O(n^2)
                    completado++;
                }
                //mirar si puedo mover a la izquierda
                if (posY != 0) {
                    moverIzquierda(posX, posY, puzzle);//O(n^2)
                    completado++;
                }
                //mirar si puedo mover a la derecha
                if (posY != puzzle[0].length - 1) {
                    moverDerecha(posX, posY, puzzle);//O(n^2)
                    completado++;
                }
            }
            //si sale del ciclo termina el caso de ese cero evaluado
            //Cuando sale del ciclo ya se cuenta con el valor de movimiento con menos
            //costo y su movimiento evaluado asi:
            //arriba = 1; //U
            //abajo = 0; //D
            //izquiera = 10;//L
            //derecha = 11; //R
            //creacion de salida de resultado, se evalua el valor de movimiento y se agrega
            //a la variable mejorMovimiento se trae del metodo
            //O(1)
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
            //O(1)
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
            //llama al metodo para obtener denuevo la posicion del cero
            //con el puzzle modificado
            auxValorCosto = 0; //guardar los costos del metodo costos
            auxMovimiento = 0;
            int[] posicionCero = posicionCero(puzzle); // Obtener la posición del cero
            organizar(posicionCero, puzzle); // Llamar al método organizar y pasarle la posición del cero
        }
        return null;
    }
    //O(1)
    //guardar el ultimo movimiento mas eficiente de ese cero
    static void ultimoMovimientoEficiente(int[] movimiento) {
        if (auxMovimientoEficiente[0] == 0) {//primera ves de ingreso
            auxMovimientoEficiente = movimiento;
        } else {//movimiento con mejor costo
            mejorMovimiento = movimiento;
        }
    }//Este metodo termina cuando el ciclo while de organizar termina guardando el mejor movimiento de ese cero

    //Metodos para mover el cero
    //O(n^2)
    static int[] moverArriba(int posX, int posY, int[][] puzzle) {//Mover el cero hacia arriba
        int[][] copiaPuzzle = new int[puzzle.length][];//copia puzzle
        for (int i = 0; i < puzzle.length; i++) {//Crea matriz es O(i^2) => O(n^2)
            copiaPuzzle[i] = Arrays.copyOf(puzzle[i], puzzle[i].length);
        }
        copiaPuzzle[posX][posY] = copiaPuzzle[posX - 1][posY];
        copiaPuzzle[posX - 1][posY] = 0;
        //se envia a la heuristica
        int costoArriba = calcularCostoHeuristico(copiaPuzzle);
        int[] datosArriba = new int[2];//guardar datos del movimiento
        datosArriba[0] = costoArriba; // Almacenar el costo del movimiento
        datosArriba[1] = 1; //movimiento realizado U 
        costos(datosArriba);//envio al metodo costos
        return null;
    }
    //O(n^2)
    static int[] moverAbajo(int posX, int posY, int[][] puzzle) {//Mover el cero hacia abajo
        int[][] copiaPuzzle = new int[puzzle.length][];//copia puzzle
        for (int i = 0; i < puzzle.length; i++) {
            copiaPuzzle[i] = Arrays.copyOf(puzzle[i], puzzle[i].length);
        }
        //movimiento realizado en copiaPuzzle
        copiaPuzzle[posX][posY] = copiaPuzzle[posX + 1][posY];
        copiaPuzzle[posX + 1][posY] = 0;
        //se envia a la heuristica
        int costoAbajo = calcularCostoHeuristico(copiaPuzzle);
        int[] datosAbajo = new int[2];
        datosAbajo[0] = costoAbajo; // Almacenar el costo del movimiento
        datosAbajo[1] = 0; //D abajo movmiento
        costos(datosAbajo);//envio al metodo costos
        return null;
    }
    //O(n^2)
    static int[] moverIzquierda(int posX, int posY, int[][] puzzle) {//Mover el cero hacia la izquierda
        int[][] copiaPuzzle = new int[puzzle.length][];//copia puzzle
        for (int i = 0; i < puzzle.length; i++) {
            copiaPuzzle[i] = Arrays.copyOf(puzzle[i], puzzle[i].length);
        }
        //movimiento realizado en copiaPuzzle
        copiaPuzzle[posX][posY] = copiaPuzzle[posX][posY - 1];
        copiaPuzzle[posX][posY - 1] = 0;
        //se envia a la heuristica
        int costoIzquierda = calcularCostoHeuristico(copiaPuzzle);
        int[] datosIzquierda = new int[2];
        datosIzquierda[0] = costoIzquierda; // Almacenar el costo del movimiento
        datosIzquierda[1] = 10; //L izquierda movmiento
        costos(datosIzquierda);//envio al metodo costos
        return null;
    }
    //O(n^2)
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
        int[] datosDerecha = new int[2];
        datosDerecha[0] = costoDerecha; // Almacenar el costo del movimiento
        datosDerecha[1] = 11; //R derecha movmiento
        costos(datosDerecha);//envio al metodo costos
        return null;
    }

    //costos para el movimiento  O(1)
    static int[] costos(int[] datosCostos) {
        int costos = datosCostos[0];//valores de los costos de la heuristica
        int movimiento = datosCostos[1];//movimiento realizado
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
        //se usa para almacenar los mejores movimientos de la evaluacion del cero
        ultimoMovimientoEficiente(movimientosEficientes);
        return null;
    }
    //O(n^2)
    public static void main(String[] args) {
        Scanner keyboard = new Scanner(System.in);
        int n = 0; //conjuntos de rompecabezas a armar
        int casos = 0;//numeros de puzzle
        n = keyboard.nextInt();
        while (casos < n) {
            int[][] initialPuzzle = new int[4][4];
            //cargo la matriz con los datos O(1)
            for (int x = 0; x < initialPuzzle.length; x++) {
                for (int y = 0; y < initialPuzzle[x].length; y++) {
                    initialPuzzle[x][y] = keyboard.nextInt();
                }
            }
            //verifico si el rompecabezas inicial tiene solucion
            if (tieneSolucion(initialPuzzle)) {//lo envio a metodo
                int[] posicionCero = posicionCero(initialPuzzle); // guardo la posicion cero de lo realizado del metodo con el puzzle inicial
                organizar(posicionCero, initialPuzzle); // Llamar al método organizar y pasarle la posición del cero
            } else {
                System.out.println("This puzzle is not solvable.");
            }
            casos++;
        }
    }
}
