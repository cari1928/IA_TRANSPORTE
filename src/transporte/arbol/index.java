package transporte.arbol;

//import javafx.beans.binding.StringBinding;
/**
 * Estructura del archivo indice
 */
public class index {

    private String llave;
    private Integer direccionLogica;

    // Getters
    public String getLlave() {
        return llave;
    }

    public Integer getDireccionLogica() {
        return direccionLogica;
    }

    //Setters 
    public void setLlave(String llave) {
        this.llave = llave;
    }

    public void setDireccionLogica(Integer direccionLogica) {
        this.direccionLogica = direccionLogica;
    }

    @Override
    public String toString() {
        StringBuilder cadena = new StringBuilder();
        return cadena.append("Index").append(": ").append(llave).append(" ").append(direccionLogica).toString();
    }
} //Fin de la clase 
