package trabajarconobligatorio;

import java.util.Date;
import java.time.LocalDate;

/**
 *
 * @author Rafael
 */
public class TRABAJARCONOBLIGATORIO {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {

        Obligatorio obl = new Obligatorio();
        Prueba p = new Prueba();
        juegodepruebaContactos(obl, p); // juego de prueba ejemplo

        juegodepruebaMensajesYSistema(obl, p); // juego de prueba ejemplo  

    }

    public static void juegodepruebaMensajesYSistema(Obligatorio obl, Prueba p) {
        p.ver(obl.crearSistemaMensajes(3).resultado, Retorno.Resultado.OK, "Se creara sistma para 3 palabras por linea");
        Date f = new Date();
        System.out.println("El tercer Contacto");
        System.out.println(obl.contactos.obtenerElemento(new Contacto(3)).getDato().toString());
       
        
        p.ver(obl.agregarMensaje(1, 2, f).resultado, Retorno.Resultado.OK, "Se agrega un mensaje");
        Obligatorio.SistemaMensajes.mostrar();
        p.ver(obl.eliminarMensaje(1, 1).resultado, Retorno.Resultado.OK, "Se elimina el mensaje creado");
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
        // System.out.println(obl.contactos.esVacia());
        p.imprimirResultadosPrueba();
    }
}
