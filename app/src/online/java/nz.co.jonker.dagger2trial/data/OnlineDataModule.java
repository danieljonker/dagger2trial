package nz.co.jonker.dagger2trial.data;


import javax.inject.Singleton;

import dagger.Module;
import dagger.Provides;

import retrofit.RestAdapter;


/**
 * Created by datacom_mobile01 on 15/05/15.
 */
@Module
public class OnlineDataModule {
    @Provides @Singleton
    ApiInterface provideApiInterface(RestAdapter restAdapter){
        return restAdapter.create(ApiInterface.class);
    }
}
