package by.medvedeva.anastasiya.nailservicemarina.adapters;

import android.databinding.ObservableField;
import android.util.Log;

import by.medvedeva.anastasiya.nailservicemarina.base.BaseItemViewModel;


/**
 * Created by Medvedeva Anastasiya
 * on 18.08.2017.
 */

public class TimeItemViewModel extends BaseItemViewModel<String> {
    public ObservableField<String> time = new ObservableField<>("");

    @Override
    public void setItem(String item, int position) {
        Log.e("AAA", "ITEM " + position);
        Log.e("AAA", "ITEM time" + item);
        time.set(item);
    }


    @Override
    public void reservedEvent(String s) {

    }
}
