package by.medvedeva.anastasiya.nailservicemarina.domain.interaction;

import javax.inject.Inject;

import by.medvedeva.anastasiya.nailservicemarina.data.entity.TimeSlotData;
import by.medvedeva.anastasiya.nailservicemarina.data.net.RestService;
import by.medvedeva.anastasiya.nailservicemarina.domain.entity.TimeSlot;
import by.medvedeva.anastasiya.nailservicemarina.domain.interaction.base.UseCase;
import io.reactivex.Observable;

/**
 * Created by Medvedeva Anastasiya
 * on 21.09.2017.
 */

public class TimeSlotSaverUseCase extends UseCase<TimeSlot, TimeSlotData> {
    private RestService restService;

    @Inject
    public TimeSlotSaverUseCase(RestService restService) {
        this.restService = restService;
    }

    @Override
    protected Observable<TimeSlotData> buildUseCase(TimeSlot timeSlot) {

        TimeSlotData timeSlotData = new TimeSlotData();
        timeSlotData.setCalendarDate(timeSlot.getCalendarDate());
        timeSlotData.setEmail(timeSlot.getEmail());
        timeSlotData.setFullName(timeSlot.getFullName());
        timeSlotData.setPhone(timeSlot.getPhone());
        timeSlotData.setTime(timeSlot.getTime());


        return restService.saveTimeSlot(timeSlotData);
    }
}
