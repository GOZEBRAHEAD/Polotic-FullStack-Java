package ejercicio1;

import java.util.Scanner;

public class Ejercicio1 {

    public static void main(String[] args) {
        
        Scanner teclado = new Scanner(System.in);
        
        System.out.println("[Punto a]");
        
        for (int i = 1; i <= 35; i++) {
            
            System.out.println(i);
        }
        
        System.out.println("// ========================= //");
        
        System.out.println("[Punto b]");
        
        System.out.print("Ingrese el limite de numeros a imprimir: ");
        int limiteEscrito = teclado.nextInt();
        
        for (int i = 1; i <= limiteEscrito; i++) {
            
            System.out.println(i);
        }
        
        System.out.println("// ========================= //");
        
        System.out.println("[Punto c]");
        
        for (int i = 200; i <= 250; i+=2) {
            
            System.out.print(i + " ");
        }
        
        System.out.println("");
        
        System.out.println("// ========================= //");
        
        System.out.println("[Punto d]");
        
        for (int i = 10; i > 0; i--) {
            
            System.out.println(i);
        }
        
        System.out.println("// ========================= //");
        
        System.out.println("[Punto e]");
        
        String palabraEscrita = teclado.nextLine();
        
        while(!palabraEscrita.equals("salir")) {
            
            palabraEscrita = teclado.nextLine();
        }
    }
    
}
