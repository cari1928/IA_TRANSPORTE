package transporte.grafo;

import java.util.ArrayList;
import java.util.Collections;
import java.util.LinkedList;
import java.util.Queue;
import javax.swing.table.JTableHeader;
import javax.swing.table.TableColumn;
import javax.swing.table.TableColumnModel;
import javax.swing.table.TableModel;
import transporte.arbol.GrafoHashMap;
import transporte.matriz.Tabla;

/**
 * * Clase encargada de escribir en el archivo maestro
 *
 * @author AlphaGo
 */
public class GestionBusqueda implements Busqueda {

    //Atributos de la clase
    private Tabla table = null;
    private TDAInfo grafo = null;
    //-----------Elementos para búsqueda por anchura--------------
    private Queue<String> cola;
    private ArrayList listRoute;
    private ArrayList ruta;
    GrafoHashMap nodos;
    private ArrayList<String> list;
    //------------------------------------------------------------
    private int cnodos;

    public GestionBusqueda(Tabla pTable, TDAInfo pGrafo, GrafoHashMap nodos) {
        this.table = pTable;
        this.grafo = pGrafo;
        this.nodos = nodos;
        cola = new LinkedList();
        ruta = new ArrayList();
        listRoute = new ArrayList();
        cnodos = 0;
        list = new ArrayList();
        list.add("");

        this.nodos = fillHashMap();

    }

    //se llena el hashmap
    public GrafoHashMap fillHashMap() {
        String[][] tableData = this.table.getRedGrafo().getMatrix(); //contenido de la matriz

        //Obtener el encabezado
        JTableHeader tTemp = this.table.getTableHeader(); //contenido del encabezado
        TableColumnModel tcModel = tTemp.getColumnModel(); //cabecera de la tabla
        TableColumn tColumn;

        GrafoHashMap tempMap = new GrafoHashMap();
        char origen, destino;

        for (byte i = 0; i < tableData.length; i++) {
            for (byte j = 0; j < tableData[0].length; j++) {
                if (tableData[i][j] != null) {
                    if (!tableData[i][j].equals("null") || !tableData[i][j].equals("")) { //para no tener en cuenta valores nulos
                        origen = (char) (i + 65); //lo convierte a letra
                        destino = (char) (j + 65); //lo convierte a letra
                        tColumn = tcModel.getColumn(i); //se posiciona en el encabezado
                        tempMap.add(origen + "", destino + "", tColumn.getHeaderValue().toString(), (tableData[i][j]));
                    }
                }
            }
        }
        return tempMap;
    }

    public void printRuta(ArrayList pList) {
        StringBuilder builder;
        String cad = "";
        String cad2 = ""; //2do tipo de ruta

        String rel, rel2, origen, destino, descOrigen, descDestino, costo;

        for (int i = 0; i < pList.size(); i++) {
            //se obtiene la relación
            rel = pList.get(i).toString();

            //invierte las letras
            builder = new StringBuilder(rel);
            rel2 = builder.reverse().toString();

            //tipo de ruta 1
            cad += pList.get(i) + "->";

            //tipo de ruta 2
            origen = nodos.llaves.get(rel).getOrigen();
            destino = nodos.llaves.get(rel).getDestino();
            descOrigen = nodos.llaves.get(rel).getDescOrigen();
            descDestino = nodos.llaves.get(rel2).getDescOrigen();
            costo = nodos.llaves.get(rel).getCosto();

            cad2 += origen + ":" + descOrigen + " " + costo + " " + destino + ":" + descDestino + "\n";
        }
        System.out.println(cad.substring(0, cad.length() - 2));
        System.out.println(cad2);
    }

    @Override
    public void anchura(String s, boolean flagRoot) {
        String values;
        String[] parts;
        ArrayList internalList = new ArrayList();

        if (!flagRoot) { // si se trata del nodo raiz
            cola.add(s); //se inserta
        }

        if (cola.size() > 0) {
            s = cola.poll(); //saca el elemento
            ruta.add(s); //se va creando el camino

            //se obtienen los nodos hijos
            values = nodos.llaves.values() + "";
            parts = values.split(" ");
            //Obtiene los nodos con los que se conecta directamente
            for (int i = 0; i < parts.length; i++) {
                if (parts[i].equals("[" + s + "]")) {
                    internalList.add(parts[i + 1].substring(1, 2));
                }
            }
            Collections.sort(internalList); //ordena alfabéticamente los elementos de la lista

            for (int i = 0; i < internalList.size(); i++) { //inserta los hijos en el árbol
                if (!(listRoute.contains(internalList.get(i) + s)) && !(listRoute.contains(s + internalList.get(i)))) { //si la ruta no existe todavía
                    cola.add(internalList.get(i) + "");
                    listRoute.add(s + internalList.get(i)); //agregada a lista de rutas
                }
            }
            anchura(null, true);
        } else {
            System.out.println("Se terminó la búsqueda");
            printRuta(listRoute); //para pruebas
        }
    }

    @Override
    public void profundidad(String raiz) {
        String all;
        String[] parts;
        String almacena = "";
        String varO, varC;

        //Compara la raiz con el destino
        if (!raiz.equals(grafo.getDestino())) {
            all = nodos.llaves.values() + "";
            parts = all.split(" ");

            //SI LA VARIBLE PARTS POSICION [I] ES IGUAL A ORIGEN
            for (int i = 0; i < parts.length; i++) {
                if (parts[i].equals("[" + raiz + "]")) {
                    list.add(parts[i + 1].substring(1, 2));
//                almacena+=(parts[i + 1].substring(1, 2));      
                }
            }
//        char[] letras = almacena.toCharArray();
//        java.util.Arrays.sort(letras);
//        String ordenada = new String(letras);
//        list.add(ordenada);
//              
            cola.add(raiz);
//        for(int i=0;i<list.size();i++){
//            varO=(list.get(cnodos)+"").substring(0,1);
//            varC=(list.get(cnodos)+"").substring(0);
//            cola.add(varO);
//        //profundidad(varO);
//            System.out.println("almacena");
//        }
            System.out.println("Se encontró ruta\nCaminos:");
            System.out.println("Raiz: " + raiz);
            printRuta(list);

        } else {
            System.out.println("Se encontró ruta\nCaminos:");
            System.out.println(raiz + "->" + grafo.getDestino());
        }
    }
} // Fin de la clase 
