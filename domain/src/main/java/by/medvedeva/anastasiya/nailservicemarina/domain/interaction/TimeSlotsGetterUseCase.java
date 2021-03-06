package by.medvedeva.anastasiya.nailservicemarina.domain.interaction;

import android.util.Log;

import java.util.ArrayList;
import java.util.List;

import javax.inject.Inject;

import by.medvedeva.anastasiya.nailservicemarina.data.entity.TimeSlotData;
import by.medvedeva.anastasiya.nailservicemarina.data.net.RestService;
import by.medvedeva.anastasiya.nailservicemarina.domain.entity.TimeSlot;
import by.medvedeva.anastasiya.nailservicemarina.domain.interaction.base.UseCase;
import io.reactivex.Observable;
import io.reactivex.annotations.NonNull;
import io.reactivex.functions.Function;

/**
 * Created by Medvedeva Anastasiya
 * on 19.09.2017.
 */

public class TimeSlotsGetterUseCase extends UseCase<String, List<TimeSlot>> {
    private static final String LOG_TAG = "log_tag";
    private RestService restService;

    @Inject
    public TimeSlotsGetterUseCase(RestService restService) {
        this.restService = restService;

    }

    @Override
    protected Observable<List<TimeSlot>> buildUseCase(String calendarDate) {
        return restService.getTimeSlots(calendarDate).map(new Function<List<TimeSlotData>, List<TimeSlot>>() {
            @Override
            public List<TimeSlot> apply(@NonNull List<TimeSlotData> timeSlotDataList) throws Exception {
                List<TimeSlot> timeSlotList = new ArrayList<>();
                if (timeSlotDataList.size() != 0) {
                    for (TimeSlotData timeslotData : timeSlotDataList) {
                        timeSlotList.add(convert(timeslotData));
                    }
                } else {
                    Log.e(LOG_TAG, "List is empty");
                }
                return timeSlotList;
            }
        });
    }

    private TimeSlot convert(TimeSlotData timeslotData) {
        TimeSlot timeSlot = new TimeSlot();
        timeSlot.setCalendarDate(timeslotData.getCalendarDate());
        timeSlot.setEmail(timeslotData.getEmail());
        timeSlot.setFullName(timeslotData.getFullName());
        timeSlot.setId(timeslotData.getId());
        timeSlot.setPhone(timeslotData.getPhone());
        timeSlot.setTime(timeslotData.getTime());
        return timeSlot;
    }
}
