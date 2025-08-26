package pages.base.mainPage.passPage.passTypesPage;

import com.codeborne.selenide.SelenideElement;
import io.appium.java_client.AppiumDriver;
import io.appium.java_client.MobileElement;
import io.qameta.allure.Step;

import java.time.Duration;

import static com.codeborne.selenide.Condition.visible;

public abstract class QrPassMainPageBase {
    protected final AppiumDriver<MobileElement> appiumDriver;



    // Локаторы элементов страницы
    public abstract SelenideElement pageHeader();
    public abstract SelenideElement alreadyHavePassText();
    public abstract SelenideElement generateButton();
    public abstract SelenideElement modalWindowSuccessApproved();
    public abstract SelenideElement modalWindowSuccessNotApproved();
    public abstract SelenideElement checkBoxIllGoToReception();
    public abstract SelenideElement confirmRadioButton();
    public abstract SelenideElement myPassesButton();
    // Конструктор класса
    public QrPassMainPageBase(AppiumDriver<MobileElement> appiumDriver) {
        this.appiumDriver = appiumDriver;
    }

    // Методы класса
    @Step("Жду загрузки экрана 'QR'")
    public QrPassMainPageBase waitUntilLoaded() {
        pageHeader().shouldBe(visible, Duration.ofSeconds(10));
        return this;
    }
    @Step("Жду загрузки экрана 'QR': У вас уже есть новый пропуск")
    public void waitUntilLoadedAlreadyHavePassText() {
        alreadyHavePassText().shouldBe(visible, Duration.ofSeconds(10));
    }
    @Step("Жду загрузки экрана 'Успешно' (без подтверждения на ресепшене)")
    public void waitUntilLoadedModalWindowSuccessApproved() {
        modalWindowSuccessApproved().shouldBe(visible, Duration.ofSeconds(10));
    }
    @Step("Жду загрузки экрана 'Успешно' (без подтверждения на ресепшене)")
    public void waitUntilLoadedModalWindowSuccessNotApproved() {
        modalWindowSuccessNotApproved().shouldBe(visible, Duration.ofSeconds(10));
    }
    @Step("Жду загрузки экрана 'Успешно' (без подтверждения на ресепшене)")
    public void clickToCheckBox() {
        checkBoxIllGoToReception()
                .shouldBe(visible, Duration.ofSeconds(10))
                .click();
    }
    @Step("Нажимаю на кнопку 'Сгенерировать'")
    public void clickToGenerateButton() {
        generateButton()
                .shouldBe(visible, Duration.ofSeconds(10))
                .click();
    }
    @Step("Нажимаю на радио-баттон 'Я подойду на ресепшен с паспортом'")
    public void clickToRadioButton() {
        confirmRadioButton().shouldBe(visible, Duration.ofSeconds(10));
    }
    @Step("Нажимаю на кнопку 'Мои пропуска'")
    public void clickToMyPassesButton() {
        myPassesButton()
                .shouldBe(visible, Duration.ofSeconds(10))
                .click();
    }

    @Step("Подаю заявку на личный QR-пропуск: подтвержден")
    public void requestPersonalQRPassBeingApproved() {
        waitUntilLoaded();
        clickToGenerateButton();
        waitUntilLoadedModalWindowSuccessApproved();
        clickToMyPassesButton();
    }
    @Step("Подаю заявку на личный QR-пропуск: не подтвержден")
    public void requestPersonalQRPassBeingNotApproved() {
        waitUntilLoaded();
        clickToGenerateButton();
        waitUntilLoadedModalWindowSuccessNotApproved();
        clickToCheckBox();
        clickToMyPassesButton();
    }

}
