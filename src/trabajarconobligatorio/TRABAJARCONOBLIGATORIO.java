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

        Obligatorio obl = new Obligatorio();
        Prueba p = new Prueba();
        // juegodepruebaContactos(obl, p); // juego de prueba ejemplo
        // juegodepruebaMensajesYSistema(obl, p); // juego de prueba ejemplo
        // juegopruebaReporte(obl, p);
        juegodepruebaLineas(obl, p);
    }

    public static void juegodepruebaMensajesYSistema(Obligatorio obl, Prueba p) {
        p.ver(obl.crearSistemaMensajes(3).resultado, Retorno.Resultado.OK, "Se creara sistma para 3 palabras por linea");
        Date f = new Date();

        p.ver(obl.agregarMensaje(1, 2, f).resultado, Retorno.Resultado.OK, "Se agrega un mensaje");
        p.ver(obl.agregarMensaje(1, 3, f).resultado, Retorno.Resultado.OK, "Se agrega un mensaje");
        p.ver(obl.agregarMensaje(2, 4, f).resultado, Retorno.Resultado.OK, "Se agrega un mensaje");
//        Obligatorio.SistemaMensajes.mostrar();
        // p.ver(obl.eliminarMensaje(1, 1).resultado, Retorno.Resultado.OK, "Se elimina el mensaje 1");
//        Obligatorio.SistemaMensajes.mostrar();
        // p.ver(obl.destruirSistemaMensajes().resultado, Retorno.Resultado.OK, " sistema eliminado");
        // p.imprimirResultadosPrueba();

        juegopruebaDiccionario(obl, p);

    }

    public static void juegopruebaReporte(Obligatorio obl, Prueba p) {
        obl.crearSistemaMensajes(3);
        Date f = new Date();
        p.ver(obl.agregarMensaje(1, 2, f).resultado, Retorno.Resultado.OK, "Se agrega un mensaje");
        p.ver(obl.agregarMensaje(1, 3, f).resultado, Retorno.Resultado.OK, "Se agrega un mensaje");
        p.ver(obl.agregarMensaje(2, 4, f).resultado, Retorno.Resultado.OK, "Se agrega un mensaje");

        p.ver(obl.cantidadDeMensajes(1).resultado, Retorno.Resultado.OK, "Se muestra la cantidad de mensajes");
    }

    public static void juegopruebaDiccionario(Obligatorio obl, Prueba p) {

        obl.ingresarPalabraDiccionario("Diccionario1");
        obl.ingresarPalabraDiccionario("Diccionario2");
        obl.ingresarPalabraDiccionario("Diccionario3");

        obl.imprimirDiccionario();

//        juegopruebaDiccionario(obl, p);
//        
//
//        obl.agregarMensaje(1, 2, new Date());
//        obl.agregarMensaje(2, 3, new Date());
//        obl.agregarMensaje(1, 3, new Date());
//        
//    
//        System.out.println(obl.cantidadDeMensajes(1).valorEntero);
//        
//        obl.eliminarMensaje(1,1);
//        
//        System.out.println(obl.cantidadDeMensajes(1).valorEntero); 
    }

    public static void juegodepruebaContactos(Obligatorio obl, Prueba p) {
        p.ver(obl.agregarContacto(1, "Contacto1").resultado, Retorno.Resultado.OK, " sistema eliminado");
        p.ver(obl.agregarContacto(2, "Contacto2").resultado, Retorno.Resultado.OK, " sistema eliminado");
        p.ver(obl.agregarContacto(3, "Contacto3").resultado, Retorno.Resultado.OK, " sistema eliminado");
        p.ver(obl.agregarContacto(4, "Contacto4").resultado, Retorno.Resultado.OK, " sistema eliminado");
        obl.contactos.mostrar();
        System.out.println(obl.contactos.esVacia());
        p.imprimirResultadosPrueba();
    }

    public static void juegodepruebaLineas(Obligatorio obl, Prueba p) {
        System.out.println("JUEGO DE PRUEBA LINEAS");
        p.ver(obl.crearSistemaMensajes(3).resultado, Retorno.Resultado.OK, "Se creara sistma para 3 palabras por linea");
        Date f = new Date();
        p.ver(obl.agregarContacto(1, "Contacto1").resultado, Retorno.Resultado.OK, "Se agrega 'Contacto1'");
        p.ver(obl.agregarContacto(2, "Contacto2").resultado, Retorno.Resultado.OK, "Se agrega 'Contacto2'");
        p.ver(obl.agregarMensaje(1, 2, f).resultado, Retorno.Resultado.OK, "Se agrega un mensaje");

        p.ver(obl.insertarLinea(1, 1).resultado, Retorno.Resultado.OK, "Se agrega Linea");
        Obligatorio.SistemaMensajes.mostrar();

    }

}
