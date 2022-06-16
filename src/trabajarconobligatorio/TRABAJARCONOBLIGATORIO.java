package trabajarconobligatorio;

import java.util.Date;

public class TRABAJARCONOBLIGATORIO {

    public static void main(String[] args) {

        Obligatorio obl = new Obligatorio();
        Prueba p = new Prueba();

        // juegodepruebaSistema(obl, p);
        // juegodepruebaContactos(obl, p);
        // juegodepruebaMensajes(obl, p);
        // juegopruebaFucionalidades(obl, p);
        // juegopruebaDiccionario(obl, p);
        // juegopruebaPalabrasDiccionario(obl, p);
        // juegopruebaReporte(obl, p);
        // juegodepruebaLineas(obl, p);
        // juegopruebaIncersionBorradoPalabras(obl, p);
        // juegodePruebaCantMensaje(obl, p);
    }

    public static void juegodepruebaSistema(Obligatorio obl, Prueba p) {
        p.ver(obl.crearSistemaMensajes(3).resultado, Retorno.Resultado.OK, "Se creara un sistema para 3 palabras por línea");
        Obligatorio.SistemaMensajes.mostrar();
        p.ver(obl.destruirSistemaMensajes().resultado, Retorno.Resultado.OK, "Sistema anterior eliminado");
        p.imprimirResultadosPrueba();
    }

    public static void juegodepruebaContactos(Obligatorio obl, Prueba p) {
        obl.crearSistemaMensajes(3);
        p.ver(obl.agregarContacto(1, "Federico").resultado, Retorno.Resultado.OK, "Se agrega un contacto con el número 1 y el nombre Federico, Esperado: OK");
        obl.agregarContacto(2, "Jorge");
        obl.agregarContacto(3, "Victoria");
        obl.agregarContacto(4, "Andres");
        obl.agregarContacto(5, "Mauro");
        obl.agregarContacto(6, "Juan");
        obl.agregarContacto(7, "Francisco");
        obl.agregarContacto(8, "Felipe");
        obl.agregarContacto(9, "Sebastian");
        obl.agregarContacto(10, "Ana");
        p.ver(obl.agregarContacto(1, "Pepito").resultado, Retorno.Resultado.ERROR, "Se intenta agregar un contacto repetido con el número 1, Esperado: ERROR");
        p.ver(obl.agregarContacto(3, "Vanessa").resultado, Retorno.Resultado.ERROR, "Se intenta agregar un contacto repetido con el número 3, Esperado: ERROR");
        p.ver(obl.agregarContacto(5, "Aida").resultado, Retorno.Resultado.ERROR, "Se intenta agregar un contacto repetido con el número 5, Esperado: ERROR");
        p.ver(obl.agregarContacto(3, "Vanessa").resultado, Retorno.Resultado.ERROR, "Se intenta agregar un contacto repetido con el número 3, Esperado: ERROR");
        p.ver(obl.agregarContacto(11, "Mariela").resultado, Retorno.Resultado.OK, "Se agrega un contacto con el número 11 y el nombre Mariela, Esperado: OK");
        p.ver(obl.agregarContacto(12, "Pepe").resultado, Retorno.Resultado.OK, "Se agrega un contacto con el número 12 y el nombre Pepe, Esperado: OK");
        p.ver(obl.agregarContacto(13, "Roberto").resultado, Retorno.Resultado.OK, "Se agrega un contacto con el número 13 y el nombre Roberto, Esperado: OK");
        obl.contactos.mostrar();

        p.ver(obl.eliminarContacto(11).resultado, Retorno.Resultado.OK, "Se elimina el contacto con el numero 11 y el nombre Mariela, Esperado: OK");
        p.ver(obl.eliminarContacto(12).resultado, Retorno.Resultado.OK, "Se elimina el contacto con el numero 12 y el nombre Pepe, Esperado: OK");
        p.ver(obl.eliminarContacto(13).resultado, Retorno.Resultado.OK, "Se elimina el contacto con el numero 13 y el nombre Roberto, Esperado: OK");
        p.ver(obl.eliminarContacto(200).resultado, Retorno.Resultado.ERROR, "Se intenta eliminar un contacto con un número 200, inexistente, Esperado: OK");
        p.ver(obl.eliminarContacto(180).resultado, Retorno.Resultado.ERROR, "Se intenta eliminar un contacto con un número 180, inexistente, Esperado: OK");
        obl.contactos.mostrar();

        p.imprimirResultadosPrueba();
        obl.destruirSistemaMensajes();
    }

    public static void juegodepruebaMensajes(Obligatorio obl, Prueba p) {
        obl.crearSistemaMensajes(3);
        Date f = new Date();
        p.ver(obl.agregarMensaje(1, 2, UTILS.generarFechasRandom()).resultado, Retorno.Resultado.OK, "Se agrega un mensaje para el contacto 1 como origen y el contacto 2 como destino, Esperado: OK");
        p.ver(obl.agregarMensaje(1, 3, UTILS.generarFechasRandom()).resultado, Retorno.Resultado.OK, "Se agrega un mensaje para el contacto 1 como origen y el contacto 3 como destino, Esperado: OK");
        p.ver(obl.agregarMensaje(1, 3, UTILS.generarFechasRandom()).resultado, Retorno.Resultado.OK, "Se agrega un mensaje para el contacto 1 como origen y el contacto 3 como destino, Esperado: OK");
        obl.agregarMensaje(2, 4, UTILS.generarFechasRandom());
        obl.agregarMensaje(3, 2, UTILS.generarFechasRandom());
        obl.agregarMensaje(3, 9, UTILS.generarFechasRandom());
        obl.agregarMensaje(3, 5, UTILS.generarFechasRandom());
        obl.agregarMensaje(5, 6, UTILS.generarFechasRandom());
        obl.agregarMensaje(5, 7, UTILS.generarFechasRandom());
        obl.agregarMensaje(5, 8, UTILS.generarFechasRandom());
        obl.agregarMensaje(5, 10, UTILS.generarFechasRandom());
        obl.agregarMensaje(6, 4, UTILS.generarFechasRandom());
        obl.agregarMensaje(6, 3, UTILS.generarFechasRandom());
        obl.agregarMensaje(7, 4, UTILS.generarFechasRandom());
        obl.agregarMensaje(8, 3, UTILS.generarFechasRandom());
        obl.agregarMensaje(8, 9, UTILS.generarFechasRandom());
        obl.agregarMensaje(8, 10, UTILS.generarFechasRandom());
        obl.agregarMensaje(10, 1, UTILS.generarFechasRandom());
        obl.agregarMensaje(10, 2, UTILS.generarFechasRandom());
        obl.agregarMensaje(5, 1, UTILS.generarFechasRandom());
        obl.agregarMensaje(6, 2, UTILS.generarFechasRandom());
        obl.agregarMensaje(8, 7, UTILS.generarFechasRandom());
        p.ver(obl.agregarMensaje(25, 41, UTILS.generarFechasRandom()).resultado, Retorno.Resultado.ERROR, "Se intenta agregar un mensaje para un contacto de origen 25 y un contacto destino 41, ambos inexistentes, Esperado: ERROR");
        p.ver(obl.agregarMensaje(250, 2, UTILS.generarFechasRandom()).resultado, Retorno.Resultado.ERROR, "Se intenta agregar un mensaje para un contacto de origen 250 inexistente, Esperado: ERROR");
        p.ver(obl.agregarMensaje(2, 128, UTILS.generarFechasRandom()).resultado, Retorno.Resultado.ERROR, "Se intenta agregar un mensaje para un contacto de destino 128 inexistente, Esperado: ERROR");
        Obligatorio.SistemaMensajes.mostrar();

        p.ver(obl.eliminarMensaje(1, 20).resultado, Retorno.Resultado.OK, "Se elimina el mensaje con numero 20 y el numero de contacto de origen 1, Esperado: OK");
        p.ver(obl.eliminarMensaje(2, 21).resultado, Retorno.Resultado.OK, "Se elimina el mensaje con numero 21 y el numero de contacto de origen 2, Esperado: OK");
        p.ver(obl.eliminarMensaje(7, 22).resultado, Retorno.Resultado.OK, "Se elimina el mensaje con numero 22 y el numero de contacto de origen 7, Esperado: OK");
        p.ver(obl.eliminarMensaje(1, 88).resultado, Retorno.Resultado.ERROR, "Se intenta eliminar el mensaje con un numero de mensaje 88 inexistente, Esperado: ERROR");
        p.ver(obl.eliminarMensaje(91, 1).resultado, Retorno.Resultado.ERROR, "Se intenta eliminar el mensaje con un numero de contacto 91 inexistente, Esperado: ERROR");
        Obligatorio.SistemaMensajes.mostrar();
        // obl.destruirSistemaMensajes();
        // p.imprimirResultadosPrueba();
    }
    
    public static void juegodepruebaLineas(Obligatorio obl, Prueba p) {
        System.out.println("JUEGO DE PRUEBA LINEAS");
        obl.crearSistemaMensajes(3);
        Date f = new Date();
        obl.agregarContacto(1, "Contacto1");
        obl.agregarContacto(2, "Contacto2");
        obl.agregarContacto(3, "Contacto3");
        obl.agregarMensaje(1, 2, f);
        obl.agregarMensaje(2, 1, f);
        obl.agregarMensaje(3, 1, f);

        //Obligatorio.SistemaMensajes.mostrar();
        p.ver(obl.insertarLinea(1, 1).resultado, Retorno.Resultado.OK, "Se inserta una linea en el numero de mensaje 1 con el numero de contacto 1, Esperado: OK");
        p.ver(obl.insertarLinea(1, 1).resultado, Retorno.Resultado.OK, "Se inserta otra linea en el numero de mensaje 1, con el numero de contacto 1, Esperado: OK");
        obl.insertarLinea(1, 1);
        obl.insertarLinea(1, 1);
        p.ver(obl.insertarLinea(2, 2).resultado, Retorno.Resultado.OK, "Se inserta una linea en el contacto 2 con el numero de mensaje 0, Esperado: OK");
        p.ver(obl.insertarLinea(2, 2).resultado, Retorno.Resultado.OK, "Se inserta una linea en el contacto 2 con el numero de mensaje 1, Esperado: OK");
        obl.insertarLinea(2, 2);
        p.ver(obl.insertarLinea(3, 3).resultado, Retorno.Resultado.OK, "Se inserta una linea en el contacto 3 con el numero de mensaje 3, Esperado: OK");
        p.ver(obl.insertarLinea(232, 1).resultado, Retorno.Resultado.ERROR, "Se inserta una linea en un contacto inexistente con el numero de mensaje 1, Esperado: ERROR");
        p.ver(obl.insertarLinea(2, 189).resultado, Retorno.Resultado.ERROR, "Se inserta una linea en el contacto 2 con el numero de mensaje inexistente, Esperado: ERROR");
        p.ver(obl.insertarLinea(223, 189).resultado, Retorno.Resultado.ERROR, "Se inserta una linea en un contacto inexistente con un numero de mensaje inexistente, Esperado: ERROR");

        //p.ver(obl.insertarLineaEnPosicion(3, 3, 1).resultado, Retorno.Resultado.OK, "Se inserta una linea en el contacto 3, mensaje 3 en la posicion 1, Esperado: OK");
        //p.ver(obl.insertarLineaEnPosicion(3, 3, 2).resultado, Retorno.Resultado.OK, "Se inserta una linea en el contacto 3, mensaje 3 en la posicion 2, Esperado: OK");
        //p.ver(obl.insertarLineaEnPosicion(3, 3, 3).resultado, Retorno.Resultado.OK, "Se inserta una linea en el contacto 3, mensaje 3 en la posicion 3, Esperado: OK");
        //p.ver(obl.insertarLineaEnPosicion(31, 3, 8).resultado, Retorno.Resultado.OK, "Se inserta una linea en el contacto 3, mensaje 3 en la posicion 8, Esperado: OK");
        //p.ver(obl.insertarLineaEnPosicion(3, 35, 8).resultado, Retorno.Resultado.OK, "Se inserta una linea en el contacto 3, mensaje 3 en la posicion 8, Esperado: OK");
        //p.ver(obl.insertarLineaEnPosicion(3, 3, 85).resultado, Retorno.Resultado.OK, "Se inserta una linea en el contacto 3, mensaje 3 y en una posicion no adyacente, Esperado: OK");

        p.ver(obl.insertarPalabraEnLinea(1, 1, 0, 0, "Palabra1").resultado, Retorno.Resultado.OK, "Se inserta 'Palabra1' en el contacto 1 con el numero de mensaje 1 en la posicion de linea 0 y de palabra 0, Esperado: OK");
        p.ver(obl.insertarPalabraEnLinea(1, 1, 0, 1, "Palabra2").resultado, Retorno.Resultado.OK, "Se inserta 'Palabra2' en el contacto 1 con el numero de mensaje 1 en la posicion de linea 0 y de palabra 1, Esperado: OK");
        p.ver(obl.insertarPalabraEnLinea(1, 1, 0, 2, "Palabra3").resultado, Retorno.Resultado.OK, "Se inserta 'Palabra3' en el contacto 1 con el numero de mensaje 1 en la posicion de linea 0 y de palabra 2, Esperado: OK"); 
        p.ver(obl.insertarPalabraEnLinea(2, 2, 0, 0, "PalabraA").resultado, Retorno.Resultado.OK, "Se inserta 'PalabraA' en el contacto 2 con el numero de mensaje 2 en la posicion de linea 0 y de palabra 0, Esperado: OK"); 
        p.ver(obl.insertarPalabraEnLinea(2, 2, 1, 0, "PalabraB").resultado, Retorno.Resultado.OK, "Se inserta 'PalabraA' en el contacto 2 con el numero de mensaje 2 en la posicion de linea 0 y de palabra 0, Esperado: OK"); 
       // p.ver(obl.insertarPalabraEnLinea(112, 1, 0, 2, "PalabraX").resultado, Retorno.Resultado.ERROR, "Se intenta insertar 'PalabraX' en un contacto inexistente, Esperado: ERROR");
       // p.ver(obl.insertarPalabraEnLinea(1, 322, 0, 2, "PalabraZ").resultado, Retorno.Resultado.ERROR, "Se intenta insertar 'PalabraZ' en un mensaje inexistente, Esperado: ERROR");
        //p.ver(obl.insertarPalabraEnLinea(1, 1, 0, 15, "PalabraX").resultado, Retorno.Resultado.ERROR, "Se intenta insertar 'PalabraX' en una posicion de palabra inexistente, Esperado: ERROR");
        //p.ver(obl.insertarPalabraEnLinea(2, 1, 23, 3, "PalabraX").resultado, Retorno.Resultado.ERROR, "Se intenta insertar 'PalabraX' en una posicion de linea inexistente, Esperado: ERROR");

        p.ver(obl.imprimirLinea(1, 1, 1).resultado, Retorno.Resultado.OK, "Se imprime la linea 1 del mensaje 1, Esperado : OK");
        p.ver(obl.imprimirLinea(2, 2, 2).resultado, Retorno.Resultado.OK, "Se imprime la linea 2 del mensaje 2, Esperado: OK");
        p.ver(obl.imprimirLinea(223, 1, 0).resultado, Retorno.Resultado.ERROR, "Se inserta una linea en un contacto inexistente con un numero de mensaje inexistente, Esperado: ERROR");
        p.ver(obl.imprimirLinea(1, 189, 1).resultado, Retorno.Resultado.ERROR, "Se inserta una linea en un contacto inexistente con un numero de mensaje inexistente, Esperado: ERROR");

        
         p.ver(obl.imprimirTexto(1, 1).resultado, Retorno.Resultado.OK, "Se imprimen todas las lineas del mensaje 1, Esperado: OK");
         obl.imprimirTexto(1,1);
         obl.imprimirTexto(2,2);
         
         p.ver(obl.imprimirTexto(132, 1).resultado, Retorno.Resultado.ERROR, "Se intentan imprimir las lineas asociadas a un mensaje de un contacto inexistente, Esperado: ERROR");
         p.ver(obl.imprimirTexto(1, 143).resultado, Retorno.Resultado.ERROR, "Se intentan imprimir las lineas de un mensaje inexistente con un contacto contacto existente, Esperado: ERROR");
         p.ver(obl.imprimirTexto(131, 143).resultado, Retorno.Resultado.ERROR, "Se intentan imprimir las lineas de un mensaje y contactos inexistentes, Esperado: ERROR");

         //p.ver(obl.borrarLinea(1, 1, 0).resultado, Retorno.Resultado.OK, "Se borra la linea 0 del mensaje 1 asociado al contacto 1, se corre la siguiente a esta posicion, Esperado: OK");
         //p.ver(obl.borrarLinea(1, 1, 0).resultado, Retorno.Resultado.OK, "Se borra la linea 0 del mensaje 1 asociado al contacto 1, se corre la siguiente a esta posicion, Esperado: OK");
        // p.ver(obl.borrarLinea(2, 2, 0).resultado, Retorno.Resultado.OK, "Se borra la linea 0 del mensaje 1 asociado al contacto 1, se corre la siguiente a esta posicion, Esperado: OK");
         //p.ver(obl.borrarLinea(25, 2, 0).resultado, Retorno.Resultado.ERROR, "Se intenta borrar una linea de un contacto inexistente,Esperado ERROR");
         //p.ver(obl.borrarLinea(2, 27, 0).resultado, Retorno.Resultado.ERROR, "Se intenta borrar una lista de un mensaje inexistente, Esperado: ERROR");
         //p.ver(obl.borrarLinea(2, 2, 88).resultado, Retorno.Resultado.ERROR, "Se intenta borrar una linea de una posicion invalida, Esperado: ERROR");
         obl.imprimirTexto(1, 1);
         obl.imprimirTexto(2, 2);
//        obl.imprimirTexto(1, 1);
        
        p.imprimirResultadosPrueba();
    }

    public static void juegopruebaFucionalidades(Obligatorio obl, Prueba p) {
        System.out.println("JUEGO DE PRUEBA FUNCIONALIDADES");
        obl.crearSistemaMensajes(3);
        Date f = new Date();
        obl.agregarContacto(1, "Contacto1");
        obl.agregarContacto(2, "Contacto2");
        obl.agregarContacto(3, "Contacto3");
        obl.agregarMensaje(1, 2, f);
        obl.agregarMensaje(2, 1, f);
        obl.agregarMensaje(3, 1, f);
        
        obl.insertarLinea(1, 1);
        obl.insertarLinea(1, 1);
        obl.insertarLinea(1, 1);
        obl.insertarLinea(1, 1);
        obl.insertarLinea(1, 1);
        obl.insertarLinea(2, 2);
        obl.insertarLinea(2, 2);
       
        obl.insertarPalabraEnLinea(1, 1, 0, 0, "PalabraABorrarOcurrencia");
        obl.insertarPalabraEnLinea(1, 1, 0, 1, "PalabraABorrarOcurrencia");
        obl.insertarPalabraEnLinea(1, 1, 0, 2, "PalabraABorrarOcurrencia");
        obl.insertarPalabraEnLinea(1, 1, 1, 0, "PalabrX");
        obl.insertarPalabraEnLinea(1, 1, 1, 1, "PalabraY");
        obl.insertarPalabraEnLinea(1, 1, 1, 2, "PalabraZ");
        obl.insertarPalabraEnLinea(1, 1, 2, 2, "PalabraYYY");
        obl.insertarPalabraEnLinea(1, 1, 3, 3, "PalabraXXX");
        obl.insertarPalabraEnLinea(1, 1, 4, 0, "PalabraABorrarOcurrencia");
        obl.insertarPalabraEnLinea(2, 2, 0, 0, "PalabraABorrar");
        obl.imprimirTexto(1, 1);
        obl.imprimirTexto(2, 2);
  
        p.ver(obl.borrarOcurrenciasPalabraEnTexto(1, 1, "PalabraABorrarOcurrencia").resultado, Retorno.Resultado.OK, "Se borra la palabra 'PalabraABorrarOcurrencia' del mensaje 1 asociado al contacto 1, Esperado: OK");
        p.ver(obl.borrarPalabra(2, 2, 0, 0).resultado, Retorno.Resultado.OK, "Se borra la palabra 'PalabraABorrar' del mensaje 2 asociado al contacto 2, Esperado: OK");
        p.ver(obl.borrarPalabra(1, 1, 0, 0).resultado, Retorno.Resultado.OK, "Se borra la palabra 'PalabraABorrar' del mensaje 1 asociado al contacto 1, Esperado: OK");
        obl.imprimirTexto(1, 1);
        obl.imprimirTexto(2, 2);
        
        p.imprimirResultadosPrueba();
    }

    public static void juegopruebaDiccionario(Obligatorio obl, Prueba p) {
        p.ver(obl.ingresarPalabraDiccionario("Diccionario1").resultado, Retorno.Resultado.OK, "Se ingresa una palabra de forma ordenada en el diccionario");
        obl.ingresarPalabraDiccionario("Diccionario2");
        obl.ingresarPalabraDiccionario("Diccionario3");
        obl.ingresarPalabraDiccionario("Diccionario4");
        p.ver(obl.imprimirDiccionario().resultado, Retorno.Resultado.OK, "Se muestra el diccionario en caso de no estar vacio");
        p.ver(obl.borrarPalabraDiccionario("Diccionario3").resultado, Retorno.Resultado.OK, "Se borra la palabra del diccionario en caso de que exista");
        obl.imprimirDiccionario();
        p.imprimirResultadosPrueba();
    }
    
    public static void juegopruebaPalabrasDiccionario(Obligatorio obl, Prueba p) {

        obl.crearSistemaMensajes(3);
        obl.agregarContacto(1, "Contacto1");
        obl.agregarContacto(2, "Contacto2");
        obl.agregarMensaje(1, 2, new Date());
        obl.insertarLinea(1, 1);

        obl.insertarPalabraEnLinea(1, 1, 0, 0, "Palabra1");
        obl.insertarPalabraEnLinea(1, 1, 0, 1, "PalabraDiccionario");
        obl.insertarPalabraEnLinea(1, 1, 0, 2, "Palabra2");
        obl.borrarOcurrenciasPalabraEnLinea(1, 1, 0, "Palabra1");

        obl.ingresarPalabraDiccionario("PalabraDiccionario");
        obl.ingresarPalabraDiccionario("Diccionario3");
        obl.ingresarPalabraDiccionario("Diccionario3");
        p.ver(obl.ImprimirTextoIncorrecto(1, 1).resultado, Retorno.Resultado.OK, "Se intenta mostrar las palabras del mensaje que no se encuentren en el diccionario");
        obl.imprimirDiccionario();
    }


    public static void juegodePruebaCantMensaje(Obligatorio obl, Prueba p) {
        System.out.println("Juego de Pruebas Cantidad Mensajes");
        obl.crearSistemaMensajes(3);
        obl.agregarContacto(1, "Micaela");
        obl.agregarContacto(2, "Felipe");
        obl.agregarContacto(3, "Romina");
        obl.agregarContacto(4, "Camila");
        obl.agregarContacto(5, "Marco");
        obl.agregarContacto(6, "Diego");
        // FECHAS
        Date d0 = new Date("01/25/2022");
        Date d1 = new Date("02/28/2022");
        Date d2 = new Date("03/03/2022");
        Date d3 = new Date("10/07/2022");
        Date d4 = new Date("14/07/2022");

        for (int i = 0; i < 3; i++) {
            obl.agregarMensaje(1, 2, d0); // origen, destino
            obl.agregarMensaje(1, 2, d1); // origen, destino
            obl.agregarMensaje(1, 2, d1); // origen, destino
            obl.agregarMensaje(1, 2, d2); // origen, destino
            obl.agregarMensaje(1, 2, d3); // origen, destino
            obl.agregarMensaje(1, 2, d1); // origen, destino
            obl.agregarMensaje(1, 2, d4); // origen, destino
        }

        obl.cantidadDeMensajes(1);
        // Obligatorio.SistemaMensajes.mostrar();
        obl.destruirSistemaMensajes();
    }
}
