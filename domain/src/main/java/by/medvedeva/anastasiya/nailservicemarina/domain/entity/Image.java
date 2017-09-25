package by.medvedeva.anastasiya.nailservicemarina.domain.entity;

/**
 * Created by Medvedeva Anastasiya
 * on 25.09.2017.
 */

public class Image implements DomainModel {
    private String url;


    public String getUrl() {
        return url;
    }

    public void setUrl(String url) {
        this.url = url;
    }

    public Image() {
    }
}
