package baseUtils.mobApp;

import io.qameta.allure.Step;
import io.qameta.allure.restassured.AllureRestAssured;
import io.restassured.http.ContentType;
import io.restassured.response.Response;

import java.time.OffsetDateTime;
import java.time.ZoneOffset;
import java.time.format.DateTimeFormatter;

import static io.restassured.RestAssured.given;

public class ApiRequests {
    public static final String BASE_URL = "https://app-services.c0d.org/api/v1/auth/auth/";
    public static final String AUTHORIZE = "authorize";
    public static final String TOKEN = "token";

    public static final String BASE_URL_2 = "https://app-services.biznespro.info/";
    public static final String REQUEST_ORDER = "api/v1/requests/api/request ";

    @Step("Получить токен авторизации для зарегистрированного пользователя")
    public static Response getToken(String login, String password) {
        Credentials credentials = new Credentials(login, password);

        return given()
                .filter(new AllureRestAssured())
                .baseUri(BASE_URL)
                .contentType(ContentType.JSON)
                .body(credentials)
                .when()
                .log().all()
                .post(AUTHORIZE)
                .then()
                .log().all()
                .extract().response();
    }

    @Step("Создание технической заявки")
    public static Response makeRequestOrder(String token) {
        String userId = getUserId(token);
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

        return given()
                .filter(new AllureRestAssured())
                .baseUri(BASE_URL_2)
                .contentType(ContentType.JSON)
                .accept(ContentType.JSON)
                .header("Authorization", "Bearer " + token)
                .body(createRequest)
                .when()
                .post(REQUEST_ORDER)
                .then()
                .log().status()
                .extract().response();
    }

    @Step("Получение id заявки")
    public static String getOrderId(String token) {
        Response createdOrder = makeRequestOrder(token);
        return createdOrder.then().extract().jsonPath().getString("requestId");
    }

    @Step("Получение id пользователя")
    public static String getUserId(String token) {
        return given()
                .filter(new AllureRestAssured())
                .baseUri(BASE_URL)
                .contentType(ContentType.JSON)
                .accept(ContentType.JSON)
                .header("Authorization", "Bearer " + token)
                .when()
                .get(TOKEN)
                .then()
                .statusCode(200)
                .extract().jsonPath().getString("token.claims.userId");
    }
}
