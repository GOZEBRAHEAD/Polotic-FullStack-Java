package Logica;

public class Ejercicio1A {

    public static void main(String[] args) {
        
        Nintendo64 nintendo = new Nintendo64("PAL", true);
        PlayStation2 play2 = new PlayStation2("NTSC", true, "8MB");
        XboxOne xbox = new XboxOne(true, true, true);
        
        nintendo.leerCartucho("Mario Bros");
        
        play2.leerDVD("Pes 2012");
        
        xbox.leerJuegoDigital("Call of Duty");
    }
    
}
