package trabajarconobligatorio;

public class Nodo<T> {

    //Atributos
    private T dato;
    private Nodo siguiente;

    //Constructor
    public Nodo(T elDato) {
        this.setDato(elDato);
        this.setSiguiente(null);
    }

    public T getDato() {
        return dato;
    }

    public void setDato(T dato) {
        this.dato = dato;
    }

    public Nodo getSiguiente() {
        return siguiente;
    }

    public void setSiguiente(Nodo siguiente) {
        this.siguiente = siguiente;
    }

}
