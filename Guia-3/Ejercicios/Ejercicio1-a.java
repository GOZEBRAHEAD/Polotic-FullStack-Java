package ejercicio.pkg1;

import java.util.Scanner;

/**
 *
 * @author Lucho
 */
public class Ejercicio1 {

    public static void main(String[] args) {
        
        Scanner teclado = new Scanner(System.in);
        
        int totalNombres = 7;
        
        String nombres[] = new String[totalNombres];
        
        for (int i = 0; i < totalNombres; i++) {
            
            System.out.print("Ingrese un nombre: ");
            nombres[i] = teclado.next();
        }
        
        System.out.println("================");
        System.out.println("Mostrando nombres: ");
        
        for (int i = 0; i < totalNombres; i++) {
            
            System.out.println(nombres[i]);
        }
    }
    
}
