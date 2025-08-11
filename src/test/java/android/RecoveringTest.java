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
    @DisplayName("Восстановление пароля через SMS-код → настройка PIN → вход")
    public void passRecovery() throws InterruptedException {
        loginPageAndroid.clickToForgotPassButton();

        recoverPageAndroid.waitUntilLoaded();
        recoverPageAndroid.inputDataForRecover(
                Data.UserTypes.DEFAULT_USER.phoneValidValue()
        );

        otpPageAndroid
                .waitUntilLoaded()
                .typeCorrectOtp(); // код 1111

        setPasswordPageAndroid
                .waitUntilLoaded();
        setPasswordPageAndroid.inputPassword(
                Data.UserTypes.DEFAULT_USER.passwordValidValue()
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
                        Data.UserTypes.DEFAULT_USER.phoneValidValue(),
                        Data.UserTypes.DEFAULT_USER.passwordValidValue(),
                        false
                );

        mainPageAndroid.closeAndRunApp();
        inputPinPageAndroid.clickToForgotPinButton();

        loginPageAndroid
                .waitUntilLoaded()
                .login(
                        Data.UserTypes.DEFAULT_USER.phoneValidValue(),
                        Data.UserTypes.DEFAULT_USER.passwordValidValue(),
                        false
                );

        mainPageAndroid.waitUntilLoaded().mainPageHeaderShouldBeVisible();
    }
}
