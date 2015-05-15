package nz.co.jonker.dagger2trial.data;

import retrofit.Callback;
import retrofit.http.GET;
import retrofit.http.Query;

/**
 * Created by datacom_mobile01 on 15/05/15.
 */
public interface ApiInterface {

    @GET("/")
    void checkGender(@Query("name") String name, Callback<GenderResponse> cb); //change to Meeting objects
}
