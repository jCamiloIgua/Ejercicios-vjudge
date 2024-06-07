import java.util.Scanner;
//Complejidad O (t) * O (n^2)
public class G1 {
    public static void main(String[] args) {
        Scanner teclado = new Scanner(System.in);
        int t;
        int n;
        String numeros[];
        String repetido = " ";
        String numeroMayor = " ";
        String captura;
        int contador = 0;
        boolean bandera = false;
        t = teclado.nextInt();
        for (int i = 0; i < t; i++) {
            n = teclado.nextInt();
            teclado.nextLine();
            numeros = new String[n];//tamaño arreglo
            captura = teclado.nextLine();//cargar arreglo
            numeros = captura.split(" ");
            if (n == 1) {//solo un elemento
                System.out.println("-1");
            } else {
                repetido = " ";
                numeroMayor = " ";
                bandera = false;
                for (int j = 0; j < numeros.length; j++) {
                    for (int k = j + 1; k < numeros.length; k++) {
                        if (numeros[j].equals(numeros[k])) {//iguales
                            contador++;//1
                            if (contador == 3) {
                                repetido = numeros[j];
                                if (Integer.parseInt(repetido) == Integer.parseInt(numeros[k]) && bandera == false) {
                                    numeroMayor = repetido;
                                    bandera = true;//solo entra la primera ves guardo el numero igual
                                }
                                if (Integer.parseInt(numeroMayor) < Integer.parseInt(repetido) || contador == 3) {
                                    numeroMayor = repetido;//el numero repetido mayor o si con contador son 3
                                }
                            }
                        }
                    }
                }
                if (contador < 3 || bandera == false) { 
                    System.out.println("-1");
                } else { // hay un número repetido al menos 3 veces
                    System.out.println(numeroMayor);
                }
                contador = 0;
            }
        }
    }
}
