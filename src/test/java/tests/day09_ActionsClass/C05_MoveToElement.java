package tests.day09_ActionsClass;

import org.junit.Assert;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import utilitie.ReusableMethods;
import utilitie.TestBase;

import java.lang.reflect.AccessibleObject;

public class C05_MoveToElement extends TestBase {
    @Test
    public void test01(){
        // 1- https://www.testotomasyonu.com/ adresine gidin
        // 2- “Kids Wear” menusunun acilmasi icin mouse’u bu menunun ustune getirin
        // 3- “Boys” linkine basin
        // 4- Acilan sayfadaki ilk urunu tiklayin
        // 5- Acilan sayfada urun isminin “Boys Shirt White Color” oldugunu test edin

        driver.get("https://www.testotomasyonu.com/");

        Actions actions = new Actions(driver);

        WebElement kidsWearElementi =
                driver.findElement(By.xpath("(//a[text()='Kids Wear'])[3]"));

        actions.moveToElement(kidsWearElementi).perform();

        ReusableMethods.bekle(1);

        driver.findElement(By.xpath("//a[text()='Boys']")).click();

        ReusableMethods.bekle(1);

        driver.findElement(By.xpath("(//*[@*='product-box mb-2 pb-1'])[1]")).click();

        WebElement urunIsmiElementi =
                driver.findElement(By.xpath("//div[@class=' heading-sm mb-4']"));

        String expectedIsmi = "Boys Shirt White Color";
        String actualIsmi = urunIsmiElementi.getText();

        Assert.assertEquals(expectedIsmi,actualIsmi);

        ReusableMethods.bekle(1);

    }
}
