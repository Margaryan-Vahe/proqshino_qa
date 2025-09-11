package baseUtils.oneC;

import io.qameta.allure.Step;
import io.restassured.http.ContentType;
import io.restassured.response.Response;

import static io.restassured.RestAssured.given;

public class ApiRequests {
    public static final String BASE_URL_PROD = "https://biznespro.a101.ru/prod_arenda/hs/RentalObject/";
    public static final String BASE_URL_PREPROD = "https://biznespro.a101.ru/preprod_arenda/hs/RentalObject/";

    public static final String RENTAL_OBJECT = "RentalObject/";
    public static final String NOMENCLATURE = "Nomenclature/";
    public static final String COUNTERPARTY = "Counterparty/";
    public static final String EQUIPMENT = "Equipment/";

    public static final String USER_NAME = "API_User";
    public static final String PASSWORD = "123456";

    @Step("Получение данных по помещениям")
    public Response getRentalObjectData() {
        return given()
                .baseUri(BASE_URL_PROD)
                .contentType(ContentType.JSON)
                .auth().basic(USER_NAME, PASSWORD)
                .when()
                .get(RENTAL_OBJECT);
    }

    @Step("Получение данных по номенклатуре")
    public Response getNomenclatureData() {
        return given()
                .baseUri(BASE_URL_PROD)
                .contentType(ContentType.JSON)
                .auth().basic(USER_NAME, PASSWORD)
                .when()
                .get(NOMENCLATURE);
    }

    @Step("Получение данных по контрагентам")
    public Response getCounterPartyData() {
        return given()
                .baseUri(BASE_URL_PROD)
                .contentType(ContentType.JSON)
                .auth().basic(USER_NAME, PASSWORD)
                .when()
                .get(COUNTERPARTY);
    }

    @Step("Получение данных по оборудованиям")
    public Response getEquipmentData() {
        return given()
                .baseUri(BASE_URL_PROD)
                .contentType(ContentType.JSON)
                .auth().basic(USER_NAME, PASSWORD)
                .when()
                .get(EQUIPMENT);
    }
}
