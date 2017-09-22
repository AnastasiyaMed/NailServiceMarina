package by.medvedeva.anastasiya.nailservicemarina.utility_entity;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by Medvedeva Anastasiya
 * on 22.09.2017.
 */

public class AvailableTimes {

    private List<String> avalibleTimes;

    public AvailableTimes() {
        avalibleTimes = new ArrayList<>();
        avalibleTimes.add("9:00-11:00");
        avalibleTimes.add("11:00-13:00");
        avalibleTimes.add("13:00-15:00");
        avalibleTimes.add("15:00-17:00");
        avalibleTimes.add("17:00-19:00");
        avalibleTimes.add("19:00-21:00");
    }

    public List<String> getAvalibleTimes() {
        return avalibleTimes;
    }
}
