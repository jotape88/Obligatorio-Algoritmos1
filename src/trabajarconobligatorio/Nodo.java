package trabajarconobligatorio;

public class Nodo<T> {

    private T dato;
    private Nodo<T> siguiente;
    private Nodo<T> anterior;

    public Nodo(T dato) {
        this.dato = dato;
        this.siguiente = null;
        this.anterior = null;
    }

    public T getDato() {
        return dato;
    }

    public void setDato(T dato) {
        this.dato = dato;
    }

    public Nodo<T> getSiguiente() {
        return siguiente;
    }

    public void setSiguiente(Nodo<T> siguiente) {
        this.siguiente = siguiente;
    }

    @Override
    public String toString() {
        return "Nodo{" + "dato=" + dato.toString() + ", siguiente=" + getSiguiente() + '}';
    }

    /**
     * @return the anterior
     */
    public Nodo<T> getAnterior() {
        return anterior;
    }

    /**
     * @param anterior the anterior to set
     */
    public void setAnterior(Nodo<T> anterior) {
        this.anterior = anterior;
    }

}
