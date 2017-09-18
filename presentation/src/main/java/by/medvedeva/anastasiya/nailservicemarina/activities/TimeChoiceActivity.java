package by.medvedeva.anastasiya.nailservicemarina.activities;

import android.databinding.DataBindingUtil;
import android.os.Bundle;
import android.support.annotation.Nullable;

import by.medvedeva.anastasiya.nailservicemarina.R;
import by.medvedeva.anastasiya.nailservicemarina.base.BaseActivity;
import by.medvedeva.anastasiya.nailservicemarina.databinding.ActivityTimeChoiceBinding;

/**
 * Created by Medvedeva Anastasiya
 * on 18.09.2017.
 */

public class TimeChoiceActivity extends BaseActivity {

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        final TimeChoiceViewModel viewModel = new TimeChoiceViewModel(this);
        this.viewModel = viewModel;
        ActivityTimeChoiceBinding binding = DataBindingUtil.setContentView(this, R.layout.activity_time_choice);
        binding.setViewModel(viewModel);
        super.onCreate(savedInstanceState);
    }
}
