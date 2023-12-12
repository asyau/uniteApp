import java.util.Calendar;

public class Announcement {
    Calendar time;
    String organize;
    String eventInformation;

    public Announcement(Calendar time, String organize, String eventInformation) {
        this.time = time;
        this.organize = organize;
        this.eventInformation = eventInformation;
    }

    public Calendar getTime() {
        return time;
    }

    public String getOrganize() {
        return organize;
    }

    public String getEventInformation() {
        return eventInformation;
    }
}