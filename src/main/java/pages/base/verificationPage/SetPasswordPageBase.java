package pages.base.verificationPage;

import com.codeborne.selenide.SelenideElement;
import io.appium.java_client.AppiumDriver;
import io.appium.java_client.MobileElement;
import io.qameta.allure.Step;

import java.time.Duration;

import static com.codeborne.selenide.Condition.visible;
import static com.codeborne.selenide.Condition.enabled;

public abstract class SetPasswordPageBase {
    protected final AppiumDriver<MobileElement> appiumDriver; // было static

    // Локаторы элементов страницы
    public abstract SelenideElement pageHeader();
    public abstract SelenideElement setPassField();
    public abstract SelenideElement repeatPassField();
    public abstract SelenideElement passIsMatchMessage();
    public abstract SelenideElement savePasswordButton();

    // Конструктор класса
    public SetPasswordPageBase(AppiumDriver<MobileElement> appiumDriver) {
        this.appiumDriver = appiumDriver;
    }

    // Методы класса
    @Step("Жду загрузки экрана 'Задайте пароль'")
    public SetPasswordPageBase waitUntilLoaded() {
        pageHeader().shouldBe(visible, Duration.ofSeconds(10));
        return this;
    }

    @Step("Ввожу новый пароль")
    public void setPassword(String pass){
        waitUntilLoaded();
        setPassField().shouldBe(visible, Duration.ofSeconds(10)).shouldBe(enabled);
        setPassField().click();
        setPassField().sendKeys(pass); // по правилу проекта — только sendKeys
    }

    @Step("Повторяю пароль")
    public void repeatPassword(String pass){
        repeatPassField().shouldBe(visible, Duration.ofSeconds(10)).shouldBe(enabled);
        repeatPassField().click();
        repeatPassField().sendKeys(pass); // по правилу проекта — только sendKeys
    }

    @Step("Сохраняю пароль")
    public void clickToSavePassButton(){
        passIsMatchMessage().shouldBe(visible, Duration.ofSeconds(5));
        savePasswordButton().shouldBe(visible, Duration.ofSeconds(10)).click();
    }

    @Step("Заполняю и сохраняю пароль")
    public void inputPassword(String pass){
        setPassword(pass);
        repeatPassword(pass);
        clickToSavePassButton();
    }
}
