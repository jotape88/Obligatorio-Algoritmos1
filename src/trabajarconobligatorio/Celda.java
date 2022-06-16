package trabajarconobligatorio;

import java.util.Date;
import java.util.Objects;

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
        throw new UnsupportedOperationException("Not supported yet.");
    }
}
