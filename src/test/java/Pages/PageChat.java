package Pages;

import io.appium.java_client.android.AndroidDriver;

public class PageChat {
    AndroidDriver driver;

    public PageChat(AndroidDriver driver){
        this.driver = driver;
    }

    public void regresar(){
        driver.navigate().back();
    }
}
