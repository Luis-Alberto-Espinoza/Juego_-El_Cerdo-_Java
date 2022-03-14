package principal;

import segundointentoventana.StartFrameUi;
import segundointentoventana.ui.MainUI;

import javax.swing.*;
import java.util.ArrayList;

public class Juego {
    boolean hayGanador = false;
    Servicio servicio = new Servicio();

    Comparadores comparadores = new Comparadores();


    int dado;
    int turno;
    int cant = 2;

    /**/
    MainUI mainUI = new MainUI();
    /**/
    public static ArrayList<Jugador> listaOrdenadaParticipantes;


    public void inicioJuego() {
        ArrayList<Jugador> jugadoresParticipantes;

        String stringListaordenada;

        int contador = 0;

        /*Se pide el puntaje final del juego*/
//        int puntajeFinal = 20;///////////////////////////////////////falta pedir el fin del juego
        int puntajeFinal = servicio.puntajeFinal();

        /*Cantidad de Participantes*/
        int cant = servicio.CantidadDeJugadores();

        /*se pide los nombres de los participantes*/
        jugadoresParticipantes = servicio.pedirNombre(cant);

        /*Sorteo de Turnos*/
        servicio.vMostrar("Tiramos los dados para cada jugador, asi determinamos el orden de turnos", "ATENCIÓN!!!");
        servicio.sorteoDeTurnos(jugadoresParticipantes);

        /*Muestra: nombre y turno de lo que hay en la lista*/
        servicio.vMostrar(servicio.listaStringParticipantes(jugadoresParticipantes), "Inscripción de participantes");

        /*Ordenar las Listas*/
        String getTurno = "getTurno()";
        jugadoresParticipantes.sort(Comparadores.ordenarXturno); //De mayor a menor; de acuerdo al número que sacó en el dado
        listaOrdenadaParticipantes = servicio.ordenarConsecutivosTurnos(jugadoresParticipantes);//Se setea el valor del turno correspondiente en el juego

        /*
        stringListaordenada = servicio.listaStringParticipantes(listaOrdenadaParticipantes); //Se guarda en un estring todos los datos en formato tabla
        System.out.println(stringListaordenada+ "-----lo de lista ordenada-----");

         */



        //servicio.vMostrar("La lista ordenada por turnos queda de la siguiente manera\n" + stringListaordenada);
        servicio.vMostrar(servicio.listaStringParticipantes(listaOrdenadaParticipantes), "lista Ordenada por Turnos");



         StartFrameUi starFrame = new StartFrameUi();
          starFrame.inicioFrame();
        starFrame.createGUI();

         mainUI.llenarMatriz(jugadoresParticipantes);




        ////muestra: nombre y turno de lo que hay en la lista
        int cont = 1;
        for (Jugador jugador :
                jugadoresParticipantes) {
            //int resp = JOptionPane.showConfirmDialog(null,"Estas seguro?");//Mensaje de confirmacion YES NO Question
            Servicio.vMostrar("EL turno n°" + cont + " le corresponde a => " + jugador.getNombre() + " que sacó en el dado el => " + jugador.getTurno(),"plapla");
            cont++;
        }
        servicio.vMostrar("Comienza la partida. De acuerdo al turno se ira tirando de a un dado a la vez\n" +
                "El puntaje que salga se ira almacenando en 'Puntaje Parcial'.\n" +
                "Hasta que el jugador se plante\n" +
                "Si el valor del dado es un '1' se perderá el 'Acumulado Parcial'. ", "Comienza la partida!!!");
        /////

///////declaracion de la decicion del participantede plantarse o seguir
        boolean plantarse = false;
        int contaderesco = 0;

        do {
            for (int i = 0; i < jugadoresParticipantes.size(); i++) {
                Integer total = 0;
                listaOrdenadaParticipantes.get(i).setParcial(0);
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
                                "\nEl dado marcó uno no se suma en esta ronda, \nContinua el siguiente jugador", "que mala suerte");
                        /*Muestra el mesaje x consola*/
                        System.out.println();
                        System.out.println("¨¨¨¨¨¨¨¨¨¨¨¨¨¨¨¨");
                        System.out.println(listaOrdenadaParticipantes.get(i).getNombre().toUpperCase() + " saco un  uno en el dado");
                        break;

                        /*Si el numero del dado es mayor a 1*/
                    } else {
                        System.out.println("");
                        System.out.println("NUEVO JUGADOR " + listaOrdenadaParticipantes.get(i).getNombre());
                        System.out.println(listaOrdenadaParticipantes.get(i).getParcial() + "=== parcial inicial");
                        System.out.println(listaOrdenadaParticipantes.get(i).getResultado() + "=== resultado inicial");
                        System.out.println("esta es la jugada " + jugada);
                        System.out.println(listaOrdenadaParticipantes.get(i).getParcial() + jugada + "=== parcial + jugada");

                        /*Se setea el parcial = parcial + nueva jugada*/
                        listaOrdenadaParticipantes.get(i).setParcial(listaOrdenadaParticipantes.get(i).getParcial() + jugada);
                        System.out.println(listaOrdenadaParticipantes.get(i).getParcial() + "=== parcial nuevo");

                        /*se guarda en variables locales lo que trae el parcial y el total*/
                        nuevoParcial = listaOrdenadaParticipantes.get(i).getParcial();
                        total = listaOrdenadaParticipantes.get(i).getResultado();
                        System.out.println("parcial--> " + nuevoParcial + " TOTAL--> " + total);

                        /*muestra el cartel de: el turno, el nombre en mayusculas, y lo que devuelve la tirada de dados */
                        servicio.vMostrar(listaOrdenadaParticipantes.get(i).getTurno() + " == " + listaOrdenadaParticipantes.get(i).getNombre().toUpperCase()
                                + " \nEl número del dado es => " + jugada, "Tiradad de Dados");

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
                + servicio.listaStringParticipantesGanadores(listaOrdenadaParticipantes), "Hay ganador");
        System.out.println("Hay ganador  ==>  "
                + servicio.listaStringParticipantesGanadores(listaOrdenadaParticipantes) + "Hay ganador");
    }
}

