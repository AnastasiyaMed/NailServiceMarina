package by.medvedeva.anastasiya.nailservicemarina.domain.interaction;

import by.medvedeva.anastasiya.nailservicemarina.data.entity.TimeSlotData;
import by.medvedeva.anastasiya.nailservicemarina.domain.entity.TimeSlot;
import by.medvedeva.anastasiya.nailservicemarina.domain.interaction.base.UseCase;
import io.reactivex.Observable;

/**
 * Created by Medvedeva Anastasiya
 * on 21.09.2017.
 */

public class TimeSlotSaverUseCase extends UseCase <TimeSlot, TimeSlotData> {
    @Override
    protected Observable<TimeSlotData> buildUseCase(TimeSlot timeSlot) {
        return null;
    }
}
