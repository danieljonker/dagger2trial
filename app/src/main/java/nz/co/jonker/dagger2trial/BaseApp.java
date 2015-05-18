package nz.co.jonker.dagger2trial;

import android.app.Application;import java.lang.Override;

import uk.co.chrisjenx.calligraphy.CalligraphyConfig;

/**
 * Created by datacom_mobile01 on 15/05/15.
 */
public class BaseApp extends Application {
    public DataComponent component;

    public int mCurrentApiVersion = 0;

    @Override
    public void onCreate() {
        super.onCreate();

        component = DaggerDataComponent.builder().baseModule(new BaseModule(this)).build();
        component.inject(this);

        //set up fonts
        CalligraphyConfig.initDefault(new CalligraphyConfig.Builder()
                        .setDefaultFontPath("fonts/Roboto-Regular.ttf")
                        .setFontAttrId(R.attr.fontPath)
                        .build()
        );

        mCurrentApiVersion = android.os.Build.VERSION.SDK_INT;
    }
}
