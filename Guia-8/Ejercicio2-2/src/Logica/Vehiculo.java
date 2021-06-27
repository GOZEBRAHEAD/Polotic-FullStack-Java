package Logica;

public class Vehiculo {
    
    private String patente;
    private String numChasis;
    private String motor;
    private String color;
    private String marca;
    private String modelo;
    private int cantidadAsientos;

    public Vehiculo() {
    }

    public Vehiculo(String patente, String numChasis, String motor, String color, String marca, String modelo, int cantidadAsientos) {
        this.patente = patente;
        this.numChasis = numChasis;
        this.motor = motor;
        this.color = color;
        this.marca = marca;
        this.modelo = modelo;
        this.cantidadAsientos = cantidadAsientos;
    }

    public int getCantidadAsientos() {
        return cantidadAsientos;
    }

    public String getColor() {
        return color;
    }

    public String getMarca() {
        return marca;
    }

    public String getModelo() {
        return modelo;
    }

    public String getMotor() {
        return motor;
    }

    public String getNumChasis() {
        return numChasis;
    }

    public String getPatente() {
        return patente;
    }

    public void setCantidadAsientos(int cantidadAsientos) {
        this.cantidadAsientos = cantidadAsientos;
    }

    public void setColor(String color) {
        this.color = color;
    }

    public void setMarca(String marca) {
        this.marca = marca;
    }

    public void setModelo(String modelo) {
        this.modelo = modelo;
    }

    public void setMotor(String motor) {
        this.motor = motor;
    }

    public void setNumChasis(String numChasis) {
        this.numChasis = numChasis;
    }

    public void setPatente(String patente) {
        this.patente = patente;
    }
    
    public void mostrarMensaje() {
        System.out.println("Hola soy un vehiculo!");
    }
}
