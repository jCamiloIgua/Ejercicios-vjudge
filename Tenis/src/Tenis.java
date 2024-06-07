
import java.util.Scanner;

//Dificultad =  O (Log 2 (p))
public class Tenis {

    public static void main(String[] args) {
        Scanner teclado = new Scanner(System.in);
        int p;
        boolean bandera = true;
        int mod;
        int partidos = 0;
        int impar;
        int contadorImpar = 0;
        p = teclado.nextInt();
        if (p == 1 || p == 0) { //solo un jugador o cero jugadores
            System.out.println(partidos);//cero partidos
        }else{
                while (bandera == true) {
                mod = p % 2;
                if (mod == 0) { //par
                    p = p / 2;
                    partidos = partidos + p;
                    if (p == 1) { //solo un jugador
                        partidos = partidos + contadorImpar;
                        bandera = false;
                    }
                } else {// impar
                    impar = p;  
                    p = p - 1;  
                    impar = impar - p;  
                    contadorImpar = contadorImpar + impar; 
                }
            }
                System.out.println(partidos);     
        }
    }
}
