package nz.co.jonker.dagger2trial;

import android.app.Application;import java.lang.Override;

import nz.co.jonker.dagger2trial.data.DataModule;

/**
 * Created by datacom_mobile01 on 15/05/15.
 */
public class BaseApp extends Application {
    DataComponent component;

    @Override
    public void onCreate() {
        super.onCreate();

        component = DaggerDataComponent.builder().dataModule(new DataModule(this)).build();
        component.inject(this);
    }
}
