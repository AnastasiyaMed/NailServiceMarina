package by.medvedeva.anastasiya.nailservicemarina;

import android.app.Application;

import by.medvedeva.anastasiya.nailservicemarina.datainjection.AppComponent;
import by.medvedeva.anastasiya.nailservicemarina.datainjection.AppModule;
import by.medvedeva.anastasiya.nailservicemarina.datainjection.DaggerAppComponent;

/**
 * Created by Medvedeva Anastasiya
 * on 25.09.2017.
 */

public class AppTools extends Application {
    public static AppComponent appComponent;

    @Override
    public void onCreate() {
        super.onCreate();
        appComponent = DaggerAppComponent.builder()
                .appModule(new AppModule(this))
                .build();
    }

}
