package by.medvedeva.anastasiya.nailservicemarina.domain.interaction;

import java.util.List;

import by.medvedeva.anastasiya.nailservicemarina.domain.entity.TimeSlot;
import by.medvedeva.anastasiya.nailservicemarina.domain.interaction.base.UseCase;
import io.reactivex.Observable;

/**
 * Created by Medvedeva Anastasiya
 * on 19.09.2017.
 */

public class TimeSlotsGetterUseCase extends UseCase <Void, List<TimeSlot>> {
    @Override
    protected Observable<List<TimeSlot>> buildUseCase(Void aVoid) {
        return null;
    }
}
