import java.util.HashMap;
import java.util.Scanner;
//Complejidad O (t * n) 
public class G {
    public static void main(String[] args) {
        Scanner teclado = new Scanner(System.in);
        int t;
        int n;
        String numeros[];
        String repetido = "";
        String captura;
        boolean bandera = false;
        t = teclado.nextInt();
        for (int i = 0; i < t; i++) {
            HashMap<String, Integer> frecuenciaNumero = new HashMap<>();
            n = teclado.nextInt();
            teclado.nextLine();
            numeros = new String[n];
            captura = teclado.nextLine();
            numeros = captura.split(" ");
            if (n == 1) {
                System.out.println("-1");
            } else {
                bandera = false;
                for (int j = 0; j < numeros.length; j++) {
                    repetido = numeros[j];
                    //actualizar frecuencia
                    frecuenciaNumero.put(repetido, frecuenciaNumero.getOrDefault(repetido, 0) + 1);
                    if (frecuenciaNumero.get(repetido) == 3) {
                        System.out.println(repetido);
                        bandera = true;
                        break;
                    }
                }//no encontro
                if (!bandera) {
                    System.out.println("-1");
                }
            }
        }
    }
}
