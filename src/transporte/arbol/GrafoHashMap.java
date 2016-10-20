package transporte.arbol;

import java.util.Collection;
import java.util.HashMap;

public class GrafoHashMap {

    public HashMap<String, nodoHash> llaves;

    public GrafoHashMap() {
        llaves = new HashMap<>();
    }

    public void add(String origen, String destino, String costo) {
        String llave = origen + destino;
        nodoHash n = new nodoHash(llave, origen, destino, costo);
        llaves.put(llave, n);
    }

    public void add(String origen, String destino, String descOrigen, String costo) {
        String llave = origen + destino; //relación
        nodoHash tdaNodo = new nodoHash(llave, origen, descOrigen, destino, costo);
        llaves.put(llave, tdaNodo); //se guarda toda la info en el hashmap
    }

    @Override
    public String toString() {
        String ret = "";
        for (nodoHash n : llaves.values()) {
            ret += n + "\n";
        }
        return ret;
    }

    public nodoHash buscar(String llave) {
        return llaves.get(llave);
    }

    public Collection<nodoHash> values() {
        return llaves.values();
    }

    public HashMap<String, nodoHash> getLlaves() {
        return llaves;
    }
}
