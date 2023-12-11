import java.util.ArrayList;

public class ContactHolder {

    private ArrayList<StaffContact> staff;
    private ArrayList<EmergencyContact> emergency;

    public ContactHolder(ArrayList<StaffContact> staff, ArrayList<EmergencyContact> emergency){
        this.emergency = emergency;
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
            if (mainString.contains(substring)) {
                return true;
            }
        }
        return false;
    }
    
    public void setEmergency(ArrayList<EmergencyContact> emergency) {
        this.emergency = emergency;
    }

    public void setStaff(ArrayList<StaffContact> staff) {
        this.staff = staff;
    }

    public ArrayList<EmergencyContact> getEmergency() {
        return emergency;
    }

    public ArrayList<StaffContact> getStaff() {
        return staff;
    }
}