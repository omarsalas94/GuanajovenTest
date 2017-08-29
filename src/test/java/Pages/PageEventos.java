package Pages;

import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.android.AndroidElement;
import org.openqa.selenium.By;

import java.util.ArrayList;
import java.util.List;

public class PageEventos {
    private AndroidDriver driver;

    private By xpathListaEventos = By.xpath("//android.support.v7.widget.RecyclerView[@resource-id='mx.gob.jovenes.guanajuato:id/rv_eventos']/android.widget.FrameLayout");
    private By idNombreEventos = By.id("mx.gob.jovenes.guanajuato:id/tv_titulo");

    private List<AndroidElement> listNombreEventos;

    public PageEventos(AndroidDriver driver){
        this.driver = driver;
    }

    public ArrayList<String> getListaNombreEventos(){
        ArrayList<String> regresar = new ArrayList<String>();
        listNombreEventos = driver.findElements(idNombreEventos);
        for (int i = 0; i < listNombreEventos.size(); i++) {
            regresar.add(listNombreEventos.get(i).getText());
        }
        return regresar;
    }

    public List<AndroidElement> getListaEventos(){
        return driver.findElements(xpathListaEventos);
    }

    public void clicRegresar(){
        driver.navigate().back();
    }
}
