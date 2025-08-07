package pages.base;

import com.codeborne.selenide.SelenideElement;
import io.appium.java_client.AppiumDriver;
import io.appium.java_client.MobileElement;

import java.time.Duration;

import static com.codeborne.selenide.Condition.visible;

public abstract class OtpPageBase {
    public static AppiumDriver<MobileElement> appiumDriver;
    public static final String CORRECT_OTP_VALUE = "1111";

    // Локаторы элементов страницы
    public abstract SelenideElement pageHeader();

    public abstract SelenideElement otpField();

    public abstract SelenideElement resendOtpButton();

    public abstract SelenideElement noAccessToPhoneButton();

    public abstract SelenideElement backButton();

    // Конструктор класса
    public OtpPageBase(AppiumDriver<MobileElement> appiumDriver) {
        this.appiumDriver = appiumDriver;
    }

    // Методы класса
    public void waitUntilLoaded() {
        pageHeader().shouldBe(visible, Duration.ofSeconds(10));
    }

    public void typeCorrectOtp() {
        waitUntilLoaded();

        otpField().click();
        otpField().sendKeys(CORRECT_OTP_VALUE);
    }
    public void clickToResendOtpButton() throws InterruptedException {
        Thread.sleep(1500);
        resendOtpButton().click();
    }
}
