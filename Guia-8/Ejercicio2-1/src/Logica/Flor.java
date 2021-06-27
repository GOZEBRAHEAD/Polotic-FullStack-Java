package Logica;

public class Flor extends Planta {
    
    private String colorPetalos;
    private int promedioPetalos;
    private String colorPistilo;
    private String variedadFlor;
    private String estacionFlorece;

    public Flor() {
    }

    public Flor(String colorPetalos, int promedioPetalos, String colorPistilo, String variedadFlor, 
            String estacionFlorece, String nombre, int altoTallo, boolean tieneHojas, String climaIdeal) {
        
        super(nombre, altoTallo, tieneHojas, climaIdeal);
        
        this.colorPetalos = colorPetalos;
        this.promedioPetalos = promedioPetalos;
        this.colorPistilo = colorPistilo;
        this.variedadFlor = variedadFlor;
        this.estacionFlorece = estacionFlorece;
    }

    public String getColorPetalos() {
        return colorPetalos;
    }

    public String getColorPistilo() {
        return colorPistilo;
    }

    public String getEstacionFlorece() {
        return estacionFlorece;
    }

    public int getPromedioPetalos() {
        return promedioPetalos;
    }

    public String getVariedadFlor() {
        return variedadFlor;
    }

    public void setColorPetalos(String colorPetalos) {
        this.colorPetalos = colorPetalos;
    }

    public void setColorPistilo(String colorPistilo) {
        this.colorPistilo = colorPistilo;
    }

    public void setEstacionFlorece(String estacionFlorece) {
        this.estacionFlorece = estacionFlorece;
    }

    public void setPromedioPetalos(int promedioPetalos) {
        this.promedioPetalos = promedioPetalos;
    }

    public void setVariedadFlor(String variedadFlor) {
        this.variedadFlor = variedadFlor;
    }
    
    public void hablar() {
        System.out.println("Hola soy una Flor!");
    }
}
