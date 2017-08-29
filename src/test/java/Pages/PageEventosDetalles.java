package Pages;

import io.appium.java_client.android.AndroidDriver;
import org.openqa.selenium.By;

public class PageEventosDetalles {
    private AndroidDriver driver;

    private By idNombre = By.id("mx.gob.jovenes.guanajuato:id/tv_nombre_evento");
    private By idDireccion = By.id("mx.gob.jovenes.guanajuato:id/tv_direccion_evento");
    private By idDetalles = By.id("mx.gob.jovenes.guanajuato:id/tv_descripcion_evento");
    private By idFecha = By.id("mx.gob.jovenes.guanajuato:id/tv_fechas_evento");
    private By idEstatus = By.id("mx.gob.jovenes.guanajuato:id/textview_evento_caducado");

    public PageEventosDetalles(AndroidDriver driver){
        this.driver = driver;
    }

    public String getNombre(){
        return driver.findElement(idNombre).getText();
    }

    public String getDireccion() {
        return driver.findElement(idDireccion).getText();
    }

    public String getDetalles() {
        return driver.findElement(idDetalles).getText();
    }

    public String getFecha() {
        return driver.findElement(idFecha).getText();
    }

    public String getEstatus() {
        return driver.findElement(idEstatus).getText();
    }

    public void clicRegresar(){
        driver.navigate().back();
    }
}
