package pages.base;

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
    public abstract SelenideElement resendOtpButton();
    public abstract SelenideElement noAccessToPhoneButton();
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
    public OtpPageBase typeCorrectOtp() {
        waitUntilLoaded();
        otpField()
                .shouldBe(visible, Duration.ofSeconds(10))
                .click();
        otpField().sendKeys(CORRECT_OTP_VALUE);
        return this;
    }

    @Step("Запрашиваю повторную отправку SMS-кода")
    public void clickToResendOtpButton() throws InterruptedException { // оставлено по твоему правилу
        Thread.sleep(1500);
        resendOtpButton()
                .shouldBe(visible, Duration.ofSeconds(10))
                .click();
    }

    @Step("Возвращаюсь назад со страницы OTP")
    public OtpPageBase clickBack() {
        backButton().shouldBe(visible, Duration.ofSeconds(10)).click();
        return this;
    }
}
