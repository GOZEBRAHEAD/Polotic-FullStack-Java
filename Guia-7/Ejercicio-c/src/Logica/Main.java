package Logica;

public class Main {

    public static void main(String[] args) {
        
        Mascota mascotas[] = new Mascota[5];
        
        Mascota mascota1 = new Mascota("1", "perro", "m", "rojo", "a", "a");
        Mascota mascota2 = new Mascota("2", "gato", "f", "azul", "b", "b");
        Mascota mascota3 = new Mascota("3", "loro", "m", "marron", "c", "c");
        Mascota mascota4 = new Mascota("4", "perro", "f", "verde", "d", "d");
        Mascota mascota5 = new Mascota("5", "gato", "m", "gris", "e", "e");
        
        mascotas[0] = mascota1;
        mascotas[1] = mascota2;
        mascotas[2] = mascota3;
        mascotas[3] = mascota4;
        mascotas[4] = mascota5;
        
        System.out.println("// ========================= //");
        
        for (int i = 0; i < mascotas.length; i++) {
            
            System.out.println("Mascota " + mascotas[i].getNombre() + 
                    ", especie " + mascotas[i].getEspecie() + 
                    ", sexo " + mascotas[i].getSexo());
        }
        
        mascota2.setNombre("2 modificado");
        mascota3.setNombre("3 modificado");
        
        System.out.println("// ========================= //");
        
        System.out.println("Mascota " + mascota2.getNombre() + 
                    ", especie " + mascota2.getEspecie() + 
                    ", sexo " + mascota2.getSexo() +
                    ", color " + mascota2.getColor() +
                    ", pelaje " + mascota2.getPelaje() +
                    ", raza " + mascota2.getRaza());
        
        System.out.println("Mascota " + mascota3.getNombre() + 
                    ", especie " + mascota3.getEspecie() + 
                    ", sexo " + mascota3.getSexo() +
                    ", color " + mascota3.getColor() +
                    ", pelaje " + mascota3.getPelaje() +
                    ", raza " + mascota3.getRaza());
        
        System.out.println("// ========================= //");
        
        for (int i = 0; i < mascotas.length; i++) {
            
            if (mascotas[i].getEspecie().equals("perro")) {
                
                System.out.println("Mascota " + mascotas[i].getNombre() + 
                    ", especie " + mascotas[i].getEspecie() + 
                    ", sexo " + mascotas[i].getSexo() +
                    ", color " + mascotas[i].getColor() +
                    ", pelaje " + mascotas[i].getPelaje() +
                    ", raza " + mascotas[i].getRaza());
            }
        }
    }
    
}
