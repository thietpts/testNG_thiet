package ThucHanh;

import org.openqa.selenium.By;

public class Pack1 extends common {

    public static void main(String[] args) {
        createDriver();
        Pack1.login();
        Pack1.customer();
    }

    public static void customer(){
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
        driver.findElement(By.xpath(locator.btnSave)).click();
    }
}
