package by.medvedeva.anastasiya.nailservicemarina.activities;

import android.databinding.DataBindingUtil;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.widget.GridLayoutManager;
import android.support.v7.widget.LinearLayoutManager;

import by.medvedeva.anastasiya.nailservicemarina.R;
import by.medvedeva.anastasiya.nailservicemarina.base.BaseActivity;
import by.medvedeva.anastasiya.nailservicemarina.databinding.ActivityGalaryBinding;

/**
 * Created by Medvedeva Anastasiya
 * on 24.09.2017.
 */

public class GalaryActivity extends BaseActivity {

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        final GalaryViewModel viewModel = new GalaryViewModel(this);
        this.viewModel = viewModel;

        ActivityGalaryBinding binding = DataBindingUtil.setContentView(this, R.layout.activity_galary);
        binding.setViewModel(viewModel);
        binding.recyclerView.setLayoutManager(new LinearLayoutManager(this));
        binding.recyclerView.setAdapter(viewModel.adapter);
        super.onCreate(savedInstanceState);
    }
}
