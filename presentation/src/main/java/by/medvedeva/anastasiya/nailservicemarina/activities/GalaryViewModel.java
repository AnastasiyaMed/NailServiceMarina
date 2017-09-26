package by.medvedeva.anastasiya.nailservicemarina.activities;

import android.app.Activity;
import android.databinding.ObservableField;

import java.util.ArrayList;
import java.util.List;

import javax.inject.Inject;

import by.medvedeva.anastasiya.nailservicemarina.AppTools;
import by.medvedeva.anastasiya.nailservicemarina.R;
import by.medvedeva.anastasiya.nailservicemarina.adapters.GalaryAdapter;
import by.medvedeva.anastasiya.nailservicemarina.base.BaseViewModel;
import by.medvedeva.anastasiya.nailservicemarina.domain.entity.Image;
import by.medvedeva.anastasiya.nailservicemarina.domain.interaction.ImagesGetterUseCase;
import io.reactivex.annotations.NonNull;
import io.reactivex.observers.DisposableObserver;

/**
 * Created by Medvedeva Anastasiya
 * on 24.09.2017.
 */

public class GalaryViewModel implements BaseViewModel {
    public enum STATE {PROGRESS, DATA}

    private Activity activity;
    private List<String> imageUrls = new ArrayList<>();
    public ObservableField<STATE> state = new ObservableField<>(STATE.PROGRESS);
    GalaryAdapter adapter = new GalaryAdapter(imageUrls);

    @Inject
    ImagesGetterUseCase useCase;


    GalaryViewModel(Activity activity) {
        this.activity = activity;
        AppTools.appComponent.inject(this);
    }

    @Override
    public void init() {

    }

    @Override
    public void release() {

    }


    @Override
    public void resume() {
        useCase.execute(null, new DisposableObserver<List<Image>>() {
            @Override
            public void onNext(@NonNull List<Image> images) {
                if (images.size() != 0) {
                    for (Image image : images) {
                        imageUrls.add(image.getUrl());
                    }
                }
                adapter.setItems(imageUrls);
                state.set(STATE.DATA);
            }

            @Override
            public void onError(@NonNull Throwable e) {
                imageUrls.add(activity.getString(R.string.error));
                adapter.setItems(imageUrls);
                state.set(STATE.DATA);
            }

            @Override
            public void onComplete() {

            }
        });
    }

    @Override
    public void pause() {
        useCase.dispose();
    }

    @Override
    public void reservedEvent(String s) {

    }
}
