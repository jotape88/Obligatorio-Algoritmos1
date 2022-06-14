/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package trabajarconobligatorio;

/**
 *
 * @author Francisco
 */
public class Contacto implements Comparable<Contacto> {

    public int numeroContacto;
    private String nombre;

    public Contacto(int numContacto, String nombreContacto) {
        this.numeroContacto = numContacto;
        this.nombre = nombreContacto;
    }

    public Contacto(int numContacto) {
        this.numeroContacto = numContacto;
    }

    @Override
    public int compareTo(Contacto o) {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }

    @Override
    public boolean equals(Object obj) {
        if (obj == null || obj.getClass() != this.getClass()) {
            return false;
        }
        Contacto c = (Contacto) obj;
        return c.getNumeroContacto() == this.numeroContacto; //J.P
    }

    public String toString() {
        return  "{ Numero : " + this.numeroContacto + ", Nombre : '" + this.nombre + "' }";
    }

    /**
     * @return the numeroContacto
     */
    public int getNumeroContacto() {
        return numeroContacto;
    }

    /**
     * @param numeroContacto the numeroContacto to set
     */
    public void setNumeroContacto(int numeroContacto) {
        this.numeroContacto = numeroContacto;
    }

    /**
     * @return the nombre
     */
    public String getNombre() {
        return nombre;
    }

    /**
     * @param nombre the nombre to set
     */
    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

}
