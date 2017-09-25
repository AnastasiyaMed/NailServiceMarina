package by.medvedeva.anastasiya.nailservicemarina.activities;

import com.crashlytics.android.Crashlytics;

import io.fabric.sdk.android.Fabric;

import android.databinding.DataBindingUtil;
import android.os.Bundle;
import android.support.annotation.Nullable;

import com.crashlytics.android.Crashlytics;

import io.fabric.sdk.android.Fabric;

import by.medvedeva.anastasiya.nailservicemarina.R;
import by.medvedeva.anastasiya.nailservicemarina.base.BaseActivity;
import by.medvedeva.anastasiya.nailservicemarina.databinding.ActivityCalendarBinding;

/**
 * Created by Medvedeva Anastasiya
 * on 16.09.2017.
 */

public class CalendarActivity extends BaseActivity {

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        final CalendarViewModel viewModel = new CalendarViewModel(this);
        this.viewModel = viewModel;
        ActivityCalendarBinding binding = DataBindingUtil.setContentView(this, R.layout.activity_calendar);

        binding.setViewModel(viewModel);
        super.onCreate(savedInstanceState);
        Fabric.with(this, new Crashlytics());
        final Fabric fabric = new Fabric.Builder(this)
                .kits(new Crashlytics())
                .debuggable(true)
                .build();
        Fabric.with(fabric);

    }
}
