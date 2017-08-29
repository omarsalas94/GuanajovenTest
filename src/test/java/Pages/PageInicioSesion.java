package Pages;

import io.appium.java_client.android.AndroidDriver;
import org.openqa.selenium.By;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class PageInicioSesion {
    private AndroidDriver driver;

    private By idEmail = By.id("mx.gob.jovenes.guanajuato:id/email_et");
    private By idPass = By.id("mx.gob.jovenes.guanajuato:id/pass_et");
    private By idIniciarSesion = By.id("mx.gob.jovenes.guanajuato:id/btn_iniciar_sesion");
    private By idFacebook = By.id("mx.gob.jovenes.guanajuato:id/btn_facebook");
    private By idGoogle = By.id("mx.gob.jovenes.guanajuato:id/btn_google");
    private By idOtraCuentaGoogle = By.id("android:id/button2");
    private By idPublicidad = By.id("mx.gob.jovenes.guanajuato:id/boton_ayuda");
    public By idError = By.id("mx.gob.jovenes.guanajuato:id/snackbar_text");

    public PageInicioSesion(AndroidDriver driver) {
        this.driver = driver;
    }

    public void escribirEmail(String email) {
        driver.findElement(idEmail).click();
        driver.findElement(idEmail).sendKeys(email);
    }

    public void escribirPass(String pass) {
        driver.findElement(idPass).sendKeys(pass);
        driver.hideKeyboard();
    }

    public void clicIniciarSesion() {
        driver.findElement(idIniciarSesion).click();
    }

    public void clicIniciarSesionGoogle() {
        driver.findElement(idGoogle).click();
    }

    public void clicIniciarSesionFacebook() {
        driver.findElement(idFacebook).click();
    }

    public void clicUsarOtraCuentaGoogle() {
        driver.findElement(idOtraCuentaGoogle).click();
    }

    public void error(){
        System.out.println(driver.findElement(idError).isEnabled());
    }

    public void cerrarPublicidad() {
        if (isVisible(idPublicidad)) {
            driver.findElement(idPublicidad).click();
        }
    }

    private Boolean isVisible(By element) {
        WebDriverWait wait = new WebDriverWait(driver, 5);
        wait.until(ExpectedConditions.presenceOfElementLocated(element));

        return driver.findElement(element).isDisplayed();
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
