package pages.base.mainPage;

import com.codeborne.selenide.SelenideElement;
import io.appium.java_client.AppiumDriver;
import io.appium.java_client.MobileElement;
import io.appium.java_client.android.AndroidDriver;
import io.qameta.allure.Step;

import java.time.Duration;

import static com.codeborne.selenide.Condition.visible;

public abstract class MainPageBase {
    protected final AppiumDriver<MobileElement> appiumDriver;

    // Локаторы
    public abstract SelenideElement mainPageHeader();
    public abstract SelenideElement profileButton();
    public abstract SelenideElement passButton();
    public abstract SelenideElement QRButton();
    public abstract SelenideElement QRCode();

    public MainPageBase(AppiumDriver<MobileElement> appiumDriver) {
        this.appiumDriver = appiumDriver;
    }

    @Step("Жду загрузки главной страницы")
    public MainPageBase waitUntilLoaded() {
        mainPageHeader().shouldBe(visible, Duration.ofSeconds(10));
        return this;
    }

    @Step("Проверяю, что заголовок главной страницы виден")
    public void mainPageHeaderShouldBeVisible() {
        mainPageHeader().shouldBe(visible, Duration.ofSeconds(10));
    }

    @Step("Открываю профиль с главной страницы")
    public void openProfile() {
        profileButton().shouldBe(visible, Duration.ofSeconds(10)).click();
    }

    @Step("Открываю раздел Пропуск с главной страницы")
    public void openPassPage() {
        passButton().shouldBe(visible, Duration.ofSeconds(10)).click();
    }

    // Перезагрузка приложения: без хардкода appId
    @Step("Перезапускаю приложение: {appId}")
    public void closeAndRunApp(String appId) {
        AndroidDriver<MobileElement> android = (AndroidDriver<MobileElement>) appiumDriver;
        android.terminateApp(appId);
        android.activateApp(appId);
    }

    // Оставил перегрузку — чтобы не ломать существующие тесты
    @Step("Перезапускаю приложение (app.id из -D или дефолт)")
    public void closeAndRunApp() {
        String appId = System.getProperty("app.id", "ru.prokshino.prokshino");
        closeAndRunApp(appId);
    }

    @Step("Переключаю мобильные данные (Android)")
    public void toggleMobileData() {
        AndroidDriver<MobileElement> android = (AndroidDriver<MobileElement>) appiumDriver;
        android.toggleData();
    }
    @Step("Открываю QR-пропуск")
    public void openQR() {
        waitUntilLoaded();
        QRButton()
                .shouldBe(visible, Duration.ofSeconds(10))
                .click();

        QRCode().shouldBe(visible, Duration.ofSeconds(10));
    }
}
