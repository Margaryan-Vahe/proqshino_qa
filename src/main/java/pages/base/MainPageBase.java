package pages.base;

import com.codeborne.selenide.SelenideElement;
import io.appium.java_client.AppiumDriver;
import io.appium.java_client.MobileElement;
import io.appium.java_client.android.AndroidDriver;

import java.time.Duration;
import java.util.HashMap;
import java.util.Map;

import static com.codeborne.selenide.Condition.visible;

public abstract class MainPageBase {
    public final AppiumDriver<MobileElement> appiumDriver;

    // Локаторы элементов страницы
    public abstract SelenideElement mainPageHeader();

    public abstract SelenideElement profileButton();

    // Конструктор класса
    public MainPageBase(AppiumDriver<MobileElement> appiumDriver) {
        this.appiumDriver = appiumDriver;
    }

    // Методы класса
    public MainPageBase waitUntilLoaded() {
        mainPageHeader().shouldBe(visible, Duration.ofSeconds(10));
        return this;
    }

    public void mainPageHeaderShouldNeVisible() {
        mainPageHeader().shouldBe(visible, Duration.ofSeconds(10));
    }

    public void openProfile() {
        profileButton().shouldBe(visible).click();
    }

    public void closeAndRunApp() {
        AndroidDriver<MobileElement> android = (AndroidDriver<MobileElement>) appiumDriver;
        String appId = "ru.prokshino.prokshino";

        android.terminateApp(appId);
        android.activateApp(appId);
    }

    public void turnInternet() {
        AndroidDriver<MobileElement> android = (AndroidDriver<MobileElement>) appiumDriver;
        android.toggleData();
    }
}
