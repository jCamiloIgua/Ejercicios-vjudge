import java.util.Scanner;
//Complejidad O(t)
public class D {
    public static void main(String[] args) {
       Scanner teclado = new Scanner(System.in);
       int t = 0;
       int a;
       int b;
       int c;
       String res="";
       String captura;
       String numeros [];
       t=teclado.nextInt();
       teclado.nextLine();
        for (int i = 0; i <t; i++) {
            captura = teclado.nextLine();
            numeros=captura.split(" ");
            a = Integer.parseInt(numeros[0]);
            b = Integer.parseInt(numeros[1]);
            c = Integer.parseInt(numeros[2]);
            if((a >=1 && a<=9)&&(b>=1 && b<=9)&&(c>=-8 && c<=18)){
                if(a+b==c){
                  res="+";
                }else{
                    if(a-b==c){
                        res="-";
                    }
                }
                System.out.println(res);
                a=0;
                b=0;
                c=0;
            }
        }
    }
}
