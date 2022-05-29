package trabajarconobligatorio;

public class Lista<T> implements ILista<T> {

    private Nodo<T> inicio;
    private Nodo<T> fin;
    private int cantidad;
    private int tope;

    public int getTope() {
        return tope;
    }

    public void setTope(int tope) {
        this.tope = tope;
    }

    public Lista() {
        this.inicio = null;
        this.fin = null;
        this.cantidad = 0;
    }

    @Override
    public boolean esVacia() {
        return this.cantidad == 0;
    }

    @Override
    public void borrarInicio() {

    }

    @Override
    public void borrarFin() {

    }

    @Override
    public void mostrar() {

    }

    @Override
    public void vaciar() {
        this.inicio = null;
        this.fin = null;
        this.cantidad = 0;
    }

    public Nodo<T> getInicio() {
        return inicio;
    }

    @Override
    public void agregarInicio(T n) {

        Nodo<T> nuevo = new Nodo(n);
        if (esVacia()) {
            inicio = nuevo;
            fin = inicio;
        } else {
            nuevo.setSiguiente(getInicio());
            inicio = nuevo;
        }

        cantidad++;
    }

    @Override
    public void agregarFinal(T n) {
        Nodo<T> nuevo = new Nodo(n);
        if (this.esVacia()) {
            agregarInicio(n);
        } else {

            fin.setSiguiente(nuevo);
            fin = nuevo;
        }
        cantidad++;
    }

    @Override
    public void borrarElemento(T n) {

    }

    @Override
    public Nodo<T> obtenerElemento(T n) {
        Nodo<T> ret = new Nodo<>(n);
        return ret;
    }

    @Override
    public void agregarOrd(T n) {

    }

    @Override
    public void mostrarREC(T l) {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }

}
