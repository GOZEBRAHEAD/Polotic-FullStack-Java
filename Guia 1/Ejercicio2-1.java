package ejercicio2.pkg1;

import java.util.Scanner;

public class Ejercicio21 {

    public static void main(String[] args) {
        
        Scanner teclado = new Scanner(System.in);
        
        System.out.print("Por favor, ingrese el tipo de empleado (1, 2 o 3): ");
        
        int tipoEmpleado = teclado.nextInt();
        
        double sueldoFinal;
        
        switch(tipoEmpleado) {
            
            case 1:
                
                System.out.println("Tipo de empleado: REPOSITOR");
                System.out.println("Los repositores cobran $15.890 + un bono de 10%.");
                
                sueldoFinal = 15890 + (15890 * 0.10);
                
                System.out.println("SUELDO FINAL: $" + sueldoFinal);
                break;
            
            case 2:
                System.out.println("Tipo de empleado: CAJERO");
                System.out.println("Los cajeros cobran $25.630,89 fijos.");
                
                sueldoFinal = 25630.89;
                
                System.out.println("SUELDO FINAL: $" + sueldoFinal);
                break;
                
            case 3:
                System.out.println("Tipo de empleado: SUPERVISOR");
                System.out.println("Los supervisores cobran $35.560,20 - un 11% de jubilación.");
                
                sueldoFinal = 35560.20 - (35560.20 * 0.11);
                
                System.out.println("SUELDO FINAL: $" + sueldoFinal);
                break;
                
            default:
                System.out.println("Tipo de empleado erroneo, cancelando...");
                break;
        }
    }
    
}
