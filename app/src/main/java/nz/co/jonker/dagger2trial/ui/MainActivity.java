package nz.co.jonker.dagger2trial.ui;

import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.Toolbar;
import android.util.Log;
import android.view.Menu;
import android.view.MenuItem;

import java.util.ArrayList;

import javax.inject.Inject;

import butterknife.ButterKnife;
import butterknife.InjectView;
import nz.co.jonker.dagger2trial.BaseActivity;
import nz.co.jonker.dagger2trial.R;
import nz.co.jonker.dagger2trial.data.ApiInterface;
import nz.co.jonker.dagger2trial.data.models.Course;
import nz.co.jonker.dagger2trial.data.models.CourseResponse;
import retrofit.Callback;
import retrofit.RetrofitError;
import retrofit.client.Response;


public class MainActivity extends BaseActivity {
    public static final String TAG = "MainActivity";

    @InjectView(R.id.toolbar) Toolbar mToolbar;

    @Inject
    ApiInterface api;

    //views - testing out butterknife
    @InjectView(R.id.recycler)
    RecyclerView courseRecycler;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        ButterKnife.inject(this);

        setSupportActionBar(mToolbar);

        app.component.inject(this);
        courseRecycler.setLayoutManager(new LinearLayoutManager(MainActivity.this));
        courseRecycler.setAdapter(new CoursesAdapter(new ArrayList<Course>(), this));

        api.listCourses(new Callback<CourseResponse>() {
            @Override
            public void success(CourseResponse courseResponse, Response response) {
                Log.d(TAG, "success");
                courseRecycler.setLayoutManager(new LinearLayoutManager(MainActivity.this));
                courseRecycler.setAdapter(new CoursesAdapter(courseResponse.getCourses(), MainActivity.this));
            }

            @Override
            public void failure(RetrofitError error) {
                Log.w(TAG, "failure", error.getCause());
            }
        });
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_main, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();

        //noinspection SimplifiableIfStatement
        if (id == R.id.action_settings) {
            return true;
        }

        return super.onOptionsItemSelected(item);
    }
}
