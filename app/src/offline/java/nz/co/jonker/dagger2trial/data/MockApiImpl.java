package nz.co.jonker.dagger2trial.data;


import android.content.Context;
import android.util.Log;

import com.google.gson.Gson;

import java.io.IOException;
import java.io.InputStream;
import java.util.ArrayList;

import javax.inject.Inject;

import nz.co.jonker.dagger2trial.BaseApp;
import nz.co.jonker.dagger2trial.data.models.CourseResponse;
import retrofit.Callback;
import retrofit.client.Header;
import retrofit.client.Response;

/**
 * Created by datacom_mobile01 on 15/05/15.
 */
public class MockApiImpl implements ApiInterface {
    public static final String TAG = "MockApiImpl";
    private Context mContext;

    @Inject
    Gson gson;

    @Inject
    MockApiImpl(Context context) {
        this.mContext = context;
    }

    @Override
    public void listCourses(Callback<CourseResponse> cb) {

        Log.d(TAG, "listCourses");
        String json = loadJSONFromAsset(mContext, "courses.json");

        Log.d(TAG, "json: " + json);
//        Log.d(TAG, "gson:? " + gson.toString());
        //todo: download the images and add them to assets folder and replace image urls
        CourseResponse mockResponse = gson.fromJson(json, CourseResponse.class);

        if (mockResponse != null){
            cb.success(mockResponse, new Response("response", 200, "OK", new ArrayList<Header>(), null));
        } else {
            //cb.failure..
            Log.w(TAG, "failure");
        }

    }

    public String loadJSONFromAsset(Context context, String fileName) {
        String json = null;
        try {
            InputStream is = context.getAssets().open(fileName);

            int size = is.available();
            byte[] buffer = new byte[size];

            is.read(buffer);
            is.close();

            json = new String(buffer, "UTF-8");
        } catch (IOException ex) {
            ex.printStackTrace();
            return null;
        }
        return json;
    }
}
