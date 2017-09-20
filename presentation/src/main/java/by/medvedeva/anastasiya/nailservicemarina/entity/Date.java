package by.medvedeva.anastasiya.nailservicemarina.entity;

import java.util.HashMap;

/**
 * Created by Medvedeva Anastasiya
 * on 20.09.2017.
 */

public class Date {
    private HashMap<Integer, String> daysOfWeek;
    private HashMap<Integer, String> monthsOfYear;

    public HashMap<Integer, String> getDayOfWeek() {
        return daysOfWeek;
    }


    public HashMap<Integer, String> getMonthsOfYear() {
        return monthsOfYear;
    }

    private HashMap<Integer, String> initWeek() {

        daysOfWeek.put(1, "Sunday");
        daysOfWeek.put(2, "Monday");
        daysOfWeek.put(3, "Tuesday");
        daysOfWeek.put(4, "Wednesday");
        daysOfWeek.put(5, "Thursday");
        daysOfWeek.put(6, "Friday");
        daysOfWeek.put(7, "Saturday");
        return daysOfWeek;
    }
}
