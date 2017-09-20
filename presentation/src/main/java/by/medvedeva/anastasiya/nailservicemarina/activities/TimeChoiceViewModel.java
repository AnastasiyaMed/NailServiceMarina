package by.medvedeva.anastasiya.nailservicemarina.activities;

import android.app.Activity;
import android.content.Intent;
import android.util.Log;

import java.util.ArrayList;
import java.util.List;

import by.medvedeva.anastasiya.nailservicemarina.adapters.TimeChoiceAdapter;
import by.medvedeva.anastasiya.nailservicemarina.base.BaseViewModel;
import by.medvedeva.anastasiya.nailservicemarina.domain.entity.TimeSlot;
import by.medvedeva.anastasiya.nailservicemarina.domain.interaction.TimeSlotsGetterUseCase;
import io.reactivex.annotations.NonNull;
import io.reactivex.observers.DisposableObserver;

/**
 * Created by Medvedeva Anastasiya
 * on 18.09.2017.
 */

public class TimeChoiceViewModel implements BaseViewModel {
    public static final String DAY = "DAY";
    public static final String MONTH = "MONTH";
    public static final String YEAR = "YEAR";

    public enum STATE {PROGRESS, DATA}

    private Activity activity;

    TimeChoiceAdapter adapter = new TimeChoiceAdapter();
    TimeSlotsGetterUseCase useCase = new TimeSlotsGetterUseCase();

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

        Intent intent = activity.getIntent();


        String calendarDate = (String.valueOf(intent.getIntExtra(YEAR, 0)))
                .concat(" ")
                .concat(String.valueOf(intent.getIntExtra(MONTH, 0)))
                .concat(" ")
                .concat(String.valueOf(intent.getIntExtra(DAY, 0)));

        useCase.execute(calendarDate, new DisposableObserver<List<TimeSlot>>() {
            @Override
            public void onNext(@NonNull List<TimeSlot> timeSlots) {
                if (timeSlots.size() != 0) {
                    Log.e("BBB", timeSlots.toString());
                }
            }

            @Override
            public void onError(@NonNull Throwable e) {

            }

            @Override
            public void onComplete() {

            }
        });


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
