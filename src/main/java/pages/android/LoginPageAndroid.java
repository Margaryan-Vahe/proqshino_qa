package pages.android;

import com.codeborne.selenide.SelenideElement;
import io.appium.java_client.AppiumDriver;
import io.appium.java_client.MobileBy;
import io.appium.java_client.MobileElement;
import pages.base.LoginPageBase;

import static com.codeborne.selenide.Selenide.$;

public class LoginPageAndroid extends LoginPageBase {
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

    @Override
    public SelenideElement forgotPassButton() {
        return $(MobileBy.AccessibilityId("Забыл пароль"));
    }

    // Конструктор класса
    public LoginPageAndroid(AppiumDriver<MobileElement> appiumDriver) {
        super(appiumDriver);
    }

    // Методы класса

}
