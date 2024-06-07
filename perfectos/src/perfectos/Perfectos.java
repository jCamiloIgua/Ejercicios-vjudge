
package perfectos;
import java.util.Scanner;

public class Perfectos {

    public static void main(String[] args) {
        Scanner teclado = new Scanner(System.in);
        int cantidadNumeros;
        int cociente = 0;
        int primerPerfecto = 6;
        int contador1 = 1; //de los divisores
        int suma = 0;
        int contadorPerfecto = 0;
        
        System.out.println("Cuantos numeros perfectos quiere: ");
        cantidadNumeros = teclado.nextInt();
     
                       //1 <= 2
            while(contadorPerfecto <= cantidadNumeros){ //busqueda de los perfectos
                //6 / 1  --> 6   // 6 /2 --> 3  // 6 / 3 // 7 / 1 --> 7 (7 /2) --(7 / 3)  // 7 / 4
             cociente = primerPerfecto/contador1; 
             //cocientes del numero
             System.out.println("Co: " + cociente); // 2 // 3 //2  // 1
             
              //sumo los divisores 
              
            suma = suma + contador1;  // 1  + // 2 --> 3 + 3 // 6 // 1 // 4  // va suma 6  // 10
            System.out.println("Suma " + suma);
            //6 <= 6 // 3<= 6 si  //  2 <= 6 si  //7 <= 7 // 3 <= 7 si // 2 <= 7  //1 <= 7 si
            if(cociente <= primerPerfecto){
                // 1 == 6 no // 3 == 6 No // 6 == 6 si // 1 == 7 no // 4 == 7 no  // 6 ==7 no  //10 == primerpercto no (error)
                if(suma <=primerPerfecto){
                System.out.println("perfecto: "  + primerPerfecto);
                primerPerfecto++; //7
                suma = 0; // 0
                contador1 = 0;
                contadorPerfecto++; // un solo perfecto
             }
                if(suma > primerPerfecto){
                primerPerfecto++; //7
                suma = 0; // 0
                contador1 = 0;
                }
            }
            contador1++; // 2  // 3  // 1 //2 //3  // 4
                
            } 
    }
    
}
