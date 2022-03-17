package principal;

import javax.swing.*;
import java.util.ArrayList;
import java.util.Locale;
import java.util.Random;
import java.util.Scanner;

public class Servicio {
    Scanner teclado = new Scanner(System.in);
    static String[] jugadores;
    static int[][] tablaPuntuaciones;
    int n;
//metodo aleatorio entere 1 y 6

    public int random() {
        return (int) ((Math.random() * 6) + 1);
    }



    public static int CantidadDeJugadores() {
        String resultado;
        int contador = 0;
        boolean valideitor;
        //   pedir la cantidad de jugadores
        do {
            if (contador > 0) {
                resultado = vPedir(" Disculpe ingresó una opción incorrecta\nIngrese la cantidad de jugadores que participarán:" +
                        "\n Hasta 6 participantes se permite en este juego");
            } else {
                resultado = vPedir(" Ingrese la cantidad de jugadores que participarán del juego:");
            }
            contador++;
        } while (!(validadCantidadJugadores(resultado)));
        return Integer.parseInt(resultado);
    }

    public ArrayList<Jugador> pedirNombre(int n) {

        //Inicializamos los arrays con el numero de jugadores.
        jugadores = new String[n];
        tablaPuntuaciones = new int[n][5];

        //Pedimos nombres...
        System.out.println("\nIntroduzca nombres.");
        Object[] nombresArray = {"Automatico", "Manual"};

        int respuetaNombres = JOptionPane.showOptionDialog(null, "La carga de nombres puede ser...", "Como cargar los nombres ", 0,
                JOptionPane.QUESTION_MESSAGE,
                null,
                nombresArray
                , "Automatico");
        if (respuetaNombres == 0) {
            return cargaAutomatica(n);
        } else {
            return cargaManual(n);
        }

    }

    private ArrayList<Jugador> cargaManual(int n) {
        ArrayList<Jugador> participantes = new ArrayList();
        String nombre;
        int contador = 1;
        int contadorErrores = 0;
        for (int i = 0; i < n; i++) {
            do {
                if (contadorErrores > 0) {
                    nombre = vPedir("Ingrese el nombre del " + contador + "°  de los participantes+" +
                            "\n Este es el " + contadorErrores + "° error!!\n Solo se aceptan letras para el Nombre");
                } else {
                    nombre = vPedir("Ingrese el nombre del " + contador + "°  de los participantes");
                }
                contadorErrores++;
            } while (!(validarNombre(nombre)));
            contadorErrores = 0;
            contador++;
            participantes.add(new Jugador(nombre));
        }
        return participantes;
    }


    private ArrayList<Jugador> cargaAutomatica(int n) {
        String nombre;
        ArrayList<Jugador> participantes = new ArrayList();
        String[] nombreAleatorio = {"alberto", "espinoza", "morales", "micielli", "moron"};
        for (int i = 0; i < n; i++) {
            participantes.add(new Jugador(boot()[i].toUpperCase()));
        }
        return participantes;
    }


    public static String[] boot() {
        String[] boots = new String[6];
        boots[0] = "luis";
        boots[1] = "alberto";
        boots[2] = "espinoza";
        boots[3] = "morales";
        boots[4] = "natalia";
        boots[5] = "malena";
        return boots;
    }

    public static void vMostrar(String texto, String titulo) {
        JOptionPane.showMessageDialog(null, texto, titulo, 0);
    }

    public static String vPedir(String texto) {
        return JOptionPane.showInputDialog(null, texto);
    }

    public static int vPedirNum(String texto) {
        return Integer.parseInt(JOptionPane.showInputDialog(null, texto));
    }

    public boolean validarNombre(String datos) {
        return datos.matches("[a-zA-Z]*");
    }

    public static boolean validadCantidadJugadores(String datos) {

        return datos.matches("[1-6]");
    }

    public ArrayList<Jugador> ordenarConsecutivosTurnos(ArrayList<Jugador> jugadoresParticipantes) {
        for (int i = 0; i < jugadoresParticipantes.size(); i++) {
            jugadoresParticipantes.get(i).setTurno(i + 1);
        }
        return jugadoresParticipantes;
    }

    public String listaStringParticipantes(ArrayList<Jugador> listaOrdenadaParticipantes) {
        String stringRetorno = "";
        for (int i = 0; i < listaOrdenadaParticipantes.size(); i++) {
            if (i == 0) {
                stringRetorno =  String.valueOf(listaOrdenadaParticipantes.get(i).getNombre()) + " sacó en el dado, ";
            } else {
                stringRetorno = stringRetorno + String.valueOf(listaOrdenadaParticipantes.get(i).getNombre()) + " sacó en el dado, ";
            }
            stringRetorno = stringRetorno + listaOrdenadaParticipantes.get(i).getvInicialDado() + ", \n";
//            stringRetorno = stringRetorno + String.valueOf(listaOrdenadaParticipantes.get(i).getParcial()) + ", ";
//            stringRetorno = stringRetorno + String.valueOf(listaOrdenadaParticipantes.get(i).getResultado()) + ";\n";
        }
        return stringRetorno;
    }
    public String listaStringParticipantesOrdenada(ArrayList<Jugador> listaOrdenadaParticipantes) {
        String stringRetorno = "";
        for (int i = 0; i < listaOrdenadaParticipantes.size(); i++) {
            if (i == 0) {
                stringRetorno =  String.valueOf(listaOrdenadaParticipantes.get(i).getNombre()) + " le tocó en el dado el ";
            } else {
                stringRetorno = stringRetorno + String.valueOf(listaOrdenadaParticipantes.get(i).getNombre()) + " le tocó en el dado el ";
            }
            stringRetorno = stringRetorno + listaOrdenadaParticipantes.get(i).getvInicialDado() + " , le corresponde el turno #";
//            stringRetorno = stringRetorno + String.valueOf(listaOrdenadaParticipantes.get(i).getParcial()) + ", ";
            stringRetorno = stringRetorno + String.valueOf(listaOrdenadaParticipantes.get(i).getTurno()) + ";\n";
        }
        return stringRetorno;
    }

    public String listaStringParticipantesGanadores(ArrayList<Jugador> listaOrdenadaParticipantes) {
        String stringRetorno = "";
        for (int i = 0; i < listaOrdenadaParticipantes.size(); i++) {
            if (i == 0) {
                stringRetorno = String.valueOf(listaOrdenadaParticipantes.get(i).getTurno()) + ", ";
            } else {
                stringRetorno = stringRetorno + String.valueOf(listaOrdenadaParticipantes.get(i).getTurno() + ", ");
            }
            stringRetorno = stringRetorno + listaOrdenadaParticipantes.get(i).getNombre() + ", ";
            stringRetorno = stringRetorno + String.valueOf(listaOrdenadaParticipantes.get(i).getResultado()) + ";\n";
        }
        return stringRetorno;
    }

    public void sorteoDeTurnos(ArrayList<Jugador> jugadoresParticipantes) {
        int[] vdt = new int[jugadoresParticipantes.size()];
        vdt = vectorDeTurnos(jugadoresParticipantes.size());
        for (int i = 0; i < jugadoresParticipantes.size(); i++) {
            jugadoresParticipantes.get(i).setvInicialDado(vdt[i]);
           // System.out.println("*********"+jugadoresParticipantes.get(i).setTurno(vdt[i]));
        }
    }

    public int[] vectorDeTurnos(int cant) {
        int[] vectorTurnosValidados = new int[cant];
        vectorTurnosValidados[0] = tirarDados();
        for (int i = 1; i < cant; i++) {
            vectorTurnosValidados[i] = tirarDados();
            for (int j = 0; j < i; j++) {
                if (vectorTurnosValidados[i] == vectorTurnosValidados[j]) {
                    i--;
                }
            }
        }
        return vectorTurnosValidados;
    }

    public int tirarDados() {
        return random();
    }

    public void turnoXpodio(ArrayList<Jugador> listaOrdenadaParticipantes) {
        for (int i = 0; i < listaOrdenadaParticipantes.size(); i++) {
            listaOrdenadaParticipantes.get(i).setTurno(i + 1);
        }
    }


//    public boolean comprobarGanador(ArrayList<Jugador> listaOrdenadaParticipantes) {
//        if (jugadoresParticipantes.get(i).getResultado() >= 20) {
//            System.out.println("HAY UN GANADOR!!!!");
//            System.out.println("el ganador es " + jugadoresParticipantes.get(i).getNombre());
//            hayGanador = true;
//            break;
//
//        }
//    }
}