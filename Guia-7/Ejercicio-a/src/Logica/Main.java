package Logica;

public class Main {

    public static void main(String[] args) {
        
        Auto autoParam_1 = new Auto("rojo", "renault", "2018", "abc123", 5);
        Auto autoParam_2 = new Auto("azul", "bmw", "2016", "asd444", 4);
        Auto autoParam_3 = new Auto("verde", "lamborghini", "2020", "zxc612", 3);
        
        Auto autoNoParam = new Auto();
        
        System.out.println("Auto con parametros 1: " + 
                autoParam_1.getMarca() + " / " + 
                autoParam_1.getModelo() + " / " +
                autoParam_1.getPatente());
        
        System.out.println("Auto con parametros 2: " + 
                autoParam_2.getMarca() + " / " + 
                autoParam_2.getModelo() + " / " +
                autoParam_2.getPatente());
        
        System.out.println("Auto con parametros 3: " + 
                autoParam_3.getMarca() + " / " + 
                autoParam_3.getModelo() + " / " +
                autoParam_3.getPatente());
        
        System.out.println("Auto sin parametros: " + autoNoParam.getMarca());
    }
    
}
