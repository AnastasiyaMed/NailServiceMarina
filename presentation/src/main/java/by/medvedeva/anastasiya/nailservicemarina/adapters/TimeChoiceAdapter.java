package by.medvedeva.anastasiya.nailservicemarina.adapters;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import java.util.List;

import by.medvedeva.anastasiya.nailservicemarina.base.BaseAdapter;
import by.medvedeva.anastasiya.nailservicemarina.base.BaseItemViewHolder;


/**
 * Created by Medvedeva Anastasiya
 * on 18.08.2017.
 */

public class TimeChoiceAdapter extends BaseAdapter<String, TimeItemViewModel> {
    private List<String> items;

    public TimeChoiceAdapter(List<String> items) {
        this.items = items;
    }

    private OnItemClickListener onItemClickListener;

    public void setOnItemClickListener(OnItemClickListener onItemClickListener) {
        this.onItemClickListener = onItemClickListener;
    }

    @Override
    public TimeItemViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        TimeItemViewModel itemViewModel = new TimeItemViewModel();
        return TimeItemViewHolder.create(LayoutInflater.from(parent.getContext()),
                parent, itemViewModel);
    }

    @Override
    public void onBindViewHolder(BaseItemViewHolder<String, TimeItemViewModel, ?> holder, int position) {
        super.onBindViewHolder(holder, position);
        final String time = items.get(position);
        holder.itemView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (onItemClickListener != null) {
                    onItemClickListener.onItemClick(time);
                }
            }
        });
    }

    public interface OnItemClickListener {
        void onItemClick(String time);
    }

}
