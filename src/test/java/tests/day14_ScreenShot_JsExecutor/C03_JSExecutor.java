package tests.day14_ScreenShot_JsExecutor;

import org.junit.Assert;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebElement;
import utilitie.ReusableMethods;
import utilitie.TestBase;

public class C03_JSExecutor extends TestBase {
    @Test
    public void test01(){
        driver.get("https://www.testotomasyonu.com");

        // alt kisimda bulunan Best Sport Shoes bolumune kadar asağı inin

        JavascriptExecutor jse = (JavascriptExecutor) driver;

        // basligin "Best Sport Shoes For Multi Gender." oldugunu test edin

        WebElement bestSportElementi = driver.findElement(By.xpath("(//*[@class='blog-heading'])[2]"));

        // jse ile istedigimiz best spor elementine kadar asagi inelim
        jse.executeScript("arguments[0].scrollIntoView();",bestSportElementi);
        ReusableMethods.bekle(2);

        String expectedBaslik = "Best Sport Shoes For Multi Gender.";
        String actualBaslik = bestSportElementi.getText();

        ReusableMethods.webElementScreenShot(bestSportElementi,"best");
        Assert.assertEquals(expectedBaslik,actualBaslik);


    }
}
