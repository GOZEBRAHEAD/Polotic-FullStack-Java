package ejercicio2.b;

import java.util.Scanner;

/**
 *
 * @author Lucho
 */
public class Ejercicio2B {

    public static void main(String[] args) {
        
        Scanner teclado = new Scanner(System.in);
        
        int matriz[][] = new int[6][6];
        
        System.out.println("Cargando matriz con numeros 1 en su diagonal.");
        
        for (int i = 0; i < 6; i++) {
            
            for (int j = 0; j < 6; j++) {
                
                if (i == j) {
                    
                    matriz[i][j] = 1;
                }
            }
        }
        
        System.out.println("===============");
        System.out.println("Imprimiendo matriz de 6x6:");
        
        for (int i = 0; i < 6; i++) {
            
            for (int j = 0; j < 6; j++) {
                
                System.out.print(matriz[i][j] + " ");
            }
            
            System.out.println("");
        }
    }
    
}
