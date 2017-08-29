package Pages;

import io.appium.java_client.android.AndroidDriver;

public class PageConvocatorias {
    private AndroidDriver driver;

    public PageConvocatorias(AndroidDriver driver){
        this.driver = driver;
    }

    public void regresar(){
        driver.navigate().back();
    }
}
