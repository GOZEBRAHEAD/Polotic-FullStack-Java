package ejercicio2.d;

import java.util.Scanner;

/**
 *
 * @author Lucho
 */
public class Ejercicio2D {

    public static void main(String[] args) {
        
        Scanner teclado = new Scanner(System.in);
        
        double matriz[][] = new double[4][4];
        double notas = 0;
        
        for (int i = 0; i < 4; i++) {
            
            System.out.println("Cargando notas del alumno #" + (i+1) + ":");
            
            for (int j = 0; j < 3; j++) {
                
                System.out.print("Nota #" + (j+1) + ": ");
                matriz[i][j] = teclado.nextDouble();
                
                notas += matriz[i][j];
            }
            
            matriz[i][3] = notas / 3;
            
            notas = 0;
        }
        
        System.out.println("========================");
        
        for (int i = 0; i < 4; i++) {
            
            System.out.println("");
            System.out.println("Mostrando notas del alumno #" + (i+1) + ":");
            
            for (int j = 0; j < 3; j++) {
                
                System.out.println("Nota #" + (j+1) + ": " + matriz[i][j]);
            }
            
            System.out.println("Promedio: " + matriz[i][3]);
        }
    }
    
}
