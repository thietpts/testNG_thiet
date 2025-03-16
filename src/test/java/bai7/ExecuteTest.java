package bai7;
import ThucHanh.locator;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.testng.annotations.*;
import java.time.Duration;

import static java.lang.Thread.sleep;

public class ExecuteTest {
    public static WebDriver driver;

    @BeforeClass
    public void createDriver(){
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

    @Test
    public void TestSendKeys() throws InterruptedException {

        //driver kế thừa từ class SetupBrowser
        driver.get("https://www.google.com/");

        // Element search box
        WebElement element = driver.findElement(By.xpath("//textarea[@name='q']"));

        // Tạo đối tượng của Actions class và để driver vào
        Actions action = new Actions(driver);

        // Dùng action để gọi hàm sendkeys điền dữ liệu. Không dùng sendKeys của WebElement
        action.sendKeys(element, "Anh Tester").perform();
        action.sendKeys(Keys.ENTER).perform();
        sleep(2000);
    }

    @AfterClass
    public void Close(){
        driver.quit();
    }

    @Test
    public void moveToElement() throws InterruptedException {
        driver.get("https://anhtester.com/");
        sleep(2000);
        WebElement element = driver.findElement(By.xpath("//h2[contains(text(),'Kiến thức Automation Testing')]"));

        Actions action = new Actions(driver);

        //Move to element (di chuyển tới title Kiến thức Automation Testing)
        action.moveToElement(element).perform();

        sleep(2000);
    }

    @Test
    public void demoDragAndDropWithActionClass() throws InterruptedException {
        driver.get("http://www.dhtmlgoodies.com/scripts/drag-drop-custom/demo-drag-drop-3.html");
        sleep(1);

        // Bắt element cần kéo
        WebElement From = driver.findElement(By.xpath("//div[@id='box6']"));
        // Bắt element cần thả đến
        WebElement To = driver.findElement(By.xpath("//div[@id='countries']//div[1]"));

        sleep(1);
        Actions action = new Actions(driver);
        // Kéo và thả
        action.dragAndDrop(From, To).perform();

        sleep(5000);
    }

    @Test
    public void inputTextUppercase() throws InterruptedException {
        driver.get("https://www.google.com/");
        Thread.sleep(2000);
        WebElement element = driver.findElement(By.xpath("//textarea[@name='q']"));

        Actions action = new Actions(driver);

        // Đè giữ phím SHIFT và nhập text -> Chữ in hoa
        action.keyDown(element, Keys.SHIFT).sendKeys("anh tester").keyUp(element, Keys.SHIFT).sendKeys("anh tester").build().perform();

        Thread.sleep(2000);
    }

    @Test
    public void testIFrame01() throws InterruptedException {

        driver.navigate().to("https://anhtester.com/contact");
        Thread.sleep(10000);
        System.out.println("iframe total: " + driver.findElements(By.tagName("iframe")).size());
        //----Switch to content of Messenger--------
        driver.switchTo().frame(0); //Thẻ iframe thứ nhất
        System.out.println(driver.findElement(By.xpath("//label[@id='recaptcha-anchor-label']")).getText());

        //----Switch to icon of Messenger---------

        //1. Switch to Parent WindowHandle
        driver.switchTo().parentFrame(); //Chuyển về nội dung chính không thuộc iframe nào

        Thread.sleep(2000);
    }
}
