/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package trabajarconobligatorio;

/**
 *
 * @author Francisco
 */
public class NodoMensaje {

    private NodoMensaje dato;
    private NodoMensaje siguiente;
    private ListaLineas listaLineas;
    private int topeLineas;

    public NodoMensaje(NodoMensaje elDato, int tope) {
        this.dato = elDato;
        this.topeLineas = tope;
        listaLineas = new ListaLineas(tope);
    }

    public NodoMensaje getSiguiente() {
        return siguiente;
    }

    public void setSiguiente(NodoMensaje siguiente) {
        this.siguiente = siguiente;
    }

    public ListaLineas getListaLineas() {
        return listaLineas;
    }

    public void setListaLineas(ListaLineas listaLineas) {
        this.listaLineas = listaLineas;
    }

    public int getTopeLineas() {
        return topeLineas;
    }

    public void setTopeLineas(int topeLineas) {
        this.topeLineas = topeLineas;
    }

    public NodoMensaje getDato() {
        return dato;
    }

    public void setDato(NodoMensaje dato) {
        this.dato = dato;
    }

}
