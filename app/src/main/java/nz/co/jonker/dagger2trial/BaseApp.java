package nz.co.jonker.dagger2trial;

import android.app.Application;import java.lang.Override;

/**
 * Created by datacom_mobile01 on 15/05/15.
 */
public class BaseApp extends Application {
    DataComponent component;

    @Override
    public void onCreate() {
        super.onCreate();

        component = DaggerDataComponent.create();
        component.inject(this);
    }
}
