package Test;

import Pages.*;
import org.testng.Assert;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;


import TestingActivo.BDConexion;
import TestingActivo.ModeloPrueba;

public class GuanajovenTest2 extends Setup {
    long tiempoInicio = 0;
    String estatus = "";
    //¨***************************
    PageComenzar pageComenzar;
    PageInicioRegistro pageInicioRegistro;
    PageRegistro pageRegistro;

    PageInicioSesion pageInicioSesion;

    //****Paginas******
    PagePrincipal pagePrincipal;
        PageCodigoGuanajoven pageCodigoGuanajoven;
        PageEventos pageEventos;
            PageEventosDetalles pageEventosDetalles;
        PageConvocatorias pageConvocatorias;
        PagePromociones pagePromociones;
            PagePromocionesDetalles pagePromocionesDetalles;
        PageRedesSociales pageRedesSociales;
        PageChat pageChat;

    //****Base Datos****
    BDConexion conexion;
    ModeloPrueba modeloPrueba;

    @BeforeTest
    public void inicio() {
        prepareAndroidForAppium();
        tiempoInicio = System.currentTimeMillis();
    }

    @AfterTest
    public void fin() {
        cerrarApp();
    }

    @Test
    public void pruebaGuanajoven() {
        //Base datos
        conexion = new BDConexion();

        //Prueba
        pageComenzar = new PageComenzar(driver);
        pageComenzar.clicComenzar();

        for (int i = 0; i < conexion.getParametros().size()/2; i++) {
            pageInicioRegistro = new PageInicioRegistro(driver);
            pageInicioRegistro.seleccionarInicioRgistro("Iniciar");

            pageInicioSesion = new PageInicioSesion(driver);
            pageInicioSesion.escribirEmail(String.valueOf(conexion.getParametros().get(i).get(3)));
            pageInicioSesion.escribirPass(String.valueOf(conexion.getParametros().get(i).get(3)));
            pageInicioSesion.clicIniciarSesion();
            pageInicioSesion.cerrarPublicidad();
            pagePrincipal = new PagePrincipal(driver);
            pagePrincipal.clicCodigoGuanajoven();
                pageCodigoGuanajoven = new PageCodigoGuanajoven(driver);
                //System.out.println(pageCodigoGuanajoven.getEmail());
                //*****************Modelo para la BASEDATOS****************************
                modeloPrueba = new ModeloPrueba();
                modeloPrueba.setId_caso_prueba(3);
                modeloPrueba.setNombre("CodigoGuanajoven");
                modeloPrueba.setEsperado(String.valueOf(conexion.getParametros().get(i).get(3)));
                modeloPrueba.setRecibido(pageCodigoGuanajoven.getEmail());
                try{
                    Assert.assertEquals(String.valueOf(conexion.getParametros().get(i).get(3)), pageCodigoGuanajoven.getEmail());
                    estatus = "Pasada";
                }catch (AssertionError ex){
                    estatus = "Fallida";
                }
                modeloPrueba.setEstatus(estatus);
                modeloPrueba.setTiempo((System.currentTimeMillis()-tiempoInicio)/1000 + " seg.");
                modeloPrueba.setCreated_at(getFecha());
                modeloPrueba.setUpdate_at(null);
                modeloPrueba.setDelete_at(null);

                conexion.insertarPrueba(modeloPrueba);
                //*****************Modelo para la BASEDATOS****************************
                pageCodigoGuanajoven.clicRegresar();

            pagePrincipal.clicEventos();
                pageEventos = new PageEventos(driver);
                for (int j = 0; j < pageEventos.getListaEventos().size() ; j++) {
                    pageEventosDetalles = new PageEventosDetalles(driver);
                    pageEventos.getListaEventos().get(j).click();
                        String recibido = pageEventosDetalles.getNombre();
                    pageEventosDetalles.clicRegresar();

                    //*****************Modelo para la BASEDATOS****************************
                    modeloPrueba = new ModeloPrueba();
                    modeloPrueba.setId_caso_prueba(3);
                    modeloPrueba.setNombre("Eventos");
                    modeloPrueba.setEsperado(pageEventos.getListaNombreEventos().get(j));
                    modeloPrueba.setRecibido(recibido);
                    try{
                        Assert.assertEquals(pageEventos.getListaNombreEventos().get(j), recibido);
                        estatus = "Pasada";
                    }catch (AssertionError ex){
                        estatus = "Fallida";
                    }
                    modeloPrueba.setEstatus(estatus);
                    modeloPrueba.setTiempo((System.currentTimeMillis()-tiempoInicio)/1000 + " seg.");
                    modeloPrueba.setCreated_at(getFecha());
                    modeloPrueba.setUpdate_at(null);
                    modeloPrueba.setDelete_at(null);

                    conexion.insertarPrueba(modeloPrueba);
                    //*****************Modelo para la BASEDATOS***************************

                }
                pageEventos.clicRegresar();

            pagePrincipal.clicConvocatorias();
                pageConvocatorias = new PageConvocatorias(driver);
                pageConvocatorias.regresar();

            pagePrincipal.clicPromociones();
                pagePromociones = new PagePromociones(driver);
                /*System.out.println(pagePromociones.getListaEmpresas().size());
                for (int j = 0; j < pagePromociones.getListaEmpresas().size(); j++) {
                    esperar(2);
                    pagePromociones.getListaEmpresas().get(j).click();
                    esperar(2);
                    pagePromociones.regresar();
                }*/
                pagePromociones.regresar();

            pagePrincipal.clicRedesSociales();
                pageRedesSociales = new PageRedesSociales(driver);
                pageRedesSociales.regresar();

            pagePrincipal.clicChat();
                pageChat = new PageChat(driver);
                pageChat.regresar();

            pagePrincipal.abrirMenuNavegacion();
                pagePrincipal.cerrarSesion("Cerrar sesión");
        }

    }

    public void esperar(int seg) {
        seg *= 1000;
        try {
            Thread.currentThread().sleep(seg);
        } catch (InterruptedException ex) {
            System.out.println(ex.getMessage());
        }
    }
}