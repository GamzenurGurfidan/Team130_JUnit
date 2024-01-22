package tests.day10_actionsClass_fileTestleri;

import com.github.javafaker.Faker;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import utilitie.ReusableMethods;
import utilitie.TestBase;

import java.security.Key;

public class C03_FacebookKayitTesti extends TestBase {
    @Test
    public void kayitTesti(){

        // 1- https://www.facebook.com adresine gidelim
        driver.get("https://www.facebook.com");

        // 2- Cookies kabul edelim
        // driver.findElement(By.xpath("//*[@title='Allow all cookies']"));

        // 3- Yeni hesap olustur butonuna basalim
        driver.findElement(By.xpath("//*[text()='Yeni hesap oluştur']")).click();

        // 4- Ad, soyad, mail ve sifre kutularina deger yazalim ve kaydol tusuna basalim
        WebElement firstNameKutusu =
                driver.findElement(By.xpath("//input[@name='firstname']"));

        Actions actions = new Actions(driver);
        Faker faker = new Faker();

        String fakeMail = faker.internet().emailAddress();

        actions.click(firstNameKutusu)
                .sendKeys(faker.name().firstName())
                .sendKeys(Keys.TAB)
                .sendKeys(faker.name().lastName())
                .sendKeys(Keys.TAB)
                .sendKeys(fakeMail)
                .sendKeys(Keys.TAB)
                .sendKeys(fakeMail)
                .sendKeys(Keys.TAB)
                .sendKeys(faker.internet().password())
                .sendKeys(Keys.TAB)
                .sendKeys(Keys.TAB)
                .sendKeys("15")
                .sendKeys(Keys.TAB)
                .sendKeys("Mar")
                .sendKeys(Keys.TAB)
                .sendKeys("1997")
                .sendKeys(Keys.TAB)
                .sendKeys(Keys.TAB)
                .sendKeys(Keys.ARROW_RIGHT).sendKeys(Keys.ARROW_LEFT)
                .perform();


        // 5- Kaydol tusuna basalim

        ReusableMethods.bekle(3);

        driver.findElement(By.name("websubmit")).click();

        ReusableMethods.bekle(3);

    }
}
