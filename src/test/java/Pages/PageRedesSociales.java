package Pages;

import io.appium.java_client.android.AndroidDriver;

public class PageRedesSociales {
    private AndroidDriver driver;

    public PageRedesSociales(AndroidDriver driver){
        this.driver = driver;
    }

    public void regresar(){
        driver.navigate().back();
    }
}
