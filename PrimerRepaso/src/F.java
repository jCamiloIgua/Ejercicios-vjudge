import java.util.Scanner;
//Complejidad O(t)
public class F {
    public static void main(String[] args) {
        Scanner teclado = new Scanner(System.in);
        int t;//casos de prueba
        int operacion = 0;//suma
        String valores[];
        String numeros[];
        t = teclado.nextInt();
        teclado.nextLine();
        valores = new String[t];
        //datos
        for (int j = 0; j < valores.length; j++) {
            valores[j] = teclado.nextLine(); //cargo
            numeros = valores[j].split("\\+");//dividir 
            int a = Integer.parseInt(numeros[0]);
            int b = Integer.parseInt(numeros[1]);
            operacion = a + b;
            System.out.println(operacion);
        }
    }
}

