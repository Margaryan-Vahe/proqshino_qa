package android;

import baseUtils.SetupCapabilities;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import pages.android.InputPinPageAndroid;
import pages.android.LoginPageAndroid;
import pages.android.MainPageAndroid;
import pages.android.RecoverPageAndroid;

import static baseUtils.SetupCapabilities.appiumDriver;
import static org.junit.jupiter.api.Assertions.assertNotNull;

public class BaseAndroidTest{
    MainPageAndroid mainPageAndroid;
    LoginPageAndroid loginPageAndroid;
    InputPinPageAndroid inputPinPageAndroid;
    RecoverPageAndroid recoverPageAndroid;

    @BeforeEach
    public void initPages() throws Exception {
        new SetupCapabilities().setUp();
        assertNotNull(appiumDriver, "Appium driver не инициализирован");

        mainPageAndroid = new MainPageAndroid(appiumDriver);
        loginPageAndroid = new LoginPageAndroid(appiumDriver);
        inputPinPageAndroid = new InputPinPageAndroid(appiumDriver);
        recoverPageAndroid = new RecoverPageAndroid(appiumDriver);
    }

    @AfterEach
    public void tearDown(){
        if(appiumDriver != null){
            appiumDriver.quit();
        }
    }

}
