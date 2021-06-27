package Logica;

public class Ejercicio21 {

    public static void main(String[] args) {
        
        System.out.println("===================");
        
        Charmander charmander = new Charmander();
        
        charmander.atacarPlacaje();
        charmander.atacarAscuas();
        charmander.atacarLanzallamas();
        
        System.out.println("===================");
        
        Pikachu pikachu = new Pikachu();
        
        pikachu.atacarPlacaje();
        pikachu.atacarImpactrueno();
        pikachu.atacarRayo();
        
        System.out.println("===================");
        
        Bulbasur bulbasur = new Bulbasur();
        
        bulbasur.atacarPlacaje();
        bulbasur.atacarHojaAfilada();
        bulbasur.atacarLatigoCepa();
        
        System.out.println("===================");
        
        Squirtle squirtle = new Squirtle();
        
        squirtle.atacarPlacaje();
        squirtle.atacarHidrobomba();
        squirtle.atacarHidropulso();
        squirtle.atacarPistolaAgua();
        
        System.out.println("===================");
    }
    
}
