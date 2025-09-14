package oneC;

import baseUtils.oneC.ApiRequests;
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
}
