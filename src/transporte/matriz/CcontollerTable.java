package transporte.matriz;

import javax.swing.JTable;


/**Clase que controla la vista de la tabla 
 * @author AlphaGo
 */
public class CcontollerTable 
{
    //Referencia de la interrfaz tabla 
    private Tabla grafoTab=null;

    /**Recibe como referencia la interfaz grafica utilizada
     * @param pTable Recibe la ventana mostrada al usuario 
     */
    public CcontollerTable( Tabla pTable) 
    {
        this.grafoTab=pTable;
    }
    
    
    /**Metodo para cargar la matriz en la tabla 
     * @param Matriz Recibe la tabla donde se almacena la matriz
     * @param Dimencion capacidad de la matriz 
     */
    public void Crear_Matriz(JTable Matriz,int Dimencion)
    {
        ModeloTabla DTM=new ModeloTabla( createColumns( Dimencion ) ,Dimencion);
        grafoTab.setRedGrafo(DTM);
       Matriz.setModel(grafoTab.getRedGrafo() );
    } // Fin del metodo 
    
    
    
    /**Metodo para Crear las columnas 
     * @param Dimension Numero de columnas a crear
     */
    private String[] createColumns(Integer Dimension)
    {
        String [] Columnas;
        if(Dimension>0)
        {
            Columnas = new String [Dimension];

                for (int i = 0; i < Dimension; i++) 
                    Columnas[i]=""+(char) (i + 65);

            return Columnas;
        }
            else
                return new String[1];   
        
    } // Fin del metodo

    /**Metodo para obtener la matriz de adyacenc
     * @return Devuelve la matriz de adyacencia que el usuario teclee*/
    public String[][] getArray()
    {
        return grafoTab.getRedGrafo().getArray();
    } // Fin del metodo
    
    
    /**Metodo para imprimir un arreglo Bidimientcional
     * @param matriz Matriz generica a imprimir
     */
    public void printArray(Object[][] matriz)
    {
        for (Object[] matriz1 : matriz) 
        {
            System.out.print("|");
            for (int y = 0; y < matriz1.length; y++) 
            {
                System.out.print(matriz1[y]);
                if (y != matriz1.length - 1) 
                {
                    
                    System.out.print("\t");
                    System.out.print("|");
                    System.out.print("\t");
                }
            }
            System.out.println("|");
        }
    } // Fin del metodo 
    
} // Fin de la clase 
