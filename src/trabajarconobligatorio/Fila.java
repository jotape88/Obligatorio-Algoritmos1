/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package trabajarconobligatorio;

/**
 *
 * @author mauro
 */
public class Fila implements Comparable<Fila>{ 
    private String nombreCliente;
    private Lista<Celda> listaCelda = new Lista<>();

    public Fila(String nombreCliente) {
        this.nombreCliente = nombreCliente;
    }

    public String getNombreCliente() {
        return nombreCliente;
    }

    public void setNombreCliente(String nombreCliente) {
        this.nombreCliente = nombreCliente;
    }

    public Lista<Celda> getListaCelda() {
        return listaCelda;
    }

    public void setListaCelda(Lista<Celda> listaCelda) {
        this.listaCelda = listaCelda;
    }

    @Override
    public String toString() {
        return "Fila{" + "nombreCliente=" + nombreCliente + ", listaCelda=" + listaCelda.toString() + '}';
    }

    @Override
    public int compareTo(Fila o) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
    
    
    
}
