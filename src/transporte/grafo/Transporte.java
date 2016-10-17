package transporte.grafo;


import java.io.IOException;
import java.io.RandomAccessFile;
import java.util.ArrayList;
import transporte.arbol.GrafoHashMap;
import transporte.arbol.nodoHash;


/**
 *Inteligencia Artificial 
 * Clase encargada de gestionar el archivo maestro para alamacenar los datos 
 * @author AlphaGo*/
public class Transporte 
{

    //Atributos de la clase
    private   TDAInfo info;
    private GrafoHashMap grafoTransporte;
    private ArrayList<String> indice;
   private String [][] matrix;
   
    /**Constructor de la clase 
     * @param matrizAdy Recibe una matriz de adyacencia 
     */
    public Transporte(String[][] matrizAdy) 
    {
        if( matrizAdy!=null )
        {
            this.matrix=matrizAdy;
            grafoTransporte=indexFile(matrizAdy);
        }
    }
    
    /**Metodo para escribir el archivo Maestro
     * @param element Elemento a escribir en el archivo Maestro
     * @throws java.io.IOException Lanza un error si la lectura del archivo falla  */
    private void write(nodoHash element) throws IOException
    {
        System.out.println( "Writing Object" );
        try (RandomAccessFile file = new RandomAccessFile( "transporte", "rw" )) 
        {
             System.out.println(file.length());
             file.seek( file.length() ); //nos situamos al final del fichero
             file.writeChars( writeString(element.getLlave() ).toString()  );
             file.writeChars( writeString(element.getOrigen()).toString()  );
             file.writeChars( writeString(element.getDestino()).toString()  );
             file.writeInt( element.getCosto() );
             System.out.println( file.length() );
        }
        
    } //========================= FIN DEL METODO  ======================================
    
   /**Escribe todos los elementos en el archivo maestro*/
    public void writeAll()
    {
        try 
            {
                for (nodoHash n :grafoTransporte.values()) 
                {
                    write(n);
                }
            } catch (IOException ex) {
                System.out.println(ex);
            }
    }
    
    
    /**Metodo para leer el archivo Secuencial
     *@throws IOException Lanza una excepcion en caso de que exista error en la lectura 
     */
    public void readSecuential() throws IOException
    {
        long ap_actual;
        long ap_final;
        
        String llave;
        System.out.println("Read fileMaster");
      try (RandomAccessFile readfile = new RandomAccessFile( "transporte", "rw" )) 
        {
            while ( (ap_actual=readfile.getFilePointer() ) !=( ap_final=readfile.length() )  ) 
            {  
                System.out.println( readString(readfile,2) ); // Llave 
                System.out.println( readString(readfile,1) ); //  Origen
                System.out.println( readString(readfile,1) ); // Destino 
                System.out.println(readfile.readInt()); // costo
            }
        }
    } //========================= FIN DEL METODO  ======================================
    
   /**
     * @param elemento Recibe el archivo de entrada que hay que leer 
     * @param numCaracteres el numero de caracteres a leer
     * @return La cadena leida del archivo
     * @throws java.io.IOException*/
    public String readString(RandomAccessFile elemento,int numCaracteres) throws IOException
    {
               char nombre[]=new char[numCaracteres],temp;
                for (int c = 0; c < nombre.length; c++) 
                {
                    temp=elemento.readChar();
                    nombre[c]=temp;  
                }
          return new String(nombre).replace('\0', ' ');
    } // Fin del metodo
    
    /**Convierte un string a un buffer de caracteres para escribir en el archivo
     * @param n Elemento a escribir en el archivo
     * @return Retorna un buffer de caracteres
     */
    public StringBuffer writeString(String n)
    {
        StringBuffer buffer= new StringBuffer( n);
        buffer.setLength( n.length()); 
           return buffer;  
    } // Fin del metodo
    
 
    public nodoHash readMasterRandom(int index) throws IOException
    {
       int n,dl;
       long lreg,desplaza;
       nodoHash registro;
       
        
        try (RandomAccessFile readfile = new RandomAccessFile( "transporte", "rw" )) 
        {
            //Leer un registro completo
                readString(readfile,2); // Llave
                readString(readfile,1); //  Origen
                readString(readfile,1); // Destino 
                readfile.readInt(); // costo
                lreg=readfile.getFilePointer();
            
                dl=index;
                desplaza=(dl-1)*lreg;
                readfile.seek(desplaza);
                registro=new nodoHash();
                registro.setLlave( readString(readfile,2) );// Llave
                registro.setOrigen(readString(readfile,1) ); //  Origen
                registro.setDestino( readString(readfile,1)  );// Destino
                registro.setCosto( readfile.readInt() ); // Costo
                
        }
        return registro;               
    }

    
    /**Metodo encargado de pasar la matriz de adyacencia  y generar su llave*/
    private GrafoHashMap indexFile (String[][] array) 
    {
        GrafoHashMap map = new GrafoHashMap();
        char origen, destino;
        for (byte i = 0; i < array.length; i++)
        {
            for (byte j = 0; j < array[0].length; j++) 
            {
                if (array[i][j]!=null) 
                {
                    origen = (char) (i + 65); //lo convierte a letra
                    destino = (char) (j + 65); //lo convierte a letra
                    map.add (origen + "", destino + "", Integer.parseInt(array[i][j]));
                }  
            }
        }
        return map;
   }
   
    public  GrafoHashMap getGrafo()
    {
        return grafoTransporte;
    }
    
  
} // Fin del metodo