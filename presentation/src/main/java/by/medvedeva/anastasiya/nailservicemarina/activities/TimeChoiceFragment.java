package by.medvedeva.anastasiya.nailservicemarina.activities;

import android.content.Context;
import android.databinding.DataBindingUtil;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import by.medvedeva.anastasiya.nailservicemarina.R;
import by.medvedeva.anastasiya.nailservicemarina.adapters.TimeChoiceAdapter;
import by.medvedeva.anastasiya.nailservicemarina.base.BaseFragment;
import by.medvedeva.anastasiya.nailservicemarina.databinding.FragmentTimeChoiceBinding;

/**
 * Created by Medvedeva Anastasiya
 * on 20.09.2017.
 */

public class TimeChoiceFragment extends BaseFragment {

    public interface onTimeReservedListener {
        public void reservedEvent(String s);
    }

    public onTimeReservedListener timeReservedListener;



    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        this.viewModel = new TimeChoiceFragmentViewModel(this);
        super.onCreate(savedInstanceState);
    }

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        FragmentTimeChoiceBinding binding = DataBindingUtil.inflate(inflater, R.layout.fragment_time_choice, container, false);
        binding.setViewModel((TimeChoiceFragmentViewModel) viewModel);
        return binding.getRoot();
    }

    @Override
    public void onViewCreated(View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
    }

    @Override
    public void onAttach(Context context) {
        super.onAttach(context);
        try {
            timeReservedListener = (onTimeReservedListener) context;
        } catch (ClassCastException e) {
            throw new ClassCastException(getActivity().toString() + " must implement onTimeReservedListener");
        }
    }
}
