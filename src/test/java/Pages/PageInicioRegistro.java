package Pages;

import io.appium.java_client.android.AndroidDriver;
import org.openqa.selenium.By;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class PageInicioRegistro {
    AndroidDriver driver;

    By idIniciarSesion = By.id("mx.gob.jovenes.guanajuato:id/btn_login");
    By idRegistrar = By.id("mx.gob.jovenes.guanajuato:id/btn_registrar");

    public PageInicioRegistro(AndroidDriver driver){
        this.driver = driver;
    }

    public void seleccionarInicioRgistro(String inicioRegistro){
        if(inicioRegistro.equals("Iniciar")){
            if(isVisible(idIniciarSesion)) {
                driver.findElement(idIniciarSesion).click();
            }
        }else if(inicioRegistro.equals("Registrar")){
            if(isVisible(idRegistrar)){
                driver.findElement(idRegistrar).click();
            }
        }
    }

    private Boolean isVisible(By element) {
        WebDriverWait wait = new WebDriverWait(driver, 20);
        wait.until(ExpectedConditions.presenceOfElementLocated(element));

        return driver.findElement(element).isDisplayed();
    }
}
