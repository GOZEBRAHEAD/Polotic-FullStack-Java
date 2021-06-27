package ejercicio1.e;

import java.util.Scanner;

/**
 *
 * @author Lucho
 */
public class Ejercicio1E {

    public static void main(String[] args) {
        
        Scanner tecladoStrings = new Scanner(System.in);
        Scanner tecladoInts = new Scanner(System.in);
        
        final int TOTAL_CIUDADES = 5;
        
        String ciudades[] = new String[TOTAL_CIUDADES];
        int tempMin[] = new int[TOTAL_CIUDADES];
        int tempMax[] = new int[TOTAL_CIUDADES];
        
        int ciudadMenorTemperatura = 1000, ciudadMayorTemperatura = -1000;
        int indexCiudadMenorTemperatura = 0, indexCiudadMayorTemperatura = 0;
        
        System.out.println("Ingresando ciudades y temperaturas:");
        System.out.println("// ================ //");
        
        for (int i = 0; i < TOTAL_CIUDADES; i++) {
            
            System.out.println("[CARGANDO DATOS: " + (i+1) + "/5]");
            
            System.out.print("Ciudad: ");
            ciudades[i] = tecladoStrings.nextLine();
            
            System.out.print("Temperatura minima: ");
            tempMin[i] = tecladoInts.nextInt();
            
            if (tempMin[i] < ciudadMenorTemperatura) {
                
                ciudadMenorTemperatura = tempMin[i];
                indexCiudadMenorTemperatura = i;
            }
            
            System.out.print("Temperatura maxima: ");
            tempMax[i] = tecladoInts.nextInt();
            
            if (tempMax[i] > ciudadMayorTemperatura) {
                
                ciudadMayorTemperatura = tempMax[i];
                indexCiudadMayorTemperatura = i;
            }
            
            System.out.println("// ================ //");
        }
        
        System.out.println("Ciudad con menor temperatura: " + ciudades[indexCiudadMenorTemperatura]);
        System.out.println("Ciudad con mayor temperatura: " + ciudades[indexCiudadMayorTemperatura]);
    }
    
}
