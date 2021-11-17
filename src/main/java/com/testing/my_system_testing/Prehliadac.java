package com.testing.my_system_testing;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.util.concurrent.TimeUnit;

public class Prehliadac {
    private static WebDriver prehliadac;
    private static WebDriverWait wait = new WebDriverWait(prehliadac, 15);

    public static WebDriver ziskajMozillaPrehliadac(){
        System.setProperty("webdriver.gecko.driver", "C:\\Java-Training\\Selenium\\geckodriver.exe");
        prehliadac = new FirefoxDriver();
        prehliadac.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
        return prehliadac;
    }

    public static WebDriver ziskajChromePrehliadac(){
        System.setProperty("webdriver.chrome.driver", "C:\\Java-Training\\Selenium\\chromedriver.exe");
        WebDriver prehliadac = new ChromeDriver();
        prehliadac.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
        return prehliadac;
    }

    public static void prihlasenieDoAplikacie (String url, String emailElementId, String email, String hesloElementId ,String heslo){
        prehliadac.navigate().to(url);
        WebElement elementEmail = prehliadac.findElement(By.id(emailElementId));
        elementEmail.sendKeys(email);

        WebElement elementHeslo = prehliadac.findElement(By.id(hesloElementId));
        elementHeslo.sendKeys(heslo);
        elementHeslo.sendKeys(Keys.ENTER);
    }

    public static void klikniNaElement (String xPath){
        wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath(xPath)));
        WebElement vseobecnyElement = prehliadac.findElement(By.xpath(xPath));
        vseobecnyElement.click();
    }

    public static void vpisHodnotuDoElementu (String xPath, String hodnota){
        wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath(xPath)));
        WebElement vseobecnyElement = prehliadac.findElement(By.xpath(xPath));
        vseobecnyElement.sendKeys(hodnota);
    }
}
