package Logica;

import Logica.Empleado;
import Logica.Habitacion;
import Logica.Huesped;
import java.util.Date;
import javax.annotation.Generated;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;

@Generated(value="EclipseLink-2.5.2.v20140319-rNA", date="2021-08-09T00:51:50")
@StaticMetamodel(Reserva.class)
public class Reserva_ { 

    public static volatile SingularAttribute<Reserva, Huesped> huesped;
    public static volatile SingularAttribute<Reserva, Date> checkIn;
    public static volatile SingularAttribute<Reserva, Date> fechaAlta;
    public static volatile SingularAttribute<Reserva, Empleado> empleado;
    public static volatile SingularAttribute<Reserva, Integer> id;
    public static volatile SingularAttribute<Reserva, Date> checkOut;
    public static volatile SingularAttribute<Reserva, Habitacion> habitacion;

}