package Pages;

import io.appium.java_client.android.AndroidDriver;
import org.openqa.selenium.By;

public class PagePromocionesDetalles {
    private AndroidDriver driver;

    private By xpathEmpresas = By.xpath("//android.support.v7.widget.RecyclerView[@resource-id='mx.gob.jovenes.guanajuato:id/rv_empresas']/android.widget.LinearLayout");

    public PagePromocionesDetalles(AndroidDriver driver){
        this.driver = driver;
    }


}
