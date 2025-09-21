import baseUtils.Data;
import baseUtils.DataBaseRequests;

public class Main {
    public static void main(String[] args) {
        String userId = DataBaseRequests.getUserId(Data.UserTypes.FOR_PROD_TEST_USER.phoneValidValue(), true);
        DataBaseRequests.deleteUserRequest(userId, true);

    }
}
