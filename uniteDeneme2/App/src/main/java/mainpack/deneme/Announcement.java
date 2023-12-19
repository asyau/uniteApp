package mainpack.deneme;

import java.util.Calendar;

public class Announcement {
    Calendar time;
    String organizer;
    String eventInformation;
    String place;

    public Announcement(Calendar time, String organizer, String eventInformation, String place) {
        Calendar thisCalendar = Calendar.getInstance();
        copyCalendarProperties(time, thisCalendar);
        this.time = thisCalendar;
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

    private static void copyCalendarProperties(Calendar source, Calendar destination) {
        // Copy individual properties from the source to the destination
        destination.set(Calendar.YEAR, source.get(Calendar.YEAR));
        destination.set(Calendar.MONTH, source.get(Calendar.MONTH));
        destination.set(Calendar.DAY_OF_MONTH, source.get(Calendar.DAY_OF_MONTH));
        // ... copy other properties as needed
    }
}