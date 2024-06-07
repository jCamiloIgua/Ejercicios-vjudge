
import java.util.HashMap;
import java.util.Scanner;

/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Main.java to edit this template
 */
/**
 *
 * @author camil
 */
public class ayuda {

    public static void main(String[] args) {
      
  
        Scanner teclado = new Scanner(System.in);
        int t = teclado.nextInt(); // número de casos de prueba

        for (int i = 0; i < t; i++) {
            int n = teclado.nextInt(); // longitud del array
            HashMap<Integer, Integer> frecuencia = new HashMap<>(); // para mantener la frecuencia de cada número

            // Llenar la frecuencia de cada número
            for (int j = 0; j < n; j++) {
                int num = teclado.nextInt();
                frecuencia.put(num, frecuencia.getOrDefault(num, 0) + 1);
            }

            // Buscar un número que aparezca al menos tres veces
            boolean encontrado = false;
            for (int num : frecuencia.keySet()) {
                if (frecuencia.get(num) >= 3) {
                    System.out.println(num);
                    encontrado = true;
                    break;
                }
            }

            // Si no se encontró ningún número que aparezca al menos tres veces, imprimir -1
            if (!encontrado) {
                System.out.println("-1");
            }
        }
    }
}
