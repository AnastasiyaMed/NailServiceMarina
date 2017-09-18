package by.medvedeva.anastasiya.nailservicemarina.activities;


import android.app.Activity;
import android.databinding.ObservableField;
import android.databinding.ObservableLong;
import android.util.Log;
import android.widget.Toast;

import java.text.DateFormat;

import by.medvedeva.anastasiya.nailservicemarina.base.BaseViewModel;

public class CalendarViewModel  implements BaseViewModel, DateHandler {

    public enum STATE {PROGRESS, DATA}


    private Activity activity;
    public ObservableLong date = new ObservableLong(System.currentTimeMillis());
    public ObservableField<STATE> state = new ObservableField<>(STATE.PROGRESS);

    public CalendarViewModel(Activity activity) {
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

        Log.e("AAA", String.valueOf(date.get()));

        //  Toast.makeText(activity, day.get().toString(), Toast.LENGTH_LONG).show();
    }

    @Override
    public void pause() {

    }

    public void onSuperButtonClick() {
        Toast.makeText(activity, String.valueOf(date.get()), Toast.LENGTH_LONG).show();
        Log.e("AAAA", String.valueOf(date.get()));
    }

    @Override
    public void onSelectedDayChange() {
        Long day = date.get();
       // Long date = view.getDate();
        DateFormat df =DateFormat.getDateInstance();
        String selectedDate = df.format(day);
        Toast.makeText(activity, selectedDate, Toast.LENGTH_LONG).show();
    }
}
