package mainpack.deneme;

import java.util.Calendar;

public class Announcement {
    Calendar time;
    String organizer;
    String eventInformation;
    String place;

    public Announcement(Calendar time, String organizer, String eventInformation, String place) {
        this.time = time;
        this.organizer = organizer;
        this.eventInformation = eventInformation;
        this.place = place;
    }
    public Calendar getTime() {
        return time;
    }

    public String getOrganizer() {
        return organizer;
    }

    public String getEventInformation() {
        return eventInformation;
    }

    public String getPlace() {return place;}
}