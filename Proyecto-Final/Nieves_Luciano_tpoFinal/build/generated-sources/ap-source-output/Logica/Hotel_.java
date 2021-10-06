package Logica;

import Logica.Empleado;
import Logica.Habitacion;
import Logica.Huesped;
import Logica.Reserva;
import javax.annotation.Generated;
import javax.persistence.metamodel.ListAttribute;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;

@Generated(value="EclipseLink-2.5.2.v20140319-rNA", date="2021-08-09T00:51:50")
@StaticMetamodel(Hotel.class)
public class Hotel_ { 

    public static volatile ListAttribute<Hotel, Empleado> listaEmpleados;
    public static volatile ListAttribute<Hotel, Reserva> listaReservas;
    public static volatile ListAttribute<Hotel, Habitacion> listaHabitaciones;
    public static volatile ListAttribute<Hotel, Huesped> listaHuespedes;
    public static volatile SingularAttribute<Hotel, Integer> id;

}