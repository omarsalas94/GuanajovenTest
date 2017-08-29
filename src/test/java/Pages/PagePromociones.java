package Pages;

import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.android.AndroidElement;
import org.openqa.selenium.By;

import java.util.ArrayList;
import java.util.List;

public class PagePromociones {
    private AndroidDriver driver;

    private By xpathElementos = By.xpath("//android.support.v7.widget.RecyclerView[@resource-id='mx.gob.jovenes.guanajuato:id/rv_empresas']/android.widget.LinearLayout");
    private By idNombreEmpresa = By.id("mx.gob.jovenes.guanajuato:id/textview_nombre_empresa");
    private By idURLEmpresa = By.id("mx.gob.jovenes.guanajuato:id/textview_url_empresa");

    public PagePromociones(AndroidDriver driver){
        this.driver = driver;
    }

    public List<AndroidElement> getListaEmpresas(){
        return driver.findElements(xpathElementos);
    }

    public ArrayList<String> getNombreEmpresas(){
        ArrayList<String> regresar = new ArrayList<String>();
        List<AndroidElement> elements = driver.findElements(idNombreEmpresa);
        for (int i = 0; i < elements.size() ; i++) {
            regresar.add(elements.get(i).getText());
        }
        return regresar;
    }

    public void regresar(){
        driver.navigate().back();
    }

}
