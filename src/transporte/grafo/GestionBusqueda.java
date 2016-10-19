package transporte.grafo;

import java.util.ArrayList;
import java.util.Collections;
import java.util.LinkedList;
import java.util.Queue;
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

        //Se llena hashMap
        String[][] tableData = this.table.getRedGrafo().getMatrix();
        this.nodos = fillHashMap(tableData);
    }

    public GrafoHashMap fillHashMap(String[][] array) {
        GrafoHashMap map = new GrafoHashMap();
        char origen, destino;
        for (byte i = 0; i < array.length; i++) {
            for (byte j = 0; j < array[0].length; j++) {
                //no hay valores vacíos o nulos
                if (!array[i][j].equals("null") || !array[i][j].equals("") || !(array[i][j] == null)) {
                    origen = (char) (i + 65); //lo convierte a letra
                    destino = (char) (j + 65); //lo convierte a letra
                    map.add(origen + "", destino + "", (array[i][j]));
                }
            }
        }
        return map;
    }

    public void printRuta(ArrayList pList) {
        String cad = "";
        for (int i = 0; i < pList.size(); i++) {
            cad += pList.get(i) + "->";
        }
        System.out.println(cad.substring(0, cad.length() - 2));
    }

    @Override
    public void anchura(String s, boolean flagRoot) {
        String values;
        String[] parts;
        ArrayList list = new ArrayList();

        if (!flagRoot) { // si se trata del nodo raiz
            cola.add(s); //se inserta
        }

        if (cola.size() > 0) {
            s = cola.poll();
            ruta.add(s); //se va creando el camino
            if (!s.equals(grafo.getDestino())) { //no es el destino
                //se obtienen los nodos hijos
                values = nodos.llaves.values() + "";
                parts = values.split(" ");
                //Obtiene los nodos con los que se conecta directamente
                for (int i = 0; i < parts.length; i++) {
                    if (parts[i].equals("[" + s + "]")) {
                        list.add(parts[i + 1].substring(1, 2));
                    }
                }
                Collections.sort(list); //ordena alfabéticamente los elementos de la lista
                for (int i = 0; i < list.size(); i++) { //inserta los hijos en el árbol
                    if (!(listRoute.contains(list.get(i) + s)) && !(listRoute.contains(s + list.get(i)))) { //si la ruta no existe todavía
                        cola.add(list.get(i) + "");
                        listRoute.add(s + list.get(i)); //agregada a lista de rutas
                    }
                }
                anchura(null, true);
            } else {
                System.out.println("Se encontró ruta\nCaminos:");
                printRuta(listRoute);
            }
        } else {
            System.out.println("No se encontró alguna ruta");
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
