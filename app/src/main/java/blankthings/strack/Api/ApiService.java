package blankthings.strack.Api;

import android.support.annotation.Nullable;
import android.text.TextUtils;

import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

/**
 * Created by iosifvilcea on 6/22/16.
 */
public class ApiService {

    private Endpoints endpoints;
    private String BASE_URL = "http://jsonplaceholder.typicode.com/";
    private Retrofit retrofit = new Retrofit.Builder()
            .baseUrl(BASE_URL)
            .addConverterFactory(GsonConverterFactory.create())
            .build();


    public ApiService() {
        this(null);
    }

    public ApiService(@Nullable final String url) {
        if (!TextUtils.isEmpty(url)) {
            BASE_URL = url;
        }

        createEndpoints();
    }


    private void createEndpoints() {
        endpoints = retrofit.create(Endpoints.class);
    }


    public Endpoints make() {
        return endpoints;
    }
}
