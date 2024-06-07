import java.util.Scanner;
//complejidad O(t)
public class C {
    public static void main(String[] args) {
        Scanner keyboard = new Scanner(System.in);
        int t = keyboard.nextInt();//numero casos
        int casos = 0;
        int n = 0;//matriz
        int esferas = 0;
        while (casos < t) {
            n = keyboard.nextInt();
            esferas = ((n * n) / 2) + n;
            if (n % 2 == 0) {//par clavos
                esferas = esferas - 1;
            }
            System.out.println(esferas);
            esferas = 0;
            casos++;
        }
    }
}
