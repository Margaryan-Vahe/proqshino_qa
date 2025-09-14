package oneC;

import baseUtils.Data;
import baseUtils.DataBaseRequests;
import io.restassured.response.Response;
import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertNotNull;

public class CheckDataFromOneCTest {
    static String phone;

    @AfterAll
    public static void tearDown() {
        String userId = DataBaseRequests.getUserId(phone, true);
        String userRequest = DataBaseRequests.getUserRequests(userId, true);
        if (!userRequest.isEmpty()) {
            DataBaseRequests.deleteUserRequest(userId, true);
        }
    }

    @Test
    @DisplayName("Проверка получения номера технической заявки из 1С")
    public void checkOrderedOneCNumber() {
        phone = Data.UserTypes.FOR_PROD_TEST_USER.phoneValidValue();

        baseUtils.mobApp.ApiRequests.makeRequestOrder(
                Data.UserTypes.FOR_PROD_TEST_USER.phoneFullValue(),
                Data.UserTypes.FOR_PROD_TEST_USER.passwordValidValue());

        Response orderedRequest = baseUtils.ms.ApiRequests.getOrderedOneCNumber();
        String oneCNumber = orderedRequest.then()
                .statusCode(200)
                .extract()
                .path("[0].oneCNumber");

        assertNotNull(oneCNumber, "oneCNumber у первой заявки не должен быть null");
    }
}
