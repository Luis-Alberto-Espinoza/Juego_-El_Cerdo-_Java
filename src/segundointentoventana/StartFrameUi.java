package segundointentoventana;

import principal.Juego;
import segundointentoventana.ui.*;

import javax.swing.*;

public class StartFrameUi {
    public static void inicioFrame(){
        SwingUtilities.invokeLater(new Runnable() {
            @Override
            public void run() {
                createGUI();
            }
        });
    }

    public static void createGUI() {
   // Juego play = new Juego();
        MainUI ui = new MainUI();// llama a ortra clase
        //System.out.println(play.jugadoresParticipantes);
        JPanel root = ui.getRootPanel();
        JFrame frame = new JFrame();
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setContentPane(root);
        frame.pack();
        frame.setLocationRelativeTo(null);
        frame.setVisible(true);

    }

}
