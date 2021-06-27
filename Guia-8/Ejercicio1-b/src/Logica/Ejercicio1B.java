package Logica;

public class Ejercicio1B {

    public static void main(String[] args) {
        
        Fruta frutas[] = new Fruta[5];
        
        Fruta fruta1 = new Fruta("Manzana", "roja", 50, "dura", true);
        Fruta fruta2 = new Fruta("Naranja", "anaranjado", 70, "dura", true);
        Fruta fruta3 = new Fruta("Pera", "verde", 25, "blanda", true);
        Fruta fruta4 = new Fruta("Sandía", "verde", 100, "dura", true);
        Fruta fruta5 = new Fruta("Banana", "amarillo", 120, "blanda", true);
        
        frutas[0] = fruta1;
        frutas[1] = fruta2;
        frutas[2] = fruta3;
        frutas[3] = fruta4;
        frutas[4] = fruta5;
        
        for (int i = 0; i < 5; i++) {
            
            System.out.println("Fruta: " + frutas[i].getNombre() + " - Calorias: " + frutas[i].getCalorias());
        }
        
        System.out.println("// ==================== //");
        System.out.println("Cambiando todos los datos de 2 frutas");
        
        frutas[1].setNombre("Frutilla");
        frutas[1].setColor("rojo");
        frutas[1].setCalorias(65);
        frutas[1].setTipoCascara("blanda");
        
        frutas[3].setNombre("Limon");
        frutas[3].setColor("amarillo");
        frutas[3].setCalorias(33);
        frutas[3].setTipoCascara("dura");
        
        System.out.println("// ==================== //");
        
        for (int i = 0; i < 5; i++) {
            
            System.out.println("Fruta: " + frutas[i].getNombre() +
                                " | Color: " + frutas[i].getColor() + 
                                " | Calorias: " + frutas[i].getCalorias() +
                                " | Cascara: " + frutas[i].getTipoCascara() + 
                                " | Comestible: " + frutas[i].getEsComestible());
        }
        
        System.out.println("// ==================== //");
        System.out.println("Frutas de color verde:");
        
        for (int i = 0; i < 5; i++) {
            
            if (!frutas[i].getColor().equals("verde")) {
                continue;
            }
            
            System.out.println("Fruta: " + frutas[i].getNombre() +
                                " | Color: " + frutas[i].getColor() + 
                                " | Calorias: " + frutas[i].getCalorias() +
                                " | Cascara: " + frutas[i].getTipoCascara() + 
                                " | Comestible: " + frutas[i].getEsComestible());
        }
    }
    
}
