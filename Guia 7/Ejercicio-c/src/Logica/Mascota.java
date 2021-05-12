package Logica;

public class Mascota {
    
    private String nombre;
    private String especie;
    private String sexo;
    private String color;
    private String pelaje;
    private String raza;

    public Mascota() {
    }

    public Mascota(String nombre, String especie, String sexo, String color, String pelaje, String raza) {
        this.nombre = nombre;
        this.especie = especie;
        this.sexo = sexo;
        this.color = color;
        this.pelaje = pelaje;
        this.raza = raza;
    }

    public String getColor() {
        return color;
    }

    public String getEspecie() {
        return especie;
    }

    public String getNombre() {
        return nombre;
    }

    public String getPelaje() {
        return pelaje;
    }

    public String getRaza() {
        return raza;
    }

    public String getSexo() {
        return sexo;
    }

    public void setColor(String color) {
        this.color = color;
    }

    public void setEspecie(String especie) {
        this.especie = especie;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public void setPelaje(String pelaje) {
        this.pelaje = pelaje;
    }

    public void setRaza(String raza) {
        this.raza = raza;
    }

    public void setSexo(String sexo) {
        this.sexo = sexo;
    }
    
    
}
