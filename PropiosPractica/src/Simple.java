import java.util.Scanner;
//complejidad O (n)
public class Simple {
    public static void main(String[] args) {
       Scanner teclado = new Scanner(System.in);
       String numeros = teclado.nextLine();
       char[] caracteres;
       caracteres = numeros.toCharArray();
        for (int i = 0; i< caracteres.length; i++) {
           System.out.print(caracteres[i]+ " "); 
        }
    }  
}
//entrada
// 23
//salida 
// 2 3