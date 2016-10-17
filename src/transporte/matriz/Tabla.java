package transporte.matriz;

import java.io.IOException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;
import javax.swing.table.TableModel;
import transporte.arbol.GrafoHashMap;
import transporte.grafo.GestionBusqueda;
import transporte.grafo.TDAInfo;
import transporte.grafo.Transporte;

/**
 * Interfaz encargada de pedir la informacion del grafo
 *
 * @author alphaGo
 */
public class Tabla extends javax.swing.JFrame {

    CcontrollerTable pasa = null;
    TableModel cNodos;
    private GestionBusqueda manager;
    private Transporte trans;
    private ModeloTabla redGrafo;

    public Tabla(TableModel cNodos) {
        initComponents();
        setLocationRelativeTo(null);
        this.cNodos = cNodos;                   //Guarda descripción de los nodos
        pasa = new CcontrollerTable(this);
        setVisible(true);
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jScrollPane1 = new javax.swing.JScrollPane();
        Matriz = new javax.swing.JTable();
        jButton1 = new javax.swing.JButton();
        Dimencion = new javax.swing.JTextField();
        Guardar = new javax.swing.JButton();
        Carga_Matriz = new javax.swing.JButton();
        jLabel1 = new javax.swing.JLabel();
        Metodos_Busqueda = new javax.swing.JComboBox<String>();
        Origen = new javax.swing.JTextField();
        Destino = new javax.swing.JTextField();
        jLabel2 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        Buscar = new javax.swing.JButton();
        jLabel4 = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        Matriz.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {

            }
        ));
        jScrollPane1.setViewportView(Matriz);

        jButton1.setText("Nueva Tabla");
        jButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton1ActionPerformed(evt);
            }
        });

        Guardar.setText("Guardar");
        Guardar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                Guardar(evt);
            }
        });

        Carga_Matriz.setText("Cargar Matriz");
        Carga_Matriz.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                Carga_Matriz(evt);
            }
        });

        jLabel1.setText("Tipo de busqueda");

        Metodos_Busqueda.setModel(new javax.swing.DefaultComboBoxModel(new String[] { "Anchura", "Profundidad" }));

        jLabel2.setText("Origen");

        jLabel3.setText("Distino");

        Buscar.setText("Buscar");
        Buscar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                Buscar(evt);
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
                    .addGroup(layout.createSequentialGroup()
                        .addGap(12, 12, 12)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(layout.createSequentialGroup()
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(jLabel1)
                                    .addComponent(Metodos_Busqueda, javax.swing.GroupLayout.PREFERRED_SIZE, 137, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addGap(32, 32, 32)
                                .addComponent(Carga_Matriz)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(Guardar))
                            .addGroup(layout.createSequentialGroup()
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(jLabel2, javax.swing.GroupLayout.Alignment.TRAILING)
                                    .addComponent(jLabel3, javax.swing.GroupLayout.Alignment.TRAILING))
                                .addGap(29, 29, 29)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                                    .addComponent(Destino, javax.swing.GroupLayout.DEFAULT_SIZE, 40, Short.MAX_VALUE)
                                    .addComponent(Origen))
                                .addGap(18, 18, 18)
                                .addComponent(Buscar)))
                        .addGap(0, 0, Short.MAX_VALUE))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addComponent(jLabel4, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(jScrollPane1, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, 745, Short.MAX_VALUE)
                            .addGroup(javax.swing.GroupLayout.Alignment.LEADING, layout.createSequentialGroup()
                                .addComponent(jButton1)
                                .addGap(18, 18, 18)
                                .addComponent(Dimencion, javax.swing.GroupLayout.PREFERRED_SIZE, 34, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(0, 0, Short.MAX_VALUE)))
                        .addContainerGap())))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jButton1)
                    .addComponent(Dimencion, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(31, 31, 31)
                .addComponent(jLabel4)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 210, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(Carga_Matriz)
                    .addComponent(Guardar)
                    .addComponent(jLabel1))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(Metodos_Busqueda, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(Origen, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel2))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(Destino, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel3)))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                        .addComponent(Buscar)
                        .addGap(16, 16, 16)))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton1ActionPerformed

        String dato = Dimencion.getText();

        if (dato.length() > 0) {
            pasa.Crear_Matriz(Matriz, Integer.parseInt(dato.trim()), "matrix");
        } else {
            JOptionPane.showMessageDialog(null, "Ingresa Un numero", "Aviso", JOptionPane.ERROR_MESSAGE);
        }
    }//GEN-LAST:event_jButton1ActionPerformed

    //metodo que lee la tabla y la guarda en el archivo
    private void Guardar(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_Guardar


        if (JOptionPane.showInputDialog("Es corecta la matriz? \nSi o No").equalsIgnoreCase("si")) {
            JOptionPane.showMessageDialog(null, "Matriz Guardada");
            pasa.printArray(pasa.getArray());

            trans = new Transporte(pasa.getArray());
            try {
                //trans.writeAll();
                //trans.readSecuential();
                System.out.println(trans.readMasterRandom(1));
            } catch (IOException ex) {
                Logger.getLogger(Tabla.class.getName()).log(Level.SEVERE, null, ex);
            }

        }


    }//GEN-LAST:event_Guardar

    private void Carga_Matriz(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_Carga_Matriz
        // TODO add your handling code here:
        Archivo Accion = new Archivo();
        Accion.Cargar(Matriz);
    }//GEN-LAST:event_Carga_Matriz

    private void Buscar(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_Buscar
        // TODO add your handling code here:

        GrafoHashMap nodos = new GrafoHashMap();
        String Metodo = (String) Metodos_Busqueda.getSelectedItem(); //obtiene método de búsqueda
        String Nodo_Origen = Origen.getText();
        String Nodo_Destino = Destino.getText();
        TDAInfo info = new TDAInfo(null, Nodo_Origen, Nodo_Destino, 0);

        manager = new GestionBusqueda(this, info, nodos);
        if (Metodo.equals("Anchura")) {
            //Llamar a l metodo de anchura
            manager.anchura(Nodo_Origen, false);
        } else {
            manager.profundidad(Nodo_Origen);
        }
    }//GEN-LAST:event_Buscar

    public CcontrollerTable getTable() {
        return pasa;
    }

    public ModeloTabla getRedGrafo() {
        return redGrafo;
    }

    public void setRedGrafo(ModeloTabla tipo) {
        this.redGrafo = tipo;
    }
    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton Buscar;
    private javax.swing.JButton Carga_Matriz;
    private javax.swing.JTextField Destino;
    private javax.swing.JTextField Dimencion;
    private javax.swing.JButton Guardar;
    private javax.swing.JTable Matriz;
    private javax.swing.JComboBox<String> Metodos_Busqueda;
    private javax.swing.JTextField Origen;
    private javax.swing.JButton jButton1;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JScrollPane jScrollPane1;
    // End of variables declaration//GEN-END:variables
}
