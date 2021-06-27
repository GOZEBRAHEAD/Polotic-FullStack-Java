package Logica;

public class Bulbasur extends Pokemon implements IPlanta {

    public Bulbasur() {
    }    

    @Override
    public void atacarPlacaje() {
        System.out.println("Soy Bulbasur y estoy atacando con Placaje");
    }

    @Override
    public void atacarArañazo() {
        System.out.println("Soy Bulbasur y estoy atacando con Arañazo");
    }

    @Override
    public void atacarMordisco() {
        System.out.println("Soy Bulbasur y estoy atacando con Mordisco");
    }

    @Override
    public void atacarParalizar() {
        System.out.println("Soy Bulbasur y estoy atacando con Paralizar");
    }

    @Override
    public void atacarDrenaje() {
        System.out.println("Soy Bulbasur y estoy atacando con Drenaje");
    }

    @Override
    public void atacarHojaAfilada() {
        System.out.println("Soy Bulbasur y estoy atacando con Hoja Afilada");
    }

    @Override
    public void atacarLatigoCepa() {
        System.out.println("Soy Bulbasur y estoy atacando con Latigo Cepa");
    }
}
