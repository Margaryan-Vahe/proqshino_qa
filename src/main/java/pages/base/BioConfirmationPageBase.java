package pages.base;

import com.codeborne.selenide.SelenideElement;
import io.appium.java_client.AppiumDriver;
import io.appium.java_client.MobileBy;
import io.appium.java_client.MobileElement;

import static com.codeborne.selenide.Condition.visible;
import static com.codeborne.selenide.Selenide.$;

public abstract class BioConfirmationPageBase {
    AppiumDriver<MobileElement> appiumDriver;
    // Локаторы элементов страницы
    public abstract SelenideElement bioModalWindow();
    public abstract SelenideElement confirmBiometricButton();
    public abstract SelenideElement refuseBiometricButton();

    // Конструктор класса
    public BioConfirmationPageBase(AppiumDriver<MobileElement> appiumDriver) {
        this.appiumDriver = appiumDriver;
    }

    // Методы класса
    public BioConfirmationPageBase waitUntilLoaded() {
        bioModalWindow().shouldBe(visible);
        return this;
    }
    public void clickToConfirmButton() {
        confirmBiometricButton().click();
    }
    public void clickToRefuseButton() {
        refuseBiometricButton().click();
    }
}
