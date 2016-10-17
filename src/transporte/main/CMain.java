package transporte.main;

import transporte.matriz.Tabla;

/**
 * Clase main para la ejecucion del programa
 *
 * @author AlphaGo
 */
public class CMain
{

    public static void main(String[] args) {
        try {
            for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
                if ("Windows".equals(info.getName())) {
                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } catch (ClassNotFoundException | InstantiationException | IllegalAccessException | javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(Tabla.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }

        java.awt.EventQueue.invokeLater(new Runnable() 
        {
            @Override
            public void run() {

                Tabla GUI = new Tabla();
                GUI.setVisible(true);
            }
        });
    }
} // Fin de la clase 

