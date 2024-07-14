
import java.util.Scanner;


/**
 *
 * @author Jonatan Igua
 */
public class MissingNumber {

    public static void main(String[] args) {
        Scanner keyboard = new Scanner(System.in);
        int n = keyboard.nextInt();
        int content[];
        int cont=0;
        int perdido = 0;
        content = new int[n-1];//arreglo con un tamaño menor (4)
        for (int i = 0; i < content.length; i++) {
            int ingreso = keyboard.nextInt();
            content[i] = ingreso;
        }
       
        for (int i = 0; i < content.length; i++) {
            
            if(content[i]!= n){//diferente al numero del tamaño
                cont += content[i];
            }
            System.out.println(content[i]);
        }
        perdido = (n*2) - cont;
        System.out.println("dada " + perdido);
    }
}


//6

// 2 3 1 6 4