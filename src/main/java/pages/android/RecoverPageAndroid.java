package pages.android;

import com.codeborne.selenide.SelenideElement;
import io.appium.java_client.AppiumDriver;
import io.appium.java_client.MobileBy;
import io.appium.java_client.MobileElement;
import pages.base.RecoveryPageBase;

import static com.codeborne.selenide.Selenide.$;

public class RecoverPageAndroid extends RecoveryPageBase {

    // Элементы страницы
    @Override
    public SelenideElement pageHeader() {
        return $(MobileBy.AccessibilityId("Забыли пароль?")) ;
    }

    @Override
    public SelenideElement phoneNumberField() {
        return $(MobileBy.className("android.widget.EditText")) ;
    }

    @Override
    public SelenideElement continueButton() {
        return $(MobileBy.AccessibilityId("Продолжить"));
    }

    @Override
    public SelenideElement noAccessToPhoneButton() {
        return $(MobileBy.AccessibilityId("Нет доступа к номеру телефона")) ;
    }

    @Override
    public SelenideElement alreadyHaveAccountButton() {
        return $(MobileBy.AccessibilityId("Уже есть аккаунт? Войдите")) ;
    }

    // Конструктор классаа
    public RecoverPageAndroid(AppiumDriver<MobileElement> appiumDriver) {
        super(appiumDriver);
    }

    // Методы класса
}
