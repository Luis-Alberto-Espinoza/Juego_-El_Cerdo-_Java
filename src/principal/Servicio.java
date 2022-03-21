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
                        "\n Hasta 6 participantes se permite en este juego","Vuelva a intentarlo");
            } else {
                resultado = vPedir(" Ingrese la cantidad de jugadores que participarán del juego:"," Cuantos jugadores seran?");
            }
            contador++;
        } while (!(validadCantidadJugadores(resultado)));
        return Integer.parseInt(resultado);
    }

    public static boolean validadCantidadJugadores(String datos) {

        return datos.matches("[1-6]");
    }

    public ArrayList<Jugador> pedirNombre(int n) {

        //Inicializamos los arrays con el numero de jugadores.
        jugadores = new String[n];
        tablaPuntuaciones = new int[n][5];

        //Pedimos nombres...

        System.out.println("\nIntroduzca nombres.");
        Object[] nombresArray = {"Automático", "Manual"};

        int respuetaNombres = JOptionPane.showOptionDialog(null, "La carga de nombres puede ser...", "Como cargar los nombres ", 0,
                JOptionPane.QUESTION_MESSAGE,
                null,
                nombresArray
                , "Automático");
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
                            "\n Este es el " + contadorErrores + "° error!!\n Solo se aceptan letras para el Nombre","Error!!! Vuelva a ingresar el nombre");
                } else {
                    nombre = vPedir("Ingrese el nombre del " + contador + "°  de los participantes", " Ingrese el nombre del participante");
                }
                contadorErrores++;
            } while (!(validarNombre(nombre)));
            contadorErrores = 0;
            contador++;
            participantes.add(new Jugador(nombre.toUpperCase()));
        }
        return participantes;
    }

    private ArrayList<Jugador> cargaAutomatica(int n) {
        String nombre;
        ArrayList<Jugador> participantes = new ArrayList();
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
        JOptionPane.showMessageDialog(null, texto, titulo,1);
    }

    public static String vPedir(String texto, String titulo) {
        return JOptionPane.showInputDialog(null, texto, titulo, 3);
    }

    public static int vPedirNum(String texto) {
        return Integer.parseInt(JOptionPane.showInputDialog(null, texto));
    }

    public String mensajeXjugada(ArrayList<Jugador> participante, int i, int jugada) {
        String mensaje = "";
        if (participante.get(i).getResultado() == 0 & participante.get(i).getParcial() == 0) {
            mensaje = ("JUGADOR=> " + participante.get(i).getNombre()
                    + "\nTira el dado y obtiene un => " + jugada
                    + "\nSi se planta ahora, el total sería => " + (participante.get(i).getResultado() + participante.get(i).getParcial() + jugada) + "\n");

        } else if (participante.get(i).getParcial() == 0 & participante.get(i).getResultado() > 0) {
            mensaje = ("JUGADOR=> " + participante.get(i).getNombre()
                    + "\nTira el dado y obtiene un => " + jugada
                    + "\nEl acumulado de rondas anteriores es => " + participante.get(i).getResultado()
                    + "\nSi se planta ahora, el total sería => " + (participante.get(i).getResultado() + participante.get(i).getParcial() + jugada) + "\n");

        } else if (participante.get(i).getParcial() > 0 & participante.get(i).getResultado() == 0) {
            mensaje = ("JUGADOR=> " + participante.get(i).getNombre()
                    + "\nTira el dado y obtiene un => " + jugada
                    + "\nEl anterior parcial es => " + participante.get(i).getParcial()
                    + "\nEl nuevo parcial es => " + (participante.get(i).getParcial() + jugada)
                    + "\nSi se planta ahora, el total sería => " + (participante.get(i).getResultado() + participante.get(i).getParcial() + jugada) + "\n");

        } else {
            mensaje = ("JUGADOR=> " + participante.get(i).getNombre()
                    + "\nTira el dado y obtiene un => " + jugada
                    + "\nEl anterior parcial es => " + participante.get(i).getParcial()
                    + "\nEl nuevo parcial es => " + (participante.get(i).getParcial() + jugada)
                    + "\nEl acumulado de rondas anteriores es => " + participante.get(i).getResultado()
                    + "\nSi se planta ahora, el total sería => " + (participante.get(i).getResultado() + participante.get(i).getParcial() + jugada) + "\n");
        }
        return mensaje;
    }

    public boolean validarNombre(String datos) {
        return datos.matches("[a-zA-Z]*");
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
                stringRetorno = String.valueOf(listaOrdenadaParticipantes.get(i).getNombre()) + " sacó en el dado, ";
            } else {
                stringRetorno = stringRetorno + String.valueOf(listaOrdenadaParticipantes.get(i).getNombre()) + " sacó en el dado, ";
            }
            stringRetorno = stringRetorno + listaOrdenadaParticipantes.get(i).getvInicialDado() + ", \n";
        }
        return stringRetorno;
    }

    public String listaStringParticipantesOrdenada(ArrayList<Jugador> listaOrdenadaParticipantes) {
        String stringRetorno = "";
        for (int i = 0; i < listaOrdenadaParticipantes.size(); i++) {
            if (i == 0)  {
                stringRetorno = String.valueOf(listaOrdenadaParticipantes.get(i).getNombre()) + " le tocó en el dado el ";
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
                stringRetorno = "EL PUESTO " + String.valueOf(listaOrdenadaParticipantes.get(i).getTurno()) + " es para, ";
            } else {
                stringRetorno += "EL PUESTO " + String.valueOf(listaOrdenadaParticipantes.get(i).getTurno()) + " es para, ";
            }
            stringRetorno += listaOrdenadaParticipantes.get(i).getNombre() + ", ";
            stringRetorno += " con " + String.valueOf(listaOrdenadaParticipantes.get(i).getResultado()) + " puntos ;\n";
        }
        return stringRetorno;
    }

    public String listaStringContadorNegativo(ArrayList<Jugador> listaParticipantes) {

        String stringRetorno = "\n";
        int contador = 0;
        for (int i = 0; i < listaParticipantes.size(); i++) {
            if (listaParticipantes.get(i).getContadorNegaivo() > 0) {
                contador++;
            }
        }
        for (int i = 0; i < listaParticipantes.size(); i++) {
            if (listaParticipantes.get(i).getContadorNegaivo() > 0) {
                if (contador == 1) {
                    if (listaParticipantes.get(i).getContadorNegaivo() == 1) {
                        stringRetorno += "El jugador que tuvo más mala suerte fué: " + (listaParticipantes.get(i).getNombre() + " que obtuvo #") +
                                (listaParticipantes.get(i).getContadorNegaivo() + " ves el uno en el dado");
                    } else {
                        stringRetorno += "El jugador que tuvo más mala suerte fué: " + (listaParticipantes.get(i).getNombre() + " que obtuvo #") +
                                (listaParticipantes.get(i).getContadorNegaivo() + " veces el uno en el dado");
                    }
                } else if (contador > 2) {
                    if (i == 0) {
                        stringRetorno += "Los jugadores que tuvieron más mala suerte fueron: \n" + (listaParticipantes.get(i).getNombre() + " que obtuvo #") +
                                (listaParticipantes.get(i).getContadorNegaivo() + " veces el uno en el dado \n");
                    }
                    if (i > 0) {
                        stringRetorno += (listaParticipantes.get(i).getNombre() + " que obtuvo #") +
                                (listaParticipantes.get(i).getContadorNegaivo() + " veces el uno en el dado \n");
                    }
                }
            }
        }
        if (contador == 0) {
            stringRetorno += "Que suerte a ningún participante le tocó el UNO en el dado";
        }
        return stringRetorno;
    }

    public void sorteoDeTurnos(ArrayList<Jugador> jugadoresParticipantes) {
        int[] vdt = new int[jugadoresParticipantes.size()];
        vdt = vectorDeTurnos(jugadoresParticipantes.size());
        for (int i = 0; i < jugadoresParticipantes.size(); i++) {
            jugadoresParticipantes.get(i).setvInicialDado(vdt[i]);
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

    public int validaPuntajeFinal() {
        Integer puntajeFinal = 0;
        String entrada = "";
        int contador = 0;
        boolean validado = false;
        boolean isNumeric = false;
        do {
            contador = 0;
            do {
                if (contador == 0) {
                    entrada = vPedir("Participantes pueden decidir ¿Cuál será el puntaje final?" +
                            "\nRecomendación entre 7 y 50 \n", "Puntaje Final!!!" );
                } else {
                    entrada = vPedir("Disculpe su ingreso no fue un número!!! \n Ingrese el puntaje final \n\n", " Error!!! Ingrese el puntaje final");
                }
                isNumeric = entrada.matches("[+-]?\\d*(\\.\\d+)?");
                contador++;
            } while (!isNumeric);
            puntajeFinal = Integer.parseInt(entrada);
            if (puntajeFinal < 7) {
                vMostrar("Disculpe su ingreso fué un número menor a 7!!! " +
                        "\n Ingrese el puntaje final \n ", "ERROR !!!!");
            }
            if (puntajeFinal > 6) {
                validado = true;
            }
        } while (!validado);
        return puntajeFinal;
    }
}