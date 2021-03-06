package nz.co.jonker.dagger2trial;

import javax.inject.Singleton;

import dagger.Component;
import nz.co.jonker.dagger2trial.data.DataModule;
import nz.co.jonker.dagger2trial.data.OnlineDataModule;
import nz.co.jonker.dagger2trial.ui.MainActivity;

/**
 * Created by datacom_mobile01 on 15/05/15.
 */
@Singleton
@Component(modules = {BaseModule.class, DataModule.class, OnlineDataModule.class})
public interface DataComponent {

    void inject(MainActivity mainActivity);
    void inject(BaseApp baseApp);
}
