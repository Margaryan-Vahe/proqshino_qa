package android;

import baseUtils.Data;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

public class PassCreatingTest extends BaseAndroidTest {
    @Override
    @BeforeEach
    public void initPages() throws Exception {
        super.initPages();
        mainPageAndroid.openProfile();
    }

    @Override
    @AfterEach
    public void tearDown() {
        myPassesPageAndroid.deactivatePass();
        super.tearDown();
    }

    @Test
    @DisplayName("Успешный выпуск личного QR-пропуска: будучи подтвержденным на ресепшен пользователем")
    public void successCreatingPersonalQRPassBeingApproved() throws Exception {
        loginPageAndroid
                .waitUntilLoaded()
                .login(
                        Data.UserTypes.APPROVED_USER.phoneValidValue(),
                        Data.UserTypes.APPROVED_USER.passwordValidValue(),
                        false
                );

        mainPageAndroid.openPassPage();
        passCreationMainPageAndroid.clickToPersonalPassButton();
        personalPassTypesPageAndroid.clickToQRPassButton();
        qrPassMainPageAndroid.requestPersonalQRPassBeingApproved();

        myPassesPageAndroid.checkQRActiveStatus();
    }

}
