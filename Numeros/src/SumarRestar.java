
import java.util.Scanner;

public class SumarRestar {
//Complejidad seria O ()
    public static void main(String[] args) {
        Scanner teclado = new Scanner(System.in);
        int inverso = 0;
        int residuo = 0;
        int palindromo = 0;//suma de los numeros
        boolean bandera = true;
        int suma = 0;
        int numeroIngresado = 0;
        int cont = 0;

        int num = teclado.nextInt();
        numeroIngresado = num; //O (1)

        //numero inverso
        //num sea 1
        while (num != 0) {//195//19 //1  // O (log 10 (num))
            residuo = num % 10; //5 //9 //1
            num = num / 10;  //19 //1 //0
            inverso = (inverso * 10) + residuo; //5 //59 //591
        }
        if (inverso == numeroIngresado) { //O (1)
            System.out.println("El numero ingrwsado no puede ser palindromo");
        } else {
            suma = numeroIngresado + inverso; //suma O(1)
            System.out.println("Inverso1 " + inverso);
            System.out.println("suma1 " + suma);
            while (bandera) { //  O (log 10 (aux))
                //Palindromo
                //palindromo es igual de derecha a izquierda
                int aux = suma;
                int auxResiduo = 0;
                palindromo = 0;  // O(1)
                //while (aux != 0) {
                while (aux != 0) { //O (log 10 (aux))
                    auxResiduo = aux % 10; //5 //9 //1
                    aux = aux / 10;  //19 //1 //0
                    palindromo = (palindromo * 10) + auxResiduo; //5 //59 //591
                }
                //bin pero no
                if (suma == palindromo) { //O (1)
                    System.out.println("Es palindromo");
                    System.out.println(palindromo);
                    bandera = false;//importante
                } else {//sume el numero con su inverso
                    System.out.println("No es");
                    suma = suma + palindromo; // O(1)
                    System.out.println("suma= " + suma);
                    System.out.println("Palindromo: " + palindromo);
                }
                cont++; //O (1)
            }
            //salida  numero giros y palindromo
            System.out.println(cont + " " + palindromo); //O(1)
        }
    }
}

//primer ciclo es  O (logaritmo 10 (num))
//ciclo interno es O (logartimo 10 (aux cuadrado))
//Final O (logaritmo 10 (aux al cuadrado) * logaritmo 10 de (num))
