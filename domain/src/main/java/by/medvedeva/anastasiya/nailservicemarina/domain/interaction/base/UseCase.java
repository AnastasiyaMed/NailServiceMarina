package by.medvedeva.anastasiya.nailservicemarina.domain.interaction.base;

import by.medvedeva.anastasiya.nailservicemarina.domain.entity.TimeSlot;
import io.reactivex.Observable;
import io.reactivex.android.schedulers.AndroidSchedulers;
import io.reactivex.disposables.Disposable;
import io.reactivex.observers.DisposableObserver;
import io.reactivex.schedulers.Schedulers;

/**
 * Created by Medvedeva Anastasiya
 * on 19.09.2017.
 */

public abstract class UseCase<InParam, OutParam> {
    private Disposable disposable;

    protected abstract Observable<OutParam> buildUseCase(InParam param);


    public TimeSlot execute(InParam param, DisposableObserver<OutParam> disposableObserver) {
        disposable = buildUseCase(param)
                .observeOn(AndroidSchedulers.mainThread())
                .subscribeOn(Schedulers.newThread())
                .subscribeWith(disposableObserver);
        return null;
    }

    public void dispose() {
        if (!disposable.isDisposed()) {
            disposable.dispose();
        }
    }
}
