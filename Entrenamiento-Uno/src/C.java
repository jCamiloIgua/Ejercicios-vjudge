
import java.util.Scanner;

public class C {

    public static void main(String[] args) {
        Scanner teclado = new Scanner(System.in);
        int x = 0; //valor cero al inicio
        int n; // numero de operaciones
        String operacion = " " ;//guardar operacion
        n = teclado.nextInt(); //capturo el numero entero
        int contador = 1;//saber instrucciones a ingresar
        //X solo inicia en 0 y va incrementando o disminuyendo
        //n solo dice el numero de operaciones con x
        while(contador <= n){ 
            operacion = teclado.next();//ingresa la operacion
            //SUMA
            if("X++".equals(operacion)||("++X".equals(operacion))){
                x = x + 1; 
            }
            //RESTA
            if("--X".equals(operacion)|| ("X--".equals(operacion))){
                x = x - 1;  
            }   
            contador++; 
        }
        System.out.println(x);
    } 
}
