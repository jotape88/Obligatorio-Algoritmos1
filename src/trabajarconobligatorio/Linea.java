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

    private Lista<Palabra> listaPalabras = new Lista<>();
    static private int numeroLineas = 0;

    @Override
    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null) {
            return false;
        }
        if (getClass() != obj.getClass()) {
            return false;
        }
        final Linea other = (Linea) obj;
        if (this.numeroLinea != other.numeroLinea) {
            return false;
        }
        return true;
    }
    private int numeroLinea = 0;

    public Linea() {
        this.numeroLinea = Linea.numeroLineas;
        Linea.numeroLineas++;
    }

    public Linea(int topePalabras) {
        this.listaPalabras.setTope(topePalabras);
    }

    public int getNumeroLinea() {
        return numeroLinea;
    }

    public void setNumeroLinea(int numeroLinea) {
        this.numeroLinea = numeroLinea;
    }

    public Lista<Palabra> getListaPalabras() {
        return listaPalabras;

    }

    public void setListaPalabras(Lista<Palabra> listaPalabras) {
        this.listaPalabras = listaPalabras;
    }

    @Override
    public int compareTo(Linea o) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public String toString() {
        return "Linea " + numeroLinea + " : " + listaPalabras.toString() + "}\n";
    }

}
