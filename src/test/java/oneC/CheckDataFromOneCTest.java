package oneC;

import baseUtils.Data;
import baseUtils.DataBaseRequests;
import baseUtils.oneC.ApiRequests;
import io.qameta.allure.Allure;
import io.restassured.response.Response;
import org.junit.jupiter.api.*;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

import static baseUtils.mobApp.ApiRequests.getToken;
import static org.junit.jupiter.api.Assertions.assertNotNull;

public class CheckDataFromOneCTest {
    static String phone;
    static String oneCNumber;
    static String userRequestId;
    static String userId;

    @BeforeEach
    public void setUp() throws InterruptedException {
        phone = Data.UserTypes.FOR_PROD_TEST_USER.phoneValidValue();
        userId = DataBaseRequests.getUserId(phone, true);

        Response getUserToken = getToken(
                Data.UserTypes.FOR_PROD_TEST_USER.phoneFullValue(),
                Data.UserTypes.FOR_PROD_TEST_USER.passwordValidValue());
        String token = getUserToken.then().extract().path("token");

        Response createResp = baseUtils.mobApp.ApiRequests.makeRequestOrder(token);

        Allure.addAttachment("Create request response", "application/json", createResp.asPrettyString());
        createResp.then().statusCode(201);

        Response orderedRequest = baseUtils.ms.ApiRequests.getOrderedOneCNumber();
        orderedRequest.then().log().status().statusCode(200);

        int maxAttempt = 5;
        do {
            Thread.sleep(2000);

            userRequestId = DataBaseRequests.getUserRequests(userId, true);
            oneCNumber = DataBaseRequests.getUserRequestsOneCNumber(userId, true);

            System.out.println(userRequestId + " - " + oneCNumber);
            if (userRequestId == null && oneCNumber == null) {
                try {
                    Thread.sleep(1000);
                    maxAttempt --;
                } catch (InterruptedException ignored) {
                }
            }
        } while ((userRequestId == null || oneCNumber == null) && maxAttempt > 0);
    }

    @AfterEach
    public void tearDown() {
        userId = DataBaseRequests.getUserId(phone, true);
        userRequestId = DataBaseRequests.getUserRequests(userId, true);
        if (!userRequestId.isEmpty()) {
            DataBaseRequests.deleteUserRequest(userId, true);
        }
    }

    @Test
    @DisplayName("Проверка получения номера технической заявки из 1С")
    public void checkOrderedOneCNumber() {
        assertNotNull(oneCNumber, "oneCNumber у первой заявки не должен быть null");
    }

    @ParameterizedTest(name = "Проверка изменения статуса заявки → {0}")
    @ValueSource(strings = {
            "На рассмотрении",
            "Отклонена",
            "Утверждена",
            "Выполняется",
            "Выполнена"
    })
    @DisplayName("Проверка изменения статуса заявки (параметризованный)")
    void changeOrderStatus(String status) {
        Response response = ApiRequests.authenticate();
        response.then().statusCode(200);
        String token = response.then().extract().path("id_token");
        Response response_ = ApiRequests.changeRentServiceStatus(
                token,
                userRequestId,
                oneCNumber,
                status);
        response_.then().statusCode(200).log().all();

        Allure.step("Response for status = " + status, () -> {
            Allure.addAttachment(
                    "Body",
                    "application/json",
                    response_.asPrettyString(),
                    ".json"
            );
        });
    }
}