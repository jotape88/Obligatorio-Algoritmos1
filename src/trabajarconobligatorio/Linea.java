/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package trabajarconobligatorio;

/**
 *
 * @author Francisco
 */
public class Linea implements Comparable<Linea> {

    private Lista<Palabra> listaPalabras;

    public Lista<Palabra> getListaPalabras() {
        return listaPalabras;
    }

    public void setListaPalabras(Lista<Palabra> listaPalabras) {
        this.listaPalabras = listaPalabras;
    }

    public Linea(int topePalabras) {
        this.listaPalabras.setTope(topePalabras);        
    }

    @Override
    public int compareTo(Linea o) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public String toString() {
        return "Linea{" + "listaPalabras=" + listaPalabras.getInicio().toString() + '}';
    }

}
