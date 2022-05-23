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
    private ListaLineas listaLineas;
    private int topeLineas;
    
    public NodoMensaje(Nodo elDato, int tope) {
        this.dato = elDato;
        this.topeLineas = tope;        
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
