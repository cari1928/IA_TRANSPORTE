package transporte.matriz;

import javax.swing.JTable;
import javax.swing.table.TableModel;

/**
 * Clase que controla la vista de la tabla
 *
 * @author AlphaGo
 */
public class CcontrollerTable {
    //Referencia de la interrfaz tabla 

    private Tabla grafoTab = null;
    private TablaNodos nodosTab = null;

    /**
     * Recibe como referencia la interfaz grafica utilizada
     *
     * @param pTable Recibe la ventana mostrada al usuario
     */
    public CcontrollerTable(Tabla pTable) {
        this.grafoTab = pTable;
    }

    public CcontrollerTable(TablaNodos pTable) {
        this.nodosTab = pTable;
    }

    /**
     * Metodo para cargar la matriz en la tabla
     *
     * @param Matriz Recibe la tabla donde se almacena la matriz
     * @param Dimencion capacidad de la matriz
     */
    public void Crear_Matriz(JTable Matriz, int Dimencion, String type) {
        ModeloTabla DTM;
        switch (type) {
            case "matrix":
                DTM = new ModeloTabla(createColumns(Dimencion), Dimencion, type);
                grafoTab.setRedGrafo(DTM);
                Matriz.setModel(grafoTab.getRedGrafo());
                break;
            case "array":
                DTM = new ModeloTabla(createColumns(Dimencion), Dimencion, type);
                nodosTab.setRedGrafo(DTM);
                Matriz.setModel(nodosTab.getRedGrafo());
                break;
        }
    } // Fin del metodo 

    /**
     * Metodo para Crear las columnas
     *
     * @param Dimension Numero de columnas a crear
     */
    private String[] createColumns(Integer Dimension) {
        String[] Columnas;
        if (Dimension > 0) {
            Columnas = new String[Dimension];

            for (int i = 0; i < Dimension; i++) {
                Columnas[i] = "" + (char) (i + 65);
            }

            return Columnas;
        } else {
            return new String[1];
        }

    } // Fin del metodo

    /**
     * Metodo para obtener la matriz de adyacenc
     *
     * @return Devuelve la matriz de adyacencia que el usuario teclee
     */
    public String[][] getArray() {
        return grafoTab.getRedGrafo().getMatrix();
    } // Fin del metodo

    /**
     * Metodo para imprimir un arreglo Bidimientcional
     *
     * @param matriz Matriz generica a imprimir
     */
    public void printArray(Object[][] matriz) {
        for (Object[] matriz1 : matriz) {
            System.out.print("|");
            for (int y = 0; y < matriz1.length; y++) {
                System.out.print(matriz1[y]);
                if (y != matriz1.length - 1) {

                    System.out.print("\t");
                    System.out.print("|");
                    System.out.print("\t");
                }
            }
            System.out.println("|");
        }
    } // Fin del metodo

    public boolean checkMatrix(JTable matrix) {
        TableModel tModel = matrix.getModel();
        int cols, rows;
        cols = tModel.getColumnCount();

        //First check
        if (cols == 0) { //the table wasn't built
            return false;
        }

        rows = tModel.getRowCount();
        //Second check
        for (int i = 0; i < rows; i++) {
            for (int j = 0; j < cols; j++) {
                if (tModel.getValueAt(i, j) == null) { //there are null values
                    return false;
                }
            }
        }

        return true; //everything is ok
    }
} // Fin de la clase 
