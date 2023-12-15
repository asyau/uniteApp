package mainpack.deneme;

import java.util.Calendar;

public class Announcement {
    Calendar time;
    String organizer;
    String eventInformation;

    public Announcement(Calendar time, String organizer, String eventInformation) {
        this.time = time;
        this.organizer = organizer;
        this.eventInformation = eventInformation;
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
}