package Logica;

public class Mueble {
    
    private String nombre;
    private double alto;
    private double ancho;
    private String material;
    private int cantidad;

    public Mueble() {
    }

    public Mueble(String nombre, double alto, double ancho, String material, int cantidad) {
        this.nombre = nombre;
        this.alto = alto;
        this.ancho = ancho;
        this.material = material;
        this.cantidad = cantidad;
    }

    public double getAlto() {
        return alto;
    }

    public double getAncho() {
        return ancho;
    }

    public int getCantidad() {
        return cantidad;
    }

    public String getMaterial() {
        return material;
    }

    public String getNombre() {
        return nombre;
    }

    public void setAlto(double alto) {
        this.alto = alto;
    }

    public void setAncho(double ancho) {
        this.ancho = ancho;
    }

    public void setCantidad(int cantidad) {
        this.cantidad = cantidad;
    }

    public void setMaterial(String material) {
        this.material = material;
    }
    
    public void setNombre(String nombre) {
        this.nombre = nombre;
    }
}
