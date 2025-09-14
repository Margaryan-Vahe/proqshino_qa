package baseUtils.ms;

import io.qameta.allure.Step;
import io.restassured.http.ContentType;
import io.restassured.response.Response;

import java.io.File;

import static io.restassured.RestAssured.given;

public class ApiRequests {
    public static final String MS_UI_URL = "http://10.129.0.10:8090";
    public static final String USER_REQUESTS = "api/user-requests";

    public static final String BASE_URL = "http://10.129.0.13:8090";
    public static final String ADD_FILE = "/api/admin/users/excel/company/";
    public static final String LOGIN = "/api/authenticate";

    @Step("Логин пользователя MS")
    public static Response login() {
        Credentials creds = new Credentials(
                "admin",
                "true",
                "+71111111111");

        return given()
                .baseUri(BASE_URL)
                .contentType(ContentType.JSON)
                .accept(ContentType.JSON)
                .body(creds)
                .when()
                .post(LOGIN)
                .then()
                .log().status()
                .extract().response();
    }

    @Step("Загрузка файла")
    public static Response loadFile(String token, String companyId) {
        File excelFile = new File("src/test/resources/users-template_for_test.xlsx");

        return given()
                .baseUri(BASE_URL)
                .contentType(ContentType.MULTIPART)
                .accept(ContentType.JSON)
                .header("Authorization", "Bearer " + token)

                .multiPart("files", excelFile,
                        "application/vnd.openxmlformats-officedocument.spreadsheetml.sheet")

                .when()
                .post(ADD_FILE + companyId)
                .then()
                .log().status()
                .extract().response();
    }

    @Step("Проверка получения из 1С номера технической заявки")
    public static Response getOrderedOneCNumber() {
        Response login = baseUtils.ms.ApiRequests.login();
        login.then().statusCode(200);
        String token = login.then().extract().path("id_token");

        return given()
                .baseUri(MS_UI_URL)
                .queryParam("page", 0)
                .queryParam("size", 20)
                .queryParam("sort", "createdAt,desc")
                .contentType(ContentType.JSON)
                .accept(ContentType.JSON)
                .header("Authorization", "Bearer " + token)
                .when()
                .get(USER_REQUESTS);
    }
}
