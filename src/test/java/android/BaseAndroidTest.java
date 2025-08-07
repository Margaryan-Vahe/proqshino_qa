package android;

import baseUtils.SetupCapabilities;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import pages.android.*;

import static baseUtils.SetupCapabilities.appiumDriver;
import static org.junit.jupiter.api.Assertions.assertNotNull;

public class BaseAndroidTest{
    MainPageAndroid mainPageAndroid;
    LoginPageAndroid loginPageAndroid;
    InputPinPageAndroid inputPinPageAndroid;
    RecoverPageAndroid recoverPageAndroid;
    OtpPageAndroid otpPageAndroid;
    SetPasswordPageAndroid setPasswordPageAndroid;
    SetPinPageAndroid setPinPageAndroid;
    RepeatPinPageAndroid repeatPinPageAndroid;
    BioConfirmationPageAndroid bioConfirmationPageAndroid;

    @BeforeEach
    public void initPages() throws Exception {
        new SetupCapabilities().setUp();
        assertNotNull(appiumDriver, "Appium driver не инициализирован");

        mainPageAndroid = new MainPageAndroid(appiumDriver);
        loginPageAndroid = new LoginPageAndroid(appiumDriver);
        inputPinPageAndroid = new InputPinPageAndroid(appiumDriver);
        recoverPageAndroid = new RecoverPageAndroid(appiumDriver);
        otpPageAndroid = new OtpPageAndroid(appiumDriver);
        setPasswordPageAndroid = new SetPasswordPageAndroid(appiumDriver);
        setPinPageAndroid = new SetPinPageAndroid(appiumDriver);
        repeatPinPageAndroid = new RepeatPinPageAndroid(appiumDriver);
        bioConfirmationPageAndroid = new BioConfirmationPageAndroid(appiumDriver);
    }

    @AfterEach
    public void tearDown(){
        if(appiumDriver != null){
            appiumDriver.quit();
        }
    }

}
