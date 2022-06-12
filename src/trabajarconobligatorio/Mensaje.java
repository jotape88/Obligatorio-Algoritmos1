/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package trabajarconobligatorio;

import java.text.SimpleDateFormat;
import java.util.Date;

/**
 *
 * @author Francisco
 */
public class Mensaje implements Comparable<Mensaje> {

    static int nroMensajes = 1;
    private final int numeroDeMensaje;
    private Contacto contOrigen;
    private Contacto contDestino;
    private Date fecha;
    private Lista<Linea> listaLineas = new Lista<>();

    public Mensaje(Contacto contOrigen, Contacto contDestino, Date fecha, int topePalabras) {
        this.numeroDeMensaje = Mensaje.nroMensajes;
        this.contOrigen = contOrigen;
        this.contDestino = contDestino;
        this.fecha = fecha;
        Mensaje.nroMensajes++;
        this.listaLineas.setTope(topePalabras);
    }

    public Lista<Linea> getListaLineas() {
        return listaLineas;
    }

    public void setListaLineas(Lista<Linea> listaLineas) {
        this.listaLineas = listaLineas;
    }

    public Mensaje(int nroMensaje) {
        this.numeroDeMensaje = nroMensaje;
    }

    public Mensaje(int nroMensaje, Contacto contOrigen) {
        this.numeroDeMensaje = nroMensaje;
        this.contOrigen = contOrigen;
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
        Mensaje m = (Mensaje) obj;

        if (m.getContOrigen() != null) {
            return m.getNumeroDeMensaje() == this.numeroDeMensaje && m.equals(m.contOrigen.numeroContacto);
        }
        System.out.println("this");
        System.out.println(this.contOrigen.getNumeroContacto());
        System.out.println("other");
        System.out.println(m.contOrigen.getNumeroContacto());
        System.out.println("");
        return m.getNumeroDeMensaje() == this.numeroDeMensaje;

    }

    @Override
    public String toString() {
        SimpleDateFormat sdf = new SimpleDateFormat();
        String fechaStr = "xx/xx/xxxx";
        sdf.applyPattern("dd/MM/yyyy");
        if (this.fecha != null) {
            fechaStr = sdf.format(this.fecha);
        }

        return "Mensaje: { \nnumeroDeMensaje : '" + numeroDeMensaje + "', \ncontOrigen : \n\t" + contOrigen + ", \ncontDestino : \n\t" + contDestino + ", \nfecha : '" + fechaStr + "', \nlistaLineas : '" + listaLineas.toString() + "'\n }";
    }

}
