/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package trabajarconobligatorio;

/**
 *
 * @author Francisco
 */
public class NodoLinea {

    private Nodo dato;
    private Nodo siguiente;
    private ListaLineas listaLineas;
    private int topeLienas;
    
    public NodoLinea(Nodo elDato, int tope) {
        this.dato = elDato;
        this.topeLienas = tope;
        
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
