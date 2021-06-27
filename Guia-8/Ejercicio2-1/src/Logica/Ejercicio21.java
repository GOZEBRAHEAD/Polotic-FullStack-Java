package Logica;

public class Ejercicio21 {

    public static void main(String[] args) {
        
        Arbol arbol = new Arbol("acacia", "duro", 3, "marron oscuro", "verdes", "acacia", 5, true, "verano");
        
        Flor flor = new Flor("rojo", 6, "verde", "grande", "otoño", "rosa", 4, true, "otoño");
        
        Arbusto arbusto = new Arbusto(2, true, "mediano", "verde oscuro", true, "arbustito", 10, true, "primavera");
        
        // Llamo a los metodos para que impriman el mensaje.
        arbol.hablar();
        flor.hablar();
        arbusto.hablar();
        
        // Si se cambian los métodos a "private", no puedo llamarlos desde acá.
    }
    
}
