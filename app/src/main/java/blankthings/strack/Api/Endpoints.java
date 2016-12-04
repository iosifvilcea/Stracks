package blankthings.strack.Api;

import java.util.List;

import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.Query;

/**
 * Created by iosifvilcea on 6/18/16.
 */
public interface Endpoints {

    @GET("/posts")
    Call<List<Post>> getPosts();

    @GET("/users")
    Call<List<User>> getUsers();

    @GET("/users")
    Call<User> getUser(@Query("businessName") String usernameQuery);

}
