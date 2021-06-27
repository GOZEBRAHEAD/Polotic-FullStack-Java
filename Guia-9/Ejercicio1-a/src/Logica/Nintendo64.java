package Logica;

public class Nintendo64 extends Consola {
    
    private String norma;
    private boolean leePiratas;

    public Nintendo64() {
    }

    public Nintendo64(String norma, boolean leePiratas) {
        this.norma = norma;
        this.leePiratas = leePiratas;
    }

    @Override
    public void cargarJuego() {
        System.out.println("Cargando juego de Nintendo64, por favor espere.");
    }
    
    public void leerCartucho(String nombreJuego) {
        System.out.println("Leyendo cartucho " + nombreJuego);
        
        cargarJuego();
    }

    public String getNorma() {
        return norma;
    }

    public boolean getLeePiratas() {
        return leePiratas;
    }

    public void setNorma(String norma) {
        this.norma = norma;
    }

    public void setLeePiratas(boolean leePiratas) {
        this.leePiratas = leePiratas;
    }
}
