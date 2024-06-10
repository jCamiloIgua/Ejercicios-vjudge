package party;

import java.util.Scanner;

/**
 *
 * @author camilo
 */
//N son las personas
// M son las parejas de dadas
// solo se pueden hacer dos cakes
// solo se puede comer una pareja completa
// si no se invita a una se suma un punto
//si lo ohay un  miembro pues no hay puntos de infelicidad ya que 
// con uno solo se puede invitar a todos
public class Party {

    public static void main(String[] args) {
        Scanner keyboard = new Scanner(System.in);
        int values[];//value unhappiness
        int cases;
        int n;//Members
        int m;//Pairs of friends
        int parejas[][];
        int valorMinimo;
        cases = keyboard.nextInt();
        for (int i = 0; i < cases; i++) {
            keyboard.nextLine();
            String saltar = keyboard.nextLine();
            String[] capture = saltar.split(" ");
            //casos iniciales
            n = Integer.parseInt(capture[0]);
            m = Integer.parseInt(capture[1]);
            values = new int[n];//tamaño de valores del total de miembros
            for (int j = 0; j < values.length; j++) {
                values[j] = keyboard.nextInt();
            }
          
            if (m != 0) {//hay parejas
                //matriz de parejas posibles es de m*2
                parejas = new int[m][2];
                for (int j = 0; j < parejas.length; j++) {
                    parejas[j][0] = keyboard.nextInt();
                    parejas[j][1] = keyboard.nextInt();;
                }
                //si el numero de pares es par infelicidad 0 todos se puden infivat
                if (m % 2 == 0) {
                    valorMinimo = 0;
                } else {
                    //Buscar mienbro con la menor infelicidad
                    //se iteramos y guardamos el valor menor evitando el valor menor de 1
                    int minimaInfelicidadSinMien = Integer.MAX_VALUE;
                    for (int j = 0; j < values.length && values[j] != 1; j++) {
                        minimaInfelicidadSinMien = Math.min(minimaInfelicidadSinMien, values[j]);
                    }
                    //Excluyendo una pareja
                    //pareja con la infelicidad baja
                    //sumamos la infelicidad de los dos miembros de la pareja
                    int minimaInfelicidadSinPareja = Integer.MAX_VALUE;
                    for (int[] pareja : parejas) {
                        int u = pareja[0] - 1; // Convertir a índice basado en 0
                        int v = pareja[1] - 1; // Convertir a índice basado en 0
                        minimaInfelicidadSinPareja = Math.min(minimaInfelicidadSinPareja, values[u] + values[v]);
                    }
                    if(minimaInfelicidadSinMien < minimaInfelicidadSinPareja ){
                        System.out.println(minimaInfelicidadSinMien);
                    }else{
                        System.out.println(minimaInfelicidadSinPareja);
                    }
                }
            }else{
                parejas = new int[0][0];
                valorMinimo = 0;
                System.out.println(valorMinimo);
            }
        }//otro caso        
    }
}
