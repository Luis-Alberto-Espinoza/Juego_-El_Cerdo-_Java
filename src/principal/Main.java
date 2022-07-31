package principal;

public class Main {
    public static void main(String[] args) {

        Juego juego;
        do {
            juego = new Juego();

            juego.pedidoDeDatos();
            juego.inicioJuego();
            juego.partida();
        } while (juego.jugarNuevamente()==0);
    }
}