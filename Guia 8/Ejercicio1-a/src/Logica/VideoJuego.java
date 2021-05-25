package Logica;

public class VideoJuego {
    
    private String codigo;
    private String titulo;
    private String consola;
    private int cantidadJugadores;
    private String categoria;

    public VideoJuego() {
    }
    
    public VideoJuego(String codigo, String titulo, String consola, int cantidadJugadores, String categoria) {
        this.codigo = codigo;
        this.titulo = titulo;
        this.consola = consola;
        this.cantidadJugadores = cantidadJugadores;
        this.categoria = categoria;
    }

    public int getCantidadJugadores() {
        return cantidadJugadores;
    }

    public String getCategoria() {
        return categoria;
    }

    public String getCodigo() {
        return codigo;
    }

    public String getConsola() {
        return consola;
    }

    public String getTitulo() {
        return titulo;
    }

    public void setCantidadJugadores(int cantidadJugadores) {
        this.cantidadJugadores = cantidadJugadores;
    }

    public void setCategoria(String categoria) {
        this.categoria = categoria;
    }

    public void setCodigo(String codigo) {
        this.codigo = codigo;
    }

    public void setConsola(String consola) {
        this.consola = consola;
    }

    public void setTitulo(String titulo) {
        this.titulo = titulo;
    }
}
