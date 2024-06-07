
import java.util.Scanner;

public class cpro {

    public static void main(String[] args) {
        Scanner keyboard = new Scanner(System.in);
        int t = 0; // casos de prueba
        t = keyboard.nextInt();
        int casos = 1;
        while (casos <= t) {//0(t) -> O(n)
            int n = 0; // tamaño matriz o clavos
            n = keyboard.nextInt();
            int matriz[][] = new int[n][n];//matriz de juego
            int giro = n - 1;// iniciar desde abajo de la matriz
            boolean bandera = false;//cambio de clavo
            boolean terminar = false;
            int numeros = 0;//numeros de juego
            int suma = 0;
            double cuadrado = 0; //verificar si el numero es cuadrado
            int xcambio = 1; //cambio de clavo en x
            int contador = 0;
            for (int x = 0; x < matriz.length && (terminar == false); x++) {//columnas
                bandera = false;//la reinicio
                for (int y = giro; (y <= matriz[x].length) && (bandera == false && terminar == false); y--) {
                    numeros++;
                    if (x >= 0 && x < matriz.length && y >= 0 && y < matriz[0].length) {
                        //  x e y están dentro del rango de la matriz
                        matriz[x][y] = numeros;
                        //solo para el primer uno
                        if (suma == 0) {
                            suma = matriz[x][y];
                        } else {
                            suma = matriz[x][y] + matriz[x][y + 1];
                            cuadrado = Math.sqrt(suma);
                            
                            if (cuadrado != Math.floor(cuadrado)) { //si no es cuadrado
                                if (matriz[xcambio][giro] == 0) {//1.3
                                    matriz[x + 1][giro] = matriz[x][y];
                                } else {
                                    xcambio++;
                                    if (xcambio <= giro) {
                                        matriz[xcambio][giro] = matriz[x][y];
                                    } else {
                                        xcambio = 1;
                                        giro = giro - 1;
                                        matriz[xcambio][giro] = matriz[x][y];
                                    }
                                }
                                y = y + 1;
                            }
                        }
                    } else {
                        xcambio = xcambio + 1;
                        matriz[xcambio][giro] = numeros;
                        terminar = true;
                    }

                }
            }
            // Iterar sobre la matriz
            for (int i = 0; i < matriz.length; i++) {//O(1)
                for (int j = 0; j < matriz[i].length; j++) {//O(1)
                    // Verificar si el elemento actual es diferente de cero
                    if (matriz[i][j] != 0) {
                        contador++;
                    }
                }
            }
            System.out.println(contador);
            casos++;
        }
    }
}
