
import java.util.Scanner;
public class ThreeProblems {
    public static void main(String[] args) {
        Scanner keyboard = new Scanner(System.in);
        int a = keyboard.nextInt();
        int b = keyboard.nextInt();
        int c = 0;
        int aux = 0;
        int aux2 = 0;
        if (a <= 7 && b <= 7) {
            if (a <= 4 && b <= 4 && a != b) {
                c = a + b;
            } else {
                if (a == b) {
                    c = a;
                } else {
                    if (a > 4 && b <= 4) {
                        aux = a;
                        a = aux - 4;
                        a = aux - 1;
                        aux2 = b;
                        b = 4 - b;
                        b = aux2 - b;
                        c = (a + b) + 1;
                    }else{
                        aux = b;
                        b = aux - 4;
                        b = aux - a;
                        aux2 = a;
                        a = 4 - a;
                        a = aux2 - 1;
                        c = (a + b) + 1;
                    }
                }
            }
            System.out.println(c);
        }
    }
}

// 1 2  --> 3 ya 

// 5 3 --> 7 ya 

// 0 0 --> 0 ya 

// 7 7 --> 7  ya

// 0 1 --> 1 ya 

// 2 2 --> 2 ya 

// 4 0 --> 4 ya

// 1 5 -- > 5

// 6 2 --> 6

// 3 4 --> 7  ya 