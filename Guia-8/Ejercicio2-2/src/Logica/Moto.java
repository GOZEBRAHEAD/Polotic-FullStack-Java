package Logica;

public class Moto extends Vehiculo {
    
    private String cilindrada;
    private String materialManubrio;

    public Moto() {
    }

    public Moto(String cilindrada, String materialManubrio, String patente, String numChasis, 
            String motor, String color, String marca, String modelo, int cantidadAsientos) {
        
        super(patente, numChasis, motor, color, marca, modelo, cantidadAsientos);
        
        this.cilindrada = cilindrada;
        this.materialManubrio = materialManubrio;
    }

    public String getCilindrada() {
        return cilindrada;
    }

    public String getMaterialManubrio() {
        return materialManubrio;
    }

    public void setCilindrada(String cilindrada) {
        this.cilindrada = cilindrada;
    }

    public void setMaterialManubrio(String materialManubrio) {
        this.materialManubrio = materialManubrio;
    }

    @Override
    public void mostrarMensaje() {
        
        System.out.println("Hola soy una Moto y mi cilindrada es de: " + getCilindrada());
    }
}
