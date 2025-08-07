package android;

import baseUtils.Data;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static com.codeborne.selenide.Condition.visible;
import static org.junit.jupiter.api.Assertions.assertTrue;

public class RecoveringTest extends BaseAndroidTest{
    @Override
    @BeforeEach
    public void initPages() throws Exception {
        super.initPages();
        mainPageAndroid.openProfile();
    }

    @Test
    public void passRecovery() throws InterruptedException {
        loginPageAndroid.clickToForgotPassButton();
        recoverPageAndroid.inputDataForRecover(Data.UserTypes.DEFAULT_USER.phoneValidValue());
        otpPageAndroid.typeCorrectOtp();
        setPasswordPageAndroid.inputPassword(Data.UserTypes.DEFAULT_USER.passwordValidValue());

        setPinPageAndroid.waitUntilLoaded();

        setPinPageAndroid.clickNum1();
        repeatPinPageAndroid.clickNum1();
        bioConfirmationPageAndroid.clickToRefuseButton();
        inputPinPageAndroid.clickNum1();

        mainPageAndroid.waitUntilLoaded();

        assertTrue(
                mainPageAndroid.mainPageHeader().is(visible),
                "Ожидался видимый заголовок главной страницы после успешного восстановления пароля"  // или: main.mainPageHeaderShouldBeVisible()
        );
    }

}
