
import java.util.Scanner;


public class Factorial {

    public static void main(String[] args) {
        Scanner keyboard = new Scanner(System.in);
        double numero = 0;
        double factorial = 1;
        System.out.println("Ingrese numero ");
        numero = keyboard.nextDouble();
        
        
        for (int i = 1; i <= numero; i++) {
            factorial = i * factorial;
            System.out.println(i + "! = " + factorial);
        }
    }
}
