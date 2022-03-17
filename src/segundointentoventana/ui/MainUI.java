package segundointentoventana.ui;

import principal.Jugador;

import javax.swing.*;
import javax.swing.table.DefaultTableCellRenderer;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableColumnModel;
import java.util.ArrayList;

public class MainUI {
    private JPanel rootPanel;
    private JTable showTable;
    private JLabel labelTitle;
    private JList list1;
    private JButton button1;
    private JButton button2;

    public MainUI() {
        createTable(matrizCargadaBots());
    }

    public Object[][] matrizCargadaBots() {
        Object[][] matrizBots = {
                {1, "Natalia", 2, 3},
                {5, "luis", 6, 7},
                {12, "Malena", 11, 14}
        };
        return matrizBots;
    }

    public void llenarMatriz(ArrayList<Jugador> jugador) {
        /*video111*/
        ArrayList<String> escritores = new ArrayList<>();
        escritores.add("john");
        escritores.add("ortiz");
        escritores.add("ordoñes");

        for (String luis :
                escritores) {
            System.out.println(luis + " String");
        }
        System.out.println("");

        Object[] escritoresObject = escritores.toArray();
        for (Object luis :
                escritoresObject) {
            System.out.println(luis + " Object");
        }
        System.out.println("");

        String[] escritoresString = (String[]) escritores.toArray(new String[0]);
        for (String luis :
                escritoresString) {
            System.out.println(luis + "  escritoresString");
        }
        System.out.println("");
        /*fin video 111*/
        /*pureba con lista de jugadores*/
        for (Jugador i :
                jugador) {
            System.out.println(i.getNombre() + ", " + i.getvInicialDado() + " esto es fore de jugador nombre y id");
        }
        System.out.println("");

//        Object[][] natalia = {
//                {"malena", "te quiero", "mucho", "toda la vida"},
//                {"malena", "te quiero", "mucho", "toda la vida"},
//                {"malena", "te quiero", "mucho", "toda la vida"},
//
//        };
//        for (Object i :
//                natalia) {
//            System.out.println(i.toString() + " i");
//        }
//        System.out.println("");
//        for (int i = 0; i < escritoresString.length ; i++) {
//            for (int j = 0; j < 4; j++) {
//               // System.out.println(escritoresString[i][j] + " doble for a un Object");
//
//            }
//
//        }

//
//        Object[][] tablaCompleta = new Object[jugador.size()][];
//        System.out.println("llegue");
//        for (int i = 1; i < jugador.size(); i++) {
//            for (int j = 0; j < 3; j++) {
//
////                tablaCompleta[i][j] = new String[]{jugador.get(i).getNombre()};
//////            tablaCompleta[i[j] = new Sorti[]{jugador.get(i).getId()};
////                tablaCompleta[i][j] = new String[]{String.valueOf(jugador.get(i).getTurno())};
////                tablaCompleta[i][j] = new String[]{String.valueOf(jugador.get(i).getResultado())};
//
//
//            }
//        }

//
//        for (int i = 0; i < tablaCompleta.length; i++) {
//            for (int j = 0; j < 4; j++) {
//
//            System.out.println(tablaCompleta[i][j]);
//            }
//        }
//
//        for (Object luis :
//        natalia) {
//            System.out.println(luis..toString() + "  escritoresString");
//        }
//        System.out.println("");


        /*fin prueba jugadores*/

//
//        System.out.println("esto es de el metodo llenar matriz = tamaño "+jugador.size());
//        Object[] tablaCompleta =new Object [jugador.size()];
//        tablaCompleta  = jugador.stream().toArray(Jugador[]::new);
        // tablaCompleta  = jugador.toArray(tablaCompleta);
        /**/

        // String[] res = (String[]) jugador.toArray( new String[0]);
        // System.out.println(Arrays.stream(res).iterator()+" ----<<<<<");
        //jugador.toArray(res);
        /**/

//        for (int i = 0; i < res.length; i++) {
//            System.out.println(jugador.get(i).getNombre()+jugador.get(i).getResultado() +" <==");
////            System.out.println(String.valueOf(res[i])+" <==");
//        }

//        for (Jugador luis :
//                jugador) {
//            System.out.println(luis);
//        }

//        System.out.println(jugador.size() + "  ===== <<<===");

//        for (int i = 0; i < jugador.size(); i++) {
////        System.out.println("==> 0 viene de el for " + String.valueOf(jugador.get(i).getTurno()));
//             tablaCompleta [i][]  {
//                    {String.valueOf(jugador.get(i).getTurno()),
//                            jugador.get(i).getNombre(),
//                            String.valueOf(jugador.get(i).getParcial()),
//                            String.valueOf(jugador.get(i).getResultado())}};
//        }
//            System.out.println(tablaCompleta[0][0]);
//            System.out.println(tablaCompleta[1][0]);
//            System.out.println(tablaCompleta[2][0]);
//            System.out.println(tablaCompleta[3][0]);

//        tablaCompleta[i][2] = String.valueOf(jugador.get(i).getParcial());
//        tablaCompleta[i][3] = String.valueOf(jugador.get(i).getResultado());
//        System.out.println("==> 1 viene de el for " + tablaCompleta[i][1]);
//        System.out.println("==> 2 viene de el for " + tablaCompleta[i][2]);
//        System.out.println("==> 3 viene de el for " + tablaCompleta[i][3]);
//        createTable(tablaCompleta);
//        }

    }


    //    public void createTable(ArrayList<Jugador> lista) {
    public void createTable(Object[][] matrizCargadaBots) {
//    public void createTable() {

        Object[][] natalia = {

                {}

//                {"malena", "te quiero", "mucho", "toda la vida"},
//                {"malena", "te quiero", "mucho", "toda la vida"},
//                {"malena", "te quiero", "mucho", "toda la vida"},

        };
        showTable.setModel(new DefaultTableModel(
//              matrizLlena,
                //          matrizCargadaBots,
                natalia,
                // null,
                new String[]{"Turno", "Nombre", "Puntaje Parcial", "Puntaje Total"}
        ));

        TableColumnModel tableColumnModel = showTable.getColumnModel();
        tableColumnModel.getColumn(0).setMinWidth(20);

        DefaultTableCellRenderer centerRender = new DefaultTableCellRenderer();
        centerRender.setHorizontalAlignment(JLabel.CENTER);
        tableColumnModel.getColumn(0).setCellRenderer(centerRender);
        tableColumnModel.getColumn(1).setCellRenderer(centerRender);
        tableColumnModel.getColumn(2).setCellRenderer(centerRender);
        tableColumnModel.getColumn(3).setCellRenderer(centerRender);


    }

    public JPanel getRootPanel() {
        return rootPanel;

    }

    private void createUIComponents() {
        // TODO: place custom component creation code here
    }

    public void prueba() {

    }
}