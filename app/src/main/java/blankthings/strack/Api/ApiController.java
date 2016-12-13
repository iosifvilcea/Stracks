package blankthings.strack.api;

import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;

/**
 * Created by iosifvilcea on 7/20/16.
 */
public class ApiController {

    private static ApiController apiController;
    private final static ApiService apiService = new ApiService();


    public static ApiController getInstance() {
        if (apiController == null) {
            apiController = new ApiController();
        }

        return apiController;
    }


    public void makeUserListRequest(Callback<List<User>> callback) {
        Call<List<User>> userCalled = apiService.make().getUsers();
        userCalled.enqueue(callback);
    }


    public void makeUserRequest(final String query, final Callback<User> userCallback) {
        Call<User> userCalled = apiService.make().getUser(query);
        userCalled.enqueue(userCallback);
    }

}
