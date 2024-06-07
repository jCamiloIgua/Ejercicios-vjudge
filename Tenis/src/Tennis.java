
import java.util.Scanner;


public class Tennis {

    
    public static void main(String[] args) {
     Scanner teclado = new Scanner(System.in);
        int p;
        int contador = 0;
        int mod = 0;
        int mitad = 0;

        int partidos = 0;
        //int ganadorImpar = 0;
        int impar = 0;

        p = teclado.nextInt();//capturo jugadores
        mod = p % 2; // par si es cero el numero de jugadores
        while (contador < p) { // 0
            if (mod == 0) { // par
                mitad = p / 2;  // 10 / 2 -->
                partidos = partidos + mitad; // 5   
                p = p - mitad; //10 - 5  --> 5
            } else { //impar
                impar = p - 1; // 5 - 1 --> 4
                p = impar;  // 4
            }
            contador++;
        }
        System.out.println(partidos);
    }
    
}
