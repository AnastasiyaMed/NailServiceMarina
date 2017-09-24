package by.medvedeva.anastasiya.nailservicemarina.adapters;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import java.util.List;

import by.medvedeva.anastasiya.nailservicemarina.activities.GalaryViewModel;
import by.medvedeva.anastasiya.nailservicemarina.base.BaseAdapter;
import by.medvedeva.anastasiya.nailservicemarina.base.BaseItemViewHolder;

/**
 * Created by Medvedeva Anastasiya
 * on 25.09.2017.
 */

public class GalaryAdapter extends BaseAdapter<String, GalaryItemViewModel> {
    private List<String> images;

    public GalaryAdapter(List<String> images) {
        this.images = images;
    }


    @Override
    public GalaryViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        GalaryItemViewModel itemViewModel = new GalaryItemViewModel();
        return GalaryViewHolder.create(LayoutInflater.from(parent.getContext()),
                parent, itemViewModel);
    }
}
