package by.medvedeva.anastasiya.nailservicemarina.adapters;

import android.view.LayoutInflater;
import android.view.ViewGroup;

import by.medvedeva.anastasiya.nailservicemarina.base.BaseItemViewHolder;
import by.medvedeva.anastasiya.nailservicemarina.databinding.ItemTimeBinding;
import by.medvedeva.anastasiya.nailservicemarina.domain.entity.TimeSlot;

/**
 * Created by Medvedeva Anastasiya
 * on 18.08.2017.
 */

public class TimeItemViewHolder extends BaseItemViewHolder<TimeSlot,
        TimeItemViewModel, ItemTimeBinding> {

    public TimeItemViewHolder(ItemTimeBinding binding, TimeItemViewModel viewModel) {
        super(binding, viewModel);
        binding.setViewModel(viewModel);
    }

    public static TimeItemViewHolder create(LayoutInflater inflater, ViewGroup parent,
                                            TimeItemViewModel viewModel) {
        ItemTimeBinding binding = ItemTimeBinding.inflate(inflater, parent, false);
        return new TimeItemViewHolder(binding, viewModel);
    }


}
