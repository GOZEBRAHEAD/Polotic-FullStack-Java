package Logica;

public class Main {

    public static void main(String[] args) {
        
        Mueble mueble1 = new Mueble("Repisa", 5, 10, "Hierro", 5);
        Mueble mueble2 = new Mueble("Contenedor", 3, 5, "Plastico", 2);
        Mueble mueble3 = new Mueble("Escritorio", 5, 8, "Metal", 7);
        
        System.out.println("Mueble 1 (" + mueble1.getNombre() + ") hecho de " + mueble1.getMaterial());
        System.out.println("Mueble 2 (" + mueble2.getNombre() + ") hecho de " + mueble2.getMaterial());
        System.out.println("Mueble 3 (" + mueble3.getNombre() + ") hecho de " + mueble3.getMaterial());
        
        mueble1.setMaterial("Madera");
        mueble2.setMaterial("Madera");
        mueble3.setMaterial("Madera");
        
        System.out.println("Mueble 1 (" + mueble1.getNombre() + ") hecho de " + mueble1.getMaterial());
        System.out.println("Mueble 2 (" + mueble2.getNombre() + ") hecho de " + mueble2.getMaterial());
        System.out.println("Mueble 3 (" + mueble3.getNombre() + ") hecho de " + mueble3.getMaterial());
    }
    
}
