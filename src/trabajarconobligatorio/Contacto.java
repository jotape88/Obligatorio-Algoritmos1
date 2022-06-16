package trabajarconobligatorio;

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
        throw new UnsupportedOperationException("Not supported yet."); 
    }

    @Override
    public boolean equals(Object obj) {
        if (obj == null || obj.getClass() != this.getClass()) {
            return false;
        }
        Contacto c = (Contacto) obj;
        return c.getNumeroContacto() == this.numeroContacto; 
    }

    public String toString() {
        return  "{ Numero : " + this.numeroContacto + ", Nombre : '" + this.nombre + "' }";
    }

    public int getNumeroContacto() {
        return numeroContacto;
    }

    public void setNumeroContacto(int numeroContacto) {
        this.numeroContacto = numeroContacto;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

}
