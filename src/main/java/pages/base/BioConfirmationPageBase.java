// pages.base.BioConfirmationPageBase — ИЗМЕНЁННЫЙ КОД
package pages.base;

import com.codeborne.selenide.SelenideElement;
import io.appium.java_client.AppiumDriver;
import io.appium.java_client.MobileElement;
import io.qameta.allure.Step;

import java.time.Duration;

import static com.codeborne.selenide.Condition.visible;

public abstract class BioConfirmationPageBase {
    protected final AppiumDriver<MobileElement> appiumDriver;

    // Локаторы элементов страницы
    public abstract SelenideElement bioModalWindow();
    public abstract SelenideElement confirmBiometricButton();
    public abstract SelenideElement refuseBiometricButton();

    // Конструктор
    public BioConfirmationPageBase(AppiumDriver<MobileElement> appiumDriver) {
        this.appiumDriver = appiumDriver;
    }

    // Методы
    @Step("Жду появления модального окна подтверждения биометрии")
    public BioConfirmationPageBase waitUntilLoaded() {
        bioModalWindow().shouldBe(visible, Duration.ofSeconds(10));
        return this;
    }

    @Step("Подтверждаю вход по биометрии")
    public void clickToConfirmButton() {
        confirmBiometricButton()
                .shouldBe(visible, Duration.ofSeconds(10))
                .click();
    }

    @Step("Отказываюсь от входа по биометрии")
    public void clickToRefuseButton() {
        refuseBiometricButton()
                .shouldBe(visible, Duration.ofSeconds(10))
                .click();
    }
}
