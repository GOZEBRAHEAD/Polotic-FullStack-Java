package ejercicio2.a;

import java.util.Scanner;

/**
 *
 * @author Lucho
 */
public class Ejercicio2A {

    public static void main(String[] args) {
        
        Scanner teclado = new Scanner(System.in);
        
        int matriz[][] = new int[4][5];
        int numeroEscrito = 0;
        
        System.out.println("Cargue la matriz unicamente con el numero 5.");
        
        for (int i = 0; i < 4; i++) {
            
            System.out.println("Cargando fila: " + (i+1));
            
            for (int j = 0; j < 5; j++) {
                
                System.out.println("Cargando columna: " + (j+1));
                
                System.out.print("Numero: ");
                numeroEscrito = teclado.nextInt();
                
                while(numeroEscrito != 5) {
                    
                    System.out.println("Solo se acepta el numero 5 en la matriz.");
                    
                    System.out.print("Numero: ");
                    numeroEscrito = teclado.nextInt();
                }
                
                matriz[i][j] = numeroEscrito;
            }
        }
        
        System.out.println("=======================");
        System.out.println("Imprimiendo matriz");
        
        for (int i = 0; i < 4; i++) {
            
            for (int j = 0; j < 5; j++) {
                
                System.out.print(matriz[i][j] + " ");
            }
            
            System.out.println("");
        }
    }
    
}
