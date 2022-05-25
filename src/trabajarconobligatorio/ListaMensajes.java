/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package trabajarconobligatorio;

/**
 *
 * @author Francisco
 */
public class ListaMensajes implements ILista<NodoMensaje> {

    //cada mensaje de la lista
    private Nodo<NodoMensaje> inicio; //Tuve que cambiar <Mensaje> a nodomensaje
    final int topeLinea;
    private int cantidadMensajes;//Agregue la cantidad (JP)

    public ListaMensajes(int tope) {
        this.topeLinea = tope;
        this.cantidadMensajes = 0;
    }

    @Override
    public boolean esVacia() {
        return cantidadMensajes == 0; //Si no usamos esVacia, podemos eliminar la cantidadMensajes
    }

    @Override
    public void agregarInicio(NodoMensaje n) {
        Nodo<NodoMensaje> nuevo = new Nodo<NodoMensaje>(n);
        if (esVacia()) {
            inicio = nuevo;
            cantidadMensajes++;
        } else {
            nuevo.setSiguiente(inicio);
            inicio = nuevo;
            cantidadMensajes++;
        }
    }

    @Override
    public void agregarFinal(NodoMensaje n) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public void borrarInicio() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public void borrarFin() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public void vaciar() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public void mostrar() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public void agregarOrd(NodoMensaje n) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public void borrarElemento(NodoMensaje n) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public Nodo<Mensaje> obtenerElemento(NodoMensaje n) {
        Nodo ret = null;
 
        if(!this.esVacia()) {
            if(inicio.getDato() == n) {
                ret = inicio;
            } else {
                    Nodo<NodoMensaje> aux = inicio;
                    ret = null;
                        while( aux.getSiguiente() != null && ret == null ) {           
                            if(aux.getDato() == n) {
                                ret = aux;
                            }
                        }
                aux = aux.getSiguiente();             
                }
            }
        return ret;
    }

    @Override
    public void mostrarREC(NodoMensaje l) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    
    /**
     * @return the cantidadMensajes
     */
    public int getCantidadMensajes() {
        return cantidadMensajes;
    }

    /**
     * @param cantidadMensajes the cantidadMensajes to set
     */
    public void setCantidadMensajes(int cantidadMensajes) {
        this.cantidadMensajes = cantidadMensajes;
    }

}
