package by.medvedeva.anastasiya.nailservicemarina.activities;

import android.content.Context;
import android.databinding.ObservableField;
import android.os.Bundle;
import android.support.v4.app.Fragment;

import by.medvedeva.anastasiya.nailservicemarina.base.BaseFragmentViewModel;

import static android.R.attr.id;

/**
 * Created by Medvedeva Anastasiya
 * on 20.09.2017.
 */

public class TimeChoiceFragmentViewModel implements BaseFragmentViewModel {

    private Fragment fragment;
    public ObservableField<String> name = new ObservableField<>("");
    public ObservableField<String> phone = new ObservableField<>("");
    public ObservableField<String> email = new ObservableField<>("");
    private String date;
    private String time;


    public TimeChoiceFragmentViewModel(Fragment fragment) {
        this.fragment = fragment;
    }

    @Override
    public void init() {

    }

    @Override
    public void onCreateView() {

    }

    @Override
    public void onViewCreated() {
        Bundle bundle = fragment.getArguments();
        if (bundle != null) {
            date = bundle.getString("DATE");
            time = bundle.getString("TIME");
        }


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

    public void onSuperButtonClick(Context context) {
    }


}
