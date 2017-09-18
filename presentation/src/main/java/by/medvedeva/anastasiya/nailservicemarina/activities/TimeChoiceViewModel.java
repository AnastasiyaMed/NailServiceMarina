package by.medvedeva.anastasiya.nailservicemarina.activities;

import android.app.Activity;

import by.medvedeva.anastasiya.nailservicemarina.base.BaseViewModel;

/**
 * Created by Medvedeva Anastasiya
 * on 18.09.2017.
 */

public class TimeChoiceViewModel implements BaseViewModel {
    public enum STATE {PROGRESS, DATA}

    private Activity activity;

    public TimeChoiceViewModel(Activity activity) {
        this.activity = activity;
    }

    @Override
    public void init() {

    }

    @Override
    public void release() {

    }

    @Override
    public void resume() {

    }

    @Override
    public void pause() {

    }
}
