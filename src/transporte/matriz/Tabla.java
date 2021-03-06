package transporte.matriz;

import java.io.IOException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;
import javax.swing.table.JTableHeader;
import transporte.arbol.GrafoHashMap;
import transporte.grafo.GestionBusqueda;
import transporte.grafo.RedSemantica;
import transporte.grafo.TDAInfo;

/**
 * Interfaz encargada de pedir la informacion del grafo
 *
 *
 * @author alphaGo
 */
public class Tabla extends javax.swing.JFrame {

    CcontrollerTable pasa = null;
    private GestionBusqueda manager;
    private RedSemantica trans;
    private ModeloTabla redGrafo;

    public Tabla(String[] Nodos) {
        initComponents();
        setLocationRelativeTo(null);
        pasa = new CcontrollerTable(this, Nodos);
        pasa.Crear_Matriz(Matriz, Nodos.length, "matrix");

        setLocationRelativeTo(null);
        setResizable(false);
        setVisible(true);
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jScrollPane1 = new javax.swing.JScrollPane();
        Matriz = new javax.swing.JTable();
        Guardar = new javax.swing.JButton();
        jLabel1 = new javax.swing.JLabel();
        Metodos_Busqueda = new javax.swing.JComboBox<String>();
        Origen = new javax.swing.JTextField();
        jLabel2 = new javax.swing.JLabel();
        continuar = new javax.swing.JButton();
        jLabel4 = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        Matriz.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {

            }
        ));
        jScrollPane1.setViewportView(Matriz);

        Guardar.setText("Guardar");
        Guardar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                Guardar(evt);
            }
        });

        jLabel1.setText("Tipo de busqueda");

        Metodos_Busqueda.setModel(new javax.swing.DefaultComboBoxModel(new String[] { "Anchura", "Profundidad" }));
        Metodos_Busqueda.setEnabled(false);

        jLabel2.setText("Origen");

        continuar.setText("Continuar");
        continuar.setEnabled(false);
        continuar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                continuar(evt);
            }
        });

        jLabel4.setBackground(new java.awt.Color(0, 51, 51));
        jLabel4.setFont(new java.awt.Font("Arial Black", 0, 18)); // NOI18N
        jLabel4.setForeground(new java.awt.Color(255, 255, 255));
        jLabel4.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel4.setText("RED SEMANTICA");
        jLabel4.setOpaque(true);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel4, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jScrollPane1)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(12, 12, 12)
                        .addComponent(jLabel1)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(Metodos_Busqueda, javax.swing.GroupLayout.PREFERRED_SIZE, 137, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addComponent(jLabel2)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(Origen, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(continuar)))
                .addContainerGap())
            .addGroup(layout.createSequentialGroup()
                .addGap(282, 282, 282)
                .addComponent(Guardar, javax.swing.GroupLayout.PREFERRED_SIZE, 200, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(283, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel4)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(Guardar)
                .addGap(7, 7, 7)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 210, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(jLabel1)
                        .addComponent(Metodos_Busqueda, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(jLabel2)
                        .addComponent(Origen, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(continuar)))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    //metodo que lee la tabla y la guarda en el archivo
    private void Guardar(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_Guardar

        if (JOptionPane.showInputDialog("Es corecta la matriz? \nSi o No").equalsIgnoreCase("si")) {
            trans = new RedSemantica(pasa.getArray());
            try {
                trans.writeAll();
                if (trans.cantidadRegistros() > 0) {
                    JOptionPane.showMessageDialog(null, "Matriz Guardada", "Atencion", JOptionPane.INFORMATION_MESSAGE);
                    habilitaCamposBusqueda(true);
                }

                trans.readSecuential();
            } catch (IOException ex) {
                Logger.getLogger(Tabla.class.getName()).log(Level.SEVERE, null, ex);
            }

        }


    }//GEN-LAST:event_Guardar

    private void continuar(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_continuar
        // TODO add your handling code here:

        GrafoHashMap nodos = new GrafoHashMap();
        String Metodo = (String) Metodos_Busqueda.getSelectedItem(); //obtiene método de búsqueda
        String Nodo_Origen = Origen.getText();
        TDAInfo info = new TDAInfo(null, Nodo_Origen, null, 0);

        manager = new GestionBusqueda(this, info, nodos);
        if (Metodo.equals("Anchura")) {
            manager.anchura(Nodo_Origen, false);
        } else {
            manager.profundidad(Nodo_Origen);
        }
    }//GEN-LAST:event_continuar

    public CcontrollerTable getTable() {
        return pasa;
    }

    public ModeloTabla getRedGrafo() {
        return redGrafo;
    }

    public void setRedGrafo(ModeloTabla tipo) {
        this.redGrafo = tipo;
    }

    public JTableHeader getTableHeader() {
        return Matriz.getTableHeader();
    }

    public void habilitaCamposBusqueda(boolean flag) {
        Metodos_Busqueda.setEnabled(flag);
        Origen.setEnabled(flag);
        continuar.setEnabled(flag);
    }
    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton Guardar;
    private javax.swing.JTable Matriz;
    private javax.swing.JComboBox<String> Metodos_Busqueda;
    private javax.swing.JTextField Origen;
    private javax.swing.JButton continuar;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JScrollPane jScrollPane1;
    // End of variables declaration//GEN-END:variables
}
