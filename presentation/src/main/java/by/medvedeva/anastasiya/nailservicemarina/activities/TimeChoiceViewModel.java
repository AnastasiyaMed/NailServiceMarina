package by.medvedeva.anastasiya.nailservicemarina.activities;

import android.content.Intent;
import android.databinding.ObservableField;
import android.os.Bundle;
import android.support.v4.app.FragmentActivity;
import android.support.v4.app.FragmentTransaction;
import android.util.Log;

import java.util.ArrayList;
import java.util.List;

import by.medvedeva.anastasiya.nailservicemarina.R;
import by.medvedeva.anastasiya.nailservicemarina.adapters.TimeChoiceAdapter;
import by.medvedeva.anastasiya.nailservicemarina.base.BaseViewModel;
import by.medvedeva.anastasiya.nailservicemarina.domain.entity.TimeSlot;
import by.medvedeva.anastasiya.nailservicemarina.domain.interaction.TimeSlotsGetterUseCase;
import by.medvedeva.anastasiya.nailservicemarina.utility_entity.AvailableTimes;
import io.reactivex.annotations.NonNull;
import io.reactivex.observers.DisposableObserver;

/**
 * Created by Medvedeva Anastasiya
 * on 18.09.2017.
 */

public class TimeChoiceViewModel implements BaseViewModel {
    private static final String DAY = "DAY";
    private static final String MONTH = "MONTH";
    private static final String YEAR = "YEAR";
    private static final String BUSY_TIMES = "BUSY_TIMES";
    private List<String> times = new ArrayList<>();

    public enum STATE {PROGRESS, DATA}

    private FragmentActivity activity;
    public ObservableField<STATE> state = new ObservableField<>(STATE.PROGRESS);
    public ObservableField<String> date = new ObservableField<>("");
    TimeChoiceAdapter adapter = new TimeChoiceAdapter(times);
    private TimeSlotsGetterUseCase useCase = new TimeSlotsGetterUseCase();

    TimeChoiceViewModel(FragmentActivity activity) {
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


        // take needed date from calendarActivity
        Intent intent = activity.getIntent();

        String calendarDate = (String.valueOf(intent.getIntExtra(DAY, 0)))
                .concat("/")
                .concat(String.valueOf(1 + intent.getIntExtra(MONTH, 0)))
                .concat("/")
                .concat(String.valueOf(intent.getIntExtra(YEAR, 0)));
        // set date to activity
        date.set(calendarDate);

        // take busy times from backendless
        useCase.execute(calendarDate, new DisposableObserver<List<TimeSlot>>() {
            @Override
            public void onNext(@NonNull List<TimeSlot> timeSlots) {
                Log.e(BUSY_TIMES, timeSlots.toString());
                // form the free times.
                // Delete busy times from list available times. And set it to field times.
                AvailableTimes availableTimes = new AvailableTimes();
                times.addAll(availableTimes.getAvalibleTimes());
                if (timeSlots.size() != 0) {
                    for (TimeSlot timeSlot : timeSlots)
                        times.remove(timeSlot.getTime());
                }

                if (times.size() == 0) {
                    String ALL_TIMES_ARE_BUSY = activity.getString(R.string.all_times_are_busy);
                    times.add(ALL_TIMES_ARE_BUSY);
                }

                adapter.setItems(times);
                state.set(STATE.DATA);
            }

            @Override
            public void onError(@NonNull Throwable e) {
            }

            @Override
            public void onComplete() {
            }
        });

        adapter.setOnItemClickListener(new TimeChoiceAdapter.OnItemClickListener() {
            @Override
            public void onItemClick(String time) {
                if (!times.get(0).equals(activity.getString(R.string.all_times_are_busy))) { // костыль, чтобы не срабатывал клин на сообщение о том, что все таймслоты заняты
                    TimeChoiceFragment fragment = new TimeChoiceFragment();
                    FragmentTransaction fragmentTransaction = activity.getSupportFragmentManager().beginTransaction();
                    fragmentTransaction.replace(R.id.container, fragment, TimeChoiceFragment.class.getName());
                    Bundle bundle = new Bundle();
                    bundle.putString("TIME", time);
                    bundle.putString("DATE", date.get());
                    fragment.setArguments(bundle);
                    //       fragmentTransaction.addToBackStack(null);
                    fragmentTransaction.commit();
                }
            }
        });

    }

    @Override
    public void pause() {

    }

}
