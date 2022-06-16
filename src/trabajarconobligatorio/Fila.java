package trabajarconobligatorio;

public class Fila implements Comparable<Fila>{ 
    private String nombreCliente;
    private Lista<Celda> listaCelda = new Lista<>();

    public Fila(String nombreCliente) {
        this.nombreCliente = nombreCliente;
    }

    public String getNombreCliente() {
        return nombreCliente;
    }

    public void setNombreCliente(String nombreCliente) {
        this.nombreCliente = nombreCliente;
    }

    public Lista<Celda> getListaCelda() {
        return listaCelda;
    }

    public void setListaCelda(Lista<Celda> listaCelda) {
        this.listaCelda = listaCelda;
    }

    @Override
    public String toString() {
        return "Fila{" + "nombreCliente=" + nombreCliente + ", listaCelda=" + listaCelda.toString() + '}';
    }

    @Override
    public int compareTo(Fila o) {
        throw new UnsupportedOperationException("Not supported yet."); 
    }  
}
