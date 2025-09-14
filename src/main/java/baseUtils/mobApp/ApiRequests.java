package baseUtils.mobApp;

import baseUtils.DataBaseRequests;
import io.qameta.allure.Step;
import io.restassured.http.ContentType;
import io.restassured.response.Response;

import java.time.OffsetDateTime;
import java.time.ZoneOffset;
import java.time.format.DateTimeFormatter;

import static io.restassured.RestAssured.given;

public class ApiRequests {
    public static final String BASE_URL = "https://app-services.c0d.org/api/v1/auth/auth/";
    public static final String AUTHORIZE = "authorize";

    public static final String BASE_URL_2 = "https://app-services.biznespro.info/";
    public static final String REQUEST_ORDER = "api/v1/requests/api/request ";


    @Step("Получить токен авторизации для зарегистрированного пользователя")
    public static Response getToken(String login, String password) {
        Credentials credentials = new Credentials(login, password);

        return given()
                .baseUri(BASE_URL)
                .contentType(ContentType.JSON)
                .body(credentials)
                .when()
                .post(AUTHORIZE)
                .then()
                .log().all()
                .extract().response();
    }

    @Step("Создание технической заявки")
    public static void makeRequestOrder(String login, String password) {
        Response getUserToken = getToken(login, password);
        String token = getUserToken.then().extract().path("token");

        String phone = login.replaceAll("\\D", "");
        String userId = DataBaseRequests.getUserId(phone, true);

        String createdAt = OffsetDateTime.now(ZoneOffset.UTC)
                .format(DateTimeFormatter.ofPattern("yyyy-MM-dd'T'HH:mm:ss.SSSSSS'Z'"));

        CreateRequest createRequest = new CreateRequest(
                null,
                userId,
                null,
                createdAt,
                "Общие вопросы",
                "тестовая заявка ",
                "IN_REVIEW",
                null,
                null,
                null,
                null
        );


        given()
                .baseUri(BASE_URL_2)
                .contentType(ContentType.JSON)
                .accept(ContentType.JSON)
                .header("Authorization", "Bearer " + token)
                .body(createRequest)
                .when()
                .post(REQUEST_ORDER)
                .then()
                .log().all()
                .statusCode(200);
    }
}
