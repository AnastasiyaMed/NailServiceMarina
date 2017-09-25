package by.medvedeva.anastasiya.nailservicemarina.domain.interaction;

import android.util.Log;

import java.util.ArrayList;
import java.util.List;

import by.medvedeva.anastasiya.nailservicemarina.data.entity.ImageData;
import by.medvedeva.anastasiya.nailservicemarina.data.net.RestService;
import by.medvedeva.anastasiya.nailservicemarina.domain.entity.Image;
import by.medvedeva.anastasiya.nailservicemarina.domain.interaction.base.UseCase;
import io.reactivex.Observable;
import io.reactivex.annotations.NonNull;
import io.reactivex.functions.Function;

/**
 * Created by Medvedeva Anastasiya
 * on 25.09.2017.
 */

public class ImagesGetterUseCase extends UseCase<Void, List<Image>> {
    private static final String LOG_TAG = "log_tag";

    @Override
    protected Observable<List<Image>> buildUseCase(Void aVoid) {
        return RestService.getInstance().getAllImages().map(new Function<List<ImageData>, List<Image>>() {
            @Override
            public List<Image> apply(@NonNull List<ImageData> imageDatas) throws Exception {
                List<Image> imageList = new ArrayList<>();
                if (imageDatas.size() != 0) {
                    for (ImageData imageData : imageDatas) {
                        imageList.add(convert(imageData));
                    }
                } else {
                    Log.e(LOG_TAG, "List images is empty");
                }
                return imageList;
            }
        });
    }

    private Image convert(ImageData imageData) {
        Image image = new Image();
        image.setUrl(imageData.getImageUrl());
        return image;
    }
}
