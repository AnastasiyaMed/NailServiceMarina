package by.medvedeva.anastasiya.nailservicemarina.datainjection;

import javax.inject.Singleton;

import by.medvedeva.anastasiya.nailservicemarina.activities.GalaryViewModel;
import by.medvedeva.anastasiya.nailservicemarina.activities.TimeChoiceFragmentViewModel;
import by.medvedeva.anastasiya.nailservicemarina.activities.TimeChoiceViewModel;
import by.medvedeva.anastasiya.nailservicemarina.adapters.GalaryItemViewModel;
import dagger.Component;

/**
 * Created by Medvedeva Anastasiya
 * on 25.09.2017.
 */

@Component(modules = AppModule.class)
@Singleton
public interface AppComponent {

    void inject(GalaryViewModel viewModel);

    void inject(TimeChoiceFragmentViewModel viewModel);

    void inject(TimeChoiceViewModel viewModel);


}
