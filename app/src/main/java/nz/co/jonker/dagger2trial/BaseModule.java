package nz.co.jonker.dagger2trial;

import android.content.Context;

import javax.inject.Singleton;

import dagger.Module;
import dagger.Provides;

/**
 * Created by jonker on 16/05/15.
 */
@Module
public class BaseModule {
    private final BaseApp application;

    public BaseModule(BaseApp application) {
        this.application = application;
    }

    @Provides
    @Singleton
    Context provideApplicationContext() {
        return this.application;
    }

}
