package org.example;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import java.time.Duration;

//TIP To <b>Run</b> code, press <shortcut actionId="Run"/> or
// click the <icon src="AllIcons.Actions.Execute"/> icon in the gutter.
public class Main {
    public static void main(String[] args) {
        System.out.println("Hello");
        WebDriver driver;
        driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
        driver.get("https://anhtester.com/");
        driver.findElement(By.id("btn-login")).click();
        driver.findElement(By.name("email")).sendKeys("thietpts@gmail.com.vn");
        driver.findElement(By.name("password")).sendKeys("123456");
        driver.navigate().back();
        
    }


}