package pages.base;

import com.codeborne.selenide.Condition;
import com.codeborne.selenide.SelenideElement;
import io.appium.java_client.AppiumDriver;
import io.appium.java_client.MobileBy;
import io.appium.java_client.MobileElement;
import pages.BaseProfilePage;

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
    public ProfilePageBase waitUntilLoaded() {
        pageHeader().shouldBe(Condition.visible);
        return this;
    }
    public String getPageHeaderText(){
        return pageHeader().getText();
    }
}
