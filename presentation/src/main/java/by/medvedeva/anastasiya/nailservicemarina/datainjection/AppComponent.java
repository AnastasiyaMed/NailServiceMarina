package by.medvedeva.anastasiya.nailservicemarina.datainjection;

import javax.inject.Singleton;

import by.medvedeva.anastasiya.nailservicemarina.adapters.GalaryItemViewModel;
import dagger.Component;

/**
 * Created by Medvedeva Anastasiya
 * on 25.09.2017.
 */

@Component(modules = AppModule.class)
@Singleton
public interface AppComponent {

public void inject (GalaryItemViewModel galaryItemViewModel);
}
