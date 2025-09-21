import baseUtils.Data;
import baseUtils.DataBaseRequests;
import baseUtils.oneC.ApiRequests;
import io.restassured.response.Response;

import static org.junit.jupiter.api.Assertions.assertNotNull;

public class Main {
    public static void main(String[] args) {

        String userId = DataBaseRequests.getUserId(Data.UserTypes.FOR_PROD_TEST_USER.phoneValidValue(), true);
        DataBaseRequests.deleteUserRequest(userId, true);

//        Response response = ApiRequests.authenticate();
//        response.then().statusCode(200);
//        String token = response.then().extract().path("id_token");
//        Response response_ = ApiRequests.changeRentServiceStatus(
//                token,
//                "8e132d89-30c2-4a1a-864a-05369f669b5e",
//                "0000-000752",
//                "Отклонена");
//        response_.then().statusCode(200).log().all();

    }
}
