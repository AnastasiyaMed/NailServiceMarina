package by.medvedeva.anastasiya.nailservicemarina.data.net;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;

import java.util.List;
import java.util.concurrent.TimeUnit;

import by.medvedeva.anastasiya.nailservicemarina.data.entity.TimeSlotData;
import io.reactivex.Observable;
import okhttp3.OkHttpClient;
import okhttp3.logging.HttpLoggingInterceptor;
import retrofit2.Retrofit;
import retrofit2.adapter.rxjava2.RxJava2CallAdapterFactory;
import retrofit2.converter.gson.GsonConverterFactory;

/**
 * Created by Medvedeva Anastasiya
 * on 20.09.2017.
 */

public class RestService {
    private static final RestService instance = new RestService();
    private RestApi restApi;

    private RestService() {
        init();
    }

    public static RestService getInstance() {
        return instance;
    }

    private void init() {

        //это для логгирования
        HttpLoggingInterceptor logging = new HttpLoggingInterceptor();
        logging.setLevel(HttpLoggingInterceptor.Level.BODY);

        OkHttpClient okHttpClient = new OkHttpClient.Builder()
                .readTimeout(10, TimeUnit.SECONDS)
                .connectTimeout(10, TimeUnit.SECONDS)
                .addInterceptor(logging)
                .build();

        Gson gson = new GsonBuilder().create();

        Retrofit retrofit = new Retrofit.Builder()
                .baseUrl("https://api.backendless.com/415554AC-F1F9-576A-FF45-F6A8FA63D400/73D25C01-BFAC-F36B-FF96-6DE3108DBE00/")
                .addCallAdapterFactory(RxJava2CallAdapterFactory.create())
                .addConverterFactory(GsonConverterFactory.create(gson))
                .client(okHttpClient).build();

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


}
