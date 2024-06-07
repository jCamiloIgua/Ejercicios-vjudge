import java.util.Arrays;
import java.util.Scanner;
//Complejidad O(s)
public class J {
    public static void main(String[] args) {
        Scanner teclado = new Scanner(System.in);
        String s[];//exprecion ingresada
        String ordenados = "";
        s = teclado.nextLine().split("\\+");
        Arrays.sort(s);//ordena
        for (int i = 0; i < s.length; i++) {
            if (i != s.length - 1) {
                ordenados = ordenados + s[i] + "+";
            } else {
                ordenados = ordenados + s[i];
            }
        }
        System.out.println(ordenados);
    }
}
