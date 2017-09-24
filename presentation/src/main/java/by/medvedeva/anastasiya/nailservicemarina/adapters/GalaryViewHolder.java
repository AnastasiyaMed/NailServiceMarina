package by.medvedeva.anastasiya.nailservicemarina.adapters;

import android.view.LayoutInflater;
import android.view.ViewGroup;

import by.medvedeva.anastasiya.nailservicemarina.base.BaseItemViewHolder;
import by.medvedeva.anastasiya.nailservicemarina.databinding.ItemGalaryBinding;
import by.medvedeva.anastasiya.nailservicemarina.databinding.ItemTimeBinding;

/**
 * Created by Medvedeva Anastasiya
 * on 25.09.2017.
 */

public class GalaryViewHolder extends BaseItemViewHolder<String, GalaryItemViewModel, ItemGalaryBinding> {

    public GalaryViewHolder(ItemGalaryBinding binding, GalaryItemViewModel viewModel) {
        super(binding, viewModel);
        binding.setViewModel(viewModel);
    }

    static GalaryViewHolder create(LayoutInflater inflater, ViewGroup parent,
                                   GalaryItemViewModel viewModel) {
        ItemGalaryBinding binding = ItemGalaryBinding.inflate(inflater, parent, false);
        return new GalaryViewHolder(binding, viewModel);
    }
}
