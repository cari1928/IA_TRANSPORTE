package transporte.grafo;

import java.io.IOException;
import java.io.RandomAccessFile;
import java.util.ArrayList;
import transporte.arbol.GrafoHashMap;
import transporte.arbol.nodoHash;

/**
 * * Inteligencia Artificial Clase encargada de gestionar el archivo maestro
 * para alamacenar los datos
 *
 * @author AlphaGo
 */
public class RedSemantica {
    //Atributos de la clase

    private TDAInfo info;
    private GrafoHashMap grafoTransporte;
    private ArrayList<String> indice;
    private String[][] matrix;
    // CONSTANTES DE LA CLASE 
    public static final short LONGITUD_REGISTO = 38;

    public RedSemantica() {
        grafoTransporte = new GrafoHashMap();
        matrix = new String[1][1];
    }

    /**
     * * Constructor de la clase
     *
     * @param matrizAdy Recibe una matriz de adyacencia
     */
    public RedSemantica(String[][] matrizAdy) {
        if (matrizAdy != null) {
            this.matrix = matrizAdy;
            grafoTransporte = indexFile(matrizAdy);
        }
    }//=====================FIN DEL CONSTRUCTOR====================================

    /**
     * * Metodo para escribir el archivo Maestro
     *
     * @param element Elemento a escribir en el archivo Maestro
     * @throws java.io.IOException Lanza un error si la lectura del archivo
     * falla
     */
    private void write(nodoHash element) throws IOException {
        System.out.println("Writing Object");
        try (RandomAccessFile file = new RandomAccessFile("masterFile", "rw")) {
            System.out.println(file.length());
            file.seek(file.length()); //nos situamos al final del fichero

<<<<<<< HEAD:src/transporte/grafo/RedSemantica.java
            file.writeChars(writeString(element.getLlave(), 2).toString());
            file.writeChars(writeString(element.getOrigen(), 1).toString());
            file.writeChars(writeString(element.getDestino(), 1).toString());
=======
            file.writeChars(writeString(element.getLlave(), 1).toString());
            file.writeChars(writeString(element.getOrigen(), 30).toString());
            file.writeChars(writeString(element.getDestino(), 2).toString());
>>>>>>> 2b710fa6f208b25e1383fedc09cff2591ac766e3:src/transporte/grafo/Transporte.java
            file.writeChars(writeString(element.getCosto(), 15).toString());
            System.out.println(file.length());
        }

    } //========================= FIN DEL METODO  ======================================

    /**
     * * Escribe todos los elementos en el archivo maestro
     */
    public void writeAll() {
        try {
            for (nodoHash n : grafoTransporte.values()) {
                if (n != null) {
                    write(n);
                }
            }
        } catch (IOException ex) {
            System.out.println(ex);
        }
    } //========================= FIN DEL METODO  ======================================

    /**
     * * Actualiza el archivo maestro
     *
     * @param element Elemento a escribir en el archivo Maestro
     * @param indice Especifica la posicion en el archivo maestro
     * @throws java.io.IOException Lanza un error si la lectura del archivo
     * falla
     */
    public void update(nodoHash element, Integer indice) throws IOException {

        int direccionLogica;
        long lreg, desplaza;

        // Valida que no se sobrebase el numero de elementos del registro
        if (indice <= cantidadRegistros() && indice > 0) {
            try (RandomAccessFile file = new RandomAccessFile("masterFile", "rw")) {
                lreg = getLongitudRegistro(file);
                direccionLogica = indice;
                desplaza = (direccionLogica - 1) * lreg;
                file.seek(desplaza);

<<<<<<< HEAD:src/transporte/grafo/RedSemantica.java
                file.writeChars(writeString(element.getLlave(), 2).toString());
                file.writeChars(writeString(element.getOrigen(), 1).toString());
                file.writeChars(writeString(element.getDestino(), 1).toString());
=======
                file.writeChars(writeString(element.getLlave(), 1).toString());
                file.writeChars(writeString(element.getOrigen(), 30).toString());
                file.writeChars(writeString(element.getDestino(), 2).toString());
>>>>>>> 2b710fa6f208b25e1383fedc09cff2591ac766e3:src/transporte/grafo/Transporte.java
                file.writeChars(writeString(element.getCosto(), 15).toString());
            }
        } else {
            System.out.println("El indice no existe");
        }
    } //========================= FIN DEL METODO  ======================================

    /**
     * * Metodo para leer el archivo Secuencial
     *
     * @throws IOException Lanza una excepcion en caso de que exista error en la
     * lectura
     */
    public void readSecuential() throws IOException {
        long ap_actual, ap_final;

        try (RandomAccessFile readfile = new RandomAccessFile("MasterFile", "rw")) {
            while ((ap_actual = readfile.getFilePointer()) != (ap_final = readfile.length())) {
                System.out.println("Read fileMaster");
                System.out.println(readString(readfile, 2)); // Llave 
                System.out.println(readString(readfile, 1)); // descripcion 
                System.out.println(readString(readfile, 1)); //  relacion 
                System.out.println(readString(readfile, 15)); //  costo                
            }
        }
    } //========================= FIN DEL METODO  ======================================

    /**
     * * Obtiene el registro segun una posicion indicado
     *
     * @param index especifica la posicion del registro
     * @return Obtiene un objeto del registo
     * @throws java.io.IOException
     */
    public nodoHash getRegistro(int index) throws IOException {
        int dl;
        long lreg, desplaza;
        nodoHash registro;

        if (index <= cantidadRegistros() && index > 0) {
            try (RandomAccessFile readfile = new RandomAccessFile("FileMaster", "r")) {
                lreg = getLongitudRegistro(readfile);

                dl = index;
                desplaza = (dl - 1) * lreg;
                readfile.seek(desplaza);
                registro = new nodoHash();
<<<<<<< HEAD:src/transporte/grafo/RedSemantica.java
                registro.setLlave(readString(readfile, 2));// Llave
                registro.setOrigen(readString(readfile, 1)); // Descripcion
                registro.setDestino(readString(readfile, 1));// Relacion 
                registro.setCosto(readString(readfile, 15)); // Costo, **tenía setDestino, puede que era un error
=======
                registro.setLlave(readString(readfile, 1));// Llave
                registro.setOrigen(readString(readfile, 30)); // Descripcion
                registro.setDestino(readString(readfile, 2));// Relacion 
                registro.setDestino(readString(readfile, 15)); // Costo 
>>>>>>> 2b710fa6f208b25e1383fedc09cff2591ac766e3:src/transporte/grafo/Transporte.java
            }
        } else {
            registro = null;
            System.out.println("El Registro especificado no existe");
        }

        return registro;
    } //========================= FIN DEL METODO  ======================================

    /**
     * * Metodo encargado de pasar la matriz de adyacencia y generar su llave
     *
     * @param array Representan los costos de la red semantica
     */
    private GrafoHashMap indexFile(String[][] array) {
        GrafoHashMap map = new GrafoHashMap();
        char origen, destino;
        for (byte i = 0; i < array.length; i++) {
            for (byte j = 0; j < array[0].length; j++) {
                if (!array[i][j].equals("")) {
                    origen = (char) (i + 65); //lo convierte a letra
                    destino = (char) (j + 65); //lo convierte a letra
                    map.add(origen + "", destino + "", (array[i][j]));
                }
            }
        }
        return map;
    } //========================= FIN DEL METODO  ======================================

    /**
     * Metodo que obtiene el tamaño de un Registro del archivo maestro
     *
     * @param file Archivo del cual se desea obtener el tamaño del archivo
     * maestro
     * @return La longitud del registo
     */
    public long getLongitudRegistro(RandomAccessFile file) {
        long longitudRegistro;
        try {
            //Leer un registro completo
            readString(file, 2); // Llave
            readString(file, 1); //  descripcion
            readString(file, 1); // Relacion 
            readString(file, 15); // costo
            longitudRegistro = file.getFilePointer();
        } catch (IOException ex) {
            longitudRegistro = 0;
        }

        return longitudRegistro;
    } //========================= FIN DEL METODO  ======================================

    /**
     * * Muestra la cantidad de registros en el archivo maestro
     *
     * @return Cantidad de Registros
     */
    public long cantidadRegistros() {
        long cantidad;
        try (RandomAccessFile readfile = new RandomAccessFile("masterFile", "rw")) {
            cantidad = readfile.length() / LONGITUD_REGISTO;
        } catch (IOException e) {
            cantidad = 0; //No hay Registros
        }
        return cantidad;
    }//========================= FIN DEL METODO  ======================================

    /**
     * * Metodo para obtener el hashMap
     *
     * @return Obtiene la representacion del archivo mastro
     */
    public GrafoHashMap getGrafo() {
        return grafoTransporte;
    } //========================= FIN DEL METODO  ======================================

    /**
     * @param elemento Recibe el archivo de entrada que hay que leer
     * @param numCaracteres el numero de caracteres a leer
     * @return La cadena leida del archivo
     * @throws java.io.IOException
     */
    public String readString(RandomAccessFile elemento, int numCaracteres) throws IOException {
        char nombre[] = new char[numCaracteres], temp;
        for (int c = 0; c < nombre.length; c++) {
            temp = elemento.readChar();
            nombre[c] = temp;
        }
        return new String(nombre).replace('\0', ' ');
    }  //========================= FIN DEL METODO  ======================================

    /**
     * Convierte un string a un buffer de caracteres para escribir en el archivo
     *
     * @param n Elemento a escribir en el archivo
     * @param longitud tamaño del catacter a escribir
     * @return Retorna un buffer de caracteres
     */
    public StringBuffer writeString(String n, Integer longitud) {
        StringBuffer buffer = new StringBuffer(n);
        buffer.setLength(longitud);
        return buffer;
    }  //========================= FIN DEL METODO  ======================================
} // Fin del metodo