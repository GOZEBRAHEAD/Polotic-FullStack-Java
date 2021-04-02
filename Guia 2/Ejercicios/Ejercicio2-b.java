package ejercicio2.b;

import java.util.Scanner;

public class Ejercicio2B {

    public static void main(String[] args) {
        
        Scanner teclado = new Scanner(System.in);
        
        int num1, num2;
        double resultado = 0;
        String operador;
        boolean error;
        
        for (int i = 0; i < 10; i++) {
            
            error = false;
            
            System.out.print("Ingrese el primer numero: ");
            num1 = teclado.nextInt();

            System.out.print("Ingrese el segundo numero: ");
            num2 = teclado.nextInt();

            System.out.print("Ingrese el operador: ");
            operador = teclado.next();

            switch(operador) {

                case "+":
                    resultado = num1 + num2;
                    break;

                case "-":
                    resultado = num1 - num2;
                    break;

                case "*":
                    resultado = num1 * num2;
                    break;

                case "/":
                    
                    if (num2 == 0) {
                        error = true;
                        System.out.println("No se puede dividir por cero.");
                        break;
                    }
                    
                    resultado = num1 / num2;
                    
                    break;

                default:
                    System.out.println("Operador erroneo");
                    break;
            }
            
            if (!error) {
                
                System.out.println("Resultado:");
                System.out.println(num1 + " " + operador + " " + num2 + " = " + resultado);
            }
        }
    }
    
}
