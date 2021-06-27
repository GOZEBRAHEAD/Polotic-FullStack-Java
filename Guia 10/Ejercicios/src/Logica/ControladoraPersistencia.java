package Logica;

import Persistencia.PerroJpaController;
import java.util.logging.Level;
import java.util.logging.Logger;

public class ControladoraPersistencia {
    
    PerroJpaController jpaController = new PerroJpaController();
    
    public void guardarPerro(Perro peroNuevo) {
        
        // Trato de guardar el perro creado en la base de datos
        try {
            jpaController.create(peroNuevo);
        } catch (Exception ex) {
            Logger.getLogger(ControladoraPersistencia.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
}
