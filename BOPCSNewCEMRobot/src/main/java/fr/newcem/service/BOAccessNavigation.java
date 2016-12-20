package fr.newcem.service;

import org.omg.CORBA.SystemException;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
//import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.ie.InternetExplorerDriver;
import org.openqa.selenium.support.ui.ExpectedCondition;
import org.openqa.selenium.support.ui.WebDriverWait;
import java.util.List;
import java.util.Set;
import java.io.File;
import java.util.concurrent.TimeUnit;
/**
 * Created by moi on 17/12/2016.
 */
public class BOAccessNavigation {

    public BOAccessNavigation(){
        File file = new File("C:/seleniumDriver/IEDriverServer.exe");
        System.setProperty("webdriver.ie.driver", file.getAbsolutePath());
        WebDriver driver = new InternetExplorerDriver() {};
        driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);

        driver.get("http://www.google.com");
        //driver.get("http://www.fnac.com");
        //driver.findElement(By.className("boxSelect")).sendKeys("css=img[alt=\"Google\"]");
        driver.findElement(By.id("lst-ib")).sendKeys("css=img[alt=\"Google\"]");
        driver.findElement(By.id("lst-ib")).submit();
        driver.findElement(By.id("lst-ib")).sendKeys("css=img[alt=\"Google\"]");
        driver.findElement(By.id("lst-ib")).submit();
        WebElement element = driver.findElement(By.name("f"));
        WebElement allFormChildElements = driver.findElement(By.xpath("//form[@name='q']/*"));    // Enter something to search for
        allFormChildElements.sendKeys("Cheese!");
        // Now submit the form. WebDriver will find the form for us from the element
        element.submit();

        // Check the title of the page
        System.out.println("Page title is: " + driver.getTitle());

        // Google's search is rendered dynamically with JavaScript.
        // Wait for the page to load, timeout after 10 seconds
        (new WebDriverWait(driver, 10)).until(new ExpectedCondition<Boolean>() {
            public Boolean apply(WebDriver d) {
                return d.getTitle().toLowerCase().startsWith("cheese!");
            }
        });

        // Should see: "cheese! - Google Search"
        System.out.println("Page title is: " + driver.getTitle());

        //Close the browser
        driver.quit();
    }
}
