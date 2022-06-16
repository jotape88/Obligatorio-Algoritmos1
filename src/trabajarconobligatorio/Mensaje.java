package trabajarconobligatorio;

import java.text.SimpleDateFormat;
import java.util.Date;

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
        throw new UnsupportedOperationException("Not supported yet.");                                                                 
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
        return "Mensaje: { numeroDeMensaje : '" + numeroDeMensaje + "', contOrigen : "
                + contOrigen + ", contDestino : " + contDestino + ", fecha : '" + fechaStr + "', listaLineas : '"
                + listaLineas.toString() + "'\n }";
    }

}
