package Logica;

import Logica.Tipo;
import javax.annotation.Generated;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;

@Generated(value="EclipseLink-2.5.2.v20140319-rNA", date="2021-08-09T00:51:50")
@StaticMetamodel(Habitacion.class)
public class Habitacion_ { 

    public static volatile SingularAttribute<Habitacion, String> piso;
    public static volatile SingularAttribute<Habitacion, Tipo> tipo;
    public static volatile SingularAttribute<Habitacion, String> nombreTematica;
    public static volatile SingularAttribute<Habitacion, Integer> id;
    public static volatile SingularAttribute<Habitacion, Double> precioPorNoche;

}