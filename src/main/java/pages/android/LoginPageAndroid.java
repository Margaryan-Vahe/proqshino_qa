package pages.android;

import com.codeborne.selenide.SelenideElement;
import io.appium.java_client.AppiumDriver;
import io.appium.java_client.MobileBy;
import io.appium.java_client.MobileElement;
import io.qameta.allure.Step;
import pages.base.LoginPageBase;

import static com.codeborne.selenide.Selenide.$;
import static com.codeborne.selenide.Condition.visible;
import static com.codeborne.selenide.Condition.enabled;

public class LoginPageAndroid extends LoginPageBase {

    @Override
    public SelenideElement pageHeader() {
        return $(MobileBy.AccessibilityId("Вход"));
    }

    @Override
    public SelenideElement phoneNumberField() {
        return $(MobileBy.AndroidUIAutomator(
                "new UiSelector().className(\"android.widget.EditText\").instance(0)"
        ));
    }

    @Override
    public SelenideElement passwordField() {
        return $(MobileBy.AndroidUIAutomator(
                "new UiSelector().className(\"android.widget.EditText\").instance(1)"
        ));
    }

    @Override
    public SelenideElement loginButton(){
        return $(MobileBy.AccessibilityId("Войти"));
    }

    @Override
    public SelenideElement incorrectDataErrorMessage(){
        return $(MobileBy.AccessibilityId("Вы ввели неверный номер телефона или пароль, пожалуйста, попробуйте снова"));
    }

    @Override
    public SelenideElement forgotPassButton() {
        return $(MobileBy.AccessibilityId("Забыл пароль"));
    }

    public LoginPageAndroid(AppiumDriver<MobileElement> appiumDriver) {
        super(appiumDriver);
    }
    @Override
    public LoginPageAndroid waitUntilLoaded() {
        super.waitUntilLoaded();
        return this;
    }

    // Платформо-специфичный сценарий логина + пост-setup PIN/биометрии
    @Step("Логин: телефон={phone}, isErrorCase={isErrorCase}")
    public void login(String phone, String pass, boolean isErrorCase) throws InterruptedException {
        typePhoneNumber(phone);
        typePassword(pass);
        clickToLoginButton();

        if (isErrorCase) {
            incorrectDataErrorMessage().shouldBe(visible);
        } else {
            // На Android после логина — настройка PIN и биометрии
            new SetPinPageAndroid(appiumDriver).clickNum1();
            new RepeatPinPageAndroid(appiumDriver).clickNum1();
            new BioConfirmationPageAndroid(appiumDriver).clickToRefuseButton();
            new InputPinPageAndroid(appiumDriver).clickNum1();

            new MainPageAndroid(appiumDriver).mainPageHeader().shouldBe(visible);
        }
    }
}
