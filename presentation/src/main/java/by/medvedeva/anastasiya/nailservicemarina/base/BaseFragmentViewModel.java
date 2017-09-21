package by.medvedeva.anastasiya.nailservicemarina.base;

/**
 * Created by Medvedeva Anastasiya
 * on 09.09.2017.
 */

public interface BaseFragmentViewModel {
    void init();

    void onCreateView();

    void onViewCreated();

    void release();


    void resume();


    void pause();

}
