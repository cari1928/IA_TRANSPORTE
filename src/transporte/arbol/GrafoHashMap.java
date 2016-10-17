package transporte.arbol;

import java.util.Collection;
import java.util.HashMap;

public class GrafoHashMap {

    public HashMap<String, nodoHash> llaves;

    public GrafoHashMap() 
    {
        llaves = new HashMap<>();
        
    }

    public void add(String origen, String destino, int costo) {
        String llave = origen + destino;
        nodoHash n = new nodoHash(llave, origen, destino, costo);
        llaves.put(llave, n);
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
    
    
    public Collection<nodoHash> values()
    {
        return llaves.values();
    }
    
    public HashMap<String, nodoHash> getLlaves()
    {
        return llaves;
    }
}
