import java.util.Scanner;
//complejidad O (n)
public class B {
    public static void main(String[] args) {
        Scanner keyboard = new Scanner(System.in);
        while (keyboard.hasNext()) {
            int i = keyboard.nextInt();
            int j = keyboard.nextInt();
            int ciclomaximo = 0;
            for (int numero = Math.min(i, j); numero <= Math.max(i, j); numero++) {
                int longitud = calcularciclo(numero);
                if (longitud > ciclomaximo) {
                    ciclomaximo = longitud;
                }
            }
            System.out.println(i + " " + j + " " + ciclomaximo);
        }
    }
    private static int calcularciclo(int n) {
        int giro = 0;
        while (n != 1) { //O(n)
            if (n % 2 == 0) {
                n /= 2;
            } else {
                n = 3 * n + 1;
            }
            giro++;
        }
        return giro + 1; 
    }
}
