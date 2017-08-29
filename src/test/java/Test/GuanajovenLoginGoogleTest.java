package Test;

import Pages.*;

import TestingActivo.BDConexion;
import TestingActivo.ModeloPrueba;

import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

public class GuanajovenLoginGoogleTest extends Setup {
    BDConexion bdConexion;
    ModeloPrueba modeloPrueba;

    PageComenzar pageComenzar;
    PageInicioRegistro pageInicioRegistro;
    PageInicioSesion pageInicioSesion;

    PageInicioSesionGoogleAddAccount pageInicioSesionGoogleAddAccount;
    PageInicioSesionGoogleCreateAccount pageInicioSesionGoogleCreateAccount;
    PageInicioSesionGooleBasicInformation pageInicioSesionGooleBasicInformation;

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

        pageInicioRegistro = new PageInicioRegistro(driver);
        pageInicioRegistro.seleccionarInicioRgistro("Iniciar");

        pageInicioSesion = new PageInicioSesion(driver);
        pageInicioSesion.clicIniciarSesionGoogle();
        pageInicioSesion.clicUsarOtraCuentaGoogle();

        pageInicioSesionGoogleAddAccount = new PageInicioSesionGoogleAddAccount(driver);
        //pageInicioSesionGoogleAddAccount.escribirEmail("omar-salas@outlook.com");
        pageInicioSesionGoogleAddAccount.clicCreateAccount();

        pageInicioSesionGoogleCreateAccount = new PageInicioSesionGoogleCreateAccount(driver);
        pageInicioSesionGoogleCreateAccount.writeFirsName("omar");
        pageInicioSesionGoogleCreateAccount.writeLastName("salas");
        pageInicioSesionGoogleCreateAccount.clicNext();

        pageInicioSesionGooleBasicInformation = new PageInicioSesionGooleBasicInformation(driver);
        pageInicioSesionGooleBasicInformation.clicMes();
        System.out.println(pageInicioSesionGooleBasicInformation.getListaMes().size());
        for (int i = 0; i < pageInicioSesionGooleBasicInformation.getListaMes().size(); i++) {
            System.out.println(pageInicioSesionGooleBasicInformation.getListaMes().get(i).getText());
        }


    }
}
