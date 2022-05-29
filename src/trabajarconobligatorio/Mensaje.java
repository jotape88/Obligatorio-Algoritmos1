/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package trabajarconobligatorio;

import java.util.Date; //Revisar

/**
 *
 * @author Francisco
 */
public class Mensaje implements Comparable<Mensaje>{

    private int nroMensaje;
    private Contacto contOrigen; //Agregado (JP)
    private Contacto contDestino; //Agregado (JP)
    private Date fecha; //Sera necesario un formato date?

    public Mensaje(int nroMensaje, Contacto contOrigen, Contacto contDestino, Date fecha) {
        this.nroMensaje = nroMensaje;
        this.contOrigen = contOrigen;
        this.contDestino = contDestino;
        this.fecha = fecha;
    }

    public int getNroMensaje() {
        return nroMensaje;
    }

    public Contacto getContOrigen() {
        return contOrigen;
    }

    public Contacto getContDestino() {
        return contDestino;
    }

    public Date getFecha() {
        return fecha;
    }

    public void setNroMensaje(int nroMensaje) {
        this.nroMensaje = nroMensaje;
    }

    public void setContOrigen(Contacto contOrigen) {
        this.contOrigen = contOrigen;
    }

    public void setContDestino(Contacto contDestino) {
        this.contDestino = contDestino;
    }

    public void setFecha(Date fecha) {
        this.fecha = fecha;
    }

    @Override
    public int compareTo(Mensaje o) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

}
