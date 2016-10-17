package transporte.grafo;

/**
 * Interface que proporciona metodos genericos para poder realizar una busqueda
 *
 * @author AlphaGo
 */
public interface Busqueda {

    /**
     * Implementea la busqueda en anchura
     */
    abstract void anchura(String raiz, boolean flagRoot);
    abstract void profundidad(String raiz);
} // Fin de la interface
