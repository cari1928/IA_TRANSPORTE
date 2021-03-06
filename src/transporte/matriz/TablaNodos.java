package transporte.matriz;

import javax.swing.JOptionPane;
import javax.swing.table.JTableHeader;
import javax.swing.table.TableColumn;
import javax.swing.table.TableColumnModel;
import javax.swing.table.TableModel;
import transporte.grafo.GestionBusqueda;

/**
 * Interfaz encargada de pedir la informacion del grafo
 *
 * @author alphaGo
 */
public class TablaNodos extends javax.swing.JFrame {

    CcontrollerTable pasa = null;
    private ModeloTabla redGrafo;

    public TablaNodos() {
        initComponents();
        setLocationRelativeTo(null);
        setResizable(false);
        pasa = new CcontrollerTable(this);
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jScrollPane1 = new javax.swing.JScrollPane();
        Matriz = new javax.swing.JTable();
        jButton1 = new javax.swing.JButton();
        Dimencion = new javax.swing.JTextField();
        jLabel4 = new javax.swing.JLabel();
        btnSave = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        Matriz.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {

            }
        ));
        jScrollPane1.setViewportView(Matriz);

        jButton1.setText("Nodos");
        jButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton1ActionPerformed(evt);
            }
        });

        jLabel4.setBackground(new java.awt.Color(0, 51, 51));
        jLabel4.setFont(new java.awt.Font("Arial Black", 0, 18)); // NOI18N
        jLabel4.setForeground(new java.awt.Color(255, 255, 255));
        jLabel4.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel4.setText("Descripción de Nodos");
        jLabel4.setOpaque(true);

        btnSave.setText("Guardar");
        btnSave.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnSaveActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel4, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 745, Short.MAX_VALUE)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(jButton1)
                        .addGap(18, 18, 18)
                        .addComponent(Dimencion, javax.swing.GroupLayout.PREFERRED_SIZE, 34, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(0, 0, Short.MAX_VALUE))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                        .addGap(0, 0, Short.MAX_VALUE)
                        .addComponent(btnSave)))
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addGap(23, 23, 23)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jButton1)
                    .addComponent(Dimencion, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addComponent(jLabel4)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 43, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 14, Short.MAX_VALUE)
                .addComponent(btnSave)
                .addContainerGap())
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton1ActionPerformed
        // TODO add your handling code here:
        String dato = Dimencion.getText();
        if (dato.length() > 0) {
            pasa.Crear_Matriz(Matriz, Integer.parseInt(dato.trim()), "array");
        } else {
            JOptionPane.showMessageDialog(null, "Ingresa Un numero", "Aviso", JOptionPane.ERROR_MESSAGE);
        }
    }//GEN-LAST:event_jButton1ActionPerformed

    private void btnSaveActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnSaveActionPerformed
        // TODO add your handling code here:
        if (!pasa.checkMatrix(Matriz)) { //matrix didn't complete all the checks successfull
            JOptionPane.showMessageDialog(null, "Completa la matriz", "Aviso", JOptionPane.ERROR_MESSAGE);
        } else {
            Tabla table = new Tabla(getArray(Matriz.getModel(), Matriz.getTableHeader(), "content"));
            setVisible(false);
        }
    }//GEN-LAST:event_btnSaveActionPerformed

    //Permite obtener un arreglo con el contenido ingresado por el usuario o el encabezado del table model
    public String[] getArray(TableModel tableModel, JTableHeader tableHeader, String type) {
        TableColumnModel tcModel = tableHeader.getColumnModel(); //cabecera de la tabla
        TableColumn tColumn;
        int cols = tableModel.getColumnCount();
        String[] temp = new String[cols]; //+1 por el encabezado

        for (int i = 0; i < cols; i++) {
            if (type.equals("header")) { //regresa el header
                tColumn = tcModel.getColumn(i);
                temp[i] = tColumn.getHeaderValue().toString();
            } else { //type = "content", regresa el contenido ingresado por el usuario
                temp[i] = tableModel.getValueAt(0, i).toString();
            }
        }
        return temp;
    }

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
    private javax.swing.JTextField Dimencion;
    private javax.swing.JTable Matriz;
    private javax.swing.JButton btnSave;
    private javax.swing.JButton jButton1;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JScrollPane jScrollPane1;
    // End of variables declaration//GEN-END:variables
}
