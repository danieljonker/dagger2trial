package nz.co.jonker.dagger2trial.data;

import nz.co.jonker.dagger2trial.data.models.CourseResponse;
import retrofit.Callback;
import retrofit.http.GET;

/**
 * Created by datacom_mobile01 on 15/05/15.
 */
public interface ApiInterface {

    @GET("/courses")
    void listCourses(Callback<CourseResponse> cb);
}
