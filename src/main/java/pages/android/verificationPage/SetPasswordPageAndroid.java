package pages.android.verificationPage;

import com.codeborne.selenide.SelenideElement;
import io.appium.java_client.AppiumDriver;
import io.appium.java_client.MobileBy;
import io.appium.java_client.MobileElement;
import io.qameta.allure.Step;
import pages.base.verificationPage.SetPasswordPageBase;

import static com.codeborne.selenide.Selenide.$;

public class SetPasswordPageAndroid extends SetPasswordPageBase {
    // Элементы страницы

    @Override
    public SelenideElement pageHeader() {
        return $(MobileBy.AndroidUIAutomator(
                "new UiSelector().description(\"Задайте пароль\").instance(0)"
        ));
    }

    @Override
    public SelenideElement setPassField() {
        return $(MobileBy.xpath("((//android.view.View[@content-desc=\"Задайте пароль\"])[2]//following-sibling::android.widget.EditText)[1]"));
    }

    @Override
    public SelenideElement repeatPassField() {
        return $(MobileBy.xpath("((//android.view.View[@content-desc=\"Задайте пароль\"])[2]//following-sibling::android.widget.EditText)[2]"));
    }

    @Override
    public SelenideElement passIsMatchMessage() {
        return $(MobileBy.AccessibilityId("Пароли совпадают"));
    }

    @Override
    public SelenideElement savePasswordButton() {
        return $(MobileBy.AccessibilityId("Сохранить пароль"));
    }

    // Конструктор класса
    public SetPasswordPageAndroid(AppiumDriver<MobileElement> appiumDriver) {
        super(appiumDriver);
    }

    // Ковариант для удобного чейнинга + явные шаги под Android
    @Override
    @Step("Жду загрузки экрана 'Задайте пароль' (Android)")
    public SetPasswordPageAndroid waitUntilLoaded() {
        super.waitUntilLoaded();
        return this;
    }
}
