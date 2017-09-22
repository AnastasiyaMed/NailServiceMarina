package by.medvedeva.anastasiya.nailservicemarina.adapters;

import android.databinding.ObservableField;
import android.util.Log;

import by.medvedeva.anastasiya.nailservicemarina.base.BaseItemViewModel;
import by.medvedeva.anastasiya.nailservicemarina.domain.entity.TimeSlot;


/**
 * Created by Medvedeva Anastasiya
 * on 18.08.2017.
 */

public class TimeItemViewModel extends BaseItemViewModel<TimeSlot> {
    public ObservableField<String> time = new ObservableField<>("");

    @Override
    public void setItem(TimeSlot item, int position) {
        Log.e("AAA", "ITEM " + position);
        Log.e("AAA", "ITEM time" + item.getTime());
        time.set(item.getTime());
    }



}
