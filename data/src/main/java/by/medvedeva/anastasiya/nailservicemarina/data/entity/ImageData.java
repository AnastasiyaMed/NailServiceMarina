package by.medvedeva.anastasiya.nailservicemarina.data.entity;

import com.google.gson.annotations.SerializedName;

/**
 * Created by Medvedeva Anastasiya
 * on 25.09.2017.
 */

public class ImageData implements DataModel {
    @SerializedName("url")
    private String imageUrl;

    public String getImageUrl() {
        return imageUrl;
    }

    public void setImageUrl(String imageUrl) {
        this.imageUrl = imageUrl;
    }

    public ImageData(String imageUrl) {
        this.imageUrl = imageUrl;
    }
}
