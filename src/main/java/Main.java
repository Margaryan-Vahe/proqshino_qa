import baseUtils.Data;
import baseUtils.DataBaseRequests;
import io.restassured.response.Response;

import static baseUtils.mobApp.ApiRequests.getToken;
import static baseUtils.mobApp.ApiRequests.makeRequestOrder;

public class Main {
    public static void main(String[] args) {
        String userId = DataBaseRequests.getUserId("79331000001", true);
        DataBaseRequests.deleteUserRequest(userId, true);

//        Response getUserToken = getToken(
//                Data.UserTypes.FOR_PROD_TEST_USER.phoneFullValue(),
//                Data.UserTypes.FOR_PROD_TEST_USER.passwordValidValue());
//        String token = getUserToken.then().extract().path("token");
//
//        Response createdOrder = makeRequestOrder(token);
//        System.out.println(createdOrder.then().log().all().extract().jsonPath().getString("requestId"));

    }
}
