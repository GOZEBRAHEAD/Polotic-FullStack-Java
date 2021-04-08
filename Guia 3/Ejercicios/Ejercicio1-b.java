package ejercicio.pkg2;

import java.util.Scanner;

/**
 *
 * @author Lucho
 */
public class Ejercicio2 {

    public static void main(String[] args) {
		
        Scanner teclado = new Scanner(System.in);
        
        int numeros[] = new int[10];
        
        System.out.println("Por favor, cargue 10 numeros:");
        
        for (int i = 0; i < 10; i++) {
            
            System.out.print("Ingrese un numero: ");
            numeros[i] = teclado.nextInt();
        }
        
        // Determinar menor y mayor:
        int menor = numeros[0], mayor = numeros[0];
        
        for (int i = 0; i < 10; i++) {
            
            if (numeros[i] < menor) {
                menor = numeros[i];
            }
            else if (numeros[i] > mayor) {
                mayor = numeros[i];
            }
        }
        
        System.out.println("El menor numero del array es: " + menor);
        System.out.println("El mayor numero del array es: " + mayor);
    }
    
}
