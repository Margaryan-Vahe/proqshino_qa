package pages.base;

import com.codeborne.selenide.SelenideElement;
import io.appium.java_client.AppiumDriver;
import io.appium.java_client.MobileElement;
import io.qameta.allure.Step;

import java.time.Duration;

import static com.codeborne.selenide.Condition.visible;

public abstract class SetPersonalDataPageBase {
    protected final AppiumDriver<MobileElement> appiumDriver;

    // Локаторы экрана
    public abstract SelenideElement pageHeader();

    public abstract SelenideElement employeeRadioButton();

    public abstract SelenideElement lastNameField();

    public abstract SelenideElement firstNameField();

    public abstract SelenideElement secondNameField();

    public abstract SelenideElement emailField();

    public abstract SelenideElement innField();

    public abstract SelenideElement continueButton();

    public abstract SelenideElement regSuccessWindowNotApprovedCase();

    public abstract SelenideElement reviewedCheckBox();

    public abstract SelenideElement toMainPageButton();

    public abstract SelenideElement regSuccessWindowUserCase();


    public SetPersonalDataPageBase(AppiumDriver<MobileElement> appiumDriver) {
        this.appiumDriver = appiumDriver;
    }

    @Step("Жду загрузки экрана 'Заполните данные'")
    public SetPersonalDataPageBase waitUntilLoaded() {
        pageHeader().shouldBe(visible, Duration.ofSeconds(10));
        return this;
    }

    @Step("Жду загрузки модального окна 'Вы успешно зарегистрировались'")
    public void waitUntilLoadedSuccessModalWindow() {
        regSuccessWindowNotApprovedCase().shouldBe(visible, Duration.ofSeconds(10));
    }

    @Step("Жду загрузки модального окна 'Вы успешно зарегистрировались'")
    public void waitUntilLoadedSuccessModalWindowForUser() {
        regSuccessWindowUserCase().shouldBe(visible, Duration.ofSeconds(10));
    }

    @Step("Нажимаю на радио-батон 'Я сотрудник компании'")
    public void clickToRadioButton() {
        waitUntilLoaded();
        employeeRadioButton().click();
    }

    @Step("Ввожу данные в поле 'Фамилия'")
    public void typeLastName(String lastName) {
        waitUntilLoaded();
        SelenideElement lastName_ = lastNameField();
        lastName_.shouldBe(visible).click();
        lastName_.sendKeys(lastName);
        appiumDriver.hideKeyboard();
    }

    @Step("Ввожу данные в поле 'Имя'")
    public void typeFirstName(String firstName) {
        waitUntilLoaded();
        SelenideElement firstName_ = firstNameField();
        firstName_.shouldBe(visible).click();
        firstName_.sendKeys(firstName);
        appiumDriver.hideKeyboard();
    }

    @Step("Ввожу данные в поле 'Отчество'")
    public void typeSecondName(String secondName) {
        waitUntilLoaded();
        SelenideElement secondName_ = secondNameField();
        secondName_.shouldBe(visible).click();
        secondName_.sendKeys(secondName);
        appiumDriver.hideKeyboard();
    }

    @Step("Ввожу данные в поле 'Email'")
    public void typeEmail(String email) {
        waitUntilLoaded();
        SelenideElement email_ = emailField();
        email_.shouldBe(visible).click();
        email_.sendKeys(email);
        appiumDriver.hideKeyboard();
    }

    @Step("Ввожу данные в поле 'ИНН'")
    public void typeInn(String inn) {
        SelenideElement inn_ = innField();
        inn_.shouldBe(visible).click();
        inn_.sendKeys(inn);
        appiumDriver.hideKeyboard();
    }

    @Step("Активирую чек-бокс 'Я ознакомился с указанной информацией'")
    public void clickToCheckBox() {
        waitUntilLoadedSuccessModalWindow();
        reviewedCheckBox()
                .shouldBe(visible)
                .click();
    }

    @Step("Нажимаю на кнпоку 'На главный экран'")
    public void clickToMainPageButton() {
        waitUntilLoadedSuccessModalWindow();
        toMainPageButton()
                .shouldBe(visible)
                .click();
    }
    @Step("Нажимаю на кнпоку 'На главный экран'")
    public void clickToMainPageButton_() {
        toMainPageButton()
                .shouldBe(visible)
                .click();
    }

    @Step("Нажимаю на кнпоку 'На главный экран'")
    public void clickToMainPageButtonForUserCase() {
        waitUntilLoadedSuccessModalWindowForUser();
        toMainPageButton()
                .shouldBe(visible)
                .click();
    }

    @Step("Успешно ввожу все данные для сотрудника")
    public void typeAllDataForEmployee(
            String lastName,
            String firstName,
            String secondName,
            String email,
            String inn) throws InterruptedException {
        clickToRadioButton();

        typeLastName(lastName);
        typeFirstName(firstName);
        typeSecondName(secondName);
        typeEmail(email);
        typeInn(inn);

        Thread.sleep(1500);

        continueButton().click();
        clickToCheckBox();
        clickToMainPageButton();
    }

    @Step("Успешно ввожу все данные для сотрудника")
    public void typeAllDataForUser(
            String lastName,
            String firstName,
            String secondName,
            String email) throws InterruptedException {

        typeLastName(lastName);
        typeFirstName(firstName);
        typeEmail(email);
        typeSecondName(secondName);

        Thread.sleep(1500);

        continueButton().click();
        clickToMainPageButtonForUserCase();
    }
}
