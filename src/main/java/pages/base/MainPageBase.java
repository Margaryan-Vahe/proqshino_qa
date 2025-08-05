package pages.base;

import com.codeborne.selenide.SelenideElement;
import io.appium.java_client.AppiumDriver;
import io.appium.java_client.MobileElement;
import io.appium.java_client.android.AndroidDriver;

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
        mainPageHeader().shouldBe(visible, Duration.ofSeconds(10));
        return this;
    }
    public void mainPageHeaderShouldNeVisible(){
        mainPageHeader().shouldBe(visible,Duration.ofSeconds(10));
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

    public void turnInternet(){
        AndroidDriver<MobileElement> android = (AndroidDriver<MobileElement>) appiumDriver;
        android.toggleData();
    }
    public void enableInternet(){
        Map<String, Object> dataOn = new HashMap<>();
        dataOn.put("command", "svc data enable");
        appiumDriver.executeScript("mobile: shell", dataOn);
    }
}
