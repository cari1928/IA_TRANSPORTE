package transporte.main;

import transporte.matriz.TablaNodos;

/**
 * Clase main para la ejecucion del programa
 *
 * @author AlphaGo
 */
public class CMain {

    public static void main(String[] args) {
        try {
            for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
                if ("Windows".equals(info.getName())) {
                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } catch (ClassNotFoundException | InstantiationException | IllegalAccessException | javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(TablaNodos.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }

        java.awt.EventQueue.invokeLater(new Runnable() {
            @Override
            public void run() {

                TablaNodos GUI = new TablaNodos();
                GUI.setVisible(true);
            }
        });
    }
} // Fin de la clase 

