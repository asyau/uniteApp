package mainpack.deneme;

import java.util.ArrayList;

public class ContactHolder {

    private ArrayList<StaffContact> staff;

    public ContactHolder(ArrayList<StaffContact> staff){
        this.staff = staff;
    }

    public ArrayList<StaffContact> filterStaff(String searchKey){
        String[] searchWords = searchKey.split(" ");
        ArrayList<StaffContact> output = new ArrayList<>();
        for (StaffContact s : this.staff) {
            if (containsAny(s.getName(), searchWords) || containsAny(s.getTitle(), searchWords) || containsAny(s.getDepartment(), searchWords)) {
                output.add(s);
            }
        }
        return output;
    }

    public static boolean containsAny(String mainString, String[] stringsToCheck) {
        for (String substring : stringsToCheck) {
            if (mainString.toLowerCase().contains(substring.toLowerCase())) {
                return true;
            }
        }
        return false;
    }

    public void setStaff(ArrayList<StaffContact> staff) {
        this.staff = staff;
    }

    public ArrayList<StaffContact> getStaff() {
        return staff;
    }
}