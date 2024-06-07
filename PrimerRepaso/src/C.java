import java.util.Scanner;
//Complejidad  O (rating) || O (t)
public class C {
    public static void main(String[] args) {
        Scanner teclado = new Scanner(System.in);
        int t = 0;
        int x = 0;
        int rating[];
        t = teclado.nextInt();
        rating = new int[t];  
        //llenado de calificaciones
        for (int i = 0; i < rating.length; i++) { 
            rating[i] = teclado.nextInt(); 
        }
        //divisiones
        for (int i = 0; i < rating.length; i++) { 
            if (rating[i] >= 1900) {
                x = 1;
                System.out.println("Division " + x);
            } else {
                if (rating[i] >= 1600 && rating[i] <= 1899) {
                    x = 2;
                    System.out.println("Division " + x);
                } else {
                    if (rating[i] >= 1400 && rating[i] <= 1599) {
                        x = 3;
                        System.out.println("Division " + x);
                    } else {
                        if (rating[i] <= 1399) {
                            x = 4;
                            System.out.println("Division " + x);
                        }
                    }
                }
            }
        }
    }
}
