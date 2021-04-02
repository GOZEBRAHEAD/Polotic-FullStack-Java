package ejercicio1.pkg2;

import java.util.Scanner;

public class Ejercicio12 {

    public static void main(String[] args) {
        
        Scanner teclado = new Scanner(System.in);
        
        System.out.print("Por favor, ingrese el primer numero: ");
        
        int numero = teclado.nextInt();
        
        System.out.print("Por favor, ingrese el segundo numero: ");
        
        int numero2 = teclado.nextInt();
        
        int aux = numero;
        
        System.out.println("Numeros antes del cambio: ");
        System.out.println("numero = " + numero);
        System.out.println("numero2 = " + numero2);
        
        System.out.println("// ========================== //");
        
        numero = numero2;
        numero2 = aux;
        
        System.out.println("Numeros despues del cambio: ");
        System.out.println("numero = " + numero);
        System.out.println("numero2 = " + numero2);
    }
    
}
