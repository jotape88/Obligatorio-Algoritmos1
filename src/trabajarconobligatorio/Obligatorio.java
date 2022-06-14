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
        Retorno ret = new Retorno(Retorno.Resultado.OK);
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

        Retorno ret = new Retorno(Retorno.Resultado.OK);
        Contacto cAux = new Contacto(numContacto, "Pirulo");

        //System.out.println(cAux.toString());
        if (contactos.obtenerElemento(cAux) != null) {
            contactos.borrarElemento(cAux);
        } else {
            ret.resultado = Retorno.Resultado.ERROR;
        }

        return ret;
    }

    @Override
    public Retorno agregarMensaje(int numContactoOrigen, int numContactoDestino, Date fecha) {
        Retorno ret = new Retorno(Retorno.Resultado.OK);

        Contacto cO = new Contacto(numContactoOrigen);
        Contacto cD = new Contacto(numContactoDestino);

        if (contactos.obtenerElemento(cO) != null && contactos.obtenerElemento(cD) != null) {
            Contacto cOrigen = contactos.obtenerElemento(new Contacto(numContactoOrigen)).getDato();
            Contacto cDestino = contactos.obtenerElemento(new Contacto(numContactoDestino)).getDato();
            if(cOrigen.getNumeroContacto() == numContactoOrigen && cDestino.getNumeroContacto() == numContactoDestino){
                Mensaje m = new Mensaje(cOrigen, cDestino, fecha, SistemaMensajes.getTope());
                SistemaMensajes.agregarInicio(m);
            }
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
        Contacto cO = new Contacto(numContactoOrigen);
        Mensaje m = new Mensaje(numMensaje);

        if (contactos.obtenerElemento(cO) != null && SistemaMensajes.obtenerElemento(m) != null) {
            Mensaje men = SistemaMensajes.obtenerElemento(new Mensaje(numMensaje)).getDato();
            Contacto cAux = contactos.obtenerElemento(new Contacto(numContactoOrigen)).getDato();
            if (men.getNumeroDeMensaje() == numMensaje && cAux.getNumeroContacto() == numContactoOrigen) {
                SistemaMensajes.borrarElemento(m);
            }
        } else {
            ret.resultado = Retorno.Resultado.ERROR;
        }
        return ret;
    }

    @Override
    public Retorno imprimirTexto(int numContactoOrigen, int numMensaje) {
        Retorno ret = new Retorno(Retorno.Resultado.NO_IMPLEMENTADA);
        Mensaje m = new Mensaje(numMensaje);
        Nodo<Mensaje> menB = SistemaMensajes.obtenerElemento(m);

        if (menB != null) {
            menB.getDato().getListaLineas().mostrar();
            ret.resultado = Retorno.Resultado.OK;

        } else {
            ret.resultado = Retorno.Resultado.ERROR;
            System.out.println("Texto Vacio");
        }
        return ret;
    }

    @Override
    public Retorno insertarLinea(int numContactoOrigen, int numMensaje) {
        Retorno ret = new Retorno(Retorno.Resultado.NO_IMPLEMENTADA);
        Nodo<Mensaje> menB = SistemaMensajes.obtenerElemento(new Mensaje(numMensaje));
        if (menB != null) {
            Linea l = new Linea();
            menB.getDato().getListaLineas().agregarInicio(l);
            for (int i = 0; i <= menB.getDato().getListaLineas().getTope(); i++) {
                menB.getDato().getListaLineas().getInicio().getDato().getListaPalabras().agregarInicio(new Palabra());
            }
        }
        return ret;
    }

    @Override
    public Retorno insertarLineaEnPosicion(int numContactoOrigen, int numMensaje, int posicionLinea) {
        Retorno ret = new Retorno(Retorno.Resultado.NO_IMPLEMENTADA);
        int contadorLinea = 0;
        if (!SistemaMensajes.esVacia()) {
            Nodo nodoMensaje = SistemaMensajes.getInicio();
            while (nodoMensaje != null) {
                Mensaje esteMensaje = (Mensaje) nodoMensaje.getDato();
                if (esteMensaje.getNumeroDeMensaje() == numMensaje && esteMensaje.getContOrigen().numeroContacto == numContactoOrigen) {
                    Lista<Linea> listaLineas = esteMensaje.getListaLineas();
                    if (!listaLineas.esVacia()) {
                        Nodo nodoLinea = listaLineas.getInicio();
                        while (nodoLinea != null && contadorLinea < posicionLinea && contadorLinea < listaLineas.getTope()) {
                            nodoLinea.getSiguiente();

                        }

                        if (contadorLinea == posicionLinea) {
                            Lista<Palabra> nuevaListaPalabras = new Lista<Palabra>();
                            Linea nuevaLinea = new Linea(Obligatorio.SistemaMensajes.getTope());
                            Nodo nuevo = new Nodo(nuevaLinea);
                            nuevo.setSiguiente(nodoLinea.getSiguiente());
                            nodoLinea.setSiguiente(nuevo);
                            ret.resultado = Retorno.Resultado.OK;

                        } else {
                            ret.resultado = Retorno.Resultado.ERROR;
                        }
                    } else {
                        ret.resultado = Retorno.Resultado.ERROR;
                    }
                }
                nodoMensaje.getSiguiente();
            }
        } else {
            ret.resultado = Retorno.Resultado.ERROR;
        }

        return ret;
    }

    @Override
    public Retorno borrarLinea(int numContactoOrigen, int numMensaje, int posicionLinea) {
        Retorno ret = new Retorno(Retorno.Resultado.NO_IMPLEMENTADA);
        int contadorLinea = 0;
        if (!SistemaMensajes.esVacia()) {
            Nodo nodoMensaje = SistemaMensajes.getInicio();
            while (nodoMensaje != null) {
                Mensaje esteMensaje = (Mensaje) nodoMensaje.getDato();
                if (esteMensaje.getNumeroDeMensaje() == numMensaje && esteMensaje.getContOrigen().numeroContacto == numContactoOrigen) {
                    Lista<Linea> listaLineas = esteMensaje.getListaLineas();
                    Nodo nodoLinea = listaLineas.getInicio();
                    while (nodoLinea != null && contadorLinea < posicionLinea) {
                        nodoLinea.getSiguiente();
                    }
                    Nodo aBorrar = nodoLinea.getSiguiente();
                    nodoLinea.setSiguiente(aBorrar.getSiguiente());
                    aBorrar.setSiguiente(null);

                    ret.resultado = Retorno.Resultado.OK;

                } else {
                    nodoMensaje.getSiguiente();
                }
            }

        } else {

            ret.resultado = Retorno.Resultado.ERROR;

        }

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
        Mensaje men = new Mensaje(numMensaje);
        Nodo<Mensaje> menB = SistemaMensajes.obtenerElemento(men);
        if (menB.getDato() != null) {
            if (!menB.getDato().getListaLineas().esVacia()) {
                Nodo<Linea> actualL = menB.getDato().getListaLineas().getInicio();
                while (actualL.getSiguiente() != null) {
                    if (!actualL.getDato().getListaPalabras().esVacia()) {
                        Nodo<Palabra> actualP = actualL.getDato().getListaPalabras().getInicio();
                        while (actualP.getSiguiente() != null) {
                            if (actualP.getDato().getDato() == palabraABorrar) {
                                actualL.getDato().getListaPalabras().borrarElemento(actualP.getDato());
                            }
                            actualP = actualP.getSiguiente();
                        }
                    }
                    actualL = actualL.getSiguiente();
                }

            }
        }
        ret.resultado = Retorno.Resultado.OK;

        return ret;
    }

    @Override
    public Retorno insertarPalabraEnLinea(int numContactoOrigen, int numMensaje, int posicionLinea, int posicionPalabra, String palabraAIngresar) {

        Retorno ret = new Retorno(Retorno.Resultado.NO_IMPLEMENTADA);

        int contadorLinea = 0;
        int contadorPalabra = 0;
        boolean posPosible = false;

        if (!SistemaMensajes.esVacia()) {

            Nodo nodoMensaje = SistemaMensajes.getInicio();

            while (nodoMensaje != null && !posPosible) {

                Mensaje esteMensaje = (Mensaje) nodoMensaje.getDato();

                if (esteMensaje.getContOrigen().numeroContacto == numContactoOrigen
                        && esteMensaje.getNumeroDeMensaje() == numMensaje) {

                    Lista<Linea> lineasMensaje = esteMensaje.getListaLineas();

                    if (!lineasMensaje.esVacia()) {

                        Nodo nodoLinea = lineasMensaje.getInicio();

                        while (nodoLinea != null && contadorLinea < posicionLinea && !posPosible) {

                            if (contadorLinea == posicionLinea) {
                                Lista<String> listaPalabras = (Lista<String>) nodoLinea.getDato();

                                if (!listaPalabras.esVacia()) {

                                    Nodo estaPalabra = listaPalabras.getInicio();

                                    while (estaPalabra != null && contadorPalabra < posicionPalabra && !posPosible) {

                                        if (contadorPalabra == posicionPalabra && (contadorPalabra < listaPalabras.getTope())) {
                                            //controlar tope
                                            Nodo nuevaPalabra = new Nodo(palabraAIngresar);
                                            nuevaPalabra.setSiguiente(estaPalabra.getSiguiente());
                                            estaPalabra.setSiguiente(nuevaPalabra);
                                            posPosible = true;
                                            ret.resultado = Retorno.Resultado.OK;
                                        }

                                        estaPalabra.getSiguiente();
                                        contadorPalabra++;

                                    }
                                } else {

                                }
                            }

                            nodoLinea.getSiguiente();

                        }

                    }

                    ret.resultado = Retorno.Resultado.ERROR;

                }

                nodoMensaje.getSiguiente();
            }

        } else {

            ret.resultado = Retorno.Resultado.ERROR;
        }

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

        int contadorLinea = 0;
        int contadorPalabra = 0;
        boolean posPosible = false;

        if (!SistemaMensajes.esVacia()) {

            Nodo nodoMensaje = SistemaMensajes.getInicio();

            while (nodoMensaje != null && !posPosible) {

                Mensaje esteMensaje = (Mensaje) nodoMensaje.getDato();

                if (esteMensaje.getContOrigen().numeroContacto == numContactoOrigen
                        && esteMensaje.getNumeroDeMensaje() == numMensaje) {

                    Lista<Linea> lineasMensaje = esteMensaje.getListaLineas();

                    if (!lineasMensaje.esVacia()) {

                        Nodo nodoLinea = lineasMensaje.getInicio();

                        while (nodoLinea != null && contadorLinea < posicionLinea && !posPosible) {

                            if (contadorLinea == posicionLinea) {
                                Lista<String> listaPalabras = (Lista<String>) nodoLinea.getDato();

                                if (!listaPalabras.esVacia()) {

                                    Nodo estaPalabra = listaPalabras.getInicio();

                                    while (estaPalabra != null && contadorPalabra < posicionPalabra && !posPosible) {

                                        if (contadorPalabra == posicionPalabra) {

                                            String palabraActual = (String) estaPalabra.getDato();

                                            listaPalabras.borrarElemento(palabraActual);

                                            posPosible = true;

                                            ret.resultado = Retorno.Resultado.OK;
                                        } else {

                                            estaPalabra.getSiguiente();

                                        }

                                    }

                                } else {

                                    ret.resultado = Retorno.Resultado.ERROR;
                                }
                            }

                            nodoLinea.getSiguiente();

                        }

                    }

                    ret.resultado = Retorno.Resultado.ERROR;

                }

                nodoMensaje.getSiguiente();
            }

        } else {

            ret.resultado = Retorno.Resultado.ERROR;
        }

        return ret;
    }

    @Override
    public Retorno borrarOcurrenciasPalabraEnLinea(int numContactoOrigen, int numMensaje, int posicionLinea, String palabraABorrar) {
        Retorno ret = new Retorno(Retorno.Resultado.NO_IMPLEMENTADA);
        Mensaje men = new Mensaje(numMensaje);
        Nodo<Mensaje> menB = SistemaMensajes.obtenerElemento(men);
        if (menB.getDato() != null) {
            if (!menB.getDato().getListaLineas().esVacia()) {
                Linea l = new Linea(posicionLinea);
                Nodo<Linea> actualL = menB.getDato().getListaLineas().getInicio();
                boolean b = false;
                while (actualL != null || !b) {
                    if (actualL.getDato().getNumeroLinea() == posicionLinea) {

                        if (!actualL.getDato().getListaPalabras().esVacia()) {
                            Nodo<Palabra> actualP = actualL.getDato().getListaPalabras().getInicio();
                            Palabra pABorrar = new Palabra(palabraABorrar);
                            while (actualP != null) {
                                if (actualP.getDato().getDato() == palabraABorrar) {
                                    actualL.getDato().getListaPalabras().borrarElemento(pABorrar);
                                }
                                actualP = actualP.getSiguiente();
                            }

                        }
                        b = true;
                    }

                    actualL = actualL.getSiguiente();
                }

            }
        }
        ret.resultado = Retorno.Resultado.OK;
        return ret;
    }

    @Override
    public Retorno imprimirLinea(int numContactoOrigen, int numMensaje, int posicionLinea) {
        Retorno ret = new Retorno(Retorno.Resultado.NO_IMPLEMENTADA);
        int contadorLineas = 0;

        if (!SistemaMensajes.esVacia()) {
            Contacto cO = new Contacto(numContactoOrigen);
            Mensaje m = new Mensaje(numMensaje);
            if (contactos.obtenerElemento(cO) != null && SistemaMensajes.obtenerElemento(m) != null) {
                Mensaje msg = SistemaMensajes.obtenerElemento(new Mensaje(numMensaje)).getDato();

                Lista<Linea> listaLineas = msg.getListaLineas();
                Nodo nodoLinea = listaLineas.getInicio();
                while (nodoLinea != null && contadorLineas < posicionLinea) {
                    nodoLinea.getSiguiente();
                    contadorLineas++;
                }
                System.out.println(nodoLinea.getDato().toString());
            } else {
                ret.resultado = Retorno.Resultado.ERROR;
            }
            ret.resultado = Retorno.Resultado.ERROR;
        }
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
    public Retorno ImprimirTextoIncorrecto(int numeroContacto, int numeroMensaje) {
        Retorno ret = new Retorno(Retorno.Resultado.NO_IMPLEMENTADA);

        if (!SistemaMensajes.esVacia()) {

            Nodo nodoMensaje = SistemaMensajes.getInicio();

            while (nodoMensaje != null) {

                Mensaje esteMensaje = (Mensaje) nodoMensaje.getDato();

                if (esteMensaje.getNumeroDeMensaje() == numeroMensaje && esteMensaje.getContOrigen().numeroContacto == numeroContacto) {

                    Lista<Linea> listaLineas = esteMensaje.getListaLineas();

                    Nodo nodoLinea = listaLineas.getInicio();

                    while (nodoLinea != null) {

                        Lista<String> listaPalabras = (Lista<String>) nodoLinea.getDato();

                        Nodo nodoPalabra = listaPalabras.getInicio();

                        while (nodoPalabra != null) {

                            String palabraActual = (String) nodoPalabra.getDato();

                            if (!enDiccionario(palabraActual)) {

                                System.out.println(palabraActual);
                            }

                            nodoPalabra.getSiguiente();
                        }

                    }
                }

            }

            ret.resultado = Retorno.Resultado.ERROR;
        }

        return ret;
    }

    @Override
    public Retorno cantidadDeMensajes(int numContactoOrigen) {
        Retorno ret = new Retorno(Retorno.Resultado.NO_IMPLEMENTADA);
        int contador = 0;

        Nodo<Mensaje> mensajeAct = SistemaMensajes.getInicio();

        while (mensajeAct != null) {
            mensajeAct = mensajeAct.getSiguiente();
        }

        ret.valorEntero = contador;
        return ret;
    }

    public Boolean enDiccionario(String palabra) {

        boolean esta = false;

        Nodo palabraExistente = diccionario.obtenerElemento(palabra);

        if (palabraExistente != null) {

            esta = true;

        }

        return esta;
    }

    @Override
    public Retorno borrarPalabraDiccionario(String palabraABorrar
    ) {

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
