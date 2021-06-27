package Logica;

public class Camion extends Vehiculo {
    
    private boolean tieneAcoplado;
    private int cantidadEjes;

    public Camion() {
    }

    public Camion(boolean tieneAcoplado, int cantidadEjes, String patente, String numChasis, 
            String motor, String color, String marca, String modelo, int cantidadAsientos) {
        
        super(patente, numChasis, motor, color, marca, modelo, cantidadAsientos);
        
        this.tieneAcoplado = tieneAcoplado;
        this.cantidadEjes = cantidadEjes;
    }

    public int getCantidadEjes() {
        return cantidadEjes;
    }

    public boolean getTieneAcoplado() {
        return tieneAcoplado;
    }

    public void setCantidadEjes(int cantidadEjes) {
        this.cantidadEjes = cantidadEjes;
    }

    public void setTieneAcoplado(boolean tieneAcoplado) {
        this.tieneAcoplado = tieneAcoplado;
    }

    @Override
    public void mostrarMensaje() {
        
        System.out.println("Hola soy un Camion y mi cantidad de ejes es: " + getCantidadEjes());
    }
}
