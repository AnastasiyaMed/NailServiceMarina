package by.medvedeva.anastasiya.nailservicemarina.datainjection;

import android.content.Context;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;

import java.util.concurrent.TimeUnit;

import javax.inject.Singleton;

import by.medvedeva.anastasiya.nailservicemarina.data.net.RestService;
import by.medvedeva.anastasiya.nailservicemarina.domain.interaction.ImagesGetterUseCase;
import by.medvedeva.anastasiya.nailservicemarina.domain.interaction.TimeSlotSaverUseCase;
import by.medvedeva.anastasiya.nailservicemarina.domain.interaction.TimeSlotsGetterUseCase;
import dagger.Module;
import dagger.Provides;
import okhttp3.OkHttpClient;
import okhttp3.logging.HttpLoggingInterceptor;
import retrofit2.Retrofit;
import retrofit2.adapter.rxjava2.RxJava2CallAdapterFactory;
import retrofit2.converter.gson.GsonConverterFactory;

/**
 * Created by Medvedeva Anastasiya
 * on 25.09.2017.
 */

@Module
public class AppModule {

    private Context context;


    public AppModule(Context context) {
        this.context = context;
    }

    @Provides
    Context provideContext() {
        return context;
    }

    @Provides
    ImagesGetterUseCase provideImagesGetterUseCase(RestService restService) {
        return new ImagesGetterUseCase(restService);
    }

    @Provides
    TimeSlotSaverUseCase provideTimeSlotSaverUseCase(RestService restService) {
        return new TimeSlotSaverUseCase(restService);
    }

    @Provides
    TimeSlotsGetterUseCase provideTimeSlotsGetterUseCase(RestService restService) {
        return new TimeSlotsGetterUseCase(restService);
    }

    @Provides
    @Singleton
    OkHttpClient provideOkHttp() {
        HttpLoggingInterceptor logging = new HttpLoggingInterceptor();
        logging.setLevel(HttpLoggingInterceptor.Level.BODY);

        OkHttpClient okHttpClient = new OkHttpClient.Builder()
                .readTimeout(10, TimeUnit.SECONDS)
                .connectTimeout(10, TimeUnit.SECONDS)
                .addInterceptor(logging)
                .build();

        return okHttpClient;
    }

    @Provides
    @Singleton
    Gson provideGson() {
        return new GsonBuilder().create();
    }

    @Provides
    @Singleton
    Retrofit provideRetrofit(Gson gson, OkHttpClient okHttpClient) {

        return new Retrofit.Builder()
                .baseUrl("https://api.backendless.com/415554AC-F1F9-576A-FF45-F6A8FA63D400/73D25C01-BFAC-F36B-FF96-6DE3108DBE00/")
                .addCallAdapterFactory(RxJava2CallAdapterFactory.create())
                .addConverterFactory(GsonConverterFactory.create(gson))
                .client(okHttpClient).build();
    }

    @Provides
    @Singleton
    RestService provideRestService(Retrofit retrofit) {
        return new RestService(retrofit);
    }
}
