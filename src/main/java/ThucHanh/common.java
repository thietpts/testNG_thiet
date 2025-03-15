package ThucHanh;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;


import java.time.Duration;

public class common {
    public static WebDriver driver;

    public static void createDriver(){
        driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
    }

    public static void login(){
        driver.get(locator.url);
        driver.findElement(By.name("email")).sendKeys(locator.userName);
        driver.findElement(By.name("password")).sendKeys(locator.pass);
        driver.findElement(By.xpath(locator.btnLogin)).submit();
    }


}
