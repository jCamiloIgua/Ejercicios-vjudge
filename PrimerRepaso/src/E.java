import java.util.Scanner;
// complejidad O(t * n) 
public class E {
    public static void main(String[] args) {
        Scanner teclado = new Scanner(System.in);
        int t;//casos de prueba
        int n;//cantidad dulces 
        String d;//tamaño dulces captura con espacios
        String a[]; //captura con espacios
        int peso[];
        int suma = 0;
        int unGramo = 0;
        int dosGramos = 0;
        t = teclado.nextInt();
        teclado.nextLine();
        for (int i = 0; i < t; i++) { // O(t)
            n = teclado.nextInt();//dulces
            teclado.nextLine();
            d = teclado.nextLine();//pesos ingresados
            a = d.split(" ");// pesos con espacios
            peso = new int[n];
            //casteo de pesos
            for (int j = 0; j < a.length; j++) { // O(a) 
                peso[j] = Integer.parseInt(a[j]);
                if (peso[j] == 2) {
                    dosGramos++;
                } else {
                    unGramo++;
                }
            }
            suma = unGramo + dosGramos*2;
            if((suma%2 == 0 && unGramo>0) || (dosGramos%2 == 0 && unGramo==0)){
                System.out.println("YES");
            }else{
                System.out.println("NO");
            }
            dosGramos = 0;
            unGramo = 0;
            suma = 0;
        }
    }
}
