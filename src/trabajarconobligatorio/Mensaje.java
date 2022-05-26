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
public class Mensaje {

    private int nroMensaje;
    private Contacto contOrigen; //Agregado (JP)
    private Contacto contDestino; //Agregado (JP)
    private Date fecha; //Sera necesario un formato date?
    private NodoMensaje inicio;

    public Mensaje(int nroMensaje, Contacto contOrigen, Contacto contDestino, Date fecha) {  //Cree el constructor (J.P)
        this.nroMensaje = nroMensaje;
        this.contOrigen = contOrigen;
        this.contDestino = contDestino;
        this.fecha = fecha;;
    }

    /**
     * @return the nroMensaje
     */
    public int getNroMensaje() {
        return nroMensaje;
    }

    /**
     * @param nroMensaje the nroMensaje to set
     */
    public void setNroMensaje(int nroMensaje) {
        this.nroMensaje = nroMensaje;
    }

    /**
     * @return the Inicio
     */
    public NodoMensaje getInicio() {
        return inicio;
    }

    /**
     * @param Inicio the Inicio to set
     */
    public void setInicio(NodoMensaje Inicio) {
        this.inicio = Inicio;
    }

    /**
     * @return the contOrigen
     */
    public Contacto getContOrigen() {
        return contOrigen;
    }

    /**
     * @param contOrigen the contOrigen to set
     */
    public void setContOrigen(Contacto contOrigen) {
        this.contOrigen = contOrigen;
    }

    /**
     * @return the contDestino
     */
    public Contacto getContDestino() {
        return contDestino;
    }

    /**
     * @param contDestino the contDestino to set
     */
    public void setContDestino(Contacto contDestino) {
        this.contDestino = contDestino;
    }

    /**
     * @return the fecha
     */
    public Date getFecha() {
        return fecha;
    }

    /**
     * @param fecha the fecha to set
     */
    public void setFecha(Date fecha) {
        this.fecha = fecha;
    }

}
