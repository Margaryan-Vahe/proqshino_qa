package pages.base;

import com.codeborne.selenide.SelenideElement;
import io.appium.java_client.AppiumDriver;
import io.appium.java_client.MobileBy;
import io.appium.java_client.MobileElement;
import pages.BaseProfilePage;

import java.time.Duration;
import java.util.HashMap;
import java.util.Map;

import static com.codeborne.selenide.Condition.visible;
import static com.codeborne.selenide.Selenide.$;

public abstract class MainPageBase {
    public static AppiumDriver<MobileElement> appiumDriver;
    // Локаторы элементов страницы
    public abstract SelenideElement mainPageHeader();
    public abstract SelenideElement profileButton();

    // Конструктор класса
    public MainPageBase(AppiumDriver<MobileElement> appiumDriver) {
        this.appiumDriver = appiumDriver;
    }

    // Методы класса
    public MainPageBase waitUntilLoaded() {
        mainPageHeader().shouldBe(visible, Duration.ofSeconds(20));
        return this;
    }
    public void mainPageHeaderShouldNeVisible(){
        mainPageHeader().shouldBe(visible);
    }
    public void openProfile() {
        profileButton().shouldBe(visible).click();
    }

    public void closeAndRunApp(){
        // Завершение работы приложения по его bundleId
        Map<String, Object> terminateArgs = new HashMap<>();
        terminateArgs.put("appId", "ru.prokshino.prokshino");
        appiumDriver.executeScript("mobile: terminateApp", terminateArgs);

        // Запуск приложения по его bundleId
        Map<String, Object> activateArgs = new HashMap<>();
        activateArgs.put("appId", "ru.prokshino.prokshino");
        appiumDriver.executeScript("mobile: activateApp", activateArgs);
    }
}
