package Pages;

import io.appium.java_client.android.AndroidDriver;
import org.openqa.selenium.By;

public class PageCodigoGuanajoven {
    private AndroidDriver driver;

    private By idEmail = By.id("mx.gob.jovenes.guanajuato:id/tv_correoCG");
    private By idGenerarPDF = By.id("mx.gob.jovenes.guanajuato:id/item_generar_pdf");

    public PageCodigoGuanajoven(AndroidDriver driver){
        this.driver = driver;
    }

    public void clicGenerarPDF(){
        driver.findElement(idGenerarPDF).click();
    }

    public void clicRegresar(){
        driver.navigate().back();
    }

    public String getEmail(){
        return driver.findElement(idEmail).getText();
    }



}
