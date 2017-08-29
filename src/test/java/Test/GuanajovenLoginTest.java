package Test;

import Pages.PageComenzar;
import Pages.PageInicioSesion;
import Pages.PageInicioRegistro;
import Pages.PagePrincipal;
import TestingActivo.ModeloPrueba;
import org.openqa.selenium.NoSuchElementException;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import TestingActivo.BDConexion;

public class GuanajovenLoginTest extends Setup {
    BDConexion bdConexion;
    ModeloPrueba modeloPrueba;

    PageComenzar pageComenzar;
    PageInicioRegistro pageInicioRegistro;
    PageInicioSesion pageInicioSesion;
    PagePrincipal pagePrincipal;

    String email = "";
    String psw = "";

    String estatus = "";
    String esperado = "Cuenta registrada en Guanajoven";
    String nombrePrueba = "Login Test";
    int idCasoPrueba = 12;
    long timepoInicio = 0;

    @BeforeTest
    public void inicio() {
        timepoInicio = System.currentTimeMillis();
        prepareAndroidForAppium();
        bdConexion = new BDConexion();
    }

    @AfterTest
    public void fin() {
        cerrarApp();
    }

    @Test
    public void pruebaLoginTest() {
        pageComenzar = new PageComenzar(driver);
        pageComenzar.clicComenzar();


        for (int i = 0; i < bdConexion.getUsrPass("CP3.Guanajoven").size(); i += 2) {
            pageInicioRegistro = new PageInicioRegistro(driver);
            pageInicioRegistro.seleccionarInicioRgistro("Iniciar");

            email = String.valueOf(bdConexion.getUsrPass("CP3.Guanajoven").get(i).get(1));
            psw = String.valueOf(bdConexion.getUsrPass("CP3.Guanajoven").get(i + 1).get(1));

            pageInicioSesion = new PageInicioSesion(driver);
            pageInicioSesion.escribirEmail(email);
            pageInicioSesion.escribirPass(psw);
            pageInicioSesion.clicIniciarSesion();

            try {
                pageInicioSesion.error();
                driver.navigate().back();
                estatus = "Fail";
            } catch (NoSuchElementException ex) {
                pageInicioSesion.cerrarPublicidad();

                pagePrincipal = new PagePrincipal(driver);
                pagePrincipal.abrirMenuNavegacion();
                pagePrincipal.cerrarSesion("Cerrar sesión");
                estatus = "Success";
            }

            //Mandamos la informacion a la base de datos
            modeloPrueba = new ModeloPrueba();
            modeloPrueba.setId_caso_prueba(idCasoPrueba);
            modeloPrueba.setNombre(nombrePrueba);
            modeloPrueba.setEsperado(esperado);
            modeloPrueba.setRecibido(email);
            modeloPrueba.setEstatus(estatus);
            modeloPrueba.setTiempo((System.currentTimeMillis()-timepoInicio)/1000 + " Seg.");
            modeloPrueba.setCreated_at(getFecha());

            bdConexion.insertarPrueba(modeloPrueba);
        }
    }
}