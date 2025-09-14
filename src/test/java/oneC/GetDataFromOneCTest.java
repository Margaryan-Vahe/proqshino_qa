package oneC;

import baseUtils.Data;
import baseUtils.oneC.ApiRequests;
import io.restassured.path.json.JsonPath;
import io.restassured.response.Response;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.hamcrest.Matchers.*;
import static org.junit.jupiter.api.Assertions.assertNotNull;

public class GetDataFromOneCTest {

    @Test
    @DisplayName("Выполнение запроса на получение данных по помещениям")
    public void getRentalObjectData() {
        Response rentalObject = new ApiRequests().getRentalObjectData();

        rentalObject
                .then()
                .statusCode(200)
                .body(not(emptyOrNullString()))
                .log().all();
    }

    @Test
    @DisplayName("Выполнение запроса на получение данных по номенклатуре")
    public void getNomenclatureData() {
        Response rentalObject = new ApiRequests().getNomenclatureData();

        rentalObject
                .then()
                .statusCode(200)
                .body(not(emptyOrNullString()))
                .log().all();
    }

    @Test
    @DisplayName("Выполнение запроса на получение данных по контрагентам")
    public void getCounterpartyData() {
        Response rentalObject = new ApiRequests().getCounterPartyData();

        rentalObject
                .then()
                .statusCode(200)
                .body(not(emptyOrNullString()))
                .log().all();
    }

    @Test
    @DisplayName("Выполнение запроса на получение данных по оборудованиям")
    public void getEquipmentData() {
        Response rentalObject = new ApiRequests().getEquipmentData();

        rentalObject
                .then()
                .statusCode(200)
                .body(not(emptyOrNullString()))
                .log().all();
    }

    @Test
    @DisplayName("Проверка получения номера технической заявки из 1С")
    public void checkOrderedOneCNumber() {
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
