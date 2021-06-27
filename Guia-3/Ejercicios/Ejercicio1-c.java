package ejercicio.pkg3;

import java.util.Scanner;

/**
 *
 * @author Lucho
 */
public class Ejercicio3 {

    public static void main(String[] args) {
        
        Scanner teclado = new Scanner(System.in);
        
        int numeros[] = new int[15];
        int totalVecesTres = 0;
        
        System.out.println("Por favor, cargue 15 numeros:");
        
        for (int i = 0; i < 15; i++) {
            
            System.out.print("Ingrese un numero: ");
            numeros[i] = teclado.nextInt();
            
            // Si el numero que guardé en esa posición es 3, aumento el contador.
            if (numeros[i] == 3) {
                totalVecesTres++;
            }
        }
        
        System.out.println("El numero 3 fue ingresado un total de " + totalVecesTres + " veces.");
    }
    
}
