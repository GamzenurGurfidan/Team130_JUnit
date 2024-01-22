package tests.day11_SeleniumWaits;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.junit.Assert;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import utilitie.ReusableMethods;

import java.time.Duration;

public class C02_ExplicitWait {
    WebDriver driver;
    @Test
    public void explicitWaitTesti(){

        WebDriverManager.chromedriver().setup();
        driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(1));

        //1. https://the-internet.herokuapp.com/dynamic_controls adresine gidin.
        driver.get("https://the-internet.herokuapp.com/dynamic_controls");

        //2. Textbox’in etkin olmadigini(enabled) dogrulayın
        WebElement textBoxElementi = driver.findElement(By.xpath("//input[@type='text']"));

        Assert.assertFalse(textBoxElementi.isEnabled());

        //3. Enable butonuna tıklayın ve textbox etkin oluncaya kadar bekleyin
        driver.findElement(By.xpath("//*[text()='Enable']")).click();

        WebDriverWait wait = new WebDriverWait(driver,Duration.ofSeconds(30));
        wait.until(ExpectedConditions.elementToBeClickable(textBoxElementi));

        //4. “It’s enabled!” mesajinin goruntulendigini dogrulayın.
        WebElement itsEnabledYaziELementi = driver.findElement(By.id("message"));

        Assert.assertTrue(itsEnabledYaziELementi.isDisplayed());

        //5. Textbox’in etkin oldugunu(enabled) dogrulayın.
        Assert.assertTrue(textBoxElementi.isEnabled());


        ReusableMethods.bekle(2);
        driver.quit();
    }
}
