package by.medvedeva.anastasiya.nailservicemarina.domain.entity;

/**
 * Created by Medvedeva Anastasiya
 * on 19.09.2017.
 */

public class TimeSlot implements DomainModel {

    private String calendarDate;
    private String time;
    private String fullName;
    private String phone;
    private String email;
    private String id;

    public TimeSlot() {
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
