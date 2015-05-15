package nz.co.jonker.dagger2trial;

import javax.inject.Singleton;

import dagger.Component;
import nz.co.jonker.dagger2trial.data.DataModule;
import nz.co.jonker.dagger2trial.data.OfflineDataModule;

/**
 * Created by datacom_mobile01 on 15/05/15.
 */
@Singleton
@Component(modules = {DataModule.class, OfflineDataModule.class})
public interface DataComponent {

    void inject(MainActivity mainActivity);
    void inject(BaseApp baseApp);
}
