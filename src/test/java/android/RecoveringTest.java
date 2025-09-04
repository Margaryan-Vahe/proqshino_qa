package android;

import baseUtils.Data;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

public class RecoveringTest extends BaseAndroidTest {

    @Override
    @BeforeEach
    public void initPages() throws Exception {
        super.initPages();
        mainPageAndroid.openProfile();
    }

    @Test
    @DisplayName("Восстановление пароля через SMS-код")
    public void passRecovery() throws InterruptedException {
        loginPageAndroid.clickToForgotPassButton();

        recoverPageAndroid.waitUntilLoaded();
        recoverPageAndroid.inputDataForRecover(
                Data.UserTypes.DEFAULT_EMPLOYEE.phoneValidValue()
        );

        otpPageAndroid
                .waitUntilLoaded()
                .typeCorrectOtp(); // код 1111

        setPasswordPageAndroid
                .waitUntilLoaded();
        setPasswordPageAndroid.inputPassword(
                Data.UserTypes.DEFAULT_EMPLOYEE.passwordValidValue()
        );

        setPinPageAndroid.waitUntilLoaded().clickNum1();
        repeatPinPageAndroid.waitUntilLoaded().clickNum1();
        bioConfirmationPageAndroid.waitUntilLoaded().clickToRefuseButton();
        inputPinPageAndroid.waitUntilLoaded().clickNum1();

        mainPageAndroid.waitUntilLoaded().mainPageHeaderShouldBeVisible();
    }

    @Test
    @DisplayName("Восстановление PIN-кода через 'Забыл ПИН'")
    public void pinRecovery() throws InterruptedException {
        loginPageAndroid
                .waitUntilLoaded()
                .login(
                        Data.UserTypes.DEFAULT_EMPLOYEE.phoneValidValue(),
                        Data.UserTypes.DEFAULT_EMPLOYEE.passwordValidValue(),
                        false
                );

        mainPageAndroid.closeAndRunApp();
        inputPinPageAndroid.clickToForgotPinButton();

        loginPageAndroid
                .waitUntilLoaded()
                .login(
                        Data.UserTypes.DEFAULT_EMPLOYEE.phoneValidValue(),
                        Data.UserTypes.DEFAULT_EMPLOYEE.passwordValidValue(),
                        false
                );

        mainPageAndroid.waitUntilLoaded().mainPageHeaderShouldBeVisible();
    }
    @Test
    @DisplayName("Валидация при восстановлении пароля - отображение ошибки 'Пользователь с указанным номером не активирован, пройдите регистрацию'")
    public void validationAlreadyRegisteredAndNotActivatedPhoneErrorMessage() throws InterruptedException {
        loginPageAndroid.clickToForgotPassButton();

        recoverPageAndroid.waitUntilLoaded();
        recoverPageAndroid.inputDataForRecover(
                Data.UserTypes.NOT_ACTIVATED_EMPLOYEE.phoneValidValue()
        );

        recoverPageAndroid.waitUntilLoadedNotActivatedPhoneErrorMessage();
    }
}
