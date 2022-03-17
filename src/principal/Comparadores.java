package principal;
import java.util.Comparator;

public class Comparadores {


    public static Comparator<Jugador> ordenarXturno = new Comparator<Jugador>() {
        @Override
        public int compare(Jugador o1, Jugador o2) {
            return o2.getvInicialDado().compareTo(o1.getvInicialDado());
        }
    };


    public static Comparator<Jugador> ordenarXpuntajetotal = new Comparator<Jugador>() {
        @Override
        public int compare(Jugador o1, Jugador o2) {
            return o2.getResultado().compareTo(o1.getResultado());
        }
    };


}
