package nz.co.jonker.dagger2trial.data;


import javax.inject.Singleton;

import dagger.Module;
import dagger.Provides;
import retrofit.MockRestAdapter;
import retrofit.RestAdapter;

/**
 * Created by datacom_mobile01 on 15/05/15.
 */
@Module
public class OfflineDataModule {

    @Provides @Singleton
    MockRestAdapter provideMockRestAdapter(RestAdapter restAdapter) {
        MockRestAdapter mockRestAdapter = MockRestAdapter.from(restAdapter);
        return mockRestAdapter;
    }

    @Provides @Singleton
    ApiInterface provideApiInterface(MockRestAdapter mockRestAdapter, MockApiImpl mockApi) {
        return mockRestAdapter.create(ApiInterface.class, mockApi);
    }
}
