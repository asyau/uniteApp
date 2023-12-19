package mainpack.deneme;

import java.sql.*;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.TimeZone;

public class Question {
    private String heading;
    private String info;
    private Calendar postDate;
    private User owner;
    private int tag;
    private String timePassed;

    private int questionID;
    public static int count = 0;

    public Question(String heading, String info, int tag, Calendar postDate, User owner){
        this.heading = heading;
        this.info = info;
        this.tag = tag;
        this.postDate = postDate;
        this.owner = owner;
        questionID=count;
        count++;
        long timeDiff = Calendar.getInstance(TimeZone.getTimeZone("Europe/Istanbul")).getTimeInMillis() - postDate.getTimeInMillis();
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
            timeDiff = Calendar.getInstance(TimeZone.getTimeZone("Europe/Istanbul")).getTimeInMillis() - postDate.getTimeInMillis();
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

    public String getTimePassed() { return timePassed; }
    public String getHeading() {
        return heading;
    }

    public String getInfo() {
        return info;
    }

    public Calendar getPostDate() {
        return postDate;
    }

    public User getOwner() {
        return owner;
    }
    public int getTag() {return tag;}
    public int getQuestionID() {
        return questionID;
    }

}
