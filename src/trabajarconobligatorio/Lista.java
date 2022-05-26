package trabajarconobligatorio;

public class Lista<T extends Comparable<T>> implements ILista<T> {

    private Nodo inicio;
    private Nodo fin;
    private int cantidad;

    //Constructor   
    public Lista() {
        inicio = null;
        fin = null;
        cantidad = 0;
    }

    //obtener conctacto por numero
    public Contacto obtenerPorNumero(int numero) {

        Contacto ret = null;

        //inicializamos el obj contacto con el primero y el ultimo
        Contacto contactoI = (Contacto) inicio.getDato();
        Contacto contactoII = (Contacto) fin.getDato();

        if (!this.esVacia()) {

            if (contactoI.numeroContacto == numero) {

                ret = contactoI;
            } else {

                if (contactoII.numeroContacto == numero) {

                    ret = contactoII;

                } else {

                    Nodo actual = getInicio();
                    boolean encontre = false;

                    Contacto contactoActual = (Contacto) actual.getDato();

                    while (actual != null && contactoActual.numeroContacto != numero) {
                        actual = actual.getSiguiente();
                        contactoActual = (Contacto) actual.getDato();
                    }

                    if (actual != null) {

                        ret = contactoActual;
                    }

                }

            }

        }

        return ret;

    }

    @Override
    public boolean esVacia() {
        return getInicio() == null;
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

            //Si tiene un solo elemento
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

        Nodo mostrar = getInicio();

        while (mostrar != null) {

            System.out.print(mostrar.getDato() + " - ");
            mostrar = mostrar.getSiguiente();
        }

        System.out.println("");

    }

    @Override
    public void vaciar() {
        inicio = null;
        fin = null;
        cantidad = 0;
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

        Contacto contactoBorrar = (Contacto) n;
        System.out.println("contacto a borrar: " + contactoBorrar.toString());

        Contacto contactoI = (Contacto) inicio.getDato();
        Contacto contactoII = (Contacto) fin.getDato();

        if (!this.esVacia()) {

            if (contactoI.numeroContacto == contactoBorrar.numeroContacto) {
                borrarInicio();
            } else {
                if (fin.getDato() == n) {
                    borrarFin();
                } else {

                    Nodo aux = inicio;
                    while (aux.getSiguiente() != null && !aux.getSiguiente().getDato().equals(n)) {
                        aux = aux.getSiguiente();
                    }
                    if (aux.getSiguiente() != null) {
                        Nodo aBorrar = aux.getSiguiente();
                        aux.setSiguiente(aBorrar.getSiguiente());
                        aBorrar.setSiguiente(null);
                        cantidad--;
                    }

                }

            }

        }
    }

    @Override
    public Nodo obtenerElemento(T n) {

        Nodo<T> ret = null;

        if (!this.esVacia()) {

            if (inicio.getDato() == n) {
                ret = inicio;
            } else {

                if (fin.getDato() == n) {
                    ret = fin;
                } else {

                    Nodo actual = getInicio();
                    boolean encontre = false;

                    while (actual != null && actual.getDato() != n) {
                        actual = actual.getSiguiente();
                    }

                    if (actual != null) {
                        ret = actual;
                    }

                }

            }

        }

        return ret;
    }

    @Override
    public void agregarOrd(T n
    ) {

//        Nodo<T> nuevo = new Nodo(n);
//
//        if (this.esVacia()) {
//            inicio = nuevo;
//        } else {
//
//            if (getInicio().getDato().compareTo(n) > 0) {
//                agregarInicio(n);
//            } else {
//                Nodo<T> actual = getInicio();
//
//                while (actual.getSiguiente() != null && actual.getSiguiente().getDato().compareTo(n) < 0) {
//                    actual = actual.getSiguiente();
//                }
//
//                nuevo.setSiguiente(actual.getSiguiente());
//                actual.setSiguiente(nuevo);
//
//            }
//        }
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody

    }

    @Override
    public void mostrarREC(T l) {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }

}
