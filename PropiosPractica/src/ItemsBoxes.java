import java.util.Scanner;
public class ItemsBoxes {
    public static void main(String[] args) {
        Scanner keyboard = new Scanner(System.in);
        String capture = keyboard.nextLine();
        String[] numbers = capture.split(" ");
        int a = Integer.parseInt(numbers[0]);
        int n = Integer.parseInt(numbers[1]);
        
        int cajas = (int) Math.pow(2, n);
        cajas /= 2;
        int x = cajas * cajas;
        x = x * a;
        int divisor = (int) Math.pow(2, (n + 2));
        int resto = x % divisor;
        
        if(n%2 == 1){
            resto = resto+1;
        }
        System.out.println(resto);
    }
}
