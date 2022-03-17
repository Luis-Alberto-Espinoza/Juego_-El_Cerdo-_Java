package principal;

import segundointentoventana.StartFrameUi;
import segundointentoventana.ui.MainUI;

import javax.swing.*;
import java.util.ArrayList;

public class Juego {
    boolean hayGanador = false;
    Servicio servicio = new Servicio();
    static int puntajeFinal;
    static ArrayList<Jugador> jugadoresParticipantes;
    public static ArrayList<Jugador> listaOrdenadaParticipantes;
    Comparadores comparadores = new Comparadores();
    int contadorRondas;
    /**/
    MainUI mainUI = new MainUI();
    /**/

    public void pedidoDeDatos() {

        /*Se pide el puntaje final del juego*/
        puntajeFinal = servicio.vPedirNum("Participantes pueden decidir ¿Cuál será el puntaje final?\nRecomendación no más de 50");

        /*Se pide Cantidad de Participantes*/
        int cant = servicio.CantidadDeJugadores();

        /*se pide los nombres de los participantes*/
        jugadoresParticipantes = servicio.pedirNombre(cant);
    }

    public void inicioJuego() {

        /*Sorteo de Turnos*/
        servicio.vMostrar("Tiramos los dados para cada jugador, así determinamos el orden de turnos", "ATENCIÓN!!!");
        servicio.sorteoDeTurnos(jugadoresParticipantes);

        /*Muestra: nombre y turno de lo que hay en la lista*/
        servicio.vMostrar(servicio.listaStringParticipantes(jugadoresParticipantes), "Inscripción de participantes");
        System.out.println("Inscripción de participantes\n" + servicio.listaStringParticipantes(jugadoresParticipantes));

        /*Ordenar las Listas según el turno*/
        String getTurno = "getTurno()";
        jugadoresParticipantes.sort(Comparadores.ordenarXturno); //De mayor a menor; de acuerdo al número que sacó en el dado
        listaOrdenadaParticipantes = servicio.ordenarConsecutivosTurnos(jugadoresParticipantes);//Se setea el valor del turno correspondiente en el juego

        /*Muestra: la lista de nombres ordenada por su turno correspondiente */
        servicio.vMostrar(servicio.listaStringParticipantesOrdenada(listaOrdenadaParticipantes), "Lista ordenada por turnos");
        System.out.println("lista Ordenada por Turnos\n" + servicio.listaStringParticipantesOrdenada(listaOrdenadaParticipantes));

        /* Mostrar las reglas basicas del juego */
        servicio.vMostrar("Comienza la partida. De acuerdo al turno se ira tirando de a un dado a la vez\n" +
                "El puntaje que salga se ira almacenando en 'Puntaje Parcial'.\n" +
                "Hasta que el jugador se plante\n" +
                "Si el valor del dado es un '1' se perderá el 'Acumulado Parcial'. ", "Comienza la partida!!!");
    }

    /* !!!COMIENZA LA PARTIDA!!!!! */
    public void partida() {

        ///declaracion de la decision del participantede plantarse o seguir
        boolean plantarse = false;
        int contador = 0;

        do {
            for (int i = 0; i < jugadoresParticipantes.size(); i++) {
                Integer total = 0;
                listaOrdenadaParticipantes.get(i).setParcial(0);

                /* contabilizamos las rondas jugadas cada vez que el primer participante juega */
                if (i == 0){
                    contadorRondas++ ;
                }

                if (hayGanador) {
                    break;
                }
                do {
                    int nuevoParcial = 0;
                    plantarse = false;

                    /*De acuerdo al turno Obtenido se tira el dado */
                    int jugada = servicio.tirarDados();

                    /*Si sale 1 - Pierde el turno y no se acumula lo de esta ronda*/
                    if (jugada == 1) {

                        /*se setea el acumulado parcial a cero*/
                        jugadoresParticipantes.get(i).setParcial(0);

                        /*Muestra el mesaje x JOPane*/
                        servicio.vMostrar(listaOrdenadaParticipantes.get(i).getNombre().toUpperCase() +
                                "\nEl dado marcó UNO (1) no se suma en esta ronda, \nContinua el siguiente jugador", "Que mala suerte");
                        /*Muestra el mesaje x consola*/
                        System.out.println();
                        System.out.println(listaOrdenadaParticipantes.get(i).getNombre().toUpperCase() + " saco un uno en el dado");
                        break;

                        /*Si el numero del dado es distinto a 1*/
                    } else {
                        /*muestra el cartel de: el turno, el nombre en mayusculas, y lo que devuelve la tirada de dados */
                        servicio.vMostrar("El participante #" + listaOrdenadaParticipantes.get(i).getTurno() + " ==> " + listaOrdenadaParticipantes.get(i).getNombre().toUpperCase()
                                + " \nObtuvo en el dado, el número => " + jugada, "Tirada de Dados");


                        /*  //MENSAJE QUE SALE POR CONSOLA
                        System.out.println("");
                        System.out.println("NUEVO JUGADOR " + listaOrdenadaParticipantes.get(i).getNombre());
                        System.out.println(listaOrdenadaParticipantes.get(i).getParcial() + "=== parcial inicial");
                        System.out.println(listaOrdenadaParticipantes.get(i).getResultado() + "=== resultado inicial");
                        System.out.println("esta es la jugada " + jugada);
                        System.out.println(listaOrdenadaParticipantes.get(i).getParcial() + jugada + "=== parcial + jugada");
                         */

                        /* SE MUESTRA EL RESULTADO PARCIAL DE LA ULTIMA TIRADA DE DADOS DEL JUGADOR EN CURSO
                         *  */
                        servicio.vMostrar("NUEVO JUGADOR " + listaOrdenadaParticipantes.get(i).getNombre() + "\n" +
                                listaOrdenadaParticipantes.get(i).getParcial() + "=== el acumulado del turno es: \n" +
                                listaOrdenadaParticipantes.get(i).getResultado() + "=== acumulado de las rondas anteriores\n" +
                                "el obtenido en la jugada " + jugada + "\n" +
                                (listaOrdenadaParticipantes.get(i).getParcial() + jugada) + "=== acumulado + jugada", "RESULTADO PARCIAL");


                        /*Se setea el parcial = parcial + nueva jugada*/
                        listaOrdenadaParticipantes.get(i).setParcial(listaOrdenadaParticipantes.get(i).getParcial() + jugada);
                        System.out.println(listaOrdenadaParticipantes.get(i).getParcial() + "=== parcial nuevo");

                        /*se guarda en variables locales lo que trae el parcial y el total*/
                        nuevoParcial = listaOrdenadaParticipantes.get(i).getParcial();
                        total = listaOrdenadaParticipantes.get(i).getResultado();
                        System.out.println("parcial--> " + nuevoParcial + " TOTAL--> " + total);


                        /*Si el total + parcial superan o igualan la constante puntaje final. entonces hay Ganador*/
                        if ((nuevoParcial + total) >= puntajeFinal) {
                            plantarse = true;
                            hayGanador = true;
                            break;
                        }

                        /*Se consulta si desea plantarse o continuar*/
                        int resp;
                        String[] arreglo = {"Plantarse", "Continuar"};
                        resp = JOptionPane.showOptionDialog(null, "deseas continuar",
                                listaOrdenadaParticipantes.get(i).getNombre(), 0,
                                JOptionPane.QUESTION_MESSAGE, null, arreglo, "Continuar");
                        if ((0 == resp)) {
                            plantarse = true;
                            //listaOrdenadaParticipantes.get(i).setResultado(listaOrdenadaParticipantes.get(i).getParcial());
                            break;
                        }
                        if (hayGanador) {
                            break;

                        }
                    }
                } while (!(plantarse));//se repite hasta que desee plantarse

                /*Se setea el resultado= con el resultado + el acumulado de la ultima jugada*/
                listaOrdenadaParticipantes.get(i).setResultado(listaOrdenadaParticipantes.get(i).getResultado()
                        + listaOrdenadaParticipantes.get(i).getParcial());
                //mainUI.llenarMatriz(jugadoresParticipantes);

            }
        } while (!hayGanador);//si hay ganador se termina el juego

        /*Se ordena la lista de los participantes de acuerdo a su puntaje final */
        listaOrdenadaParticipantes.sort(Comparadores.ordenarXpuntajetotal); //De mayor a menor

        /*Modificar columna turno por podio*/
        servicio.turnoXpodio(listaOrdenadaParticipantes);

        /*se muestra lista de ganadores. En formato de String*/
        servicio.vMostrar("Hay ganador  ==>  "
                + servicio.listaStringParticipantesGanadores(listaOrdenadaParticipantes)+"\nSe jugaron "+contadorRondas+" rondas" , "Hay ganador");
        System.out.println("\nHay ganador  ==>  "+ servicio.listaStringParticipantesGanadores(listaOrdenadaParticipantes)
                +"\nSe jugaron "+contadorRondas+" rondas");
    }
}

