package Pages;

import io.appium.java_client.android.AndroidDriver;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.util.List;

public class PagePrincipal {
    private AndroidDriver driver;

    private By idMenuNavegacion = By.id("mx.gob.jovenes.guanajuato:id/boton_navigation_drawer");
    private By classElementosMenu = By.className("android.widget.CheckedTextView");
    private By idCodigoGuanajoven = By.id("mx.gob.jovenes.guanajuato:id/boton_codigo_guanajoven");
    private By idEventos = By.id("mx.gob.jovenes.guanajuato:id/boton_eventos");
    private By idConvocatorias = By.id("mx.gob.jovenes.guanajuato:id/boton_convocatorias");
    private By idPromociones = By.id("mx.gob.jovenes.guanajuato:id/boton_promociones");
    private By idRedesSociales = By.id("mx.gob.jovenes.guanajuato:id/boton_redes_sociales");
    private By idChat = By.id("mx.gob.jovenes.guanajuato:id/boton_chat");
    private By idBolsaTrabajo = By.id("mx.gob.jovenes.guanajuato:id/textview_bolsa_de_trabajo");

    public PagePrincipal(AndroidDriver driver) {
        this.driver = driver;
    }

    public void abrirMenuNavegacion() {
        driver.findElement(idMenuNavegacion).click();
    }

    public void clicCodigoGuanajoven() {
        driver.findElement(idCodigoGuanajoven).click();
    }

    public void clicEventos() {
        driver.findElement(idEventos).click();
    }

    public void clicConvocatorias() {
        driver.findElement(idConvocatorias).click();
    }

    public void clicPromociones() {
        driver.findElement(idPromociones).click();
    }

    public void clicRedesSociales() {
        driver.findElement(idRedesSociales).click();
    }

    public void clicChat() {
        driver.findElement(idChat).click();
    }

    public void clicBolsaTrabajo() {
        driver.findElement(idBolsaTrabajo).click();
    }

    public void cerrarSesion(String elementoMenu) {
        esperar(1);
        int posicion = 0;
        List<WebElement> a = driver.findElements(classElementosMenu);
        for (int i = 0; i < a.size(); i++) {
            if (elementoMenu.equals(a.get(i).getText())) {
                posicion = i;
            }
        }
        a.get(posicion).click();
    }

    public void esperar(int seg) {
        seg *= 1000;
        try {
            Thread.currentThread().sleep(seg);
        } catch (InterruptedException ex) {
            System.out.println(ex.getMessage());
        }
    }

    private Boolean isVisible(By element) {
        WebDriverWait wait = new WebDriverWait(driver, 20);
        wait.until(ExpectedConditions.presenceOfElementLocated(element));

        return driver.findElement(element).isDisplayed();
    }

}
