import java.util.ArrayList;
import java.util.Calendar;

public class AnnouncementHolder {
    Calendar minDate;
    Calendar maxDate;
    String minString, maxString;
    ArrayList<Announcement> anns;

    public AnnouncementHolder(ArrayList<Announcement> anns) {
        this.anns = anns;
        minDate = (Calendar) Application.currentTime.clone();
        maxDate = (Calendar) Application.currentTime.clone();
        maxDate.add(Calendar.DATE, 7);
        minString = calToString(minDate);
        maxString = calToString(maxDate);
    }

    private String calToString(Calendar cal) {
        String result = "";
        int day = cal.get(Calendar.DATE);
        int month = cal.get(Calendar.MONTH) + 1;
        int year = cal.get(Calendar.YEAR) % 100;

        if (day / 10 == 0) {
            result += "0"+day+"/";
        }
        else {
            result += day+"/";
        }
        if (month / 10 == 0) {
            result += "0"+month+"/";
        }
        else {
            result += month+"/";
        }
        result += year;

        return result;
    }

    private void weekForward() {
        maxDate.add(Calendar.DATE, 7);
        minDate.add(Calendar.DATE, 7);
        minString = calToString(minDate);
        maxString = calToString(maxDate);
    }
    private void weekBackward() {
        maxDate.add(Calendar.DATE, -7);
        minDate.add(Calendar.DATE, -7);
        minString = calToString(minDate);
        maxString = calToString(maxDate);
    }

    public ArrayList<Announcement> filter() {
        ArrayList<Announcement> result = new ArrayList<>();
        for (Announcement ann : anns) {
            if (ann.getTime().after(minDate) && ann.getTime().before(maxDate))
                result.add(ann);
        }

        return result;
    }



}