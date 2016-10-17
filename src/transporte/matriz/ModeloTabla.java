package transporte.matriz;

import javax.swing.table.AbstractTableModel;
import javax.swing.table.TableModel;
/**
 *Clase para modelos personalizados para las tablas
 * @see AbstractTableModel Implementa un Modelo de tabla
 * @author Martinez Sierra Daniel
 */
public  class ModeloTabla  extends AbstractTableModel  implements TableModel
{
   /***********************************************************************************
      *                                           ATRIBUTOS DE LA CLASE
     ***************************************************************************************/
    /**Almacena los valores de la tabla*/
   public String[][] elementosManejador;
   
    
    /**Titulo de la tabla*/
    protected  String[] Titulo=null;

    /**Constructor que Actualiza La tabla.<br>
       *  Obtiene directamente los valores desde la base de datos  y Actualiza la tabla
     * @param tituloColumn  titulo de las columnas
     * @param dimensiones*/
    public ModeloTabla(String[] tituloColumn, Integer dimensiones ) 
    {
        super();
        Titulo=tituloColumn; 
        elementosManejador=new String[dimensiones][dimensiones];
    }
    

   public void setElementosManejador(String [][] elementos) 
    {
        this.elementosManejador = elementos;
    }

   
    /**Metodo para obtener la matriz de adyacenc
     * @return Devuelve la matriz de adyacencia que el usuario teclee*/
    public String[][] getArray()
    {
        if( elementosManejador!=null )
            return elementosManejador;
            else
            return null;
    } // Fin del metodo

    
    /*** Obtiene el titulo de la columna seleccionada
     * @return Regresa el titulo de la tabla*/
    @Override
    public String getColumnName(int column) 
    {  
          try 
          {
              return Titulo[column];
          } 
          catch (ArrayIndexOutOfBoundsException e) 
          {
              System.out.println("Error de indice de las columnas ");
        }
        return ""; //Si hay problemas devuelve la cadena vacia para el nombre de la columna 
    } // Fin del metodo 
     
    
    @Override
    public int getColumnCount() 
    {
        return Titulo.length; 
    }
    
      @Override
    public int getRowCount() 
    {
        return  elementosManejador.length; 
    }

      /*Obtiene los elementos de la tabla*/
    @Override
    public Object getValueAt(int filas, int columnas) 
    {
        if(filas<0|| columnas<0)
            return null;
        
        return elementosManejador[filas][columnas];      
    } // Fin del metodo 

    @Override
    public void setValueAt(Object aValue, int filas, int columnas) 
    {
      elementosManejador[filas][columnas]=aValue.toString();         
    }

    @Override
    public boolean isCellEditable(int rowIndex, int columnIndex) {
        return true;
    }

} // Fin de la clase 
