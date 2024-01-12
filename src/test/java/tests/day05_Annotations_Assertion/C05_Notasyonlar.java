package tests.day05_Annotations_Assertion;

import org.junit.*;

public class C05_Notasyonlar {
    @BeforeClass
    public static void setupClass(){
        System.out.println("BeforeClass calıstı");
    }

    @AfterClass
    public static void afterClass(){
        System.out.println("AfterClass calıstı");
    }

    @Before
    public void setup(){
        System.out.println("Before methodu calisti");
    }

    @After
    public void teardown(){
        System.out.println("After methodu calıstı");
    }

    @Test
    public void test01(){
        System.out.println("test01 calısti");
    }
    @Test
    public void test02(){
        System.out.println("test02 calısti");
    }
    @Test
    public void test03(){
        System.out.println("test03 calısti");
    }

}
