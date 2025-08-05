package pages.android;

import com.codeborne.selenide.SelenideElement;
import io.appium.java_client.AppiumDriver;
import io.appium.java_client.MobileBy;
import io.appium.java_client.MobileElement;
import pages.BaseProfilePage;
import pages.base.LoginPageBase;

import static com.codeborne.selenide.Selenide.$;

public class LoginPageAndroid extends LoginPageBase {
    MainPageAndroid mainPageAndroid = new MainPageAndroid(appiumDriver);
    SetPinPageAndroid setPinPageAndroid = new SetPinPageAndroid(appiumDriver);;
    RepeatPinPageAndroid repeatPinPageAndroid = new RepeatPinPageAndroid(appiumDriver);
    InputPinPageAndroid inputPinPageAndroid = new InputPinPageAndroid(appiumDriver);
    BioConfirmationPageAndroid bioConfirmationPageAndroid = new BioConfirmationPageAndroid(appiumDriver);

    // Локаторы элементов страницы
    @Override
    public final SelenideElement pageHeader() {
        return $(MobileBy.AccessibilityId("Вход"));
    }

    @Override
    public final SelenideElement phoneNumberField() {
        return $(MobileBy.AndroidUIAutomator(
                "new UiSelector()" +
                        ".className(\"android.widget.EditText\")" +
                        ".instance(0)"
        ));
    }
    @Override
    public final SelenideElement passwordField() {
        return $(MobileBy.AndroidUIAutomator(
                "new UiSelector()" +
                        ".className(\"android.widget.EditText\")" +
                        ".instance(1)"
        ));
    }
    @Override
    public final SelenideElement loginButton(){
        return $(MobileBy.AccessibilityId("Войти"));
    }
    @Override
    public final SelenideElement incorrectDataErrorMessage(){
        return $(MobileBy.AccessibilityId("Вы ввели неверный номер телефона или пароль, пожалуйста, попробуйте снова"));
    }
    // Конструктор класса
    public LoginPageAndroid(AppiumDriver<MobileElement> appiumDriver) {
        super(appiumDriver);
    }

    // Методы класса

}
