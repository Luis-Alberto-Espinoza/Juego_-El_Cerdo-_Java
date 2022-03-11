package vistasgraficas.domingo;

import javax.swing.*;
import javax.swing.table.DefaultTableCellRenderer;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableColumnModel;

public class ventanasDomingo {
    private JPanel rootPanel;
    private JTable showTable;

    public ventanasDomingo(){

      //  crearTablaDomingo();

    }}
/*
    private void crearTablaDomingo() {
        Object matriz [][] = new String[jugador.size()][4];
        /*for (Jugador elemento :
                jugador) {
            elemento.getNombre() + " tira el Dado y le sale el número =>  " + jugador.getTurno());
        }
        for (int i = 0; i < jugador.size(); i++) {
            matriz[i][0] = String.valueOf(jugador.get(i).getTurno());
            matriz[i][1] = jugador.get(i).getNombre();
            matriz[i][2] = String.valueOf(jugador.get(i).getParcial());
            matriz[i][3] = String.valueOf(jugador.get(i).getResultado());
            System.out.println("wena viene de el for " + matriz[i][2]);
        }

        showTable.setModel(new DefaultTableModel(
                //null,
                matriz,
                // jugador.
                new String []{"Turno","Nombre", "Puntaje Parcial", "Puntaje Total" }
        ));

        TableColumnModel tableColumnModel = showTable.getColumnModel();
        tableColumnModel.getColumn(0).setMinWidth(200);

        DefaultTableCellRenderer centerRender = new DefaultTableCellRenderer();
        centerRender.setHorizontalAlignment(JLabel.CENTER);
        tableColumnModel.getColumn(0).setCellRenderer(centerRender);
        tableColumnModel.getColumn(1).setCellRenderer(centerRender);
        tableColumnModel.getColumn(2).setCellRenderer(centerRender);
        tableColumnModel.getColumn(3).setCellRenderer(centerRender);

    }
}
*/