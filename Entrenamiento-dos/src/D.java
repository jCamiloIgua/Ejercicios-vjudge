
import java.util.Scanner;

public class D {
//complejidad O(t)

    public static void main(String[] args) {
        Scanner keyboard = new Scanner(System.in);
        int t = 0;
        int n = 0;
        int m = 0;
        int casos = 0;
        int movi = 1;
        t = keyboard.nextInt();
        keyboard.nextLine();
        while (casos < t) {
            String captura = keyboard.nextLine();
            String[] cuadricula = captura.split(" ");
            n = Integer.parseInt(cuadricula[0]);
            m = Integer.parseInt(cuadricula[1]);
            if (n == 1 && m == 1) {
                movi = 0;
            } else {
                if ((n == 1 && m != 2) || (n != 2 && m == 1)) {
                    movi = -1;
                } else {
                    if (n % 2 == 0 && m % 2 == 0) {//ambos pares
                        if (n > m) {
                            movi = (n - 1) * 2;
                        } else {
                            movi = (m - 1) * 2;
                        }

                    } else if (n % 2 == 1 && m % 2 == 1) {//ambos impares
                        if (n == m) {//impares iguales
                            movi = ((n - 1) * 2);
                        } else {
                            if (n > m) {
                                movi = (n - 1) * 2;
                            } else {
                                movi = (m - 1) * 2;
                            }
                        }
                    } else {
                        if (n > m) {
                            movi = (n - 1) * 2 - 1;
                        } else {
                            movi = (m - 1) * 2 - 1;
                        }
                    }
                }
            }
            System.out.println(movi);
            movi = 0;
            casos++;
        }
    }
}
