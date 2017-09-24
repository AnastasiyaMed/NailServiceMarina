package by.medvedeva.anastasiya.nailservicemarina.activities;

import android.app.Activity;
import android.databinding.ObservableField;

import java.util.ArrayList;
import java.util.List;

import by.medvedeva.anastasiya.nailservicemarina.adapters.GalaryAdapter;
import by.medvedeva.anastasiya.nailservicemarina.base.BaseViewModel;

/**
 * Created by Medvedeva Anastasiya
 * on 24.09.2017.
 */

public class GalaryViewModel implements BaseViewModel {
    public enum STATE {PROGRESS, DATA}

    Activity activity;
    private List<String> images = new ArrayList<>();
    public ObservableField<STATE> state = new ObservableField<>(STATE.PROGRESS);
    GalaryAdapter adapter = new GalaryAdapter(images);

    public GalaryViewModel(Activity activity) {
        this.activity = activity;
    }

    @Override
    public void init() {

    }

    @Override
    public void release() {

    }

    @Override
    public void reservedEvent(String s) {

    }

    @Override
    public void resume() {

    }

    @Override
    public void pause() {

    }
}
