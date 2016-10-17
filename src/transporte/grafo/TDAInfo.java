
package transporte.grafo;

/**Clase que almacena la informacion de un Registro*/
public class TDAInfo 
{
    private String llave;
    private String origen;
    private String destino;
    private int costo;

    public TDAInfo() {
    }
    
    

    public TDAInfo(String llave, String origen, String destino, int costo) {
        this.llave = llave;
        this.origen = origen;
        this.destino = destino;
        this.costo = costo;
    }

    public String getLlave() {
        return llave;
    }

    public void setLlave(String llave) {
        this.llave = llave;
    }

    public String getOrigen() {
        return origen;
    }

    public void setOrigen(String origen) {
        this.origen = origen;
    }

    public String getDestino() {
        return destino;
    }

    public void setDestino(String destino) {
        this.destino = destino;
    }

    public int getCosto() {
        return costo;
    }

    public void setCosto(int costo) {
        this.costo = costo;
    }
    
     
    @Override
    public String toString() 
    {
        return  llave +" ["+origen+"] ("+destino+") Costo: "+costo;
    }
}
