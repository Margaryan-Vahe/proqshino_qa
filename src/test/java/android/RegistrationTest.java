package android;

import baseUtils.Data;
import baseUtils.DataBaseRequests;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

public class RegistrationTest extends BaseAndroidTest {
    String phone;

    @Override
    @BeforeEach
    public void initPages() throws Exception {
        super.initPages();
        mainPageAndroid.openProfile();
        loginPageAndroid.clickToCreateNewAccountButton();

    }

    @Override
    @AfterEach
    public void tearDown() {
        if (!DataBaseRequests.getUserId(phone, false).isEmpty()) {
            DataBaseRequests.deleteUserWithData(phone, false);
        }
        super.tearDown();
    }

    @Test
    @DisplayName("Регистрация сотрудника: прямая регистрация")
    public void simpleEmployeeRegistration() throws InterruptedException {
        phone = Data.UserTypes.FOR_SIMPLE_REGISTRATION_EMPLOYEE.phoneValidValue();
        registrationPageAndroid.successTypePhoneNumber(phone);
        otpPageAndroid.typeCorrectOtp();
        setPasswordPageAndroid.inputPassword(
                Data.UserTypes.FOR_SIMPLE_REGISTRATION_EMPLOYEE.passwordValidValue());
        setPersonalDataPageAndroid.typeAllDataForEmployee(
                Data.UserTypes.FOR_SIMPLE_REGISTRATION_EMPLOYEE.userLastName(),
                Data.UserTypes.FOR_SIMPLE_REGISTRATION_EMPLOYEE.userFirstName(),
                Data.UserTypes.FOR_SIMPLE_REGISTRATION_EMPLOYEE.userSecondName(),
                Data.UserTypes.FOR_SIMPLE_REGISTRATION_EMPLOYEE.userEmail(),
                Data.SZ_A101_INN
        );

        setPinPageAndroid.clickNum1();
        repeatPinPageAndroid.clickNum1();
        bioConfirmationPageAndroid.clickToRefuseButton();
        inputPinPageAndroid.clickNum1();

        mainPageAndroid.waitUntilLoaded();
    }

    @Test
    @DisplayName("Регистрация простого пользователя")
    public void simpleUserRegistration() throws InterruptedException {
        phone = Data.UserTypes.FOR_SIMPLE_REGISTRATION_USER.phoneValidValue();
        registrationPageAndroid.successTypePhoneNumber(phone);
        otpPageAndroid.typeCorrectOtp();
        setPasswordPageAndroid.inputPassword(
                Data.UserTypes.FOR_SIMPLE_REGISTRATION_USER.passwordValidValue());
        setPersonalDataPageAndroid.typeAllDataForUser(
                Data.UserTypes.FOR_SIMPLE_REGISTRATION_USER.userLastName(),
                Data.UserTypes.FOR_SIMPLE_REGISTRATION_USER.userFirstName(),
                Data.UserTypes.FOR_SIMPLE_REGISTRATION_USER.userSecondName(),
                Data.UserTypes.FOR_SIMPLE_REGISTRATION_USER.userEmail()
        );

        setPinPageAndroid.clickNum1();
        repeatPinPageAndroid.clickNum1();
        bioConfirmationPageAndroid.clickToRefuseButton();
        inputPinPageAndroid.clickNum1();

        mainPageAndroid.waitUntilLoaded();
    }

    @Test
    @DisplayName("Прерывание регистрации: на шаге ввода ОТП-кода")
    public void interruptRegistrationOnOTPPage() {
        phone = Data.UserTypes.FOR_SIMPLE_REGISTRATION_USER.phoneValidValue();
        registrationPageAndroid.successTypePhoneNumber(phone);
        otpPageAndroid.clickBackButton();
        registrationPageAndroid.clickToInterruptButton();

        registrationPageAndroid.waitUntilLoaded();
    }

    @Test
    @DisplayName("Прерывание регистрации: на шаге установки пароля")
    public void interruptRegistrationOnSetPasswordPage() {
        phone = Data.UserTypes.FOR_SIMPLE_REGISTRATION_USER.phoneValidValue();
        registrationPageAndroid.successTypePhoneNumber(phone);
        otpPageAndroid.typeCorrectOtp();
        otpPageAndroid.clickBackButton();
        registrationPageAndroid.clickToInterruptButton();

        registrationPageAndroid.waitUntilLoaded();
    }

    @Test
    @DisplayName("Прерывание регистрации: на шаге заполнения данных - через кнопку 'Назад'")
    public void interruptRegistrationOnSetPersonalDataPage() {
        phone = Data.UserTypes.FOR_SIMPLE_REGISTRATION_USER.phoneValidValue();
        registrationPageAndroid.successTypePhoneNumber(phone);
        otpPageAndroid.typeCorrectOtp();
        setPasswordPageAndroid.inputPassword(
                Data.UserTypes.FOR_SIMPLE_REGISTRATION_USER.passwordValidValue());
        otpPageAndroid.clickBackButton();
        registrationPageAndroid.clickToInterruptButton();

        registrationPageAndroid.waitUntilLoaded();
    }

    @Test
    @DisplayName("Прерывание регистрации: на шаге заполнения данных - через кнопку 'На главный экран'")
    public void interruptRegistrationOnSetPersonalDataPageBackToMainPage() {
        phone = Data.UserTypes.FOR_SIMPLE_REGISTRATION_USER.phoneValidValue();
        registrationPageAndroid.successTypePhoneNumber(phone);
        otpPageAndroid.typeCorrectOtp();
        setPasswordPageAndroid.inputPassword(
                Data.UserTypes.FOR_SIMPLE_REGISTRATION_USER.passwordValidValue());
        setPersonalDataPageAndroid.clickToMainPageButton_();
        registrationPageAndroid.clickToInterruptButton();

        mainPageAndroid.waitUntilLoaded();
    }
}
