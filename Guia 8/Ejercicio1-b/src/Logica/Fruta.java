/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Logica;

public class Fruta {
    
    private String nombre;
    private String color;
    private int calorias;
    private String tipoCascara;
    private boolean esComestible;

    public Fruta() {
    }
    
    public Fruta(String nombre, String color, int calorias, String tipoCascara, boolean esComestible) {
        this.nombre = nombre;
        this.color = color;
        this.calorias = calorias;
        this.tipoCascara = tipoCascara;
        this.esComestible = esComestible;
    }

    public int getCalorias() {
        return calorias;
    }

    public String getColor() {
        return color;
    }

    public String getNombre() {
        return nombre;
    }

    public String getTipoCascara() {
        return tipoCascara;
    }

    public boolean getEsComestible() {
        return esComestible;
    }

    public void setCalorias(int calorias) {
        this.calorias = calorias;
    }

    public void setColor(String color) {
        this.color = color;
    }

    public void setEsComestible(boolean esComestible) {
        this.esComestible = esComestible;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public void setTipoCascara(String tipoCascara) {
        this.tipoCascara = tipoCascara;
    }
}
