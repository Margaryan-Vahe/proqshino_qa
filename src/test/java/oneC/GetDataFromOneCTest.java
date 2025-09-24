package oneC;

import baseUtils.Data;
import baseUtils.oneC.ApiRequests;
import io.restassured.response.Response;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static baseUtils.mobApp.ApiRequests.getToken;
import static org.hamcrest.Matchers.*;

public class GetDataFromOneCTest {
    @Test
    @DisplayName("Выполнение запроса на получение данных по помещениям")
    public void getRentalObjectData() {
        Response rentalObject = new ApiRequests().getRentalObjectData();

        rentalObject
                .then()
                .log().all()
                .statusCode(200)
                .body(not(emptyOrNullString()));
    }

    @Test
    @DisplayName("Выполнение запроса на получение данных по номенклатуре")
    public void getNomenclatureData() {
        Response rentalObject = new ApiRequests().getNomenclatureData();

        rentalObject
                .then()
                .log().all()
                .statusCode(200)
                .body(not(emptyOrNullString()));
    }

    @Test
    @DisplayName("Выполнение запроса на получение данных по контрагентам")
    public void getCounterpartyData() {
        Response rentalObject = new ApiRequests().getCounterPartyData();

        rentalObject
                .then()
                .log().all()
                .statusCode(200)
                .body(not(emptyOrNullString()));
    }

    @Test
    @DisplayName("Выполнение запроса на получение данных по оборудованиям")
    public void getEquipmentData() {
        Response rentalObject = new ApiRequests().getEquipmentData();

        rentalObject
                .then()
                .log().all()
                .statusCode(200)
                .body(not(emptyOrNullString()));
    }

    @Test
    @DisplayName("Отправка сообщения из МС в сторону 1С")
    public void sendChatMessageToOneC() throws InterruptedException {
        Response getUserToken = getToken(
                Data.UserTypes.FOR_PROD_TEST_USER.phoneFullValue(),
                Data.UserTypes.FOR_PROD_TEST_USER.passwordValidValue());
        String token = getUserToken.then().extract().path("token");

        Response sendMessage = new ApiRequests().sendMessage(token);


        sendMessage
                .then()
                .log().all()
                .statusCode(200)
                .body("errors.size()", equalTo(0));
    }
}
