package transporte.matriz;

import java.io.*;
import java.util.StringTokenizer;
import javax.swing.JTable;
import javax.swing.table.TableModel;


/**Clase que almacena de manera temporal, la matriz de adyacencia 
 * @author Alphago
 * @author Jorge
 */
public class Archivo 
{
   
   /**Metodo para guardar en el archivo
    * @param Cadena_Concatenada Recibe la informacion a guardar en el archivo 
    */
   public void Guardar(String Cadena_Concatenada) 
    {
        try
        {
            FileWriter fw=new FileWriter("Matriz.txt");// Se crea un nuevo archivo
            BufferedWriter bw= new BufferedWriter(fw);

            bw.write(Cadena_Concatenada);
            bw.close();
        }
        catch(Exception e){}    
    } // Fin de metodo 
   
/**Metodo para cargar la matriz desde el archivo 
 * @param Matriz  Recibe la referencia de la tabla
 */
    public void Cargar(JTable Matriz)   
    {
         try
        {
            TableModel Modelo_Tabla = Matriz.getModel();
            
            FileReader fr=new FileReader("Matriz.txt");
            BufferedReader br=new BufferedReader(fr);
        
            String Linea="";

            int i=0;
            while((Linea=br.readLine())!=null)
            {
                //pasa.Crear_Matriz(Matriz,Linea.length());
                 StringTokenizer Token = new StringTokenizer(Linea);
                 int Dimencion=Token.countTokens();
                
                for (int j = 0; j < Dimencion; j++) 
                {
                    Modelo_Tabla.setValueAt(Token.nextToken(), i, j);
                }
                i++;   
            }
        }
    
        catch(Exception e){}  
    } // Fin del metodo cargar
    
} // fin de la clase Archivo
