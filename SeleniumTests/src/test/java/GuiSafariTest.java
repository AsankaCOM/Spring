import org.junit.Assert;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.safari.SafariDriver;

import java.util.List;

import static junit.framework.TestCase.assertEquals;

public class GuiSafariTest {
    //WebDriver  driver;

    public static void main(String[] arg){
        WebDriver driver = new SafariDriver();
        driver.get("http://localhost:8080/cars/");

    }

    //@Test
    public void titleTest()
    {
        //driver = new SafariDriver();
        //driver.get("http://localhost:8080/cars/");

        //assertEquals(driver.getTitle(), "Home");
        ;
    }

}
