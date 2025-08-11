package pages.android;

import com.codeborne.selenide.SelenideElement;
import io.appium.java_client.AppiumDriver;
import io.appium.java_client.MobileBy;
import io.appium.java_client.MobileElement;
import io.qameta.allure.Step;
import pages.base.OtpPageBase;

import static com.codeborne.selenide.Selenide.$;

public class OtpPageAndroid extends OtpPageBase {

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

    public OtpPageAndroid(AppiumDriver<MobileElement> appiumDriver) {
        super(appiumDriver);
    }

    // Ковариантные return-типы для удобного чейнинга и явные шаги под Android

    @Override
    @Step("Жду загрузки экрана ввода кода (Android)")
    public OtpPageAndroid waitUntilLoaded() {
        super.waitUntilLoaded();
        return this;
    }

    @Override
    @Step("Ввожу корректный SMS-код (Android)")
    public OtpPageAndroid typeCorrectOtp() {
        super.typeCorrectOtp();
        return this;
    }

    @Override
    @Step("Назад со страницы OTP (Android)")
    public OtpPageAndroid clickBack() {
        super.clickBack();
        return this;
    }
}
