package by.medvedeva.anastasiya.nailservicemarina.adapters;

import android.view.LayoutInflater;
import android.view.ViewGroup;

import by.medvedeva.anastasiya.nailservicemarina.base.BaseItemViewHolder;
import by.medvedeva.anastasiya.nailservicemarina.databinding.ItemTimeBinding;

/**
 * Created by Medvedeva Anastasiya
 * on 18.08.2017.
 */

class TimeItemViewHolder extends BaseItemViewHolder<String,
        TimeItemViewModel, ItemTimeBinding> {

    private TimeItemViewHolder(ItemTimeBinding binding, TimeItemViewModel viewModel) {
        super(binding, viewModel);
        binding.setViewModel(viewModel);
    }

    static TimeItemViewHolder create(LayoutInflater inflater, ViewGroup parent,
                                     TimeItemViewModel viewModel) {
        ItemTimeBinding binding = ItemTimeBinding.inflate(inflater, parent, false);
        return new TimeItemViewHolder(binding, viewModel);
    }


}
