package by.medvedeva.anastasiya.nailservicemarina.adapters;

import android.databinding.BindingAdapter;
import android.databinding.ObservableField;
import android.widget.ImageView;

import com.bumptech.glide.Glide;

import by.medvedeva.anastasiya.nailservicemarina.base.BaseItemViewModel;

/**
 * Created by Medvedeva Anastasiya
 * on 25.09.2017.
 */

public class GalaryItemViewModel extends BaseItemViewModel<String> {
    public ObservableField<String> imageUrl = new ObservableField<>("");


    @Override
    public void setItem(String item, int position) {
        imageUrl.set(item);

    }


    @BindingAdapter("bind:src")
    public static void setImage(final ImageView image, String imageUrl) {
        Glide.with(image.getContext()).load(imageUrl).into(image);
    }

    @Override
    public void reservedEvent(String s) {

    }


}
