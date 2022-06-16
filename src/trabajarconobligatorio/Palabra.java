package trabajarconobligatorio;

import java.util.Objects;

public class Palabra implements Comparable<Palabra> {

    private String dato = "";
    static int posicionPalabras = 1;
    private int posicion = 1;

    public Palabra() {
        this.posicion = Palabra.posicionPalabras;
        Palabra.posicionPalabras++;
    }

    public Palabra(String dato) {
        this.dato = dato;
    }

    public String getDato() {
        return dato;
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
        final Palabra other = (Palabra) obj;

        if (this.posicion != other.posicion) {
            return false;
        }
        return Objects.equals(this.dato, other.dato);
    }

    public void setDato(String dato) {
        this.dato = dato;
    }

    @Override
    public String toString() {
        return dato + " ";
    }

    @Override
    public int compareTo(Palabra o) {
        throw new UnsupportedOperationException("Not supported yet."); 
    }

}
