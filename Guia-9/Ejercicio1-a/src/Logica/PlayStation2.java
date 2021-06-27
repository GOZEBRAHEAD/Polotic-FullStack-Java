package Logica;

public class PlayStation2 extends Consola {
    
    private String norma;
    private boolean chipeadaONo;
    private String tamanioMemoryCard;

    public PlayStation2() {
    }

    public PlayStation2(String norma, boolean chipeadaONo, String tamanioMemoryCard) {
        this.norma = norma;
        this.chipeadaONo = chipeadaONo;
        this.tamanioMemoryCard = tamanioMemoryCard;
    }

    @Override
    public void cargarJuego() {
        System.out.println("Cargando juego de PlayStation2, por favor espere.");
    }
    
    public void leerDVD(String nombreJuego) {
        System.out.println("Leyendo DVD " + nombreJuego);
        
        cargarJuego();
    }
    
    public void grabarEnMemoryCard() {
        System.out.println("El juego fue correctamente guardado en la Memory Card.");
    }

    public String getNorma() {
        return norma;
    }

    public boolean getChipeadaONo() {
        return chipeadaONo;
    }

    public String getTamanioMemoryCard() {
        return tamanioMemoryCard;
    }

    public void setChipeadaONo(boolean chipeadaONo) {
        this.chipeadaONo = chipeadaONo;
    }

    public void setNorma(String norma) {
        this.norma = norma;
    }
}
