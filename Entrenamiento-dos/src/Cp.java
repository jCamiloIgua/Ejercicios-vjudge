import java.util.Scanner;
public class Cp {
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
            System.out.println("ca " + casos);
            System.out.println("t " + t);
            System.out.println("entro");
            for (int x = 0; x < matriz.length && (terminar == false); x++) {//columnas
                bandera = false;//la reinicio
                for (int y = giro; (y <= matriz[x].length) && (bandera == false && terminar == false); y--) {
                    numeros++;
                    System.out.println("numeros de inicio " + numeros);//11
                    if (x >= 0 && x < matriz.length && y >= 0 && y < matriz[0].length) {
                        // Aquí colocas el código que deseas ejecutar solamente si x e y están dentro del rango de la matriz
                        System.out.println("error final de matriz " + x + " " + y);
                        matriz[x][y] = numeros; //11
                        //error matriz
                        System.out.println("numeros " + numeros);
                        //solo para el primer uno
                        if (suma == 0) {
                            suma = matriz[x][y]; // 1
                            System.out.println("antes del else " + matriz[x][y]);
                            System.out.println("else " + suma);
                            System.out.println("x " + x + "y " + y);//0.3 //0 . 2
                        } else {
                            System.out.println("suma " + suma); // 4
                            System.out.println("x " + x + "y " + y); // 0,1
                            System.out.println("actual " + matriz[x][y] + "otra " + matriz[x][y + 1]); // 4 y 3
                            suma = matriz[x][y] + matriz[x][y + 1];
                            System.out.println("sumalita " + suma);
                            cuadrado = Math.sqrt(suma);
                            if (cuadrado != Math.floor(cuadrado)) { //si no es cuadrado
                                //error de cambio
                                if (matriz[xcambio][giro] == 0) {//1.3
                                    matriz[x + 1][giro] = matriz[x][y];
                                } else {
                                    xcambio++;
                                    System.out.println("cambio " + xcambio);
                                    if (xcambio <= giro) {
                                        System.out.println("cambio1 " + xcambio);
                                        matriz[xcambio][giro] = matriz[x][y];
                                    } else {
                                        System.out.println("se sobre paso x");
                                        System.out.println("valor de giro " + giro);
                                        xcambio = 1;
                                        giro = giro - 1;
                                        matriz[xcambio][giro] = matriz[x][y];
                                    }
                                }
                                y = y + 1;
                            }
                        }
                        /*
                        for (int c = 0; c < matriz.length; c++) {
                            for (int f = 0; f < matriz[c].length; f++) {
                                System.out.println("[" + c + "," + f + "] = " + matriz[c][f]);

                            }
                        }*/
                    } else {
                        System.out.println("se paso el ultmio criterio");
                        System.out.println("ultimo valor de giro " + giro);
                        System.out.println("ultimo valor de cambiox " + xcambio);
                        //giro en y que da 1
                        xcambio = xcambio + 1;
                        matriz[xcambio][giro] = numeros;
                        System.out.println("final: " + matriz[xcambio][giro]);
                        terminar = true;
                    }

                }
            }
            // Iterar sobre la matriz
            for (int i = 0; i < matriz.length; i++) {
                for (int j = 0; j < matriz[i].length; j++) {
                    // Verificar si el elemento actual es diferente de cero
                    if (matriz[i][j] != 0) {
                        // Incrementar el contador si el valor es diferente de cero
                        contador++;
                    }
                }
            }
            System.out.println(contador);
            casos++;
        }
    }
}
