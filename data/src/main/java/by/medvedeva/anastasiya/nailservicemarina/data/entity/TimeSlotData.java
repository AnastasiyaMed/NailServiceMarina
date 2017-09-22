package by.medvedeva.anastasiya.nailservicemarina.data.entity;

import com.google.gson.annotations.SerializedName;

/**
 * Created by Medvedeva Anastasiya
 * on 20.09.2017.
 */

public class TimeSlotData implements DataModel {
    @SerializedName("calendar_date")
    private String calendarDate;
    @SerializedName("time")
    private String time;
    @SerializedName("full_name")
    private String fullName;
    @SerializedName("phone")
    private String phone;
    @SerializedName("email")
    private String email;
    @SerializedName("objectId")
    private String id;

    public TimeSlotData() {
    }

    public String getCalendarDate() {
        return calendarDate;
    }

    public void setCalendarDate(String calendarDate) {
        this.calendarDate = calendarDate;
    }

    public String getTime() {
        return time;
    }

    public void setTime(String time) {
        this.time = time;
    }

    public String getFullName() {
        return fullName;
    }

    public void setFullName(String fullName) {
        this.fullName = fullName;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }
}
