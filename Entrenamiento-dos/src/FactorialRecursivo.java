
import java.util.Scanner;


public class FactorialRecursivo {

    
    public static void main(String[] args) {
        Scanner keyboard = new Scanner(System.in);
        int numeroIngresado = 0;
        System.out.println("Ingrese el numero: ");
        numeroIngresado = keyboard.nextInt();
        
        int factorial = calcularFactorial(numeroIngresado);
        System.out.println(factorial);
        
    }
    
    
    public static int calcularFactorial(int numero){
        int respuesta;
        if(numero == 0 || numero == 1){
            respuesta = 1;
        }else{
            respuesta = numero* calcularFactorial(numero-1);
        }
        return respuesta;
    }
    
}
