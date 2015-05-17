package nz.co.jonker.dagger2trial.data;

import com.google.gson.FieldNamingPolicy;
import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.google.gson.JsonDeserializationContext;
import com.google.gson.JsonDeserializer;
import com.google.gson.JsonElement;
import com.google.gson.JsonParseException;

import java.lang.reflect.Type;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.TimeZone;

import javax.inject.Singleton;

import dagger.Module;
import dagger.Provides;
import retrofit.RestAdapter;
import retrofit.client.OkClient;
import retrofit.converter.GsonConverter;

/**
 * Created by datacom_mobile01 on 15/05/15.
 */
@Module
public class DataModule {
    private static final String ENDPOINT = "https://www.udacity.com/public-api/v0";

    @Provides
    @Singleton
    Gson provideGson() {
        Gson gson = new GsonBuilder()
                .setFieldNamingPolicy(FieldNamingPolicy.LOWER_CASE_WITH_UNDERSCORES)
                .registerTypeAdapter(Date.class, new JsonDeserializer<Date>() {
                    SimpleDateFormat df = new SimpleDateFormat("yyyy-MM-dd'T'HH:mm:ss.SSS");

                    @Override
                    public Date deserialize(JsonElement json, Type typeOfT, JsonDeserializationContext context) throws JsonParseException {
                        try {
                            //there must be a simpler way to do this, but I couldn't see it...
                            Date date = df.parse(json.getAsString());
                            Date newDate = new Date(date.getTime() + TimeZone.getDefault().getOffset(date.getTime()));
                            return newDate;
                        } catch (ParseException e) {
                            return null;
                        }
                    }
                })
                .create();
        return gson;
    }

    @Provides @Singleton
    RestAdapter provideRestAdapter(Gson gson) {
        return new RestAdapter.Builder()
                .setClient(new OkClient())
                .setEndpoint(ENDPOINT)
                .setConverter(new GsonConverter(gson))
                .build();
    }
}
