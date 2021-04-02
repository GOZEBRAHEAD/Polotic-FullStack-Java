package ejercicio2.pkg3;

import java.util.Scanner;

public class Ejercicio23 {

    public static void main(String[] args) {
        
        Scanner teclado = new Scanner(System.in);
        
        System.out.print("Por favor, ingrese la edad del alumno: ");
        
        int edadAlumno = teclado.nextInt();
        
        if (edadAlumno >= 4 && edadAlumno <= 6) {
            System.out.println("Lunes y Miercoles de 16:00 a 17:00");
        }
        else if (edadAlumno >= 7 && edadAlumno <= 8) {
            System.out.println("Martes y Jueves de 16:30 a 17:30");
        }
        else if (edadAlumno >= 9 && edadAlumno <= 10) {
            System.out.println("Martes y Jueves de 17:30 a 19:00");
        }
        else if (edadAlumno >= 11 && edadAlumno <= 13) {
            System.out.println("Lunes y Miercoles de 17:00 a 18:30");
        }
        else {
            System.out.println("Edad incorrecta.");
        }
    }
    
}
