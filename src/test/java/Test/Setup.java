package Test;

import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.remote.AndroidMobileCapabilityType;
import org.openqa.selenium.remote.DesiredCapabilities;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.GregorianCalendar;

public class Setup {
    protected AndroidDriver driver;

    public void prepareAndroidForAppium() {
        DesiredCapabilities capabilities = new DesiredCapabilities();
        capabilities.setCapability("device", "Android");

        capabilities.setCapability("deviceName", "Android");
        capabilities.setCapability("plataformName", "Android");

        capabilities.setCapability(AndroidMobileCapabilityType.APP_PACKAGE, "mx.gob.jovenes.guanajuato");
        capabilities.setCapability(AndroidMobileCapabilityType.APP_ACTIVITY, ".activities.SplashActivity");
        capabilities.setCapability(AndroidMobileCapabilityType.APP_WAIT_ACTIVITY, ".activities.LoginActivity, .activities.BienvenidaActivity");

        try {
            this.driver = new AndroidDriver(new URL("http://127.0.0.1:4723/wd/hub"), capabilities);
        } catch (MalformedURLException malformedURLException) {
            System.out.println(malformedURLException.getMessage());
        }
    }

    public void cerrarApp() {
        driver.quit();
    }

    public String getFecha() {
        Calendar fecha = new GregorianCalendar();
        int año = fecha.get(Calendar.YEAR);
        int mes = fecha.get(Calendar.MONTH);
        int dia = fecha.get(Calendar.DAY_OF_MONTH);
        int hora = fecha.get(Calendar.HOUR_OF_DAY);
        int minuto = fecha.get(Calendar.MINUTE);
        int segundo = fecha.get(Calendar.SECOND);

        String fechas = año + "-" + (mes+1) + "-" + dia + " " + hora + ":"+ minuto+":"+segundo;

        return fechas;
    }
}