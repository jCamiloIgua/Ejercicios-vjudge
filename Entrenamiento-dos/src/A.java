import java.util.Scanner;
//complejidad O (n)
public class A {
    public static void main(String[] args) {
        Scanner keyboard = new Scanner(System.in);
        int n = keyboard.nextInt();
        int valorRaiz = 0; //valor raiz del tiempo
        int tiempoMo = 0; //tiempo movimiento si no es perfecto
        while (n != 0) {
            valorRaiz = (int) Math.sqrt(n);//raiz
            if (valorRaiz * valorRaiz == n) {//perfecto
                if (valorRaiz % 2 == 1){//impar vertical
                    System.out.println("1 " + valorRaiz);
                } else {
                    System.out.println(valorRaiz + " 1");//horizontal
                }
            } else {// no es perfecto
                 tiempoMo = n - valorRaiz * valorRaiz;
                if (valorRaiz % 2 == 1) {//impar
                    if (tiempoMo <= valorRaiz + 1) {
                        System.out.println((n - valorRaiz * valorRaiz) + " " + (valorRaiz + 1));
                    } else {
                        System.out.println(" " + (valorRaiz + 1) + " " + (valorRaiz + 1 - ((n - valorRaiz * valorRaiz) % (valorRaiz + 1))));
                    }
                } else {//par
                    if (tiempoMo <= valorRaiz + 1) {
                        System.out.println((valorRaiz + 1) + " " + (n - valorRaiz * valorRaiz));
                    } else {
                        System.out.println((valorRaiz + 1 - ((n - valorRaiz * valorRaiz) % (valorRaiz + 1))) + " " + (valorRaiz + 1));
                    }
                }
            }
            n = keyboard.nextInt();
        }
    }
}
