package pages.base.verificationPage;

import com.codeborne.selenide.SelenideElement;
import io.appium.java_client.AppiumDriver;
import io.appium.java_client.MobileElement;
import io.qameta.allure.Step;

import java.time.Duration;

import static com.codeborne.selenide.Condition.visible;

public abstract class OtpPageBase {
    protected final AppiumDriver<MobileElement> appiumDriver; // было static
    public static final String CORRECT_OTP_VALUE = "1111";

    // Локаторы экрана
    public abstract SelenideElement pageHeader();

    public abstract SelenideElement otpField();

    public abstract SelenideElement backButton();

    public OtpPageBase(AppiumDriver<MobileElement> appiumDriver) {
        this.appiumDriver = appiumDriver;
    }

    @Step("Жду загрузки экрана ввода кода (OTP)")
    public OtpPageBase waitUntilLoaded() {
        pageHeader().shouldBe(visible, Duration.ofSeconds(10));
        return this;
    }

    @Step("Ввожу корректный SMS-код")
    public void typeCorrectOtp() {
        waitUntilLoaded();
        otpField()
                .shouldBe(visible, Duration.ofSeconds(10))
                .click();
        otpField().sendKeys(CORRECT_OTP_VALUE);
    }

    @Step("Возвращаюсь назад со страницы OTP")
    public void clickBackButton() {
        backButton().shouldBe(visible, Duration.ofSeconds(10)).click();
    }
}
