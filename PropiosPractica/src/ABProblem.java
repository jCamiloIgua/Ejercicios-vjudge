import java.util.Scanner;
//Complejidad O (1)
public class ABProblem {
    public static void main(String[] args) {
        Scanner teclado = new Scanner(System.in);
        String numeros[] = teclado.nextLine().split(" ");
        int a = Integer.parseInt(numeros[0]);
        int b = Integer.parseInt(numeros[1]);
        a+=b;
        System.out.println(a);
    } 
}
