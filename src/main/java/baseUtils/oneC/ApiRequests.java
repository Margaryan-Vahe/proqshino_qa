package baseUtils.oneC;

import io.qameta.allure.Step;
import io.restassured.http.ContentType;
import io.restassured.response.Response;

import java.time.OffsetDateTime;
import java.time.ZoneOffset;
import java.time.format.DateTimeFormatter;

import static io.restassured.RestAssured.given;

public class ApiRequests {
    public static final String BASE_URL_PROD = "https://biznespro.a101.ru/prod_arenda/hs/RentalObject/";
    public static final String BASE_URL_PREPROD = "https://biznespro.a101.ru/preprod_arenda/hs/RentalObject/";

    public static final String BASE_URL_MS = "http://10.129.0.10:8090/api/";
    public static final String AUTHENTICATE = "authenticate";
    public static final String RENT_SERVICE = "v1/one-c/rent/service/";


    public static final String RENTAL_OBJECT = "RentalObject/";
    public static final String NOMENCLATURE = "Nomenclature/";
    public static final String COUNTERPARTY = "Counterparty/";
    public static final String EQUIPMENT = "Equipment/";

    public static final String USER_NAME = "API_User";
    public static final String PASSWORD = "123456";

    @Step("Авторизация в систему МС")
    public static Response authenticate() {
        baseUtils.oneC.Credentials credentials = new Credentials(
                "+72222222222",
                "user"
        );

        return given()
                .baseUri(BASE_URL_MS)
                .contentType(ContentType.JSON)
                .body(credentials)
                .when()
                .post(AUTHENTICATE)
                .then()
                .log().status()
                .extract().response();
    }

    @Step("Запрос на изменение статуса")
    public static Response changeRentServiceStatus(
            String token,
            String orderId,
            String orderNumber,
            String status) {
        String updated = OffsetDateTime.now(ZoneOffset.UTC)
                .format(DateTimeFormatter.ofPattern("yyyy-MM-dd'T'HH:mm:ss.SSS'Z'"));

        RentService rentService = new RentService(
                orderId,
                updated,
                orderNumber,
                false,
                status
        );

        return given()
                .baseUri(BASE_URL_MS)
                .contentType(ContentType.JSON)
                .header("Authorization", "Bearer " + token)
                .body(rentService)
                .log().all()
                .when()
                .post(RENT_SERVICE);
    }

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
