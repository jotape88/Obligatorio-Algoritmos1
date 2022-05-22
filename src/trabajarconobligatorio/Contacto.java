/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package trabajarconobligatorio;

/**
 *
 * @author Francisco
 */
public class Contacto {

    int ultimoId = 1;
    int numContacto;
    String nombre;

    public Contacto(String nombreContacto) {
        this.numContacto = ultimoId;
        this.nombre = nombreContacto;
        ultimoId++;
    }

}
