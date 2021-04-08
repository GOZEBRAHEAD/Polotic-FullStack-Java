package ejercicio2.c;

import java.util.Scanner;

/**
 *
 * @author Lucho
 */
public class Ejercicio2C {

    public static void main(String[] args) {
        
        Scanner teclado = new Scanner(System.in);
        
        String matriz[][] = new String[3][3];
        
        boolean perroEncontrado = false;
        
        for (int i = 0; i < 3; i++) {
            
            System.out.println("Cargando perros en fila: " + (i+1));
            
            for (int j = 0; j < 3; j++) {
                
                System.out.println("Cargando perros en columna: " + (j+1));
                
                System.out.print("Raza: ");
                matriz[i][j] = teclado.next();
            }
        }
        
        System.out.println("==================");
        
        System.out.print("Ingrese la raza del perro a buscar: ");
        String razaDelPerro = teclado.next();
        
        for (int i = 0; i < 3; i++) {
            
            for (int j = 0; j < 3; j++) {
                
                if (matriz[i][j].equalsIgnoreCase(razaDelPerro)) {
                    
                    perroEncontrado = true;
                    
                    System.out.println("Perro encontrado en la fila " + (i+1) + ", columna " + (j+1));
                }
            }
        }
        
        if (!perroEncontrado) {
            System.out.println("No se encontro la raza: " + razaDelPerro);
        }
    }
    
}
