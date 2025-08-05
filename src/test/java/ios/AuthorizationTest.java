package ios;

import baseUtils.Data;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static baseUtils.SetupCapabilities.appiumDriver;
import static com.codeborne.selenide.Condition.visible;
import static org.junit.jupiter.api.Assertions.assertTrue;

public class AuthorizationTest extends BaseIOSTest {

    @Override
    @BeforeEach
    public void initPages() throws Exception {
        super.initPages();
        mainPageIOS.openProfile();
    }
    @Override
    @AfterEach
    public void tearDown(){
        mainPageIOS.openProfile();

        if(appiumDriver != null){
            appiumDriver.quit();
        }
    }

    @Test
    public void successAuthorization() throws InterruptedException {
        loginPageIOS.login(Data.UserTypes.DEFAULT_USER.phoneValidValue(),
                Data.UserTypes.DEFAULT_USER.passwordValidValue(),
                false);

        assertTrue(
                mainPageIOS.mainPageHeader().is(visible),
                "Ожидался видимый заголовок главной страницы после успешного входа"  // или: main.mainPageHeaderShouldBeVisible()
        );
    }
    @Test
    public void incorrectAuthorization() throws InterruptedException {
        loginPageIOS.login(Data.UserTypes.DEFAULT_USER.phoneValidValue(),
                Data.UserTypes.DEFAULT_USER.passwordInvalidValue(),
                true);

        assertTrue(loginPageIOS
                        .incorrectDataErrorMessage()
                        .is(visible),
                "Ожидался текст ошибки");
    }
}
