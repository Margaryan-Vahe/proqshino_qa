import baseUtils.SetupCapabilities;
import com.codeborne.selenide.WebDriverRunner;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import pages.android.LoginPageAndroid;
import pages.android.MainPageAndroid;

import static baseUtils.SetupCapabilities.appiumDriver;
import static org.junit.jupiter.api.Assertions.assertLinesMatch;
import static org.junit.jupiter.api.Assertions.assertNotNull;

public class FirstTest {
    MainPageAndroid mainPageAndroid;
    LoginPageAndroid loginPageAndroid;

    @BeforeEach
    public void initPages() throws Exception {
        new SetupCapabilities().setUp();
        assertNotNull(appiumDriver, "Appium driver не инициализирован");

        mainPageAndroid = new MainPageAndroid(appiumDriver);
        loginPageAndroid = new LoginPageAndroid(appiumDriver);
    }

    @Test
    public void justRun() throws Exception {
        new SetupCapabilities().setUp();
        assertNotNull(appiumDriver, "Appium driver не инициализирован");

        mainPageAndroid.openProfile();
        loginPageAndroid.typePhoneNumber("9321217816");
    }
}
