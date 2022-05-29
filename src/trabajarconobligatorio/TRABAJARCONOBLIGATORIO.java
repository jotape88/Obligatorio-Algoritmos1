package trabajarconobligatorio;

import java.util.Date;

/**
 *
 * @author Rafael
 */
public class TRABAJARCONOBLIGATORIO {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        // TODO code application logic here
        Obligatorio obl = new Obligatorio();
        Prueba p = new Prueba();
        juegodepruebaContactos(obl, p); // juego de prueba ejemplo
        juegodepruebaMensajesYSistema(obl, p); // juego de prueba ejemplo

    }

    public static void juegodepruebaMensajesYSistema(Obligatorio obl, Prueba p) {
        p.ver(obl.crearSistemaMensajes(3).resultado, Retorno.Resultado.OK, "Se creara sistma para 3 palabras por linea");
        Obligatorio.SistemaMensajes.mostrar();
        p.ver(obl.destruirSistemaMensajes().resultado, Retorno.Resultado.OK, " sistema eliminado");
        p.imprimirResultadosPrueba();
    }

    public static void juegodepruebaContactos(Obligatorio obl, Prueba p) {
        p.ver(obl.agregarContacto(1, "Contacto1").resultado, Retorno.Resultado.OK, " sistema eliminado");
        p.ver(obl.agregarContacto(2, "Contacto2").resultado, Retorno.Resultado.OK, " sistema eliminado");
        p.ver(obl.agregarContacto(3, "Contacto3").resultado, Retorno.Resultado.OK, " sistema eliminado");
        p.ver(obl.agregarContacto(4, "Contacto4").resultado, Retorno.Resultado.OK, " sistema eliminado");
        obl.contactos.mostrar();
        p.imprimirResultadosPrueba();
    }
}
