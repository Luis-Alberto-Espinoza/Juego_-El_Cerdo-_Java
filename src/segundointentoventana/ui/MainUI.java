package segundointentoventana.ui;

import principal.Jugador;

import javax.swing.*;
import javax.swing.table.DefaultTableCellRenderer;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableColumnModel;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

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
                {1, "Na", 2, 3},
                {5, "lu", 6, 7},
                {12, "Ma", 11, 14}
        };
        return matrizBots;
    }

    public void llenarMatriz(ArrayList<Jugador> jugador) {
        /*video111*/
        ArrayList<String> escritores = new ArrayList<>();
        escritores.add("jn");
        escritores.add("oz");
        escritores.add("as");

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
            System.out.println(i.getNombre() + ", " + i.getId() + " esto es fore de jugador nombre y id");
        }
        System.out.println("");

    }


    //    public void createTable(ArrayList<Jugador> lista) {
    public void createTable(Object[][] matrizCargadaBots) {
//    public void createTable() {

        Object[][] natalia = {
                {}
        };
        showTable.setModel(new DefaultTableModel(

                natalia,
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
