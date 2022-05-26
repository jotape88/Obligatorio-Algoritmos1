/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package trabajarconobligatorio;

/**
 *
 * @author Francisco
 */
public interface ILista<T extends Comparable<T>> {

    //metodos de la interfaz
    //post: Retorna un boolean indicado si la lista es vacía
    public boolean esVacia();

    //pre: El elemento a agregar es un entero
    //post: agrega el elemento al principio de la lista
    public void agregarInicio(T n);

    //pre: n es un entero
    //post: agrega el elemento al final de la lista
    public void agregarFinal(T n);

    //post: se borra el primer elemento de la lista
    public void borrarInicio();

    //post: se elimina el ultimo elemento de la lista
    public void borrarFin();

    //post: se vacia la lista
    public void vaciar();

    //post: se muestran todos los elementos de la lista en orden 
    public void mostrar();

    //pre: n es un entero
    //pre: la lista esta ordenada en forma ascendente
    //post: se interta el elemento n en forma ordenada
    public void agregarOrd(T n);

    //pre: n es un entero
    //post: se elimina la primera ocurrencia de n en la lista
    public void borrarElemento(T n);

    //pre: n es un entero
    //post: retronar el nodo que contiene el dato n
    public Nodo obtenerElemento(T n);

    //post: muestra la lista (realizar en forma recursiva)
    public void mostrarREC(T l);

}
