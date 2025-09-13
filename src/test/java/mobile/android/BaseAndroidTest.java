package mobile.android;

import baseUtils.SetupCapabilities;
import io.qameta.allure.selenide.AllureSelenide;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import pages.android.RegistrationPageAndroid;
import pages.android.*;
import pages.android.mainPage.MainPageAndroid;
import pages.android.mainPage.passPage.*;
import pages.android.mainPage.passPage.passTypesPage.GuestPassTypesPageAndroid;
import pages.android.mainPage.passPage.passTypesPage.PersonalPassTypesPageAndroid;
import pages.android.mainPage.passPage.passTypesPage.QrGuestPassPageAndroid;
import pages.android.mainPage.passPage.passTypesPage.QrPassMainPageAndroid;
import pages.android.verificationPage.*;
import pages.android.verificationPage.pinPage.InputPinPageAndroid;
import pages.android.verificationPage.pinPage.RepeatPinPageAndroid;
import pages.android.verificationPage.pinPage.SetPinPageAndroid;

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
    protected SCUDMainPageAndroid passCreationMainPageAndroid;
    protected PersonalPassTypesPageAndroid personalPassTypesPageAndroid;
    protected QrPassMainPageAndroid qrPassMainPageAndroid;
    protected MyPassesPageAndroid myPassesPageAndroid;
    protected ProfilePageAndroid profilePageAndroid;
    protected GuestPassTypesPageAndroid guestPassTypesPageAndroid;
    protected QrGuestPassPageAndroid qrGuestPassPageAndroid;
    protected RegistrationPageAndroid registrationPageAndroid;
    protected SetPersonalDataPageAndroid setPersonalDataPageAndroid;

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
        passCreationMainPageAndroid = new SCUDMainPageAndroid(appiumDriver);
        personalPassTypesPageAndroid = new PersonalPassTypesPageAndroid(appiumDriver);
        qrPassMainPageAndroid = new QrPassMainPageAndroid(appiumDriver);
        myPassesPageAndroid = new MyPassesPageAndroid(appiumDriver);
        profilePageAndroid = new ProfilePageAndroid(appiumDriver);
        guestPassTypesPageAndroid = new GuestPassTypesPageAndroid(appiumDriver);
        qrGuestPassPageAndroid = new QrGuestPassPageAndroid(appiumDriver);
        recoverPageAndroid = new RecoverPageAndroid(appiumDriver);
        registrationPageAndroid = new RegistrationPageAndroid(appiumDriver);
        setPersonalDataPageAndroid = new SetPersonalDataPageAndroid(appiumDriver);
    }

    @AfterEach
    public void tearDown() {
        if (appiumDriver != null) {
            appiumDriver.quit();
        }
    }
}
