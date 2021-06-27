package Logica;

public class Auto extends Vehiculo {
    
    private String materialAsientos;
    private String cantidadCaballos;

    public Auto() {
    }

    public Auto(String materialAsientos, String cantidadCaballos, String patente, String numChasis, 
            String motor, String color, String marca, String modelo, int cantidadAsientos) {
        
        super(patente, numChasis, motor, color, marca, modelo, cantidadAsientos);
        
        this.materialAsientos = materialAsientos;
        this.cantidadCaballos = cantidadCaballos;
    }

    public String getCantidadCaballos() {
        return cantidadCaballos;
    }

    public String getMaterialAsientos() {
        return materialAsientos;
    }

    public void setCantidadCaballos(String cantidadCaballos) {
        this.cantidadCaballos = cantidadCaballos;
    }

    public void setMaterialAsientos(String materialAsientos) {
        this.materialAsientos = materialAsientos;
    }

    @Override
    public void mostrarMensaje() {
        
        System.out.println("Hola soy un Auto y mi marca es: " + getMarca());
    }    
}
