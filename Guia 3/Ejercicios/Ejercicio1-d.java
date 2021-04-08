package ejercicio.pkg4;

import java.util.Scanner;

/**
 *
 * @author Lucho
 */
public class Ejercicio4 {

    public static void main(String[] args) {
        
        Scanner teclado = new Scanner(System.in);
        
        int sueldos[] = new int[12];
        int totalSueldos = 0;
        double promedioFinal = 0.0;
        
        System.out.println("Cargue sus sueldos: ");
        for (int i = 0; i < 12; i++) {
            
            System.out.print("Sueldo #" + (i+1) + ": ");
            sueldos[i] = teclado.nextInt();
            
            // El sueldo que guardé recién en el array lo sumo a la variable...
            totalSueldos += sueldos[i];
        }
        
        promedioFinal = totalSueldos / 12;
        
        System.out.println("La suma total de sueldos es de $" + totalSueldos);
        System.out.println("El promedio entre los 12 sueldos es de $" + promedioFinal);
    }
    
}
