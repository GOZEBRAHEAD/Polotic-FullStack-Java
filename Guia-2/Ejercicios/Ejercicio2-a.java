package ejercicio2;

import java.util.Scanner;

public class Ejercicio2 {

    public static void main(String[] args) {
        
        Scanner teclado = new Scanner(System.in);
        
        System.out.print("Por favor, ingrese su DNI: ");
        int dni = teclado.nextInt();
        
        System.out.println("Servicios disponibles:");
        System.out.println("1) Internet 30 megas (cuyo valor es de $890 – 10% de descuento)");
        System.out.println("2) Internet 50 megas (cuyo valor es de $1050 – 5% de descuento)");
        System.out.println("3) Internet 100 megas (Cuyo valor fijo es de $1600)");
        
        System.out.print("Por favor, ingrese el tipo de servicio: ");
        int tipoServicio = teclado.nextInt();
        
        double valorFinal;
        
        switch(tipoServicio) {
            
            case 1:
                
                valorFinal = 890 - (890 * 0.10);
                System.out.println("DNI: " + dni + 
                        " | Servicio: internet 30 megas | Total a pagar: $" + valorFinal);
                break;
                
            case 2:
                
                valorFinal = 1050 - (1050 * 0.05);
                System.out.println("DNI: " + dni + 
                        " | Servicio: internet 50 megas | Total a pagar: $" + valorFinal);
                break;
                
            case 3:
                
                valorFinal = 1600;
                System.out.println("DNI: " + dni + 
                        " | Servicio: internet 100 megas | Total a pagar: $" + valorFinal);
                break;
                
            default:
                
                System.out.println("Servicio erroneo.");
                break;
        }
    }
    
}
