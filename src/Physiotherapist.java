import java.util.ArrayList;
import java.util.List;
import java.time.LocalDate;
import java.util.HashMap;
import java.util.Map;
import java.time.format.DateTimeFormatter;

public class Physiotherapist {

    private static  int next_physio_id = 1;
    private final int physiotherapist_id;
    private final String physiotherapist_name;
    private final String physiotherapist_address;
    private final String physiotherapist_phone;

    private final List<String> Expertise;

    private final List<String> TimeTable;

    public Map<String, List<String>> treatmentbyExepertise;




    public Physiotherapist(String Name , String Address, String Phone ) {
        physiotherapist_id = next_physio_id++;
        this.physiotherapist_name = Name;
        this.physiotherapist_address = Address;
        this.physiotherapist_phone = Phone;
        this.Expertise = new ArrayList<>();
        this.TimeTable = new ArrayList<>();

        this.treatmentbyExepertise = new HashMap<>();

    }

    public int getPhysiotherapist_id() {
        return physiotherapist_id;
    }
    public String getPhysiotherapist_name() {
        return physiotherapist_name;
    }
    public String getPhysiotherapist_address() {
        return physiotherapist_address;
    }
    public String getPhysiotherapist_phone() {
        return physiotherapist_phone;
    }
    public List<String> getExpertise() {
        return Expertise;
    }
    public List<String> getTimeTable() {
        return TimeTable;
    }

    public void addexpertise(String expertise)
    {
        Expertise.add(expertise);
        treatmentbyExepertise.put(expertise, new ArrayList<>());
    }

    public void addTreatment(String expertise, String TreatmentName)
    {
        List<String>    tList = treatmentbyExepertise.get(expertise);
        if(tList == null)
        {
            System.out.println("No such expertise");
            return;

        }
        tList.add(TreatmentName);

    }




//    public void addExpertise(String expertise) {
//        Expertise.add(expertise);
//    }
    public void addTreatment_slot (String Slot)
    {
        TimeTable.add(Slot);
    }



    public void addtimetable(String expertise, String treatmentName ,  String Date , String Time_slot ) {

        if(!treatmentbyExepertise.containsKey(expertise)) {

            System.out.println("No such expertise");
            return;
        }
        if (!treatmentbyExepertise.get(expertise).contains(treatmentName)) {
            System.out.println("No such treatment");
            return;
        }

        LocalDate date = LocalDate.parse(Date,DateTimeFormatter.ISO_LOCAL_DATE);
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("EEEE d MMMM yyyy");

//        boolean hasexpertise = false;
//
//        for (String expertise : Expertise) {
//            if (expertise.equalsIgnoreCase(Treatment_name)) {
//                hasexpertise = true;
//                break;
//            }
//
//
//        }
//        if (!hasexpertise) {
//            System.out.println("There is no Expertise for " + Treatment_name);
//            return;
//        }

        for (int week=0; week<4; week++) {
            LocalDate day_slot = date.plusWeeks(week);
            String slot = "WEEK " + (week + 1 ) + ": " + day_slot.format(formatter) + ", " + Time_slot + ", " + treatmentName;
            if(!TimeTable.contains(slot)) {
                TimeTable.add(slot);

            }

        }
    }
    public String getDetails() {
        // Convert expertise list to a comma-separated string; if empty, show "None"
        String expertiseStr = Expertise.isEmpty() ? "None" : String.join(", ", Expertise);

        // Convert timetable list to a string separated by " | "; if empty, show "No slots available"
        String timetableStr = TimeTable.isEmpty() ? "No slots available" : String.join(" | ", TimeTable);

        // Build and return the formatted details string
        return "Physiotherapist ID: " + physiotherapist_id + "\n" +
                "Name: " + physiotherapist_name + "\n" +
                "Address: " + physiotherapist_address + "\n" +
                "Phone: " + physiotherapist_phone + "\n" +
                "Expertise: " + expertiseStr + "\n" +
                "Timetable: " + timetableStr;
    }


//    public static void main(String[] args) {
//
//         Physiotherapist physio = new Physiotherapist("Dr. Smith", "123 Clinic Road", "0123456789");
//
//         // Add expertise areas
//         physio.addexpertise("Physiotherapy");
//         physio.addexpertise("Rehabilitation");
//         physio.addexpertise("Osteopathy");
//
//         // Generate a 4-week timetable for a treatment.
//         // Format: treatmentName, startDate in "yyyy-MM-dd", timeSlot.
//         physio.addTreatment("Physiotherapy", "Massage therapy");
//         physio.addtimetable("Physiotherapy", "Massage therapy" , "2025-05-01", "10:00 - 11:00");
//
//         // Print out the physiotherapist details
//          System.out.println(physio.getDetails());
//     }

}
