package tests.day10_actionsClass_fileTestleri;

import org.junit.Assert;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import utilitie.ReusableMethods;
import utilitie.TestBase;

import java.security.Key;

public class C02TestOtomasyonuRegister extends TestBase {

    @Test
    public void kayıtOlusturmaTesti (){
        // 1- https://www.testotomasyonu.com adresine gidelim
        // 2- Account linkine tiklayin
        // 3- Sign Up linkine basalim
        // 4- Ad, soyad, mail ve sifre kutularina deger yazalim ve Sign Up butonuna basalim
        // 5- Kaydin olusturuldugunu test edin

        driver.get("https://www.testotomasyonu.com");

        driver.findElement(By.xpath("(//a[@class='e-cart'])[1]")).click();

        driver.findElement(By.xpath("//a[text()=' Sign Up']")).click();

        WebElement firstNameKutusu = driver.findElement(By.id("firstName"));

        Actions actions = new Actions(driver);

        ReusableMethods.bekle(2);

        actions.click(firstNameKutusu)
                .sendKeys("wise")
                .sendKeys(Keys.TAB)
                .sendKeys("Quarter")
                .sendKeys(Keys.TAB)
                .sendKeys("mail@mail.com")
                .sendKeys(Keys.TAB)
                .sendKeys("12345")
                .sendKeys(Keys.TAB)
                .sendKeys("12345")
                .perform();

        // sign Up butonu basalim
        ReusableMethods.bekle(2);
        driver.findElement(By.id("btn-submit-form")).click();

        WebElement emailKutusu = driver.findElement(By.xpath("//input[@id='email']"));

        emailKutusu.sendKeys("mail@mail.com");

        WebElement passwordKutusu = driver.findElement(By.xpath("//input[@id='password']"));

        passwordKutusu.sendKeys("12345");

        WebElement signInButonu = driver.findElement(By.xpath("//*[@id='submitlogin']"));

        signInButonu.click();

        WebElement mailiKontrolu = driver.findElement(By.xpath("//p[text()='mail@mail.com']"));

        Assert.assertTrue(mailiKontrolu.isDisplayed());

    }

}
