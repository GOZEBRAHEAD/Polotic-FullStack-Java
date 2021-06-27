package Logica;

public class Ejercicio1A {

    public static void main(String[] args) {
        
        VideoJuego videojuegos[] = new VideoJuego[5];
        
        VideoJuego juego1 = new VideoJuego("1", "CS 1.6", "PC", 1, "FPS");
        VideoJuego juego2 = new VideoJuego("2", "Rocket League", "PC", 1, "Deporte");
        VideoJuego juego3 = new VideoJuego("3", "League of Legends", "PC", 1, "MOBA");
        VideoJuego juego4 = new VideoJuego("4", "Mario Bros", "Nintendo 64", 2, "Aventura");
        VideoJuego juego5 = new VideoJuego("5", "Far Cry 3", "PC", 1, "FPS/Aventura");
        
        videojuegos[0] = juego1;
        videojuegos[1] = juego2;
        videojuegos[2] = juego3;
        videojuegos[3] = juego4;
        videojuegos[4] = juego5;
        
        for (int i = 0; i < 5; i++) {
            
            System.out.println("Titulo: " + videojuegos[i].getTitulo() + 
                                " | Consola: " + videojuegos[i].getConsola() +
                                " | Cant. jugadores: " + videojuegos[i].getCantidadJugadores());
        }
        
        System.out.println("// ===================== //");
        System.out.println("Cambio de 2 videojuegos:");
        
        videojuegos[0].setTitulo("CSGO");
        videojuegos[0].setCantidadJugadores(10);
        
        videojuegos[3].setTitulo("Mario Kart");
        videojuegos[3].setCantidadJugadores(4);
        
        System.out.println("// ===================== //");
        
        for (int i = 0; i < 5; i++) {
            
            System.out.println("Codigo: " + videojuegos[i].getCodigo() +
                                " | Titulo: " + videojuegos[i].getTitulo() + 
                                " | Consola: " + videojuegos[i].getConsola() +
                                " | Cant. jugadores: " + videojuegos[i].getCantidadJugadores() + 
                                " | Categoria: " + videojuegos[i].getCategoria());
        }
        
        System.out.println("// ===================== //");
        System.out.println("Juegos que son de la consola 'Nintendo 64'");
        
        for (int i = 0; i < 5; i++) {
            
            if (!videojuegos[i].getConsola().equals("Nintendo 64")) {
                continue;
            }
            
            System.out.println("Codigo: " + videojuegos[i].getCodigo() +
                                " | Titulo: " + videojuegos[i].getTitulo() + 
                                " | Consola: " + videojuegos[i].getConsola() +
                                " | Cant. jugadores: " + videojuegos[i].getCantidadJugadores() + 
                                " | Categoria: " + videojuegos[i].getCategoria());
        }
    }
    
}
