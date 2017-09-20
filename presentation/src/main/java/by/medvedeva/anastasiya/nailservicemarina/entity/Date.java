package by.medvedeva.anastasiya.nailservicemarina.entity;

import android.util.SparseArray;

/**
 * Created by Medvedeva Anastasiya
 * on 20.09.2017.
 */

public class Date {
    private SparseArray<String> daysOfWeek;
    private SparseArray<String> monthsOfYear;

    public Date() {
        this.daysOfWeek = initWeek();
        this.monthsOfYear = initMonthsOfYear();
    }

    public SparseArray<String> getDayOfWeek() {
        return daysOfWeek;
    }


    public SparseArray<String> getMonthsOfYear() {
        return monthsOfYear;
    }

    private SparseArray<String> initWeek() {
        SparseArray<String> daysOfWeek = new SparseArray<>();
        daysOfWeek.put(1, "Sunday");
        daysOfWeek.put(2, "Monday");
        daysOfWeek.put(3, "Tuesday");
        daysOfWeek.put(4, "Wednesday");
        daysOfWeek.put(5, "Thursday");
        daysOfWeek.put(6, "Friday");
        daysOfWeek.put(7, "Saturday");
        return daysOfWeek;
    }

    private SparseArray<String> initMonthsOfYear() {
        SparseArray<String> monthsOfYear = new SparseArray<>();
        monthsOfYear.put(0, "January");
        monthsOfYear.put(1, "February");
        monthsOfYear.put(2, "March");
        monthsOfYear.put(3, "April");
        monthsOfYear.put(4, "May");
        monthsOfYear.put(5, "June");
        monthsOfYear.put(6, "July");
        monthsOfYear.put(7, "August");
        monthsOfYear.put(8, "September");
        monthsOfYear.put(9, "October");
        monthsOfYear.put(10, "November");
        monthsOfYear.put(11, "December");
        return monthsOfYear;
    }
}
