package android;

import baseUtils.Data;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

public class RecoveringTest extends BaseAndroidTest{
    @Override
    @BeforeEach
    public void initPages() throws Exception {
        super.initPages();
        mainPageAndroid.openProfile();
    }

    @Test
    public void passRecover() throws InterruptedException {
        loginPageAndroid.clickToForgotPassButton();
        recoverPageAndroid.inputDataForRecover(Data.UserTypes.DEFAULT_USER.phoneValidValue());
        otpPageAndroid.typeCorrectOtp();
    }

}
