package by.medvedeva.anastasiya.nailservicemarina.adapters;

import android.view.LayoutInflater;
import android.view.ViewGroup;


import by.medvedeva.anastasiya.nailservicemarina.base.BaseAdapter;
import by.medvedeva.anastasiya.nailservicemarina.domain.entity.TimeSlot;


/**
 * Created by Medvedeva Anastasiya
 * on 18.08.2017.
 */

public class TimeChoiceAdapter extends BaseAdapter<TimeSlot, TimeItemViewModel> {


    @Override
    public TimeItemViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        TimeItemViewModel itemViewModel = new TimeItemViewModel();
        return TimeItemViewHolder.create(LayoutInflater.from(parent.getContext()),
                parent, itemViewModel);
    }

}
