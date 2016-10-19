package transporte.arbol;

public class nodoHash {

    String llave;
    String origen;
    String destino;
    String costo;
    String descOrigen;

    public nodoHash() {
    }

    public nodoHash(String llave, String origen, String destino, String costo) {
        this.llave = llave;
        this.origen = origen;
        this.destino = destino;
        this.costo = costo;
        this.descOrigen = null; //para los que no lo ocupen
    }

    //para tener el 
    public nodoHash(String llave, String origen, String descOrigen, String destino, String costo) {
        this.llave = llave;
        this.origen = origen;
        this.destino = destino;
        this.costo = costo;
        this.descOrigen = descOrigen;
    }

    public String getDescOrigen() {
        return descOrigen;
    }

    public void setDescOrigen(String descOrigen) {
        this.descOrigen = descOrigen;
    }

    public String getLlave() {
        return llave;
    }

    public String getOrigen() {
        return origen;
    }

    public String getDestino() {
        return destino;
    }

    public String getCosto() {
        return costo;
    }

    public void setLlave(String llave) {
        this.llave = llave;
    }

    public void setOrigen(String descripcion) {
        this.origen = descripcion;
    }

    public void setDestino(String relacion) {
        this.destino = relacion;
    }

    public void setCosto(String costo) {
        this.costo = costo;
    }

    @Override
    public String toString() {
        return llave + " [" + origen + "] (" + destino + ") Costo: " + costo;
    }
}
