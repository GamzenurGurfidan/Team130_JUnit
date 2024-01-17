package tests.day09_ActionsClass;

import org.junit.Assert;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import utilitie.ReusableMethods;
import utilitie.TestBase;

public class C03_ActionsContextClick extends TestBase {
    @Test
    public void test01(){

        // 2- https://the-internet.herokuapp.com/context_menu sitesine gidin
        // 3- Cizili alan uzerinde sag click yapin
        // 4- Alert’te cikan yazinin “You selected a context menu” oldugunu test edin.
        // 5- Tamam diyerek alert’i kapatalim
        // 6- Elemental Selenium linkine tiklayalim
        // 7- Acilan sayfada h1 taginda “Make sure your code lands” yazdigini test edelim

        driver.get("https://the-internet.herokuapp.com/context_menu");

        Actions actions = new Actions(driver);

        WebElement cizgiliAlanElementi=driver.findElement(By.id("hot-spot"));

        actions.contextClick(cizgiliAlanElementi).perform();

        ReusableMethods.bekle(1);

        String expectedAlertYazi = "You selected a context menu";
        String actualYazi = driver.switchTo().alert().getText();

        Assert.assertEquals(expectedAlertYazi,actualYazi);

        driver.switchTo().alert().accept();

        ReusableMethods.bekle(1);

        driver.findElement(By.xpath("//*[text()='Elemental Selenium']"));

        // linke tıklandıgında yeni bir tab acılıyor
        // o taba gecmek icin C01deki methodu kullanalım

        ReusableMethods.titleIleWindowDegistir("Elemental Selenium | Elemental Selenium",driver);

        WebElement h1TagElementi = driver.findElement(By.tagName("h1"));

        ReusableMethods.bekle(1);

        String expectedYazi = "Make sure your code lands";
        actualYazi = h1TagElementi.getText();

        Assert.assertEquals(expectedYazi,actualYazi);


    }
}
