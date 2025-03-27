public class Appointment {
    public static int next_bookingId = 1;

    public int bookingId;
    private Patient patient;
    private Physiotherapist physiotherapist;
    private String treatmentName;
    private String treatmentDate;
    private String appointmentStatus;

    public Appointment( Patient p  , Physiotherapist physiotherapist ,  String treatmentName, String treatmentDate)
    {
        this.bookingId = next_bookingId++;
        this.patient = p;
        this.physiotherapist = physiotherapist;
        this.treatmentName = treatmentName;
        this.treatmentDate = treatmentDate;
        this.appointmentStatus = "booked";

    }
    private int getBookingId() {
        return bookingId;

    }
    public Patient getPatient() {
        return patient;
    }
    public Physiotherapist getPhysiotherapist() {
        return physiotherapist;
    }
    public String getTreatmentName() {
        return treatmentName;
    }
    public String getTreatmentDate() {
        return treatmentDate;

    }
    public String getAppointmentStatus() {
        return appointmentStatus;
    }

    public void setStatus(String status) {
        this.appointmentStatus = status;
    }

    public String getDetails ()
    {
        return "Booking ID" + bookingId + "\n"+
                "Patient : " + patient.getPatientName() + "(ID : " + patient.getPatientID() + ")\n"+
                "Physiotherapist : " + physiotherapist.getPhysiotherapist_name()  + "( ID: "  + physiotherapist.getPhysiotherapist_id() + ")\n"+
                "Treatment : " +  treatmentName + "\n" +
                "Date/Time : " + treatmentDate + "\n" +
                "Status : " + appointmentStatus;

    }

    public static void main (String[] args) {
        Patient p = new Patient("qasim" , "2/2" , "al10 9wx" , "=440749332");
        Physiotherapist p1 = new Physiotherapist("Dr ALi" , "AL" , "1029");
        Appointment APP = new Appointment(p , p1 , "pjys" , "thursday");
        System.out.println(APP.getDetails());

        Patient pp = new Patient("qasim" , "2/2" , "al10 9wx" , "=440749332");
        Physiotherapist p2 = new Physiotherapist("Dr ALi" , "AL" , "1029");
        Appointment APPp = new Appointment(p , p1 , "pjys" , "thursday");
        System.out.println(APPp.getDetails());
    }


}
