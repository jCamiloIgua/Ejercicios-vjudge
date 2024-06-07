import java.util.Scanner;
//Complejidad O (n)
public class I {
    public static void main(String[] args) {
        Scanner teclado = new Scanner(System.in);
        int n = 0;
        int contador = 0;
        char[] caracteres;
        String nombreArchivo = " ";
        String nombreCadena=" ";
        char repetido;
        n = teclado.nextInt();
        teclado.nextLine();
        nombreArchivo = teclado.nextLine();
        if(nombreArchivo.length() == n){
             caracteres = nombreArchivo.toCharArray();//cadena a arreglo
             for (int i = 0; i < caracteres.length-2; i++) {
               if(caracteres[i] == 'x' && caracteres[i+1] == 'x' && caracteres[i+2] == 'x'){
                   contador++;
               }
            }
             System.out.println(contador);
        }
    }
}
