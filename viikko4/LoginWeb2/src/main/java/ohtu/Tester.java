package ohtu;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.htmlunit.HtmlUnitDriver;

public class Tester {

    public static void main(String[] args) {
        WebDriver driver = new FirefoxDriver();
        testi1(driver);
        testi2(driver);
        testi3(driver);
        testi4(driver, "uusiii");
        testi5(driver);

    }

    private static void alusta(WebDriver driver) {
        driver.get("http://localhost:8090");

    }

    private static void testi1(WebDriver driver) {
        alusta(driver);
        WebElement element = driver.findElement(By.linkText("login"));
        element.click();
        element = driver.findElement(By.name("username"));
        element.sendKeys("pekka");
        element = driver.findElement(By.name("password"));
        element.sendKeys("akkep");
        element = driver.findElement(By.name("login"));
        element.submit();

    }

    private static void testi2(WebDriver driver) {
        alusta(driver);
        WebElement element = driver.findElement(By.linkText("login"));
        element.click();
        element = driver.findElement(By.name("username"));
        element.sendKeys("pekka");
        element = driver.findElement(By.name("password"));
        element.sendKeys("vaara");
        element = driver.findElement(By.name("login"));
        element.submit();

    }

    private static void testi3(WebDriver driver) {
        alusta(driver);
        WebElement element = driver.findElement(By.linkText("login"));
        element.click();
        element = driver.findElement(By.name("username"));
        element.sendKeys("eeole");
        element = driver.findElement(By.name("password"));
        element.sendKeys("vaara");
        element = driver.findElement(By.name("login"));
        element.submit();

    }

    private static void testi4(WebDriver driver, String nimi) {
        alusta(driver);
        WebElement element = driver.findElement(By.linkText("register new user"));
        element.click();
        element = driver.findElement(By.name("username"));
        element.sendKeys(nimi);
        element = driver.findElement(By.name("password"));
        element.sendKeys("sala1nen");
        element = driver.findElement(By.name("passwordConfirmation"));
        element.sendKeys("sala1nen");
        element = driver.findElement(By.name("add"));
        element.submit();

    }
    
        private static void testi5(WebDriver driver) {
            testi4(driver, "testiaaaa");
            WebElement e = driver.findElement(By.linkText("continue to application mainpage"));
            e.click();
            e = driver.findElement(By.linkText("logout"));
            e.click();

    }
}
