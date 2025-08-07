package pages.base;

import com.codeborne.selenide.SelenideElement;
import io.appium.java_client.AppiumDriver;
import io.appium.java_client.MobileElement;

import java.time.Duration;

import static com.codeborne.selenide.Condition.visible;

public abstract class SetPasswordPageBase {
    public static AppiumDriver<MobileElement> appiumDriver;

    // Локаторы элементов страницы
    public abstract SelenideElement pageHeader();

    public abstract SelenideElement setPassField();

    public abstract SelenideElement repeatPassField();

    public abstract SelenideElement eayButton();
    public abstract SelenideElement passIsMatchMessage();

    public abstract SelenideElement savePasswordButton();

    // Конструктор класса
    public SetPasswordPageBase(AppiumDriver<MobileElement> appiumDriver) {
        this.appiumDriver = appiumDriver;
    }

    // Методы класса
    public void waitUntilLoaded() {
        pageHeader().shouldBe(visible, Duration.ofSeconds(10));
    }

    public void setPassword(String pass){
        waitUntilLoaded();

        setPassField().click();
        setPassField().sendKeys(pass);
    }
    public void repeatPassword(String pass){
        repeatPassField().click();
        repeatPassField().sendKeys(pass);
    }
    public void clickToSavePassButton(){
        passIsMatchMessage().shouldBe(visible, Duration.ofSeconds(5));
        savePasswordButton().click();
    }
    public void inputPassword(String pass){
        setPassword(pass);
        repeatPassword(pass);
        clickToSavePassButton();
    }


}
