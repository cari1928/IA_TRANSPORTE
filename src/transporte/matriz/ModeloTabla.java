package transporte.matriz;

import javax.swing.table.AbstractTableModel;
import javax.swing.table.TableModel;

/**
 * Clase para modelos personalizados para las tablas
 *
 * @see AbstractTableModel Implementa un Modelo de tabla
 * @author alphaGo
 */
public class ModeloTabla extends AbstractTableModel implements TableModel {

    /**
     * *********************************************************************************
     * ATRIBUTOS DE LA CLASE
     * *************************************************************************************
     */
    /**
     * Almacena los valores de la tabla
     */
    public String[][] matrixManagerElements;
    public String[] arrayManagerElements;
    public String type;
    /**
     * Titulo de la tabla
     */
    protected String[] Titulo = null;

    /**
     * Constructor que Actualiza La tabla.<br>
     * Obtiene directamente los valores desde la base de datos y Actualiza la
     * tabla
     *
     * @param tituloColumn titulo de las columnas
     * @param dimensiones
     * @param type Indica arreglo unidimensional o bidimensional
     */
    public ModeloTabla(String[] tituloColumn, Integer dimensiones, String type) {
        super();
        initStructure(type, dimensiones);
        Titulo = tituloColumn;
        this.type = type;
    }

    //inicializa la estructura de datos necesaria, arreglo bidimensional (Descripción de costos) o unidimensional(descripcion de nodos)
    public void initStructure(String type, Integer dimensiones) {
        switch (type) {
            case "matrix":
                matrixManagerElements = new String[dimensiones][dimensiones];
                for (int i = 0; i < dimensiones; i++) {
                    for (int j = 0; j < dimensiones; j++) {
                        matrixManagerElements[i][j] = "";
                    }
                }
                break;
            case "array":
                arrayManagerElements = new String[dimensiones];
                arrayManagerElements = new String[dimensiones];
                for (int i = 0; i < dimensiones; i++) {
                    arrayManagerElements[i] = "";
                }
                break;
        }
    }

    public void setMatrixManagerElements(String[][] elementos) {
        this.matrixManagerElements = elementos;
    }

    public void setArrayManagerElements(String[] elementos) {
        this.arrayManagerElements = elementos;
    }

    /**
     * Metodo para obtener la matriz de adyacenc
     *
     * @return Devuelve la matriz de adyacencia que el usuario teclee
     */
    public String[][] getMatrix() {
        if (matrixManagerElements != null) {
            return matrixManagerElements;
        } else {
            return null;
        }
    } // Fin del metodo

    /**
     * Metodo para obtener el arreglo con la descripción de los Nodos
     *
     * @return Devuelve el arreglo con la información de nodos que el usuario
     * ingrese
     */
    public String[] getArray() {
        if (arrayManagerElements != null) {
            return arrayManagerElements;
        } else {
            return null;
        }
    } // Fin del metodo

    /**
     * * Obtiene el titulo de la columna seleccionada
     *
     * @return Regresa el titulo de la tabla
     */
    @Override
    public String getColumnName(int column) {
        try {
            return Titulo[column];
        } catch (ArrayIndexOutOfBoundsException e) {
            System.out.println("Error de indice de las columnas ");
        }
        return ""; //Si hay problemas devuelve la cadena vacia para el nombre de la columna 
    } // Fin del metodo 

    @Override
    public int getColumnCount() {
        return Titulo.length;
    }

    @Override
    public int getRowCount() {
        if (type.equals("matrix")) {
            return matrixManagerElements.length;
        }

        return 1; //type = array
    }

    /*Obtiene los elementos de la tabla*/
    @Override
    public Object getValueAt(int filas, int columnas) {
        if (filas < 0 || columnas < 0) {
            return null;
        }

        if (type.equals("matrix")) {
            return matrixManagerElements[filas][columnas];
        }
//        System.out.println(columnas);
        return arrayManagerElements[columnas]; //type = array

    } // Fin del metodo 

    @Override
    public void setValueAt(Object aValue, int filas, int columnas) {
        switch (type) {
            case "matrix":
                matrixManagerElements[filas][columnas] = aValue.toString();
                break;
            case "array":
                arrayManagerElements[columnas] = aValue.toString();
                break;
        }
    }

    @Override
    public boolean isCellEditable(int rowIndex, int columnIndex) {
        return true;
    }
} // Fin de la clase 
