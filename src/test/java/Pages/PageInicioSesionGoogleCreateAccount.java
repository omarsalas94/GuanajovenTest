package Pages;

import io.appium.java_client.android.AndroidDriver;
import org.openqa.selenium.By;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class PageInicioSesionGoogleCreateAccount {
    private AndroidDriver driver;

    private By idFirstName = By.id("firstName");
    private By idLastName = By.id("lastName");
    private String contentNext = "NEXT";

    public PageInicioSesionGoogleCreateAccount(AndroidDriver driver) {
        this.driver = driver;
    }

    public void writeFirsName(String firstName) {
        if (isVisible(idFirstName)) {
            driver.findElement(idFirstName).sendKeys(firstName);
        }
    }

    public void writeLastName(String lastName) {
        driver.findElement(idLastName).sendKeys(lastName);
    }

    public void clicNext() {
        driver.findElementByAccessibilityId(contentNext).click();
    }

    private Boolean isVisible(By element) {
        WebDriverWait wait = new WebDriverWait(driver, 20);
        wait.until(ExpectedConditions.presenceOfElementLocated(element));

        return driver.findElement(element).isDisplayed();
    }
}
