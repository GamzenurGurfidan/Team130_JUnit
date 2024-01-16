package tests.day08_iFrame_switchingWindows;

import org.junit.Assert;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import utilitie.ReusableMethods;
import utilitie.TestBase;

public class C01_iFrame extends TestBase {

    @Test
    public void iFrameTesti(){
        // 1 ) https://the-internet.herokuapp.com/iframe adresine gidin.
        // 2 ) Bir metod olusturun: iframeTest
        // - “An IFrame containing….” textinin erisilebilir oldugunu test edin ve  konsolda yazdirin.
        // - Text Box’a “Merhaba Dunya!” yazin.
        // - TextBox’in altinda bulunan “Elemental Selenium” linkinin gorunur oldugunu dogrulayin ve  konsolda yazdirin.

        driver.get("https://the-internet.herokuapp.com/iframe");

        WebElement anIframeYaziElementi =
                driver.findElement(By.xpath("//*[text() ='An iFrame containing the TinyMCE WYSIWYG Editor']"));

        Assert.assertTrue(anIframeYaziElementi.isEnabled());

        WebElement iFrameElementi = driver.findElement(By.xpath("//iframe[@id='mce_0_ifr']"));

        driver.switchTo().frame(iFrameElementi);

        WebElement textBoxElementi = driver.findElement(By.xpath("//*[@id='tinymce']"));

        textBoxElementi.clear();

        textBoxElementi.sendKeys("Merhaba Dunya!");

        driver.switchTo().defaultContent();

        WebElement elementalSeleniumElementi =
                driver.findElement(By.xpath("//*[text()='Elemental Selenium']"));

        Assert.assertTrue(elementalSeleniumElementi.isDisplayed());

        System.out.println(elementalSeleniumElementi.getText());

        ReusableMethods.bekle(2);

    }
}
