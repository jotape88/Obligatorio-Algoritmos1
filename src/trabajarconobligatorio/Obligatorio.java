package trabajarconobligatorio;

import java.util.Date;

/**
 *
 * @author Rafael
 */
public class Obligatorio implements IObligatorio {

    static Lista<Mensaje> SistemaMensajes = null;
    //public ListaMensajes listMensajes = new ListaMensajes(); //Creado (Francisco)
    public Lista<Contacto> contactos = new Lista<Contacto>();
    public Lista<String> diccionario = new Lista<String>();

    @Override
    public Retorno crearSistemaMensajes(int MAX_CANT_PALABRAS_X_LINEA) {
        Retorno ret = new Retorno(Retorno.Resultado.OK);
        Obligatorio.SistemaMensajes = new Lista<>();
        Obligatorio.SistemaMensajes.setTope(MAX_CANT_PALABRAS_X_LINEA);
        return ret;
    }

    @Override
    public Retorno destruirSistemaMensajes() {
        Retorno ret = new Retorno(Retorno.Resultado.OK);
        Obligatorio.SistemaMensajes = null;
        return ret;
    }

    @Override
    public Retorno agregarContacto(int numContacto, String nomContacto) {
        Retorno ret = new Retorno(Retorno.Resultado.NO_IMPLEMENTADA);
        Contacto newContacto = new Contacto(numContacto, nomContacto);
        if (contactos.obtenerElemento(newContacto) == null) {
            contactos.agregarInicio(newContacto);

        } else {
            ret.resultado = Retorno.Resultado.ERROR;
        }

        return ret;
    }

    @Override
    public Retorno eliminarContacto(int numContacto) {

        Retorno ret = new Retorno(Retorno.Resultado.NO_IMPLEMENTADA);
        Contacto cAux = new Contacto(numContacto, "Pirulo");

        System.out.println(cAux.toString());

        if (contactos.obtenerElemento(cAux) != null) {
            contactos.borrarElemento(cAux);
        } else {
            ret.resultado = Retorno.Resultado.ERROR;
        }

        return ret;
    }

    @Override
    public Retorno agregarMensaje(int numContactoOrigen, int numContactoDestino, Date fecha) {
        Retorno ret = new Retorno(Retorno.Resultado.ERROR);
        Contacto cOrigen = contactos.obtenerElemento(new Contacto(numContactoOrigen)).getDato();
        Contacto cDestino = contactos.obtenerElemento(new Contacto(numContactoDestino)).getDato();
        this.contactos.obtenerElemento(cOrigen);

        if (cOrigen != null && cDestino != null) {
            Mensaje m = new Mensaje(cOrigen, cDestino, fecha, SistemaMensajes.getTope());
            SistemaMensajes.agregarInicio(m);
        } else {
            ret.resultado = Retorno.Resultado.ERROR;
        }
        return ret;
    }

    @Override
    public Retorno eliminarMensaje(int numContactoOrigen, int numMensaje) {
        Retorno ret = new Retorno(Retorno.Resultado.OK);
        Contacto cAux = contactos.obtenerElemento(new Contacto(numContactoOrigen)).getDato();
        Mensaje men = SistemaMensajes.obtenerElemento(new Mensaje(numMensaje)).getDato();
        if (cAux != null && men != null) {
            SistemaMensajes.borrarElemento(men);
        } else {
            ret.resultado = Retorno.Resultado.ERROR;
        }
        return ret;
    }

    @Override
    public Retorno imprimirTexto(int numContactoOrigen, int numMensaje) {
        Retorno ret = new Retorno(Retorno.Resultado.NO_IMPLEMENTADA);
//        Contacto cAux = contactos.obtenerElemento(new Contacto(numContactoOrigen)).getDato();
//        
//        //Mensaje men = SistemaMensajes.obtenerElemento(new Mensaje(numMensaje)).getDato();
//
//        if (.getInicio() != null) {
//
//            ret.resultado = Retorno.Resultado.OK;
//        } else {
//
//            ret.resultado = Retorno.Resultado.ERROR;
//        }
//
        return ret;
    }

    @Override
    public Retorno insertarLinea(int numContactoOrigen, int numMensaje) {
        Retorno ret = new Retorno(Retorno.Resultado.NO_IMPLEMENTADA);
        Nodo<Contacto> contOr = contactos.obtenerElemento(new Contacto(numContactoOrigen));
        
        System.out.println("contacto");
        System.out.println(contOr.getDato().toString());
        if (contOr.getDato() != null) {
            System.out.println("aca contOr");
            Mensaje men = new Mensaje(numMensaje, contOr.getDato());
            System.out.println(men.toString());
            Nodo<Mensaje> menBus;
            menBus = SistemaMensajes.obtenerElemento(men);
            if (menBus != null) {
                System.out.println("aca menbus");
                Linea linea = new Linea(SistemaMensajes.getTope());
                Palabra pa = new Palabra();
                pa.setDato("");
                linea.getListaPalabras().agregarFinal(pa);
                menBus.getDato().getListaLineas().agregarFinal(linea);
            }
        }
        return ret;
    }

    @Override
    public Retorno insertarLineaEnPosicion(int numContactoOrigen, int numMensaje, int posicionLinea) {
        Retorno ret = new Retorno(Retorno.Resultado.NO_IMPLEMENTADA);
        return ret;
    }

    @Override
    public Retorno borrarLinea(int numContactoOrigen, int numMensaje, int posicionLinea) {
        Retorno ret = new Retorno(Retorno.Resultado.NO_IMPLEMENTADA);
        return ret;
    }

    @Override
    public Retorno borrarTodo(int numContactoOrigen, int numMensaje) {
        Retorno ret = new Retorno(Retorno.Resultado.NO_IMPLEMENTADA);
        return ret;
    }

    @Override
    public Retorno borrarOcurrenciasPalabraEnTexto(int numContactoOrigen, int numMensaje, String palabraABorrar) {
        Retorno ret = new Retorno(Retorno.Resultado.NO_IMPLEMENTADA);
        return ret;
    }

    @Override
    public Retorno insertarPalabraEnLinea(int numContactoOrigen, int numMensaje, int posicionLinea, int posicionPalabra, String palabraAIngresar) {
        Retorno ret = new Retorno(Retorno.Resultado.NO_IMPLEMENTADA);
        return ret;
    }

    @Override
    public Retorno insertarPalabraYDesplazar(int numContactoOrigen, int numMensaje, int posicionLinea, int posicionPalabra, String palabraAIngresar) {
        Retorno ret = new Retorno(Retorno.Resultado.NO_IMPLEMENTADA);
        return ret;
    }

    @Override
    public Retorno borrarPalabra(int numContactoOrigen, int numMensaje, int posicionLinea, int posicionPalabra) {
        Retorno ret = new Retorno(Retorno.Resultado.NO_IMPLEMENTADA);
        return ret;
    }

    @Override
    public Retorno borrarOcurrenciasPalabraEnLinea(int numContactoOrigen, int numMensaje, int posicionLinea, String palabraABorrar) {
        Retorno ret = new Retorno(Retorno.Resultado.NO_IMPLEMENTADA);
        return ret;
    }

    @Override
    public Retorno imprimirLinea(int numContactoOrigen, int numMensaje, int posicionLinea) {
        Retorno ret = new Retorno(Retorno.Resultado.NO_IMPLEMENTADA);

        return ret;
    }

    @Override
    public Retorno ingresarPalabraDiccionario(String palabraAIngresar) {
        Retorno ret = new Retorno(Retorno.Resultado.NO_IMPLEMENTADA);

        Nodo<String> newPalabra = diccionario.obtenerElemento(palabraAIngresar);

        if (newPalabra == null) {
            diccionario.agregarOrd(palabraAIngresar);
            ret.resultado = Retorno.Resultado.OK;
        } else {

            ret.resultado = Retorno.Resultado.ERROR;
        }
        return ret;
    }

    @Override
    public Retorno imprimirDiccionario() {

        Retorno ret = new Retorno(Retorno.Resultado.NO_IMPLEMENTADA);

        if (diccionario.getInicio() != null) {
            diccionario.mostrar();
            ret.resultado = Retorno.Resultado.OK;
        } else {
            System.out.println("Diccionario Vacio");
            ret.resultado = Retorno.Resultado.ERROR;
        }

        return ret;
    }

    @Override
    public Retorno ImprimirTextoIncorrecto() {
        Retorno ret = new Retorno(Retorno.Resultado.NO_IMPLEMENTADA);
        return ret;
    }

    @Override
    public Retorno cantidadDeMensajes(int numContactoOrigen) {
        Retorno ret = new Retorno(Retorno.Resultado.NO_IMPLEMENTADA);
        int contador = 0;

//        Contacto paramContacto = new Contacto(numContactoOrigen, "");
        Nodo<Mensaje> mensajeAct = SistemaMensajes.getInicio();

        while (mensajeAct != null) {

            int contactoActual = mensajeAct.getDato().getContOrigen().numeroContacto;

            if (contactoActual == numContactoOrigen) {
                contador++;

            }

            mensajeAct = mensajeAct.getSiguiente();
        }

        ret.valorEntero = contador;
        return ret;
    }

    @Override
    public Retorno borrarPalabraDiccionario(String palabraABorrar) {

        Retorno ret = new Retorno(Retorno.Resultado.NO_IMPLEMENTADA);

        Nodo palabra = diccionario.obtenerElemento(palabraABorrar);

        if (palabra != null) {
            diccionario.borrarElemento(palabraABorrar);
        } else {
            ret.resultado = Retorno.Resultado.ERROR;
        }

        return ret;

    }

}
