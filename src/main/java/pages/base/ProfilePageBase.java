package pages.base;

import com.codeborne.selenide.SelenideElement;
import io.appium.java_client.AppiumDriver;
import io.appium.java_client.MobileElement;
import io.qameta.allure.Step;
import pages.BaseProfilePage;

import static com.codeborne.selenide.Condition.visible;
import static com.codeborne.selenide.Selenide.$;

public abstract class ProfilePageBase implements BaseProfilePage {
    public static AppiumDriver<MobileElement> appiumDriver;

    // Конструктор класса
    public ProfilePageBase(AppiumDriver<MobileElement> appiumDriver) {
        this.appiumDriver = appiumDriver;
    }

    // Методы класса
    @Override
    public SelenideElement pageHeader() {
        return null;
    }
    public SelenideElement myPassesButton() {
        return null;
    }
    @Step("Жду загрузки экрана 'Профиль'")
    public ProfilePageBase waitUntilLoaded() {
        pageHeader().shouldBe(visible);
        return this;
    }
    @Step("Перехожу в раздел 'Мои пропуска'")
    public void clickToMyPassesButton() {
        waitUntilLoaded();
        myPassesButton().shouldBe(visible).click();
    }
}
