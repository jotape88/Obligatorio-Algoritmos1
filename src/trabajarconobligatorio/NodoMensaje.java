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

    private Nodo dato;
    private Nodo siguiente;

    public NodoMensaje(Nodo elDato) {
        this.dato = elDato;

    }

    /**
     * @return the dato
     */
    public Nodo getDato() {
        return dato;
    }

    /**
     * @param dato the dato to set
     */
    public void setDato(Nodo dato) {
        this.dato = dato;
    }

}
