import java.util.Scanner;
//Complejidad O (t*n)
public class H {
    public static void main(String[] args) {
        Scanner teclado = new Scanner(System.in);
        int a;
        int b;
        int n;
        int t;
        int contador = 0;
        String numeros[];
        numeros = new String[3];
        t = teclado.nextInt();
        teclado.nextLine();
        for (int i = 0; i < t; i++) {
            contador =0;
            String captura = teclado.nextLine();
            numeros = captura.split(" ");
            a = Integer.parseInt(numeros[0]);
            b = Integer.parseInt(numeros[1]);
            n = Integer.parseInt(numeros[2]);
            while (a<=n && b<=n) {
                if (a < b) {
                    a += b;
                } else {
                    b += a; 
                }
                contador++; 
            }
            System.out.println(contador);
        }
    }
}