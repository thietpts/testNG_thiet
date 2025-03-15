package bai7;
import ThucHanh.locator;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.*;

import java.time.Duration;

public class ExecuteTest {
    public static WebDriver driver;

    @BeforeClass
    public static void createDriver(){
        driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
    }

    public static void login(String mail, String pass){
        driver.get(locator.url);
        driver.findElement(By.name("email")).sendKeys(mail);
        driver.findElement(By.name("password")).sendKeys(pass);
        driver.findElement(By.xpath(locator.btnLogin)).submit();
    }

    @Test
    public void login1(){
        login(locator.userName, locator.pass);
    }
    @Test
    public void login2(){
        customer();
    }


    public void customer(){
        driver.findElement(By.xpath(locator.menuCustomer)).click();
        driver.findElement(By.xpath(locator.labelHeader));
        driver.findElement(By.xpath(locator.btnAddNew)).click();
        driver.findElement(By.xpath(locator.txtCompany)).sendKeys("company 1");
        driver.findElement(By.xpath(locator.txtVat)).sendKeys("10");
        driver.findElement(By.xpath(locator.txtPhone)).sendKeys("0988337446");
        driver.findElement(By.xpath(locator.txtWebsite)).sendKeys("https://nvm.com.vn");
        driver.findElement(By.xpath(locator.drpGroup)).click();
        driver.findElement(By.xpath(locator.itemGroup)).click();
        driver.findElement(By.xpath(locator.drpGroup)).click();
        driver.findElement(By.xpath(locator.drpCurrency)).click();
        driver.findElement(By.xpath(locator.itemCurrency)).click();
        driver.findElement(By.xpath(locator.drpLanguage)).click();
        driver.findElement(By.xpath(locator.itemLanguage)).click();
        driver.findElement(By.xpath(locator.ariaAddress)).sendKeys("Thực hành");
        driver.findElement(By.xpath(locator.txtCity)).sendKeys("Hà Nội");
        driver.findElement(By.xpath(locator.txtState)).sendKeys("OK");
        driver.findElement(By.xpath(locator.txtZip)).sendKeys("1000000");
        driver.findElement(By.xpath(locator.drpCountry)).click();
        driver.findElement(By.xpath(locator.itemCountry)).click();
        driver.findElement(By.xpath(locator.btnSave)).submit();
        driver.findElement(By.xpath(locator.lalCheck));
    }

    @AfterClass
    public void Close(){
        driver.quit();
        Assert.assertEquals(locator.itemLanguage,"Xin chào","sai title");
    }
}
