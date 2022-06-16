package trabajarconobligatorio;

public class Lista<T extends Comparable<T>> implements ILista<T> {

    private Nodo<T> inicio;
    private Nodo<T> fin;
    private int cantidad;
    private int tope;

    public int getTope() {
        return tope;
    }

    public int getCantidad() {
        return cantidad;
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
                fin = null;
            }

            inicio = getInicio().getSiguiente();
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
                Nodo actual = getInicio();
                Nodo siguiente = getInicio().getSiguiente();

                while (siguiente.getSiguiente() != null) {

                    actual = siguiente;
                    siguiente = siguiente.getSiguiente();
                }

                actual.setSiguiente(null);
                fin = actual;

            }

            cantidad--;

        }

    }

    @Override
    public void mostrar() {
        Nodo<T> actual = getInicio();
        if (actual != null) {
            System.out.println("Lista de " + actual.getDato().getClass().toString().split("[.]")[1] + "s : [");
            while (actual != null) {
                System.out.print(actual.getDato().toString() + " - " + "\n");
                actual = actual.getSiguiente();
            }
            System.out.println(" ]");
        } else {
            System.out.println("La lista esta vacia");
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
            nuevo.setSiguiente(this.getInicio());
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
            this.getFin().setSiguiente(nuevo);
            this.fin = nuevo;
            cantidad++;
        }
    }

    @Override
    public void borrarElemento(T n) {
        if (!this.esVacia()) {
            if (inicio.getDato().equals(n)) {
                borrarInicio();
            } else {
                if (getFin().getDato().equals(n)) {
                    borrarFin();
                } else {
                    Nodo<T> aux = inicio;
                    while (aux.getSiguiente() != null && !aux.getSiguiente().getDato().equals(n)) {
                        aux = aux.getSiguiente();
                    }
                    if (aux.getSiguiente() != null) {
                        Nodo<T> aBorrar = aux.getSiguiente();
                        aux.setSiguiente(aBorrar.getSiguiente());
                        aBorrar.setSiguiente(null);
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
            } else {
                if (getFin().getDato().equals(n)) {
                    ret = getFin();
                } else {
                    Nodo actual = getInicio();
                    boolean encontre = false;
                    while (actual != null && !encontre) {
                        if (actual.getDato().equals(n)) {
                            ret = actual;
                            encontre = true;
                        }
                        actual = actual.getSiguiente();
                    }
                }
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
            if (getFin().getDato().equals(numMensaje)) {
                ret = getFin();
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
            if (getFin().getDato().compareTo(n) < 0) {
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
        throw new UnsupportedOperationException("Not supported yet."); 
    }

    /*
    public class GFG {
    public static void main(String args[])
    {
        String str = "geekss@for@geekss";
        String[] arrOfStr = str.split("@", 2);
  
        for (String a : arrOfStr)
            System.out.println(a);
    }
}
    
     */
    @Override
    public String toString() {
        if (this.esVacia()) {
            return "La lista esta vacia";
        }
        String datosLista = "";
        Nodo<T> actual = this.inicio;
        while (actual != null) {
            datosLista += actual.getDato().toString();
            actual = actual.getSiguiente();
        }
        return datosLista;
    }

    public Nodo<T> getFin() {
        return fin;
    }

}
