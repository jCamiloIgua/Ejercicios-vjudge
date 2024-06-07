
import java.util.Scanner;
// Complejidad  O(1)
public class A {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int rs = 0;
        String captura = in.nextLine();
        String[] numeros = captura.split(" ");
        int n = Integer.parseInt(numeros[0]);//personas
        int k = Integer.parseInt(numeros[1]);
        int l = Integer.parseInt(numeros[2]);//militros
        int c = Integer.parseInt(numeros[3]);//lima
        int d = Integer.parseInt(numeros[4]);//rodajas
        int p = Integer.parseInt(numeros[5]);//sal
        int nl = Integer.parseInt(numeros[6]);//para cada persona litros
        int np = Integer.parseInt(numeros[7]);//sal por rodaja de lima
        k *= l;//20
        k /= nl;//guardar //6
        c *= d;//limas total
        p /= np;//sal para tostadas
        if (k < c && k < p) {
            rs = k;
        } else {
            if (c < k && c < p) {
                rs = c;
            } else {
                rs = p;
            }
        }
        rs /= n;
        System.out.println(rs);
    }
}
