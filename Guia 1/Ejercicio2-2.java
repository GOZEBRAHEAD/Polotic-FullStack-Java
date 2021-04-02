package ejercicio2.pkg2;

import java.util.Scanner;

public class Ejercicio22 {

    public static void main(String[] args) {
        
        Scanner teclado = new Scanner(System.in);
        
        System.out.print("Por favor, ingrese la cantidad de productos: ");
        
        int totalProductos = teclado.nextInt();
        
        if (totalProductos < 5) {
            System.out.println("No se permiten compras inferiores a 5 productos.");
        }
        else if (totalProductos >= 5 && totalProductos < 15) {
            System.out.println("El costo de envio es de $200.");
        }
        else {
            System.out.println("El envio es gratuito.");
        }
    }
    
}
