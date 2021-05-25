package Logica;

public class Arbol extends Planta {
    
    private String variedad;
    private String tipoTronco;
    private double radioTronco;
    private String color;
    private String tipoHojas;

    public Arbol() {
    }

    public Arbol(String variedad, String tipoTronco, double radioTronco, String color, 
            String tipoHojas, String nombre, int altoTallo, boolean tieneHojas, String climaIdeal) {
        
        super(nombre, altoTallo, tieneHojas, climaIdeal);
        
        this.variedad = variedad;
        this.tipoTronco = tipoTronco;
        this.radioTronco = radioTronco;
        this.color = color;
        this.tipoHojas = tipoHojas;
    }

    public String getColor() {
        return color;
    }

    public double getRadioTronco() {
        return radioTronco;
    }

    public String getTipoHojas() {
        return tipoHojas;
    }

    public String getVariedad() {
        return variedad;
    }

    public String getTipoTronco() {
        return tipoTronco;
    }

    public void setColor(String color) {
        this.color = color;
    }

    public void setVariedad(String variedad) {
        this.variedad = variedad;
    }

    public void setTipoTronco(String tipoTronco) {
        this.tipoTronco = tipoTronco;
    }

    public void setTipoHojas(String tipoHojas) {
        this.tipoHojas = tipoHojas;
    }

    public void setRadioTronco(double radioTronco) {
        this.radioTronco = radioTronco;
    }
    
    public void hablar() {
        System.out.println("Hola soy un Arbol!");
    }
}
