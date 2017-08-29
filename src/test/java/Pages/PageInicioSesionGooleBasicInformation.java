package Pages;

import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.android.AndroidElement;
import org.openqa.selenium.By;

import java.util.List;

public class PageInicioSesionGooleBasicInformation {
    private AndroidDriver driver;

    private By idMes = By.id("month-label");
    private By idMes2 = By.id("android:id/text1");
    private By idDia = By.id("");
    private By idAño = By.id("");

    public PageInicioSesionGooleBasicInformation(AndroidDriver driver){
        this.driver = driver;
    }

    public void clicMes(){
        driver.findElement(idMes).click();
    }

    public List<AndroidElement> getListaMes(){
        return driver.findElements(idMes2);
    }
}
