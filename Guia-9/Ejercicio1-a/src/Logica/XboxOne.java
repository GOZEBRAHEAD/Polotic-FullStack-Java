package Logica;

public class XboxOne extends Consola {
    
    private boolean conectadaAInternet;
    private boolean activado4K;
    private boolean descargarActualizaciones;

    public XboxOne() {
    }

    public XboxOne(boolean conectadaAInternet, boolean activado4K, boolean descargarActualizaciones) {
        this.conectadaAInternet = conectadaAInternet;
        this.activado4K = activado4K;
        this.descargarActualizaciones = descargarActualizaciones;
    }

    @Override
    public void cargarJuego() {
        System.out.println("Cargando juego de XboxOne, por favor espere.");
    }
    
    public void leerJuegoDigital(String nombreJuego) {
        System.out.println("Leyendo " + nombreJuego + " desde tienda.");
        
        cargarJuego();
    }

    public boolean getConectadaAInternet() {
        return conectadaAInternet;
    }

    public boolean getActivado4K() {
        return activado4K;
    }

    public boolean getDescargarActualizaciones() {
        return descargarActualizaciones;
    }

    public void setActivado4K(boolean activado4K) {
        this.activado4K = activado4K;
    }

    public void setConectadaAInternet(boolean conectadaAInternet) {
        this.conectadaAInternet = conectadaAInternet;
    }

    public void setDescargarActualizaciones(boolean descargarActualizaciones) {
        this.descargarActualizaciones = descargarActualizaciones;
    }
}
