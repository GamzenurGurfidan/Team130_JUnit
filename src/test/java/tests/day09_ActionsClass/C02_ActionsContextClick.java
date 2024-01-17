package tests.day09_ActionsClass;

import org.junit.Assert;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import utilitie.ReusableMethods;
import utilitie.TestBase;

public class C02_ActionsContextClick extends TestBase {

    @Test
    public void test01(){
        //1- https://testotomasyonu.com/click sitesine gidin
        //2- “DGI Drones” uzerinde sag click yapin
        //3- Alert’te cikan yazinin “Tebrikler!... Sağ click yaptınız.” oldugunu test edin.
        //4- Tamam diyerek alert’i kapatalim

        driver.get("https://testotomasyonu.com/click");

        // 1. adim: actions objesi olusturalim

        Actions actions = new Actions(driver);

        // 2. adim: kullanacagimiz  WebElementi locate edip kaydedelim

        WebElement dgiDronesElementi = driver.findElement(By.id("pic2_thumb"));

        // 3.adim: actions objesi ve kaydettigimiz webElement ile
        //         istenen actionı gerceklestirelim

        ReusableMethods.bekle(2);

        actions.contextClick(dgiDronesElementi).perform();


        ReusableMethods.bekle(2);

        String expectedAlertYazisi = "Tebrikler!... Sağ click yaptınız." ;
        String actualAlertYazisi = driver.switchTo().alert().getText();

        Assert.assertEquals(expectedAlertYazisi,actualAlertYazisi);

        driver.switchTo().alert().accept();

        ReusableMethods.bekle(2);


    }

}
