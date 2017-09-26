package by.medvedeva.anastasiya.nailservicemarina.data.net;

import java.util.List;

import by.medvedeva.anastasiya.nailservicemarina.data.entity.ImageData;
import by.medvedeva.anastasiya.nailservicemarina.data.entity.TimeSlotData;
import io.reactivex.Observable;
import retrofit2.Retrofit;

/**
 * Created by Medvedeva Anastasiya
 * on 20.09.2017.
 */

public class RestService {
    private RestApi restApi;

    public RestService(Retrofit retrofit) {
        restApi = retrofit.create(RestApi.class);
    }



    public Observable<List<TimeSlotData>> getAllTimeSlots() {
        return restApi.getAllTimeSlots();
    }

    public Observable<List<TimeSlotData>> getTimeSlots(String calendarDate) {
        return restApi.getTimeSlots("calendar_date=".concat("'").concat(calendarDate).concat("'"));
    }

    public Observable<TimeSlotData> saveTimeSlot(TimeSlotData timeSlotData) {
        return restApi.saveTimeSlot(timeSlotData);
    }

    // IMAGES FOR GALARY
    public Observable<List<ImageData>> getAllImages() {
        return restApi.getAllImages();
    }


}
