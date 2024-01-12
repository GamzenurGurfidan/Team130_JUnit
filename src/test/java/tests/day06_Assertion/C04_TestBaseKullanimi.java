package tests.day06_Assertion;

import org.junit.Assert;
import org.junit.Test;
import utilities.TestBase;

public class C04_TestBaseKullanimi extends TestBase {

    @Test
    public void test01(){

        // tsetotomasyonu sayfasina gidin
        driver.get("https://www.testotomasyonu.com");

        // sayfaya gittiginizi test edin

        String expectedURL = "https://www.testotomasyonu.com";
        String actualURL = driver.getCurrentUrl();

        Assert.assertEquals(expectedURL,actualURL);

    }

}
