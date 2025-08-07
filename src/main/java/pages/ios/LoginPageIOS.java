package pages.ios;

import baseUtils.Data;
import com.codeborne.selenide.SelenideElement;
import io.appium.java_client.*;
import pages.base.LoginPageBase;

import java.time.Duration;

import static com.codeborne.selenide.Condition.*;
import static com.codeborne.selenide.Selenide.$;

public class LoginPageIOS extends LoginPageBase {
    MainPageIOS mainPageIOS = new MainPageIOS(appiumDriver);
    SetPinPageIOS setPinPageIOS = new SetPinPageIOS(appiumDriver);
    RepeatPinPageIOS repeatPinPageIOS = new RepeatPinPageIOS(appiumDriver);
    InputPinPageIOS inputPinPageIOS = new InputPinPageIOS(appiumDriver);
    BioConfirmationPageIOS bioConfirmationPageIOS = new BioConfirmationPageIOS(appiumDriver);

    // Локаторы элементов страницы
    @Override
    public final SelenideElement pageHeader() {
        return $(MobileBy.AccessibilityId("Вход"));
    }

    @Override
    public final SelenideElement phoneNumberField() {
        return $(MobileBy
                .xpath("//XCUIElementTypeStaticText[@name=\"Введите номер телефона\"]/following-sibling::XCUIElementTypeTextField"
                ));
    }

    @Override
    public final SelenideElement passwordField() {
        return $(MobileBy
                .xpath(
                        "//XCUIElementTypeStaticText[@name=\"Введите пароль\"]/following-sibling::XCUIElementTypeTextField"
                ));
    }

    public final SelenideElement passwordFieldInFocusCondition() {
        return $(MobileBy
                .iOSClassChain(
                        "**/XCUIElementTypeWindow[1]/XCUIElementTypeOther/XCUIElementTypeOther/XCUIElementTypeOther/XCUIElementTypeOther/XCUIElementTypeOther[2]/XCUIElementTypeOther[2]/XCUIElementTypeOther[2]/XCUIElementTypeOther/XCUIElementTypeSecureTextField"
                ));
    }

    @Override
    public final SelenideElement loginButton() {
        return $(MobileBy.AccessibilityId("Войти"));
    }

    @Override
    public final SelenideElement incorrectDataErrorMessage() {
        return $(MobileBy
                .AccessibilityId("Вы ввели неверный номер телефона или пароль, пожалуйста, попробуйте снова"));
    }

    @Override
    public SelenideElement forgotPassButton() {
        return $(MobileBy.AccessibilityId("Забыл пароль"));
    }

    // Конструктор класса
    public LoginPageIOS(AppiumDriver<MobileElement> appiumDriver) {
        super(appiumDriver);
    }

    // Методы класса
    @Override
    public void typePhoneNumber(String phoneNumber) throws InterruptedException {
        boolean isFieldEmpty;
        boolean isFieldCorrect;
        String phoneFiledText;
        do {
            phoneNumberField()
                    .shouldBe(visible, Duration.ofSeconds(10));
            phoneFiledText = phoneNumberField().getText();
            if (!phoneFiledText.isEmpty()) {
                phoneNumberField().clear();
            }
            phoneNumberField().click();
            phoneNumberField().sendKeys(phoneNumber);

            phoneFiledText = phoneNumberField().getText();
            isFieldEmpty = phoneFiledText.isEmpty();
            isFieldCorrect = phoneFiledText.equals(Data.UserTypes.DEFAULT_USER.phoneFullValue());

        } while (isFieldEmpty || isFieldCorrect);
    }

    @Override
    public void typePassword(String pass) {
        SelenideElement passField = passwordField();
        passField.click();

        SelenideElement passFieldInFocusCondition = passwordFieldInFocusCondition();
        passFieldInFocusCondition
                .shouldBe(visible, enabled);
        passFieldInFocusCondition
                .sendKeys(pass);
    }
    @Override
    public void login(String phone, String pass, boolean isErrorCase) throws InterruptedException {
        typePhoneNumber(phone);
        typePassword(pass);
        clickToLoginButton();

        if (isErrorCase) {
            incorrectDataErrorMessage().shouldBe(visible);
        } else {
            setPinPageIOS.clickNum1();
            repeatPinPageIOS.clickNum1();
            bioConfirmationPageIOS.clickToRefuseButton();
            inputPinPageIOS.clickNum1();

            mainPageIOS.mainPageHeaderShouldNeVisible();
        }
    }

}