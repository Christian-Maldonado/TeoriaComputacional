/*
 * CHRISTIAN MALDONADO ZÚÑIGA
 * MATRICULA: 140218 
 * LA ESPRESION REGULAR QUE SE ELIGIO PARA ELABORAR ESTE PROGRAMA FUE LA SIGUIENTE
 * 0(11*)*
 * COMO CARACTERISTICAS PRINCIPALES SE PUEDE MENCIONAR LA EXPRESION REGULAR SE PUEDE
 * SIMPLIFICAR A TAN SOLO 10* ENTONCES TENEMOS COMO RESULTADO QUE SE VA TOMAR PRIMERAMENTE
 * SOLO UN CAMINO, EMPEZANDO CON q0 MANDANDO UN 1 "UNO" QUE ENVIA A q1 EN ESTE CASO 
 * EL ESTADO DE ACEPTACION ES q1 YA QUE DEBIDO A LA EXPRESION REDUCIDAD SE PUEDE VER QUE
 * TERMINAR CON 0 "CERO" PUEDE ESTAR O NO ESTAR EN LA CADENA QUE SE LEE AL PRINCIPIO.
 * LA LOGICA QUE SE TOMO EN CUENTA PARA REALIZAR ESTE PROGRAMA SE EXPLICA PASO A PASO
 * EN CADA LINEA MARCADA, EL PROGRAMA SOLO ACEPTA CADENAS QUE EMPICEN CON CERO Y QUE 
 * TERMINEN CON 1, AUNQUE LA CADENA PUEDE CONTENER SOLO UN CERO Y ES ACEPTADA DEBIDO A
 * LA EXPRESION REGULAR QUE SE PRESENTA.
 */

package automata;
import java.util.*;
public class Automata {
    
    int cont;   //contador
    boolean aceptado=false;   //bandera
    static char [] car; //Arreglo de caracteres
    public static void main(String[] args) {
        Scanner cad = new Scanner(System.in);
        Automata aut = new Automata();  //Instancia de la clase
        System.out.println("\n--->E(r)=10*<---\n\n");
        System.out.println("---> El programa solo acepta cadenas que contengan \nal menos un UNO al inicio y que termine con el numero CERO\n");
        System.out.println("Ingresa la cadena a evaluar: ");
        String cadena = cad.nextLine();  //Cadena a evaluar
        System.out.println("\nCADENA: "+cadena);
        car = cadena.toCharArray(); //Para evaluar caracter por caracter
        aut.inicio();   //Llamamos al estado inicial
    }

    public void inicio() {
        cont = 0;      //Contador en cero
        q0();   //Evaluamos el estado q0
        if(aceptado==true){
            System.out.println("\n\n--->CADENA CORRECTA<---");
        }
        if(aceptado==false){
            System.out.println("\n\n--->CADENA INCORRECTA<---");
        }
    }
    
    public void q0() {  // 
        if(car[0]=='1'||car[0]=='0'){
            System.out.println("\n\nESTADOS QUE RECORRE LA CADENA:\n -> q0");
            if(cont<car.length){ // Si el contador es menor que el tamaño del caracter
                if(car[cont]=='1'){ //Si el caracter en el lugar del contador 
                    cont ++;    //Que sume uno al contador para evaluar el sig caracter
                    q1();      //Si es cero que continue con q1
                }
                else if (car[cont]=='0'){   //Si el caracter en el lugar del contado
                    cont ++;    //incrementamos el contador y qeu siga con el siguiente caracter
                    qError();
                }
            }
        }
        else{
            System.out.println("\n\nSOLO SE ACEPTAN CEROS Y UNOS !!!!");
        }
    }
    public void q1() {
        System.out.println(" -> q1");
        aceptado=true;
        if(cont<car.length){    // Si el contador es menor que el tamaño del caracter
            if(car[cont]=='0'){ //Si el caracter en el lugar del contador 
                cont ++;    //Que sume uno al contador para evaluar el sig caracter
                q1();   //Si es uno que continue con q1
            }
            else if (car[cont]=='1'){   //Si el caracter en el lugar del contado
                cont ++;     //incrementamos el contador y qeu siga con el siguiente caracter
                qError();
            }
        }
    }
       
    public void qError() {
        //System.out.println("\n\n---> CADENA INCORRECTA!! \nLa cadena ingresada termina con 0 ´Cero´ o empieza con el nuemro 1");
        aceptado=false;
        return;
    }
}
