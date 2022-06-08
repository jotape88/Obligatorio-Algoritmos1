/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package trabajarconobligatorio;

import java.util.Date;

/**
 *
 * @author Francisco
 */
public class Mensaje implements Comparable<Mensaje> {

    static int nroMensajes = 1;
    private final int numeroDeMensaje;
    private Contacto contOrigen; //Agregado (JP)
    private Contacto contDestino; //Agregado (JP)
    private Date fecha;
    private final Lista<Linea> listaLineas = new Lista<>();

    public Mensaje(Contacto contOrigen, Contacto contDestino, Date fecha, int topePalabras) {
        this.numeroDeMensaje = Mensaje.nroMensajes;
        this.contOrigen = contOrigen;
        this.contDestino = contDestino;
        this.fecha = fecha;
        Mensaje.nroMensajes++;
        //this.listaLineas = new Lista<>();
        this.listaLineas.setTope(topePalabras);
    }
    
    public Mensaje(int nroMensaje) {
        this.numeroDeMensaje = nroMensaje;
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

    public void setContOrigen(Contacto contOrigen) {
        this.contOrigen = contOrigen;
    }

    public void setContDestino(Contacto contDestino) {
        this.contDestino = contDestino;
    }

    public void setFecha(Date fecha) {
        this.fecha = fecha;
    }
    
    public int getNumeroDeMensaje() {
        return numeroDeMensaje;
    }

    @Override
    public int compareTo(Mensaje o) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public boolean equals(Object obj) {
        if (obj == null || obj.getClass() != this.getClass()) {
            return false;
        }
        Mensaje m = (Mensaje)obj;
        return m.getNumeroDeMensaje() == this.numeroDeMensaje; 
//        int v = (int)obj;
//        return v == this.numeroDeMensaje; 
    }
    
    @Override
    public String toString() {
        return "Mensaje{" + "numeroDeMensaje=" + getNumeroDeMensaje() + ", contOrigen=" + contOrigen.toString() + ", contDestino=" + contDestino.toString() + ", fecha=" + fecha + ", listaLineas=" + listaLineas + '}';
    }



}
