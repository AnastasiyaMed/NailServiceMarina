package by.medvedeva.anastasiya.nailservicemarina.datainjection;

import android.content.Context;

import dagger.Module;
import dagger.Provides;

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
    public  Context provideContext(){
        return context;
    }
}
