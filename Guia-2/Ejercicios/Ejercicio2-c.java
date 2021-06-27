package ejercicio2.c;

import java.util.Scanner;

public class Ejercicio2C {

    public static void main(String[] args) {
        
        Scanner teclado = new Scanner(System.in);
        
        int dni, edad;
        String nombre, apellido;
        
        while(true) {
            
            System.out.print("Por favor ingrese el dni: ");
            dni = teclado.nextInt();

            System.out.print("Por favor ingrese el nombre: ");
            nombre = teclado.next();
            
            if (dni == 0 && nombre.equals("fin")) {
                break;
            }
            
            System.out.print("Por favor ingrese el apellido: ");
            apellido = teclado.next();

            System.out.print("Por favor ingrese la edad: ");
            edad = teclado.nextInt();
            
            System.out.println("=====================");
            
            System.out.println("La persona " + nombre + " " + apellido + " debe ser inscripto en:");
            
            if (edad >= 6 && edad <= 10) {
                System.out.println("Menores A (de 6 a 10 años).");
            }
            else if (edad >= 11 && edad <= 17) {
                System.out.println("Menores B (de 11 a 17 años).");
            }
            else if (edad >= 18 && edad <= 30) {
                System.out.println("Juveniles (de 18 a 30 años).");
            }
            else if (edad >= 31 && edad <= 50) {
                System.out.println("Adultos (de 31 a 50 años).");
            }
            else if (edad > 50) {
                System.out.println("Adultos mayores (mayores de 50 años).");
            }
            
            System.out.println("");
        }
    }
    
}
