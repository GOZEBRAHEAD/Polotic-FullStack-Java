package Logica;

public class Planta {
    
    private String nombre;
    private int altoTallo;
    private boolean tieneHojas;
    private String climaIdeal;

    public Planta() {
    }

    public Planta(String nombre, int altoTallo, boolean tieneHojas, String climaIdeal) {
        this.nombre = nombre;
        this.altoTallo = altoTallo;
        this.tieneHojas = tieneHojas;
        this.climaIdeal = climaIdeal;
    }

    public int getAltoTallo() {
        return altoTallo;
    }

    public String getClimaIdeal() {
        return climaIdeal;
    }

    public String getNombre() {
        return nombre;
    }

    public boolean getTieneHojas() {
        return tieneHojas;
    }

    public void setAltoTallo(int altoTallo) {
        this.altoTallo = altoTallo;
    }

    public void setClimaIdeal(String climaIdeal) {
        this.climaIdeal = climaIdeal;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public void setTieneHojas(boolean tieneHojas) {
        this.tieneHojas = tieneHojas;
    }
}
