package mobile.ios;

import baseUtils.SetupCapabilities;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import pages.ios.LoginPageIOS;
import pages.ios.MainPageIOS;

import static baseUtils.SetupCapabilities.appiumDriver;
import static org.junit.jupiter.api.Assertions.assertNotNull;

public class BaseIOSTest {
    MainPageIOS mainPageIOS;
    LoginPageIOS loginPageIOS;

    @BeforeEach
    public void initPages() throws Exception {
        new SetupCapabilities().setUp();
        assertNotNull(appiumDriver, "Appium driver не инициализирован");

        mainPageIOS = new MainPageIOS(appiumDriver);
        loginPageIOS = new LoginPageIOS(appiumDriver);
    }

    @AfterEach
    public void tearDown(){
        if(appiumDriver != null){
            appiumDriver.quit();
        }
    }

}
