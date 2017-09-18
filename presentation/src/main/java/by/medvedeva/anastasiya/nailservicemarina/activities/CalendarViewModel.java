package by.medvedeva.anastasiya.nailservicemarina.activities;


import android.app.Activity;
import android.databinding.ObservableField;
import android.databinding.ObservableInt;
import android.util.Log;
import android.widget.CalendarView;
import android.widget.Toast;

import java.text.DateFormat;
import java.util.Calendar;

import by.medvedeva.anastasiya.nailservicemarina.R;
import by.medvedeva.anastasiya.nailservicemarina.base.BaseViewModel;

public class CalendarViewModel implements BaseViewModel {


    private Activity activity;
    public ObservableInt year = new ObservableInt();
    public ObservableInt month = new ObservableInt();
    public ObservableInt day = new ObservableInt();

    public CalendarViewModel(Activity activity) {
        this.activity = activity;
        Calendar calendar = Calendar.getInstance();
        year.set(calendar.get(Calendar.YEAR));
        month.set(calendar.get(Calendar.MONTH));
        day.set(calendar.get(Calendar.DAY_OF_MONTH));

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

    public void onSuperButtonClick() {
        if (day.get() <= Calendar.getInstance().get(Calendar.DAY_OF_MONTH) && month.get() <= Calendar.getInstance().get(Calendar.MONTH)) {
            Toast.makeText(activity, R.string.warning, Toast.LENGTH_LONG).show();
        } else {
            Log.e("AAAA", String.valueOf(year.get()));
            Log.e("AAAA", String.valueOf(month.get() + 1));
            Log.e("AAAA", String.valueOf(day.get()));
        }
    }

}
