package android;

import baseUtils.Data;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

public class PassCreatingTest extends BaseAndroidTest {
    @Override
    @BeforeEach
    public void initPages() throws Exception {
        super.initPages();
        mainPageAndroid.openProfile();
        loginPageAndroid
                .waitUntilLoaded()
                .login(
                        Data.UserTypes.DEFAULT_USER.phoneValidValue(),
                        Data.UserTypes.DEFAULT_USER.passwordValidValue(),
                        false
                );
    }

    @Test
    @DisplayName("Успешный выпуск личного QR-пропуска: будучи подтвержденным на ресепшен пользователем")
    public void successCreatingPersonalQRPassBeingApproved() {
        mainPageAndroid.openPassPage();
        passCreationMainPageAndroid.clickToPersonalPassButton();
        personalPassTypesPageAndroid.clickToQRPassButton();
        qrPassMainPageAndroid.requestPersonalQRPassBeingApproved();
    }

}
