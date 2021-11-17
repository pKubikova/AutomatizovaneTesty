package com.testing.my_system_testing;

import com.testing.my_system_testing.Prehliadac;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.WebDriver;

public class JUnitTest {
    static WebDriver prehliadac;

    final static String url = "";
    final static String emailElementId= "email";
    final static String textPreEmail = "hodnota pre email";
    final static String hesloElementId = "password";
    final static String textPreHeslo = "hodnota pre heslo";

    @BeforeAll
    public static void nastavenie() {
         prehliadac = Prehliadac.ziskajChromePrehliadac() ;
         // prehliadac = Prehliadac.ziskajMozillaPrehliadac();
    }


    @Test
    public void testLoginPage() {
        Prehliadac.prihlasenieDoAplikacie(url,emailElementId,textPreEmail,hesloElementId,textPreHeslo);
    }


    @AfterEach
    public void tearDown() {
        prehliadac.quit();
    }
}
