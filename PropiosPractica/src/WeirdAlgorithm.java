import java.util.ArrayList;
import java.util.Scanner;
/**
 *
 * @author Jonatan Igua
 */
public class WeirdAlgorithm{
    public static void main(String[] args) {
        //Algorithm input positive integer n
        //Si es impar lo multiplica por 3 y le suma 1 but si no es impar
        //lo divide en 2 hasta llegar a 1
        Scanner keyboard = new Scanner(System.in);
        ArrayList<Long> Acumular= new ArrayList<>();
        long n = keyboard.nextLong();
        
         Acumular.add(n);//valor inicial de n 3
         while(n != 1){
             if(n%2 == 1){//impar
                 n*=3;
                 n++;
             }else{//par
                 n/=2;
             }
             Acumular.add(n);
         }
         for (int i = 0; i < Acumular.size(); i++) {
             System.out.print(Acumular.get(i) + " ");
        }
    }
}