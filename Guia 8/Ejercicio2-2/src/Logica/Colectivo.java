package Logica;

public class Colectivo extends Vehiculo {
    
    private boolean aptoDiscapacitados;
    private boolean poseeLectorSube;
    private String tipoColectivo;

    public Colectivo() {
    }

    public Colectivo(boolean aptoDiscapacitados, boolean poseeLectorSube, String tipoColectivo, String patente, 
            String numChasis, String motor, String color, String marca, String modelo, int cantidadAsientos) {
        
        super(patente, numChasis, motor, color, marca, modelo, cantidadAsientos);
        
        this.aptoDiscapacitados = aptoDiscapacitados;
        this.poseeLectorSube = poseeLectorSube;
        this.tipoColectivo = tipoColectivo;
    }

    public String getTipoColectivo() {
        return tipoColectivo;
    }

    public boolean getAptoDiscapacitados() {
        return aptoDiscapacitados;
    }

    public boolean getPoseeLectorSube() {
        return poseeLectorSube;
    }

    public void setAptoDiscapacitados(boolean aptoDiscapacitados) {
        this.aptoDiscapacitados = aptoDiscapacitados;
    }

    public void setPoseeLectorSube(boolean poseeLectorSube) {
        this.poseeLectorSube = poseeLectorSube;
    }

    public void setTipoColectivo(String tipoColectivo) {
        this.tipoColectivo = tipoColectivo;
    }

    @Override
    public void mostrarMensaje() {
        
        System.out.println("Hola soy un Colectivo y mi cantidad de asientos es: " + getCantidadAsientos());
    }
}
