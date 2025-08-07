package pages.android;

import com.codeborne.selenide.SelenideElement;
import io.appium.java_client.AppiumDriver;
import io.appium.java_client.MobileBy;
import io.appium.java_client.MobileElement;
import pages.base.OtpPageBase;

import static com.codeborne.selenide.Selenide.$;

public class OtpPageAndroid extends OtpPageBase {
    // Элементы страницы

    @Override
    public SelenideElement pageHeader() {
        return $(MobileBy.AccessibilityId("Верификация"));
    }

    @Override
    public SelenideElement otpField() {
        return $(MobileBy.className("android.widget.EditText"));
    }

    @Override
    public SelenideElement resendOtpButton() {
        return $(MobileBy.AccessibilityId("Повторно отправить смс-код"));
    }

    @Override
    public SelenideElement noAccessToPhoneButton() {
        return $(MobileBy.AccessibilityId("Нет доступа к номеру телефона"));
    }

    @Override
    public SelenideElement backButton() {
        return $(MobileBy.AccessibilityId("Назад"));
    }

    // Конструктор классаа
    public OtpPageAndroid(AppiumDriver<MobileElement> appiumDriver) {
        super(appiumDriver);
    }

    // Методы класса
}
