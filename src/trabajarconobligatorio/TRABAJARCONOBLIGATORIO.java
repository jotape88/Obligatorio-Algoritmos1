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

        // juegodepruebaSistema(obl, p); 
        juegodepruebaContactos(obl, p);
//        juegodepruebaMensajes(obl, p);

        //juegopruebaDiccionario(obl, p);
//        juegodepruebaLineas(obl, p);
        //juegopruebaReporte(obl, p);
    }

    public static void juegodepruebaSistema(Obligatorio obl, Prueba p) {
        p.ver(obl.crearSistemaMensajes(3).resultado, Retorno.Resultado.OK, "Se creara un sistema para 3 palabras por línea");
        Obligatorio.SistemaMensajes.mostrar();
        p.ver(obl.destruirSistemaMensajes().resultado, Retorno.Resultado.OK, "Sistema anterior eliminado");
        p.imprimirResultadosPrueba();
    }

    public static void juegodepruebaContactos(Obligatorio obl, Prueba p) {
        obl.crearSistemaMensajes(3);
        Date f = new Date();
        p.ver(obl.agregarMensaje(1, 2, f).resultado, Retorno.Resultado.OK, "Se agrega un mensaje para el contacto 1 como origen y el contacto 2 como destino, Esperado: OK");
        p.ver(obl.agregarMensaje(1, 3, f).resultado, Retorno.Resultado.OK, "Se agrega un mensaje para el contacto 1 como origen y el contacto 3 como destino, Esperado: OK");
        p.ver(obl.agregarMensaje(1, 3, f).resultado, Retorno.Resultado.OK, "Se agrega un mensaje para el contacto 1 como origen y el contacto 3 como destino, Esperado: OK");
        p.ver(obl.agregarMensaje(2, 4, f).resultado, Retorno.Resultado.OK, "Se agrega un mensaje para el contacto 2 como origen y el contacto 4 como destino, Esperado: OK");
        obl.agregarMensaje(3, 2, f);
        obl.agregarMensaje(3, 9, f);
        obl.agregarMensaje(3, 5, f);
        obl.agregarMensaje(5, 6, f);
        obl.agregarMensaje(5, 7, f);
        obl.agregarMensaje(5, 8, f);
        obl.agregarMensaje(5, 10, f);
        obl.agregarMensaje(6, 4, f);
        obl.agregarMensaje(6, 3, f);
        obl.agregarMensaje(7, 4, f);
        obl.agregarMensaje(8, 3, f);
        obl.agregarMensaje(8, 9, f);
        obl.agregarMensaje(8, 10, f);
        obl.agregarMensaje(10, 1, f);
        obl.agregarMensaje(10, 2, f);
        obl.agregarMensaje(5, 1, f);
        obl.agregarMensaje(6, 2, f);
        obl.agregarMensaje(8, 7, f);

        p.ver(obl.agregarMensaje(25, 41, f).resultado, Retorno.Resultado.ERROR, "Se intenta agregar un mensaje para un contacto de origen 25 y un contacto destino 41, ambos inexistentes, Esperado: ERROR");
        p.ver(obl.agregarMensaje(250, 2, f).resultado, Retorno.Resultado.ERROR, "Se intenta agregar un mensaje para un contacto de origen 250 inexistente, Esperado: ERROR");
        p.ver(obl.agregarMensaje(2, 128, f).resultado, Retorno.Resultado.ERROR, "Se intenta agregar un mensaje para un contacto de destino 128 inexistente, Esperado: ERROR");

        p.imprimirResultadosPrueba();
        obl.destruirSistemaMensajes();
    }

    public static void juegodepruebaMensajes(Obligatorio obl, Prueba p) {
        Date f = new Date();
        p.ver(obl.agregarMensaje(1, 2, f).resultado, Retorno.Resultado.OK, "Se agrega un mensaje para el contacto 1 como origen y el contacto 2 como destino, Esperado: OK");
        p.ver(obl.agregarMensaje(1, 3, f).resultado, Retorno.Resultado.OK, "Se agrega un mensaje para el contacto 1 como origen y el contacto 3 como destino, Esperado: OK");
        p.ver(obl.agregarMensaje(1, 3, f).resultado, Retorno.Resultado.OK, "Se agrega un mensaje para el contacto 1 como origen y el contacto 3 como destino, Esperado: OK");
        p.ver(obl.agregarMensaje(2, 4, f).resultado, Retorno.Resultado.OK, "Se agrega un mensaje para el contacto 2 como origen y el contacto 4 como destino, Esperado: OK");
        p.ver(obl.agregarMensaje(3, 2, f).resultado, Retorno.Resultado.OK, "Se agrega un mensaje para el contacto 3 como origen y el contacto 2 como destino, Esperado: OK");
        p.ver(obl.agregarMensaje(3, 9, f).resultado, Retorno.Resultado.OK, "Se agrega un mensaje para el contacto 3 como origen y el contacto 9 como destino, Esperado: OK");
        p.ver(obl.agregarMensaje(3, 5, f).resultado, Retorno.Resultado.OK, "Se agrega un mensaje para el contacto 3 como origen y el contacto 5 como destino, Esperado: OK");
        p.ver(obl.agregarMensaje(5, 6, f).resultado, Retorno.Resultado.OK, "Se agrega un mensaje para el contacto 5 como origen y el contacto 6 como destino, Esperado: OK");
        p.ver(obl.agregarMensaje(5, 7, f).resultado, Retorno.Resultado.OK, "Se agrega un mensaje para el contacto 5 como origen y el contacto 7 como destino, Esperado: OK");
        p.ver(obl.agregarMensaje(5, 8, f).resultado, Retorno.Resultado.OK, "Se agrega un mensaje para el contacto 5 como origen y el contacto 8 como destino, Esperado: OK");
        p.ver(obl.agregarMensaje(5, 10, f).resultado, Retorno.Resultado.OK, "Se agrega un mensaje para el contacto 5 como origen y el contacto 10 como destino, Esperado: OK");
        p.ver(obl.agregarMensaje(6, 4, f).resultado, Retorno.Resultado.OK, "Se agrega un mensaje para el contacto 6 como origen y el contacto 4 como destino, Esperado: OK");
        p.ver(obl.agregarMensaje(6, 3, f).resultado, Retorno.Resultado.OK, "Se agrega un mensaje para el contacto 6 como origen y el contacto 3 como destino, Esperado: OK");
        p.ver(obl.agregarMensaje(7, 4, f).resultado, Retorno.Resultado.OK, "Se agrega un mensaje para el contacto 7 como origen y el contacto 4 como destino, Esperado: OK");
        p.ver(obl.agregarMensaje(8, 3, f).resultado, Retorno.Resultado.OK, "Se agrega un mensaje para el contacto 8 como origen y el contacto 3 como destino, Esperado: OK");
        p.ver(obl.agregarMensaje(8, 9, f).resultado, Retorno.Resultado.OK, "Se agrega un mensaje para el contacto 8 como origen y el contacto 9 como destino, Esperado: OK");
        p.ver(obl.agregarMensaje(8, 10, f).resultado, Retorno.Resultado.OK, "Se agrega un mensaje para el contacto 8 como origen y el contacto 10 como destino, Esperado: OK");
        p.ver(obl.agregarMensaje(10, 1, f).resultado, Retorno.Resultado.OK, "Se agrega un mensaje para el contacto 10 como origen y el contacto 1 como destino, Esperado: OK");
        p.ver(obl.agregarMensaje(10, 2, f).resultado, Retorno.Resultado.OK, "Se agrega un mensaje para el contacto 10 como origen y el contacto 2 como destino, Esperado: OK");
        p.ver(obl.agregarMensaje(5, 1, f).resultado, Retorno.Resultado.OK, "Se agrega un mensaje para el contacto 5 como origen y el contacto 1 como destino, Esperado: OK");
        p.ver(obl.agregarMensaje(6, 2, f).resultado, Retorno.Resultado.OK, "Se agrega un mensaje para el contacto 6 como origen y el contacto 2 como destino, Esperado: OK");
        p.ver(obl.agregarMensaje(8, 7, f).resultado, Retorno.Resultado.OK, "Se agrega un mensaje para el contacto 8 como origen y el contacto 7 como destino, Esperado: OK");
        p.ver(obl.agregarMensaje(25, 41, f).resultado, Retorno.Resultado.ERROR, "Se intenta agregar un mensaje para un contacto de origen 25 y un contacto destino 41, ambos inexistentes, Esperado: ERROR");
        p.ver(obl.agregarMensaje(250, 2, f).resultado, Retorno.Resultado.ERROR, "Se intenta agregar un mensaje para un contacto de origen 250 inexistente, Esperado: ERROR");
        p.ver(obl.agregarMensaje(2, 128, f).resultado, Retorno.Resultado.ERROR, "Se intenta agregar un mensaje para un contacto de destino 128 inexistente, Esperado: ERROR");
        //Obligatorio.SistemaMensajes.mostrar();

        p.ver(obl.eliminarMensaje(1, 20).resultado, Retorno.Resultado.OK, "Se elimina el mensaje con numero 20 y el numero de contacto de origen 1, Esperado: OK");
        p.ver(obl.eliminarMensaje(2, 21).resultado, Retorno.Resultado.OK, "Se elimina el mensaje con numero 21 y el numero de contacto de origen 2, Esperado: OK");
        p.ver(obl.eliminarMensaje(7, 22).resultado, Retorno.Resultado.OK, "Se elimina el mensaje con numero 22 y el numero de contacto de origen 7, Esperado: OK");
        p.ver(obl.eliminarMensaje(1, 88).resultado, Retorno.Resultado.ERROR, "Se intenta eliminar el mensaje con un numero de mensaje 88 inexistente, Esperado: ERROR");
        p.ver(obl.eliminarMensaje(91, 1).resultado, Retorno.Resultado.ERROR, "Se intenta eliminar el mensaje con un numero de contacto 91 inexistente, Esperado: ERROR");
        //Obligatorio.SistemaMensajes.mostrar();
        p.imprimirResultadosPrueba();
    }

    public static void juegopruebaReporte(Obligatorio obl, Prueba p) {
//        obl.crearSistemaMensajes(3);
//        Date f = new Date();
//        p.ver(obl.agregarMensaje(1, 2, f).resultado, Retorno.Resultado.OK, "Se agrega un mensaje");
//        p.ver(obl.agregarMensaje(1, 3, f).resultado, Retorno.Resultado.OK, "Se agrega un mensaje");
//        p.ver(obl.agregarMensaje(2, 4, f).resultado, Retorno.Resultado.OK, "Se agrega un mensaje");

        //p.ver(obl.cantidadDeMensajes(1).resultado, Retorno.Resultado.OK, "Se muestra la cantidad de mensajes");
    }

    public static void juegopruebaDiccionario(Obligatorio obl, Prueba p) {

//        obl.ingresarPalabraDiccionario("Diccionario1");
//        obl.ingresarPalabraDiccionario("Diccionario2");
//        obl.ingresarPalabraDiccionario("Diccionario3");
//
//        obl.imprimirDiccionario();
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

    public static void juegodepruebaLineas(Obligatorio obl, Prueba p) {
        System.out.println("JUEGO DE PRUEBA LINEAS");
        p.ver(obl.crearSistemaMensajes(3).resultado, Retorno.Resultado.OK, "Se creara sistma para 3 palabras por linea");
        Date f = new Date();
        p.ver(obl.agregarContacto(1, "Contacto1").resultado, Retorno.Resultado.OK, "Se agrega 'Contacto1'");
        p.ver(obl.agregarContacto(2, "Contacto2").resultado, Retorno.Resultado.OK, "Se agrega 'Contacto2'");
        p.ver(obl.agregarMensaje(1, 2, f).resultado, Retorno.Resultado.OK, "Se agrega un mensaje");
        p.ver(obl.agregarMensaje(1, 2, f).resultado, Retorno.Resultado.OK, "Se agrega un mensaje");
        p.ver(obl.agregarMensaje(1, 2, f).resultado, Retorno.Resultado.OK, "Se agrega un mensaje");

        p.ver(obl.insertarLinea(1, 1).resultado, Retorno.Resultado.OK, "Se agrega Linea");
        Obligatorio.SistemaMensajes.mostrar();

    }

}
