package ejercicio2.e;

import java.util.Scanner;

/**
 *
 * @author Lucho
 */
public class Ejercicio2E {

    public static void main(String[] args) {
        
        Scanner palabras = new Scanner(System.in);
        Scanner numeros = new Scanner(System.in);
        
        String destinos[] = { "Rio de Janeiro", "Cancun", "Madrid", "Roma", "Milan", "Iguazu" };
        String horario[] = { "Mañana", "Mediodia", "Noche" };
        
        int asientosDisponibles[][] = new int[6][3];
        
        System.out.println("-----------------");
        
        for (int i = 0; i < 6; i++) {
            
            System.out.println("[Asientos disponibles para " + destinos[i] + "]");
            
            for (int j = 0; j < 3; j++) {
                
                System.out.print("- " + horario[j] + ": ");
                asientosDisponibles[i][j] = numeros.nextInt();
            }
            
            System.out.println("-----------------");
        }
        
        System.out.println("Si quiere finalizar el programa ingrese 'finish'");
        
        String palabraEscrita = palabras.next();
        
        while(!palabraEscrita.equals("finish")) {
            
            System.out.println("[RESERVA DE ASIENTOS]");
            
            System.out.print("Vuelo que quiere reservar: ");
            int numeroVuelo = numeros.nextInt();
            
            while(numeroVuelo < 0 || numeroVuelo > 5) {
                
                System.out.println("Los vuelos son del 0 al 5 " + 
                        "(Rio de Janeiro, Cancun, Madrid, Roma, Milan, Iguazu).");
                
                System.out.print("Vuelo que quiere reservar: ");
                numeroVuelo = numeros.nextInt();
            }
            
            System.out.print("Horario que quiere reservar: ");
            int horarioVuelo = numeros.nextInt();
            
            while(horarioVuelo < 0 || horarioVuelo > 2) {
                
                System.out.println("Los vuelos son del 0 al 2 (mañana, mediodia, noche).");
                
                System.out.print("Horario que quiere reservar: ");
                numeroVuelo = numeros.nextInt();
            }
            
            System.out.print("Cantidad de asientos que quiere reservar: ");
            int cantidadAsientos = numeros.nextInt();
            
            while(cantidadAsientos <= 0) {
                
                System.out.print("Numero invalido, vuelva a escribirlo: ");
                cantidadAsientos = numeros.nextInt();
            }
            
            while(asientosDisponibles[numeroVuelo][horarioVuelo] - cantidadAsientos < 0) {
                
                System.out.println("No se pudo completar su operacion dado que no hay asientos disponibles.");
                
                System.out.print("Cantidad de asientos que quiere reservar: ");
                cantidadAsientos = numeros.nextInt();
            }
            
            asientosDisponibles[numeroVuelo][horarioVuelo] -= cantidadAsientos;
            
            System.out.println("Su reserva fue realizada con exito.");
            
            for (int i = 0; i < 6; i++) {

                for (int j = 0; j < 3; j++) {

                    System.out.print(asientosDisponibles[i][j] + " ");
                }

                System.out.println("");
            }
            
            System.out.println("=======================");
            
            System.out.println("Si quiere finalizar el programa ingrese 'finish'");
            
            palabraEscrita = palabras.next();
        }
    }
    
}
