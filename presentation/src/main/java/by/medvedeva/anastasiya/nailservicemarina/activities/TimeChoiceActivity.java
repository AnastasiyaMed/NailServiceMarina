package by.medvedeva.anastasiya.nailservicemarina.activities;

import android.databinding.DataBindingUtil;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.widget.LinearLayoutManager;

import by.medvedeva.anastasiya.nailservicemarina.R;
import by.medvedeva.anastasiya.nailservicemarina.base.BaseFragmentActivity;
import by.medvedeva.anastasiya.nailservicemarina.databinding.ActivityTimeChoiceBinding;

/**
 * Created by Medvedeva Anastasiya
 * on 18.09.2017.
 */

public class TimeChoiceActivity extends BaseFragmentActivity implements TimeChoiceFragment.onTimeReservedListener {

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        final TimeChoiceViewModel viewModel = new TimeChoiceViewModel(this);
        this.viewModel = viewModel;

        ActivityTimeChoiceBinding binding = DataBindingUtil.setContentView(this, R.layout.activity_time_choice);
        binding.setViewModel(viewModel);


        binding.recyclerView.setLayoutManager(new LinearLayoutManager(this));
        binding.recyclerView.setAdapter(viewModel.adapter);
        super.onCreate(savedInstanceState);
    }

    @Override
    public void reservedEvent(String s) {
        viewModel.reservedEvent(s);
    }
}
