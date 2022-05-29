/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package trabajarconobligatorio;

/**
 *
 * @author Francisco
 */
public class Linea {

    private Lista<Palabra> listaPalabras;

    public Linea(Lista<Palabra> listaPalabras) {
        this.listaPalabras = listaPalabras;
    }

    public Lista<Palabra> getListaPalabras() {
        return listaPalabras;
    }

    public void setListaPalabras(Lista<Palabra> listaPalabras) {
        this.listaPalabras = listaPalabras;
    }

}
