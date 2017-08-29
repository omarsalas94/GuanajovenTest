package Test;

import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;

public class GuanajovenCodigoTest extends Setup{

    @BeforeTest
    public void Inicio(){

    }

    @AfterTest
    public void Cerrar(){
        cerrarApp();
    }
}
