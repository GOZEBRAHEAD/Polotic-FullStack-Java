package Logica;

public class ControladoraGUI {
    
    ControladoraPersistencia controladoraPersistencia = new ControladoraPersistencia();

    public void guardarPerro(int num_cliente, String nombre_perro, String raza, 
                            String color, String alergico, String atencion_especial, 
                            String nombre_duenio, String celular_duenio, String observaciones) {
        
        // Creo la instancia del perro y le seteo los valores
        Perro nuevoPerro = new Perro();
        
        nuevoPerro.setNum_cliente(num_cliente);
        nuevoPerro.setNombre_perro(nombre_perro);
        nuevoPerro.setRaza(raza);
        nuevoPerro.setColor(color);
        nuevoPerro.setAlergico(alergico);
        nuevoPerro.setAtencion_especial(atencion_especial);
        nuevoPerro.setNombre_duenio(nombre_duenio);
        nuevoPerro.setCelular_duenio(celular_duenio);
        nuevoPerro.setObservaciones(observaciones);
        
        // Lo mando a la controladora entre Persistencia y la DB
        controladoraPersistencia.guardarPerro(nuevoPerro);
    }
    
    
}
