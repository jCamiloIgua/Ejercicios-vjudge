
import java.util.Scanner;

public class Numeros {

    //Complejidad seria O(j * log 2 (auxi))
    public static void main(String[] args) {
        Scanner teclado = new Scanner(System.in);

        int i;
        int j;
        int giros = 0;
        int total = 0;
        String captura = teclado.nextLine();
        String[] numeros = captura.split(" ");

        i = Integer.parseInt(numeros[0]);
        j = Integer.parseInt(numeros[1]); // O(1)

        //ciclo
        while (i <= j) { //O(j)   
            int auxi = i;
            giros = 1;
            boolean bandera = true;  // O (1)
            while (bandera) {
                if (auxi == 1) {//termina
                    bandera = false; //O(1)
                } else {
                    if (auxi % 2 == 0) {//par //o(1)
                        auxi /= 2; // O(1)  log 2 (auxi)
                    } else {//impar
                        auxi = auxi * 3 + 1;
                    }
                    //giros
                    giros++;
                    if (i == 1) {
                        total = giros;
                    }
                    if (giros > total) {
                        total = giros;
                    }
                }
            }
            i++;
        }
        i = i - j;//valores iniciales
        System.out.print(i+" "+j+" "+total+" ");
    }
}
