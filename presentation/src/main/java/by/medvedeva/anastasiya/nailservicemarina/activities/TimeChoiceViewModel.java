package by.medvedeva.anastasiya.nailservicemarina.activities;

import android.app.Activity;

import java.util.ArrayList;
import java.util.List;

import by.medvedeva.anastasiya.nailservicemarina.adapters.TimeChoiceAdapter;
import by.medvedeva.anastasiya.nailservicemarina.base.BaseViewModel;
import by.medvedeva.anastasiya.nailservicemarina.domain.entity.TimeSlot;

/**
 * Created by Medvedeva Anastasiya
 * on 18.09.2017.
 */

public class TimeChoiceViewModel implements BaseViewModel {

    public enum STATE {PROGRESS, DATA}

    private Activity activity;

    TimeChoiceAdapter adapter = new TimeChoiceAdapter();

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

        //Tecтовые данные
        TimeSlot time0 = new TimeSlot();
        time0.setTime("9:00-11:00");
        TimeSlot time1 = new TimeSlot();
        time1.setTime("11:00-13:00");
        TimeSlot time2 = new TimeSlot();
        time2.setTime("13:00-15:00");
        TimeSlot time3 = new TimeSlot();
        time3.setTime("15:00-17:00");
        TimeSlot time4 = new TimeSlot();
        time4.setTime("17:00-19:00");
        TimeSlot time5 = new TimeSlot();
        time5.setTime("19:00-21:00");

        List<TimeSlot> times = new ArrayList<>();
        times.add(time0);
        times.add(time1);
        times.add(time2);
        times.add(time3);
        times.add(time4);
        times.add(time5);

        adapter.setItems(times);

    }

    @Override
    public void pause() {

    }
}
