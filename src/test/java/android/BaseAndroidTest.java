package android;

import baseUtils.SetupCapabilities;
import io.qameta.allure.selenide.AllureSelenide;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import pages.android.*;
import pages.base.PassCreationMainPageBase;

import static baseUtils.SetupCapabilities.appiumDriver;
import static com.codeborne.selenide.logevents.SelenideLogger.addListener;
import static org.junit.jupiter.api.Assertions.assertNotNull;

public class BaseAndroidTest {

    protected MainPageAndroid mainPageAndroid;
    protected LoginPageAndroid loginPageAndroid;
    protected InputPinPageAndroid inputPinPageAndroid;
    protected RecoverPageAndroid recoverPageAndroid;
    protected OtpPageAndroid otpPageAndroid;
    protected SetPasswordPageAndroid setPasswordPageAndroid;
    protected SetPinPageAndroid setPinPageAndroid;
    protected RepeatPinPageAndroid repeatPinPageAndroid;
    protected BioConfirmationPageAndroid bioConfirmationPageAndroid;
    PassCreationMainPageAndroid passCreationMainPageAndroid;
    PersonalPassTypesPageAndroid personalPassTypesPageAndroid;
    QrPassMainPageAndroid qrPassMainPageAndroid;

    @BeforeEach
    public void initPages() throws Exception {
        new SetupCapabilities().setUp();
        assertNotNull(appiumDriver, "Appium driver не инициализирован");

        // Allure + Selenide вложения (скриншоты/страница при падениях)
        addListener("AllureSelenide", new AllureSelenide()
                .screenshots(true)
                .savePageSource(true));

        mainPageAndroid = new MainPageAndroid(appiumDriver);
        loginPageAndroid = new LoginPageAndroid(appiumDriver);
        inputPinPageAndroid = new InputPinPageAndroid(appiumDriver);
        recoverPageAndroid = new RecoverPageAndroid(appiumDriver);
        otpPageAndroid = new OtpPageAndroid(appiumDriver);
        setPasswordPageAndroid = new SetPasswordPageAndroid(appiumDriver);
        setPinPageAndroid = new SetPinPageAndroid(appiumDriver);
        repeatPinPageAndroid = new RepeatPinPageAndroid(appiumDriver);
        bioConfirmationPageAndroid = new BioConfirmationPageAndroid(appiumDriver);
        passCreationMainPageAndroid = new PassCreationMainPageAndroid(appiumDriver);
        personalPassTypesPageAndroid = new PersonalPassTypesPageAndroid(appiumDriver);
        qrPassMainPageAndroid = new QrPassMainPageAndroid(appiumDriver);
    }

    @AfterEach
    public void tearDown() {
        if (appiumDriver != null) {
            appiumDriver.quit();
        }
    }
}
