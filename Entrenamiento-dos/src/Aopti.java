import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;
//complejidad O(n)
public class Aopti {
    public static void main(String[] args) {
        Scanner keyboard = new Scanner(System.in);
        Map<Integer, int[]> valorCordenadas = new HashMap<>();
        int[][] matriz = 
        {{25, 24, 23, 22, 21, 5},{10, 11, 12, 13, 20, 4},{9, 8, 7, 14, 19, 3},{2, 3, 6, 15, 18, 2},{1, 4, 5, 16, 17, 1},{1, 2, 3, 4, 5}};
        // Llenar el diccionario con los valores y sus coordenadas
        for (int x = 0; x < matriz.length; x++) {//O(1) constante
            for (int y = 0; y < matriz[x].length; y++) {//O(1) constate
                int value = matriz[x][y];
                valorCordenadas.put(value, new int[]{x, y});//inicializar diccionario coordenadas
            }
        }
        int n = keyboard.nextInt();
        while (n != 0) {//0(n)
            if (valorCordenadas.containsKey(n)) {//si contiene la clave n
                int[] coord = valorCordenadas.get(n);//guardo arreglo
                int f = matriz[5][coord[1]];//x
                int c = matriz[coord[0]][5];//y
                System.out.println(f + " " + c);
            }
            n = keyboard.nextInt();
        }
    }
}
