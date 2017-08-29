package Pages;

import io.appium.java_client.android.AndroidDriver;
import org.openqa.selenium.By;

public class PageComenzar {
    AndroidDriver driver;

    By idComenzar = By.id("mx.gob.jovenes.guanajuato:id/btn_comenzar");

    public PageComenzar(AndroidDriver driver){
        this.driver = driver;
    }

    public void clicComenzar(){
        driver.findElement(idComenzar).click();
    }
}
