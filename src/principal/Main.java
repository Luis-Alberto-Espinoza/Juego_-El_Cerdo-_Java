package principal;

public class Main {
    public static void main(String[] args) {
//          System.out.printf("Jugador #%d: ", (i + 1));
//			System.out.printf("Jugador #%d: ", (i+1));
        Juego juego = new Juego();
        Servicio servicio = new Servicio();
        juego.pedidoDeDatos();
        juego.inicioJuego();
        juego.partida();
    }
}