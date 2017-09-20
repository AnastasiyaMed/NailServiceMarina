package by.medvedeva.anastasiya.nailservicemarina.data.net;

import java.util.List;

import by.medvedeva.anastasiya.nailservicemarina.data.entity.TimeSlotData;
import io.reactivex.Observable;
import retrofit2.http.GET;
import retrofit2.http.Query;

/**
 * Created by Medvedeva Anastasiya
 * on 20.09.2017.
 */

interface RestApi {

    @GET("data/time_slots")
    Observable<List<TimeSlotData>> getAllTimeSlots();

    @GET("data/time_slots")
    Observable<List<TimeSlotData>> getTimeSlots(@Query("where") String calendarDate);

}
