package android;

import baseUtils.Data;
import baseUtils.DataBaseRequests;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

public class ValidationDuringRegistrationTest extends BaseAndroidTest {
    String phone;

    @Override
    @BeforeEach
    public void initPages() throws Exception {
        super.initPages();
        mainPageAndroid.openProfile();
        loginPageAndroid.clickToCreateNewAccountButton();

    }

    @Test
    @DisplayName("Валидация при регистрации - отображение ошибки 'Данный номер уже зарегистрирован'")
    public void validationAlreadyRegisteredPhoneErrorMessage() {
        phone = Data.UserTypes.APPROVED_EMPLOYEE.phoneValidValue();
        registrationPageAndroid.successTypePhoneNumber(phone);
        registrationPageAndroid.waitUntilLoadedAlreadyRegisteredMessage();
    }
}
