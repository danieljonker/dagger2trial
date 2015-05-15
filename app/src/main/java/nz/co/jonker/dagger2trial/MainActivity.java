package nz.co.jonker.dagger2trial;

import android.support.v7.app.ActionBarActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

import javax.inject.Inject;

import butterknife.ButterKnife;
import butterknife.InjectView;
import nz.co.jonker.dagger2trial.data.ApiInterface;
import nz.co.jonker.dagger2trial.data.GenderResponse;
import retrofit.Callback;
import retrofit.RetrofitError;
import retrofit.client.Response;


public class MainActivity extends ActionBarActivity {
    public static final String TAG = "MainActivity";
    @Inject
    ApiInterface api;

    BaseApp app;

    //views - testing out butterknife
    @InjectView(R.id.name_et)
    EditText etName;
    @InjectView(R.id.submit) Button submit;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        ButterKnife.inject(this);

        app = (BaseApp) getApplication();
        app.component.inject(this);

        submit.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                api.checkGender(etName.getText().toString(), new Callback<GenderResponse>() {
                    @Override
                    public void success(GenderResponse apiResponse, Response response) {
                        Log.d(TAG, "success: \n" + apiResponse.toString());
                    }

                    @Override
                    public void failure(RetrofitError error) {
                        Log.w(TAG, "failure: " + error.getMessage(), error.getCause());
                    }
                });
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
