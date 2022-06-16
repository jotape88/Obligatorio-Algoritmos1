package trabajarconobligatorio;

import java.util.Date;

public class Obligatorio implements IObligatorio {

    static Lista<Mensaje> SistemaMensajes = null;
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
            ret.resultado = Retorno.Resultado.OK;
        } else {
            ret.resultado = Retorno.Resultado.ERROR;
        }

        return ret;
    }

    @Override
    public Retorno eliminarContacto(int numContacto) {
        Retorno ret = new Retorno(Retorno.Resultado.NO_IMPLEMENTADA);
        Contacto cAux = new Contacto(numContacto);
        if (contactos.obtenerElemento(cAux) != null) {
            contactos.borrarElemento(cAux);
            ret.resultado = Retorno.Resultado.OK;
        } else {
            ret.resultado = Retorno.Resultado.ERROR;
        }
        return ret;
    }

    @Override
    public Retorno agregarMensaje(int numContactoOrigen, int numContactoDestino, Date fecha) {
        Retorno ret = new Retorno(Retorno.Resultado.NO_IMPLEMENTADA);

        Contacto cO = new Contacto(numContactoOrigen);
        Contacto cD = new Contacto(numContactoDestino);

        if (contactos.obtenerElemento(cO) != null && contactos.obtenerElemento(cD) != null) {
            Contacto cOrigen = contactos.obtenerElemento(new Contacto(numContactoOrigen)).getDato();
            Contacto cDestino = contactos.obtenerElemento(new Contacto(numContactoDestino)).getDato();
            if (cOrigen.getNumeroContacto() == numContactoOrigen && cDestino.getNumeroContacto() == numContactoDestino) {
                Mensaje m = new Mensaje(cOrigen, cDestino, fecha, SistemaMensajes.getTope());
                SistemaMensajes.agregarInicio(m);
                ret.resultado = Retorno.Resultado.OK;
            } else {
                ret.resultado = Retorno.Resultado.ERROR;
            }
        } else {
            ret.resultado = Retorno.Resultado.ERROR;
        }
        return ret;
    }

    @Override
    public Retorno eliminarMensaje(int numContactoOrigen, int numMensaje) {
        Retorno ret = new Retorno(Retorno.Resultado.NO_IMPLEMENTADA);
        Contacto cO = new Contacto(numContactoOrigen);
        Mensaje m = new Mensaje(numMensaje);

        if (contactos.obtenerElemento(cO) != null && SistemaMensajes.obtenerElemento(m) != null) {
            Mensaje men = SistemaMensajes.obtenerElemento(new Mensaje(numMensaje)).getDato();
            Contacto cAux = contactos.obtenerElemento(new Contacto(numContactoOrigen)).getDato();
            if (men.getNumeroDeMensaje() == numMensaje && cAux.getNumeroContacto() == numContactoOrigen) {
                SistemaMensajes.borrarElemento(m);
                ret.resultado = Retorno.Resultado.OK;
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
//        Nodo<Mensaje> menB = SistemaMensajes.obtenerElemento(new Mensaje(numMensaje));
//        if (menB != null) {
//            Linea l = new Linea();
//            menB.getDato().getListaLineas().agregarFinal(l);
//            for (int i = 0; i <= menB.getDato().getListaLineas().getTope(); i++) {
//                menB.getDato().getListaLineas().getInicio().getDato().getListaPalabras().agregarInicio(new Palabra());
//            }
//            ret.resultado = Retorno.Resultado.OK;
//        }

        Nodo<Mensaje> nodoMensaje = SistemaMensajes.obtenerElemento(new Mensaje(numMensaje));

        if (nodoMensaje != null) {
            Mensaje esteMensaje = (Mensaje) nodoMensaje.getDato();
            Lista<Palabra> nuevaListaPalabras = new Lista<Palabra>();
            Linea l = new Linea();
            esteMensaje.getListaLineas().agregarFinal(l);
            int tope = esteMensaje.getListaLineas().getTope();
            Nodo nodoLinea = esteMensaje.getListaLineas().getInicio();
            while (nodoLinea != null) {

                Linea estaLinea = (Linea) nodoLinea.getDato();
                if (estaLinea.getListaPalabras().esVacia()) {
                    for (int i = 0; i <= tope; i++) {
                        estaLinea.getListaPalabras().agregarInicio(new Palabra());
                    }

                }
                nodoLinea = nodoLinea.getSiguiente();
            }

            ret.resultado = Retorno.Resultado.OK;
        } else {
            ret.resultado = Retorno.Resultado.ERROR;
        }
        return ret;
    }

    @Override
    public Retorno insertarLineaEnPosicion(int numContactoOrigen, int numMensaje, int posicionLinea
    ) {
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
    public Retorno borrarLinea(int numContactoOrigen, int numMensaje, int posicionLinea
    ) {

        Retorno ret = new Retorno(Retorno.Resultado.NO_IMPLEMENTADA);

        int contadorLinea = 0;

        Mensaje men = new Mensaje(numMensaje);
        Nodo<Mensaje> nodoMensaje = SistemaMensajes.obtenerElemento(men);

        if (nodoMensaje == null) {
            ret.resultado = Retorno.Resultado.ERROR;
        } else {
            while (nodoMensaje != null && contadorLinea <= posicionLinea) {

                Mensaje esteMensaje = (Mensaje) nodoMensaje.getDato();
                Lista<Linea> listaLineas = esteMensaje.getListaLineas();
                Nodo nodoLinea = listaLineas.getInicio();

                if (posicionLinea == 0) {
                    listaLineas.borrarInicio();

                } else if (contadorLinea == posicionLinea) {
                    Nodo aBorrar = nodoLinea.getSiguiente();
                    nodoLinea.setSiguiente(aBorrar.getSiguiente());
                    aBorrar.setSiguiente(null);
                } else {

                    nodoLinea = nodoLinea.getSiguiente();
                }

                nodoMensaje = nodoMensaje.getSiguiente();

            }

        }

        return ret;
    }

    @Override
    public Retorno borrarTodo(int numContactoOrigen, int numMensaje
    ) {
        Retorno ret = new Retorno(Retorno.Resultado.NO_IMPLEMENTADA);
        return ret;
    }

    @Override
    public Retorno borrarOcurrenciasPalabraEnTexto(int numContactoOrigen, int numMensaje, String palabraABorrar
    ) {
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
    public Retorno insertarPalabraEnLinea(int numContactoOrigen, int numMensaje, int posicionLinea, int posicionPalabra, String palabraAIngresar
    ) {
        Retorno ret = new Retorno(Retorno.Resultado.NO_IMPLEMENTADA);

        int topePalabras = SistemaMensajes.getTope();
        int contadorLinea = 0;
        int contadorPalabra = 0;
        boolean posPosible = false;

        if (!SistemaMensajes.esVacia()) {

            Nodo nodoMensaje = SistemaMensajes.getInicio();

            while (nodoMensaje != null && !posPosible) {

                Mensaje esteMensaje = (Mensaje) nodoMensaje.getDato();

                if (esteMensaje.getContOrigen().numeroContacto == numContactoOrigen && esteMensaje.getNumeroDeMensaje() == numMensaje) {
                    Lista<Linea> lineasMensaje = esteMensaje.getListaLineas();

                    if (!lineasMensaje.esVacia()) {

                        Nodo nodoLinea = lineasMensaje.getInicio();

                        while (nodoLinea != null && !posPosible && contadorLinea <= posicionLinea) {

                            if (contadorLinea == posicionLinea) {

                                Linea lineaAux = (Linea) nodoLinea.getDato();

                                Lista<Palabra> listaPalabras = lineaAux.getListaPalabras();

                                if (!listaPalabras.esVacia()) {

                                    Nodo estaPalabra = listaPalabras.getInicio();

                                    while (estaPalabra != null && contadorPalabra <= posicionPalabra && !posPosible) {

                                        if (contadorPalabra == posicionPalabra && contadorPalabra <= topePalabras) {

                                            estaPalabra.setDato(palabraAIngresar);

                                            posPosible = true;

                                            ret.resultado = Retorno.Resultado.OK;
                                        }

                                        estaPalabra = estaPalabra.getSiguiente();
                                        contadorPalabra++;

                                    }
                                } else {

                                    ret.resultado = Retorno.Resultado.ERROR;

                                }
                            }

                            nodoLinea = nodoLinea.getSiguiente();
                            contadorLinea++;

                        }

                    } else {

                        ret.resultado = Retorno.Resultado.ERROR;
                    }

                    ret.resultado = Retorno.Resultado.ERROR;

                }

                nodoMensaje = nodoMensaje.getSiguiente();
            }

        } else {

            ret.resultado = Retorno.Resultado.ERROR;
        }
        return ret;
    }

    @Override
    public Retorno insertarPalabraYDesplazar(int numContactoOrigen, int numMensaje, int posicionLinea, int posicionPalabra, String palabraAIngresar
    ) {
        Retorno ret = new Retorno(Retorno.Resultado.NO_IMPLEMENTADA);
        return ret;
    }

    @Override
    public Retorno borrarPalabra(int numContactoOrigen, int numMensaje, int posicionLinea, int posicionPalabra
    ) {
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

                    Lista<Linea> listaLineas = esteMensaje.getListaLineas();

                    if (!listaLineas.esVacia()) {

                        Nodo nodoLinea = listaLineas.getInicio();

                        while (nodoLinea != null && contadorLinea <= posicionLinea && !posPosible) {

                            if (contadorLinea == posicionLinea) {

                                Linea lineaAux = (Linea) nodoLinea.getDato();

                                Lista<Palabra> listaPalabras = lineaAux.getListaPalabras();

                                if (!listaPalabras.esVacia()) {

                                    Nodo nodoPalabra = listaPalabras.getInicio();

                                    while (nodoPalabra != null && contadorPalabra <= posicionPalabra && !posPosible) {

                                        if (contadorPalabra == posicionPalabra) {

                                            nodoPalabra.setDato(" ");

                                            posPosible = true;

                                            ret.resultado = Retorno.Resultado.OK;

                                        }

                                        nodoPalabra = nodoPalabra.getSiguiente();
                                        contadorPalabra++;

                                    }

                                } else {

                                    ret.resultado = Retorno.Resultado.ERROR;
                                }
                            }

                            nodoLinea = nodoLinea.getSiguiente();
                            contadorLinea++;

                        }

                    }

                }

                nodoMensaje = nodoMensaje.getSiguiente();
            }

        } else {

            ret.resultado = Retorno.Resultado.ERROR;
        }

        return ret;
    }

    @Override
    public Retorno borrarOcurrenciasPalabraEnLinea(int numContactoOrigen, int numMensaje, int posicionLinea, String palabraABorrar
    ) {
        Retorno ret = new Retorno(Retorno.Resultado.NO_IMPLEMENTADA);
        Boolean bandera = false;
        int contadorLinea = 0;
        Mensaje men = new Mensaje(numMensaje);

        Nodo nodoMensaje = SistemaMensajes.obtenerElemento(men);
        if (nodoMensaje != null) {

            Mensaje esteMensaje = (Mensaje) nodoMensaje.getDato();

            Lista<Linea> listaLineas = esteMensaje.getListaLineas();

            if (!listaLineas.esVacia()) {

                Nodo nodoLinea = listaLineas.getInicio();

                while (nodoLinea != null && contadorLinea <= posicionLinea & !bandera) {

                    if (contadorLinea == posicionLinea) {
                        Linea lineaAux = (Linea) nodoLinea.getDato();
                        Lista<Palabra> listaPalabras = lineaAux.getListaPalabras();

                        if (!listaPalabras.esVacia()) {

                            Nodo nodoPalabra = listaPalabras.getInicio();

                            while (nodoPalabra != null) {

                                if (nodoPalabra.getDato().toString() == palabraABorrar) {
                                    nodoPalabra.setDato(" ");
                                    ret.resultado = Retorno.Resultado.OK;

                                }

                                nodoPalabra = nodoPalabra.getSiguiente();

                            }

                        } else {

                            bandera = true;
                            ret.resultado = Retorno.Resultado.ERROR;

                        }

                    }

                    nodoLinea = nodoLinea.getSiguiente();

                }

            } else {
                bandera = true;
                ret.resultado = Retorno.Resultado.ERROR;
            }

        } else {
            ret.resultado = Retorno.Resultado.ERROR;
        }

        return ret;
    }

    @Override
    public Retorno imprimirLinea(int numContactoOrigen, int numMensaje, int posicionLinea
    ) {
        Retorno ret = new Retorno(Retorno.Resultado.NO_IMPLEMENTADA);
        int contadorLineas = 0;
        if (!SistemaMensajes.esVacia()) {
            Contacto cO = new Contacto(numContactoOrigen);
            Mensaje m = new Mensaje(numMensaje);
            if (contactos.obtenerElemento(cO) != null && SistemaMensajes.obtenerElemento(m) != null) {
                Mensaje msg = SistemaMensajes.obtenerElemento(new Mensaje(numMensaje)).getDato();
                Lista<Linea> listaLineas = msg.getListaLineas();
                Nodo nodoLinea = listaLineas.getInicio();
                boolean bandera = false;
                int largoLineas = listaLineas.getCantidad() - 1;
                if (posicionLinea <= largoLineas) {
                    while (nodoLinea.getDato() != null && !bandera) {
                        if (contadorLineas == posicionLinea) {
                            System.out.println(nodoLinea.getDato().toString());
                            bandera = true;
                            ret.resultado = Retorno.Resultado.OK;
                        } else {
                            nodoLinea = nodoLinea.getSiguiente();
                            contadorLineas++;
                        }
                    }
                } else {
                    ret.resultado = Retorno.Resultado.ERROR;
                }
            } else {
                ret.resultado = Retorno.Resultado.ERROR;
            }
            ret.resultado = Retorno.Resultado.ERROR;
        }
        return ret;
    }

    @Override
    public Retorno ingresarPalabraDiccionario(String palabraAIngresar
    ) {
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
            ret.resultado = Retorno.Resultado.OK;
        }

        return ret;
    }

    @Override
    public Retorno ImprimirTextoIncorrecto(int numeroContacto, int numeroMensaje
    ) {
        Retorno ret = new Retorno(Retorno.Resultado.NO_IMPLEMENTADA);

        Mensaje men = new Mensaje(numeroMensaje);
        Nodo<Mensaje> nodoMensaje = SistemaMensajes.obtenerElemento(men);
        while (nodoMensaje != null) {

            Mensaje esteMensaje = (Mensaje) nodoMensaje.getDato();

            if (esteMensaje.getNumeroDeMensaje() == numeroMensaje && esteMensaje.getContOrigen().numeroContacto == numeroContacto) {

                Lista<Linea> listaLineas = esteMensaje.getListaLineas();

                Nodo nodoLinea = listaLineas.getInicio();

                while (nodoLinea != null) {

                    Linea lineaAux = (Linea) nodoLinea.getDato();
                    Lista<Palabra> listaPalabras = lineaAux.getListaPalabras();
                    Nodo nodoPalabra = listaPalabras.getInicio();

                    while (nodoPalabra != null) {

                        String stringPalabra = nodoPalabra.getDato().toString();

                        if (!enDiccionario(stringPalabra)) {

                            System.out.println(stringPalabra);

                        }
                        nodoPalabra = nodoPalabra.getSiguiente();
                    }
                    nodoLinea = nodoLinea.getSiguiente();

                }
            }

            nodoMensaje = nodoMensaje.getSiguiente();
        }

        return ret;
    }

    @Override
    public Retorno cantidadDeMensajes(int numContactoOrigen
    ) {
        Retorno ret = new Retorno(Retorno.Resultado.NO_IMPLEMENTADA);
        Fila f = null;
        Nodo<Mensaje> mensajeAct = SistemaMensajes.getInicio();

        while (mensajeAct != null) {
            if (mensajeAct.getDato().getContOrigen().getNumeroContacto() == numContactoOrigen) {

                if (f == null) {
                    f = new Fila(mensajeAct.getDato().getContOrigen().getNombre());
                }
                if (f.getListaCelda().esVacia()) {
                    Celda c = new Celda(mensajeAct.getDato().getFecha());
                    f.getListaCelda().agregarFinal(c);
                } else {
                    Celda cB = new Celda(mensajeAct.getDato().getFecha());
                    Nodo<Celda> cF = f.getListaCelda().obtenerElemento(cB);
                    if (cF != null) {
                        cF.getDato().setCantMensajes(cF.getDato().getCantMensajes() + 1);
                    } else {
                        f.getListaCelda().agregarFinal(cB);
                    }
                }
//                
//                c.setCantMensajes(c.getCantMensajes() + 1);
//                f.getListaCelda().agregarFinal(c);
            }
            mensajeAct = mensajeAct.getSiguiente();
        }
        if (f != null) {
            System.out.println(f.toString());
        }
        // ret.valorEntero = contador;
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
            ret.resultado = Retorno.Resultado.OK;
        } else {
            ret.resultado = Retorno.Resultado.ERROR;
        }

        return ret;

    }

}
