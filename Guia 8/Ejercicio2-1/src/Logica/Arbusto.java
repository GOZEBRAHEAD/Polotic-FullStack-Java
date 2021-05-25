package Logica;

public class Arbusto extends Planta {
    
    private double ancho;
    private boolean esDomestico;
    private String variedadArbusto;
    private String colorHojas;
    private boolean sePodaONo;

    public Arbusto() {
    }

    public Arbusto(double ancho, boolean esDomestico, String variedadArbusto, String colorHojas, boolean sePodaONo, 
            String nombre, int altoTallo, boolean tieneHojas, String climaIdeal) {
        
        super(nombre, altoTallo, tieneHojas, climaIdeal);
        
        this.ancho = ancho;
        this.esDomestico = esDomestico;
        this.variedadArbusto = variedadArbusto;
        this.colorHojas = colorHojas;
        this.sePodaONo = sePodaONo;
    }

    public double getAncho() {
        return ancho;
    }

    public String getColorHojas() {
        return colorHojas;
    }

    public String getVariedadArbusto() {
        return variedadArbusto;
    }

    public boolean isEsDomestico() {
        return esDomestico;
    }

    public boolean isSePodaONo() {
        return sePodaONo;
    }

    public void setAncho(double ancho) {
        this.ancho = ancho;
    }

    public void setColorHojas(String colorHojas) {
        this.colorHojas = colorHojas;
    }

    public void setEsDomestico(boolean esDomestico) {
        this.esDomestico = esDomestico;
    }

    public void setSePodaONo(boolean sePodaONo) {
        this.sePodaONo = sePodaONo;
    }

    public void setVariedadArbusto(String variedadArbusto) {
        this.variedadArbusto = variedadArbusto;
    }
    
    public void hablar() {
        System.out.println("Hola soy un Arbusto!");
    }
}
