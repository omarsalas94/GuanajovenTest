package Pages;

import io.appium.java_client.android.AndroidDriver;
import org.openqa.selenium.By;
import org.openqa.selenium.Dimension;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class PageRegistro {
    AndroidDriver driver;

    By idEmail = By.id("mx.gob.jovenes.guanajuato:id/et_emailreg");
    By idPass = By.id("mx.gob.jovenes.guanajuato:id/et_passreg");
    By idConfPass = By.id("mx.gob.jovenes.guanajuato:id/et_confpass");
    By idCurp = By.id("mx.gob.jovenes.guanajuato:id/et_curp");
    By idCP = By.id("mx.gob.jovenes.guanajuato:id/et_codigo_postal");
    By idRegistrar = By.id("mx.gob.jovenes.guanajuato:id/btn_continuar");
    By idPublicidad = By.id("mx.gob.jovenes.guanajuato:id/boton_ayuda");


    public PageRegistro(AndroidDriver driver) {
        this.driver = driver;
    }

    public void escribirEmail(String email) {
        driver.findElement(idEmail).sendKeys(email);
    }

    public void escribirPass(String pass) {
        driver.findElement(idPass).sendKeys(pass);
        hideKeyBoard();
    }

    public void escribirConfPass(String confPass) {
        driver.findElement(idConfPass).sendKeys(confPass);
        hideKeyBoard();
    }

    public void escribirCurp(String curp) {
        if (isVisible(idCurp)) {
            driver.findElement(idCurp).sendKeys(curp);
            esperar(2);
            hideKeyBoard();
            esperar(1);
            deslizar();
        }
    }

    public void escribirCP(String cp) {
        driver.findElement(idCP).sendKeys(cp);
        hideKeyBoard();
        esperar(1);
        deslizar();
    }

    public void clicRegistrar() {
        driver.findElement(idRegistrar).click();
    }

    public void cerrarPublicidad() {
        esperar(2);
        driver.findElement(idPublicidad).click();
    }

    public void hideKeyBoard() {
        driver.hideKeyboard();
    }

    public void esperar(int seg) {
        seg *= 1000;
        try {
            Thread.currentThread().sleep(seg);
        } catch (InterruptedException ex) {
            System.out.println(ex.getMessage());
        }
    }

    private void deslizar() {
        Dimension dimension = driver.manage().window().getSize();
        driver.swipe(dimension.width / 2, dimension.height - 10,
                dimension.width / 2, dimension.height / 4, 1000);
    }

    private Boolean isVisible(By element) {
        WebDriverWait wait = new WebDriverWait(driver, 20);
        wait.until(ExpectedConditions.presenceOfElementLocated(element));

        return driver.findElement(element).isDisplayed();
    }
}
