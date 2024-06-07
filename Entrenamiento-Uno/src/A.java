
import java.util.Scanner;
public class A {
    public static void main(String[] args) {
        Scanner registro = new Scanner(System.in);
        int w;
        int par = 2;
        w = registro.nextInt();
        if(w == 2){ // se valida que no se pueda si el peso es 2
            System.out.println("NO");
        }else{
             w = w % par;
             if (w == 0) {
                 System.out.println("YES");
             }else {
                 System.out.println("NO");
             }   
        }
    }   
}

