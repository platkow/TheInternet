package tests.forgotpassword;

import org.junit.jupiter.api.Test;
import tests.testBase.TestBase;

public class ForgotPasswordTest extends TestBase {
    @Test
    public void shouldRetrievePassword(){
        mainPage.navigateForgotPasswordPage();
        forgotPasswordPage.fillEmail("test@wp.pl");
        forgotPasswordPage.clickRetrievePassword();
        //cd...
    }
}
