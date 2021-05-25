package Logica;

public class Ejercicio22 {

    public static void main(String[] args) {
        
        Vehiculo vehiculos[] = new Vehiculo[9];
        
        Auto auto1 = new Auto();
        Auto auto2 = new Auto();
        Auto auto3 = new Auto();
        
        auto1.setMarca("volkswagen");
        auto2.setMarca("BMW");
        auto3.setMarca("Ferrari");
        
        Moto moto1 = new Moto();
        Moto moto2 = new Moto();
        Moto moto3 = new Moto();
        
        moto1.setCilindrada("100");
        moto2.setCilindrada("250");
        moto3.setCilindrada("350");
        
        Colectivo colectivo1 = new Colectivo();
        Colectivo colectivo2 = new Colectivo();
        
        colectivo1.setCantidadAsientos(10);
        colectivo2.setCantidadAsientos(18);
        
        Camion camion1 = new Camion();
        
        camion1.setCantidadEjes(4);
        
        vehiculos[0] = auto1;
        vehiculos[1] = auto2;
        vehiculos[2] = auto3;
        
        vehiculos[3] = moto1;
        vehiculos[4] = moto2;
        vehiculos[5] = moto3;
        
        vehiculos[6] = colectivo1;
        vehiculos[7] = colectivo2;
        
        vehiculos[8] = camion1;
        
        for (int i = 0; i < 9; i++) {
            
            vehiculos[i].mostrarMensaje();
        }
    }
    
}
