package bai7;

import org.openqa.selenium.*;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import java.time.Duration;
import java.util.Set;

import static java.lang.Thread.sleep;

public class AlertTest {
    public static WebDriver driver;

    @BeforeClass
    public void createDriver(){
        driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
    }

    @Test
    public void demoHandleAlertAccept() throws InterruptedException {
        driver.get("https://demoqa.com/alerts");
        WebElement element = driver.findElement(By.xpath("//button[@id='promtButton']"));
        sleep(2);
        JavascriptExecutor js = (JavascriptExecutor) driver;
        js.executeScript("arguments[0].scrollIntoView(true)", element);
        //Mở Alert Message, click vào nút "Click me!" thứ nhất
        driver.findElement(By.xpath("//button[@id='alertButton']")).click();
        sleep(1);
        //Khởi tạo class Alert thứ nhất
        org.openqa.selenium.Alert alert1 = driver.switchTo().alert();
        alert1.accept();
        sleep(1);
        driver.findElement(By.xpath("//button[@id='timerAlertButton']")).click();
        sleep(6000);
        org.openqa.selenium.Alert alert2 = driver.switchTo().alert();
        alert2.accept();
        sleep(1);
        driver.findElement(By.xpath("//button[@id='confirmButton']")).click();
        sleep(1000);
        org.openqa.selenium.Alert alert3 = driver.switchTo().alert();
        alert3.dismiss();
        sleep(1000);
        driver.findElement(By.xpath("//button[@id='promtButton']")).click();
        sleep(1000);
        org.openqa.selenium.Alert alert4 = driver.switchTo().alert();
        String text= alert4.getText();
        alert4.sendKeys(text);
        sleep(1000);
        alert4.accept();
        sleep(1000);
        driver.close();
    }

    @Test
    public void demoPopupTypeTab() throws InterruptedException {
        driver.get("https://demoqa.com/browser-windows");
        sleep(2000);
        driver.findElement(By.xpath("//button[@id='tabButton']")).click();
        sleep(1000);
        // Lưu lại lớp window đầu tiên - mã ID hơi dài, in ra sẽ thấy :)
        String MainWindow = driver.getWindowHandle();
        System.out.println(MainWindow);

        // Lấy tất cả các mã định danh Tab Window.
        Set<String> windows = driver.getWindowHandles();

        //Set là một Collection để lưu các phần tử giá trị KHÔNG trùng lặp.
        //Cách duyệt từng phần tử không trùng lặp trong Collection (Set) - Java Basic
        for (String window : windows) {
            System.out.println(window);
            if (!MainWindow.equals(window)) {
                //So sánh nếu thằng nào khác thằng Chính (đầu tiên) thì chuyển hướng qua nó mới thao tác được
                //Chuyển hướng driver đến Tab mới (Tab con)
                driver.switchTo().window(window);
                sleep(1000);
                System.out.println("Đã chuyển đến Tab Window mới");

                //Một số hàm hỗ trợ
                System.out.println(driver.switchTo().window(window).getTitle());
                System.out.println(driver.switchTo().window(window).getCurrentUrl());

                sleep(1000);
                //Sau khi chuyển hướng sang Tab mới thì getText cái header
                System.out.println(driver.findElement(By.xpath("//h1[@id='sampleHeading']")).getText());

                // Tắt cái Tab Window mới.
                sleep(1000);
                driver.close();
            }
        }
        // Chuyển hướng về lại tab chính ban đầu (Main Window)
        driver.switchTo().window(MainWindow);
        System.out.println("Đã chuyển về lớp Window chính: " + driver.getCurrentUrl());

        sleep(1);
    }
}
