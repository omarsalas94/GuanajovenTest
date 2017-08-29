package Test;

import Pages.PageComenzar;
import Pages.PageInicioRegistro;
import Pages.PageInicioSesion;
import Pages.PagePrincipal;
import TestingActivo.BDConexion;
import TestingActivo.ModeloPrueba;
import org.openqa.selenium.NoSuchElementException;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

public class GuanajovenEventosTest extends Setup{
    BDConexion bdConexion;
    ModeloPrueba modeloPrueba;

    PageComenzar pageComenzar;
    PageInicioRegistro pageInicioRegistro;
    PageInicioSesion pageInicioSesion;
    PagePrincipal pagePrincipal;

    String email = "";
    String psw = "";

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


        for (int i = 0; i < bdConexion.getUsrPass("CP7.Guanajoven").size(); i += 2) {
            pageInicioRegistro = new PageInicioRegistro(driver);
            pageInicioRegistro.seleccionarInicioRgistro("Iniciar");

            email = String.valueOf(bdConexion.getUsrPass("CP7.Guanajoven").get(i).get(1));
            psw = String.valueOf(bdConexion.getUsrPass("CP7.Guanajoven").get(i + 1).get(1));

            pageInicioSesion = new PageInicioSesion(driver);
            pageInicioSesion.escribirEmail(email);
            pageInicioSesion.escribirPass(psw);
            pageInicioSesion.clicIniciarSesion();

        }
    }
}
