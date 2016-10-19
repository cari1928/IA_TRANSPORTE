package transporte.arbol;

public class nodoHash {

    String llave;
    String descripcion;
    String relacion;
    String costo;

    public nodoHash() {
    }

     
    public nodoHash(String llave, String descripcion, String relacion, String costo) {
        this.llave = llave;
        this.descripcion = descripcion;
        this.relacion = relacion;
        this.costo = costo;
    }

    public String getLlave() {
        return llave;
    }

    public String getDescripcion() {
        return descripcion;
    }

    public String getRelacion() {
        return relacion;
    }

    public String getCosto() {
        return costo;
    }

    public void setLlave(String llave) {
        this.llave = llave;
    }

    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }

    public void setRelacion(String relacion) {
        this.relacion = relacion;
    }

    public void setCosto(String costo) {
        this.costo = costo;
    }

   
    

    @Override
    public String toString() {
        return llave + " [" + descripcion + "] (" + relacion + ") Costo: " + costo;
    }
}
