package trabajarconobligatorio;

public class Lista<T extends Comparable<T>> implements ILista<T> {

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
        if (!this.esVacia()) {
            if (cantidad == 1) {
                inicio = null;
                fin = null;
            }
            Nodo<T> aux = inicio;
            inicio = getInicio().getSiguiente();
            aux.setSiguiente(null);
            cantidad--;
        } else {

            System.out.println("Esta vacia");
        }
    }

    @Override
    public void borrarFin() {
        if (!this.esVacia()) {
            if (cantidad == 1) {
                inicio = null;
                fin = inicio;
            } else {
                Nodo<T> borrar = fin;
                //fin = borrar.getAnterior();
                fin.setSiguiente(null);
                //borrar.setAnterior(null);
            }
            cantidad--;
        }
    }

    @Override
    public void mostrar() {
        Nodo<T> mostrar = getInicio();
        while (mostrar != null) {
            System.out.print(mostrar.getDato().toString() + " - ");
            mostrar = mostrar.getSiguiente();
        }

        System.out.println("");
    }

    @Override
    public void vaciar() {
        this.inicio = null;
        this.fin = null;
        this.cantidad = 0;
    }

    public Nodo<T> getInicio() {
        return this.inicio;
    }

    @Override
    public void agregarInicio(T n) {
        Nodo<T> nuevo = new Nodo(n);
        if (esVacia()) {
            this.inicio = nuevo;
            this.fin = inicio;
        } else {
            nuevo.setSiguiente(getInicio());
            this.inicio = nuevo;
        }

        cantidad++;
    }

    @Override
    public void agregarFinal(T n) {
        Nodo<T> nuevo = new Nodo(n);
        if (this.esVacia()) {
            agregarInicio(n);
        } else {

            this.fin.setSiguiente(nuevo);
            this.fin = nuevo;
        }
        cantidad++;
    }

    @Override
    public void borrarElemento(T n) {
        if (!this.esVacia()) {
            if (n.equals(inicio.getDato())) {
                borrarInicio();
            } else {
                if (n.equals(fin.getDato())) {
                    borrarFin();
                } else {
                    Nodo<T> aux = inicio;
                    while (aux.getSiguiente() != null && !aux.getSiguiente().getDato().equals(n)) {
                        aux = aux.getSiguiente();
                    }
                    if (aux.getSiguiente() != null) {
                        Nodo<T> aBorrar = aux.getSiguiente();
                        aux.setSiguiente(aBorrar.getSiguiente());
                        //aux.getSiguiente().setAnterior(aux);            
                        aBorrar.setSiguiente(null);
                        //aBorrar.setAnterior(null);
                        cantidad--;
                    }
                }
            }
        }
    }

    @Override
    public Nodo<T> obtenerElemento(T n) {
        Nodo<T> ret = null;

        if (!this.esVacia()) {
            if (inicio.getDato().equals(n)) {
                ret = inicio;
            }
            if (fin.getDato().equals(n)) {
                ret = fin;
            }
            Nodo actual = inicio;
            while (actual != null) {
                if (actual.getDato().equals(n)) {
                    ret = actual;
                }
                actual = actual.getSiguiente();
            }
        }
        return ret;
    }
    
        @Override
    public Nodo<T> obtenerMensaje(int numMensaje) {
        Nodo<T> ret = null;

        if (!this.esVacia()) {
            if (inicio.getDato().equals(numMensaje)) {
                ret = inicio;
            }
            if (fin.getDato().equals(numMensaje)) {
                ret = fin;
            }
            Nodo actual = inicio;
            while (actual != null) {
                if (actual.getDato().equals(numMensaje)) {
                    ret = actual;
                }
                actual = actual.getSiguiente();
            }
        }
        return ret;
    }

    @Override
    public void agregarOrd(T n) {
        if (esVacia() || inicio.getDato().compareTo(n) > 0) {
            agregarInicio(n);
        } else {
            if (fin.getDato().compareTo(n) < 0) {
                agregarFinal(n);
            } else {
                Nodo<T> aux = inicio;

                while (aux.getSiguiente() != null && aux.getSiguiente().getDato().compareTo(n) < 0) {
                    aux = aux.getSiguiente();
                }
                Nodo nuevo = new Nodo(n);
                nuevo.setSiguiente(aux.getSiguiente());
                aux.setSiguiente(nuevo);
            }
        }
    }

    @Override
    public void mostrarREC(T l) {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }

}
