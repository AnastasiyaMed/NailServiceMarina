package by.medvedeva.anastasiya.nailservicemarina.activities;

import android.databinding.ObservableField;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.util.Log;

import by.medvedeva.anastasiya.nailservicemarina.R;
import by.medvedeva.anastasiya.nailservicemarina.base.BaseFragmentViewModel;
import by.medvedeva.anastasiya.nailservicemarina.data.entity.TimeSlotData;
import by.medvedeva.anastasiya.nailservicemarina.domain.entity.TimeSlot;
import by.medvedeva.anastasiya.nailservicemarina.domain.interaction.TimeSlotSaverUseCase;
import io.reactivex.annotations.NonNull;
import io.reactivex.observers.DisposableObserver;

/**
 * Created by Medvedeva Anastasiya
 * on 20.09.2017.
 */

public class TimeChoiceFragmentViewModel implements BaseFragmentViewModel {
    public enum STATE {PROGRESS, DATA}


    private TimeChoiceFragment fragment;
    public ObservableField<String> name = new ObservableField<>("");
    public ObservableField<String> phone = new ObservableField<>("");
    public ObservableField<String> email = new ObservableField<>("");
    public ObservableField<String> success = new ObservableField<>("");
    public ObservableField<STATE> state = new ObservableField<>(STATE.PROGRESS);

    private String date;
    private String time;
    private TimeSlotSaverUseCase useCase = new TimeSlotSaverUseCase();


    TimeChoiceFragmentViewModel(Fragment fragment) {
        this.fragment = (TimeChoiceFragment) fragment;
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
        if (useCase != null) {
            useCase.dispose();
        }

    }

    public void onSuperButtonClick() {
        final TimeSlot timeSlot = new TimeSlot();
        timeSlot.setFullName(name.get());
        timeSlot.setTime(time);
        timeSlot.setPhone(phone.get());
        timeSlot.setCalendarDate(date);
        timeSlot.setEmail(email.get());
        useCase.execute(timeSlot, new DisposableObserver<TimeSlotData>() {
            @Override
            public void onNext(@NonNull TimeSlotData timeSlotData) {
                state.set(STATE.DATA);
                success.set(fragment.getString(R.string.success).concat(" ").concat(timeSlot.getCalendarDate()).concat(" ").concat(timeSlot.getTime().concat(" ").concat(timeSlot.getFullName())));
                fragment.timeReservedListener.reservedEvent(time);
            }

            @Override
            public void onError(@NonNull Throwable e) {
                Log.e("AAA", e.getMessage());
                state.set(STATE.DATA);
                success.set(fragment.getString(R.string.error));
            }

            @Override
            public void onComplete() {

            }
        });
    }
}
