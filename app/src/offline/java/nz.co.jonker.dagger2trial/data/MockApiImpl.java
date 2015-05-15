package nz.co.jonker.dagger2trial.data;

import android.util.Log;

import java.util.ArrayList;

import javax.inject.Inject;

import retrofit.Callback;
import retrofit.client.Header;
import retrofit.client.Response;
import retrofit.http.Query;

/**
 * Created by datacom_mobile01 on 15/05/15.
 */
public class MockApiImpl implements ApiInterface {
    public static final String TAG = "MockApiImpl";

    @Inject
    MockApiImpl() {
    }

    @Override
    public void checkGender(@Query("name") String name, Callback<GenderResponse> cb) {
        GenderResponse gr;
        Log.d(TAG, "name: " + name);
        if (name.toLowerCase().trim().equals("daniel")) {
            gr = new GenderResponse(name, "male", 1.00, 8162);
        } else {
            gr = new GenderResponse(name, null, 0.00, 0);
        }


        cb.success(gr, new Response("url", 200, "OK", new ArrayList<Header>(), null));
    }
}
