package mainpack.deneme;

import java.util.Calendar;
import java.util.TimeZone;

public class Reply {
    private String content;
    private Calendar replyDate;
    private User owner;
    private String timePassed;

    public Reply(String content, User owner, Calendar replyDate){
        this.content = content;
        this.owner = owner;
        this.replyDate = replyDate;
        long timeDiff = Calendar.getInstance(TimeZone.getTimeZone("Europe/Istanbul")).getTimeInMillis() - replyDate.getTimeInMillis();
        timeDiff /= (24 * 60 * 60 * 1000);
        System.out.println(timeDiff);
        if (timeDiff / 365 == 1) {
            timePassed = String.format("%d year ago", timeDiff / 365);
        }
        else if (timeDiff / 365 != 0) {
            timePassed = String.format("%d years ago", timeDiff / 365);
        }
        else if (timeDiff / 30 == 1) {
            timePassed = String.format("%d month ago", timeDiff / 30);
        }
        else if (timeDiff / 30 != 0) {
            timePassed = String.format("%d months ago", timeDiff / 30);
        }
        else if (timeDiff / 7 == 1) {
            timePassed = String.format("%d week ago", timeDiff / 7);
        }
        else if (timeDiff / 7 != 0) {
            timePassed = String.format("%d weeks ago", timeDiff / 7);
        }
        else if (timeDiff == 1) {
            timePassed = String.format("%d day ago", timeDiff);
        }
        else if (timeDiff != 0) {
            timePassed = String.format("%d days ago", timeDiff);
        }
        else {
            timeDiff = Calendar.getInstance(TimeZone.getTimeZone("Europe/Istanbul")).getTimeInMillis() - replyDate.getTimeInMillis();
            timeDiff /= 1000;
            if (timeDiff / 3600 == 1) {
                timePassed = String.format("%d hour ago", timeDiff / 3600);
            }
            else if (timeDiff / 3600 != 0) {
                timePassed = String.format("%d hours ago", timeDiff / 3600);
            }
            else if(timeDiff / 60 == 1) {
                timePassed = String.format("%d minute ago", timeDiff / 60);
            }
            else if(timeDiff / 60 != 0) {
                timePassed = String.format("%d minutes ago", timeDiff / 60);
            }
            else if(timeDiff == 1) {
                timePassed = String.format("%d second ago", timeDiff);
            }
            else {
                timePassed = String.format("%d seconds ago", timeDiff);
            }
        }
    }

    public Calendar getReplyDate() {
        return replyDate;
    }

    public String getContent() {
        return content;
    }

    public User getOwner() {
        return owner;
    }
    public String getTimePassed() { return timePassed; }
}
