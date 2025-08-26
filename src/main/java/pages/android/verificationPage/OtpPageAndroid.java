package pages.android.verificationPage;

import com.codeborne.selenide.SelenideElement;
import io.appium.java_client.AppiumDriver;
import io.appium.java_client.MobileBy;
import io.appium.java_client.MobileElement;
import io.qameta.allure.Step;
import pages.base.verificationPage.OtpPageBase;

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
    public void typeCorrectOtp() {
        super.typeCorrectOtp();
    }

    @Override
    @Step("Назад со страницы OTP (Android)")
    public void clickBack() {
        super.clickBack();
    }
}
