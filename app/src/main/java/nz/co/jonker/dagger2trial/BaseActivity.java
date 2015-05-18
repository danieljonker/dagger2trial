package nz.co.jonker.dagger2trial;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;

public abstract class BaseActivity extends AppCompatActivity {
    public BaseApp app;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        app = (BaseApp) getApplication();
    }
}
