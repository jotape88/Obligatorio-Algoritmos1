/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package trabajarconobligatorio;

import java.util.Date;
import java.util.Objects;

/**
 *
 * @author mauro
 */
public class Celda implements Comparable<Celda> {

    private Date fecha;
    private int cantMensajes = 0;

    public Celda(Date fecha) {
        this.fecha = fecha;
    }

    public int getCantMensajes() {
        return cantMensajes;
    }

    public void setCantMensajes(int cantMensajes) {
        this.cantMensajes = cantMensajes;
    }

    @Override
    public String toString() {
        return "Celda{" + "fecha=" + UTILS.fechaAString(fecha) + ", cantMensajes=" + cantMensajes + '}';
    }

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
        final Celda other = (Celda) obj;
        if (!Objects.equals(this.fecha, other.fecha)) {
            return false;
        }
        return true;
    }

    @Override
    public int compareTo(Celda o) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

}
