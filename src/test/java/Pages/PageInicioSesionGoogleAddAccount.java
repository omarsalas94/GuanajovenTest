package Pages;

import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.android.AndroidElement;
import org.openqa.selenium.By;
import org.openqa.selenium.interactions.touch.TouchActions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.util.List;

public class PageInicioSesionGoogleAddAccount {
    private AndroidDriver driver;

    private By idEmail = By.id("identifierId");
    private By xpathCreateAccount = By.xpath("//android.view.View[@resource-id='view_container']/android.view.View[0]/android.view.View[1]/android.view.View[0]/android.view.View[4]");
    private By idCreateAccount = By.id("createAccount");

    public PageInicioSesionGoogleAddAccount(AndroidDriver driver) {
        this.driver = driver;
    }

    public void escribirEmail(String email) {
        if (isVisible(idEmail)) {
            driver.findElement(idEmail).sendKeys(email);
        }
    }

    public void clicCreateAccount() {
        esperar(8);
        driver.findElement(By.id("createAccount"));
        System.out.println(driver.findElement(By.id("createAccount")).getText());
        System.out.println("PAse");
        driver.findElementByAccessibilityId("Or create a new account").click();
        System.out.println(driver.findElementByAccessibilityId("Or create a new account").getText());

    }

    private Boolean isVisible(By element) {
        WebDriverWait wait = new WebDriverWait(driver, 20);
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