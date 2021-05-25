package Logica;

public abstract class Pokemon {
    
    protected int num_pokedex;
    protected String nombrePokemon;
    protected double pesoPokemon;
    protected String sexo;
    protected String temporadaQueAparece;
    protected String tipo;

    public Pokemon() {
    }

    public Pokemon(int num_pokedex, String nombrePokemon, double pesoPokemon, String sexo, String temporadaQueAparece, String tipo) {
        this.num_pokedex = num_pokedex;
        this.nombrePokemon = nombrePokemon;
        this.pesoPokemon = pesoPokemon;
        this.sexo = sexo;
        this.temporadaQueAparece = temporadaQueAparece;
        this.tipo = tipo;
    }
    
    public abstract void atacarPlacaje();
    
    public abstract void atacarArañazo();
    
    public abstract void atacarMordisco();

    public String getNombrePokemon() {
        return nombrePokemon;
    }

    public int getNum_pokedex() {
        return num_pokedex;
    }

    public double getPesoPokemon() {
        return pesoPokemon;
    }

    public String getSexo() {
        return sexo;
    }

    public String getTemporadaQueAparece() {
        return temporadaQueAparece;
    }

    public String getTipo() {
        return tipo;
    }

    public void setNombrePokemon(String nombrePokemon) {
        this.nombrePokemon = nombrePokemon;
    }

    public void setNum_pokedex(int num_pokedex) {
        this.num_pokedex = num_pokedex;
    }

    public void setPesoPokemon(double pesoPokemon) {
        this.pesoPokemon = pesoPokemon;
    }

    public void setSexo(String sexo) {
        this.sexo = sexo;
    }

    public void setTemporadaQueAparece(String temporadaQueAparece) {
        this.temporadaQueAparece = temporadaQueAparece;
    }

    public void setTipo(String tipo) {
        this.tipo = tipo;
    }
    
    
}
