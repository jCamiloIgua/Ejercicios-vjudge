
import java.util.Scanner;
//Complejidad  O(t)
public class B {
    public static void main(String[] args) {
        Scanner teclado = new Scanner(System.in);
        int t = 0;
        int a;
        int b;
        int c;
        int sum = 0;
        t = teclado.nextInt();//ciclo
        teclado.nextLine();
        for (int i = 0; i < t; i++) {
            String captura = teclado.nextLine();
            String[] numeros = captura.split(" ");
            a = Integer.parseInt(numeros[0]);
            b = Integer.parseInt(numeros[1]);
            c = Integer.parseInt(numeros[2]);
            sum = a + b;
            if (sum == c) {
                System.out.println("YES");
            } else {
                sum = 0;
                sum = a + c;
                if (sum == b) {
                    System.out.println("YES");
                } else {
                    sum = 0;
                    sum = b + c;
                    if (sum == a) {
                        System.out.println("YES");
                    } else {
                        System.out.println("NO");
                    }
                }
            }
        }
    }
}
