import java.util.ArrayList;
import java.util.List;

public class Patient {
     private static int next_id = 1;
    private  int patientID;
    private String patientName;
    private String DOB;
    private String address;
    private String phoneNumber;

    private List<Appointment> appointments;
    public Patient(String patientName, String DOB, String address, String phoneNumber)
    {
        this.patientID = next_id++;
      this.patientName = patientName;
      this.DOB = DOB;
      this.address = address;
      this.phoneNumber = phoneNumber;
      this.appointments = new ArrayList<>();

    }

    public  int getPatientID() {
            return patientID;
    }


    public String getPatientName() {
        return patientName;
    }
    public String getDOB() {
        return DOB;
    }
    public String getAddress() {
        return address;
    }
    public String getPhoneNumber() {
        return phoneNumber;
    }
  public void AddAppointment(Appointment appointment) {
        appointments.add(appointment);
  }
  public  void removeAppointment(Appointment appointment) {
        if (appointments.contains(appointment)) {
            appointments.remove(appointment);
        }
        else
        {
            System.out.println("Appointment not found");
        }
  }
  public String GetDetails() {
        return "Patient Id : " + patientID + "\n" +
                "Patient Name : " + patientName + "\n" +
                "DOB : " + DOB + "\n" +
                "Address : "  + address + "\n" +
                "Phone Number : " + phoneNumber + "\n";
  }

  public static void main (String[] args) {
        Patient p1 = new Patient("Qasim" , "12-MAY-1998" , "123" , "0293939");
         Patient p2 = new Patient("Qasim" , "12-MAY-1998" , "123" , "0293939");

      List<Patient> patients = new ArrayList<>();
        patients.add(p1);
        patients.add(p2);
        for(Patient p : patients) {
            System.out.println(p.GetDetails());
        }

  }



}
