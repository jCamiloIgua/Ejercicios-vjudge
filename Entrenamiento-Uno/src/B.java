
import java.util.Scanner;
public class B {
    
    public static void main(String[] args) {
        Scanner teclado = new Scanner(System.in);
        int n; //participantes
        int k; //finalista !Posicion
        int contador = 0; //contar avanzados
        
        //Los dos enteros deben estar separados por un espacio
        //capturar n y k
        String captura = teclado.nextLine(); 
        // Dividir arreglo  dos números separados
        // se crea un arreglo llamado numeros de tipo string al cual se pasa la variable captura
        String[] numeros = captura.split(" ");// .split permite decir que separe los datos en otros arreglos si hay un espacio  
        n = Integer.parseInt(numeros[0]); // Convertir string a entero variable 
        k = Integer.parseInt(numeros[1]); // Convertir string a entero variable 
        
        //Los participantes n deben ser mayores o iguales al finalista k
        //k mayor igual a 1 y menor o igual a n y n menor o igual a 50 y mayor a k
        if((n >= k) && (n <= 50 && k >=1)){//numeros positivos
            //Inicio captura puntuacion (Segunda linea)
            //Entrada para las calificaciones
            
            //se crea una variable de tipo string para capturar los numeros
            String capcalificaciones = teclado.nextLine(); 
            //Arreglo String para almacenar y separar la cadena en sub arreglos si hay un espacio y cargarlo en el arreglo
            String[] calificaciones = capcalificaciones.split(" ");
            
            // Arreglo para almacenar los números enteros
           int[] a = new int[calificaciones.length];//a variable para calificaciones
            
            // Convertir cada elemento del arreglo de cadena a entero 
            for (int i = 0; i < calificaciones.length; i++) { 
               a[i] = Integer.parseInt(calificaciones[i]);
            }
            ///Fin de captura de puntuacion
          
            //Se recorre el arreglo de a calificaciones
            for (int i = 0; i < a.length; i++) {
                //calcular participantes aprobados
                // si los numeros del vector son mayores o iguales al valor de la pocision del
                //vector k-esimo que esta en la variable k suma con el contador
                //n >= k
                if(a[i] >= a[k-1] && a[i] > 0){ // comparar un indice con la comparacion de la pocision de k en el vector a
                //a[k-1] se resta una pocision por la primera posicion que es cero 0 
                    contador++; 
               }
            }
            //participantes avanzados
           System.out.println(contador);
        }
    }
}
