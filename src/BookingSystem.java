import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

//TIP To <b>Run</b> code, press <shortcut actionId="Run"/> or
// click the <icon src="AllIcons.Actions.Execute"/> icon in the gutter.
public class BookingSystem {

    private static List<Physiotherapist>  physiotherapistList = new ArrayList<>();
    private static List<Patient> patientList = new ArrayList<>();
    public static void main(String[] args) {

        InitializeData();
        menu();

    }

    private static void InitializeData()
    {
        //HARDCODED PHYSIOTHERAPISTS AT THE START OF THE PROJECT
        Physiotherapist p1 = new Physiotherapist("Dr Qasim" , "AL10 9WX" , "+4423909182");

        p1.addExpertise("Message Therapy");
        p1.addtimetable("Message Therapy" , "2025-05-01" , "10:00 - 11:00" );
        physiotherapistList.add(p1);

    }

    private static void menu()
    {
        Scanner scanner = new Scanner(System.in);
        int choice = -1;

        while (choice != 0) {
            System.out.println("Booking System Menu");
            System.out.println("1. Add Patient");
            System.out.println("2. Remove Patient");
            System.out.println("3. Booking Appointment");
            System.out.println("4. Change or Canel Appointment");
            System.out.println("5. Attend Appointment");
            System.out.println("6. Print Appointment");
            System.out.println("0. Exit");
            System.out.print("Enter your choice: ");
            try {
                choice = Integer.parseInt(scanner.nextLine());

            }
            catch (Exception e) {
                System.out.println("Please enter a valid choice");
                continue;

            }
            switch (choice) {
                case 1:
                    addPatient(scanner);
                    break;
                    case 2:
                        removePatient(scanner);
                        break;

                   case 3:
                       bookappointment(scanner);
            }

        }
    }

    private  static void addPatient(Scanner scanner)
    {
        System.out.println("Enter Patient Name");
        String name = scanner.nextLine();
        System.out.println("Enter Patient DOB eg (DD/MM/YYYY)");
        String dob = scanner.nextLine();
        System.out.println("Enter Patient Address");
        String address = scanner.nextLine();
        System.out.println("Enter Patient Phone Number");
        String phone = scanner.nextLine();
        patientList.add(new Patient(name, dob, address, phone));
        System.out.println("Patient Added");


    }

    private static void removePatient(Scanner scanner)
    {
        System.out.println("All Patients");
        for (Patient patient : patientList) {
            System.out.println(patient.GetDetails());
        }
        System.out.println("Enter Patient Id to remove");
        int id = Integer.parseInt(scanner.nextLine());
        Patient patienttoremove = null;
        for (Patient patient : patientList) {
            if (patient.getPatientID() == id) {
                patienttoremove = patient;
                break;
            }

        }
        if (patienttoremove != null) {
            patientList.remove(patienttoremove);
            System.out.println("Patient Removed Successfully");
        }
        else {
            System.out.println("Patient Not Found");
        }
    }
    private static void bookappointment(Scanner scanner)
    {
        System.out.println("Booking Appointment");
        System.out.println("Enter Patient Id to Book");
        int id = Integer.parseInt(scanner.nextLine());
        Patient selectedpatient = null;
        for (Patient patient : patientList) {
            if (patient.getPatientID() == id) {
                selectedpatient = patient;
                break;
            }
        }
        if (selectedpatient == null) {
            System.out.println("Patient not found");
            return;
        }
        System.out.println("Look Appointment By");
        System.out.println("1. Expertise");
        System.out.println("2. Physiotherapist Name");
        int choice = Integer.parseInt(scanner.nextLine());
        List <Physiotherapist> allmatchingphysiotherapists= new ArrayList<>();
        if (choice == 1) {
            System.out.println("Enter Expertise");
            String expertise = scanner.nextLine();
            for (Physiotherapist p : physiotherapistList) {
               for (String Exp : p.getExpertise()) {
                   if (expertise.equalsIgnoreCase(Exp)) {
                       allmatchingphysiotherapists.add(p);
                       break;
                   }
               }
            }
        }
        else if (choice == 2) {
            System.out.println("Enter Physiotherapist Name");
            String physiotherapistName = scanner.nextLine();
            for (Physiotherapist p : physiotherapistList) {
                if(p.getPhysiotherapist_name().equalsIgnoreCase(physiotherapistName))
                {
                    allmatchingphysiotherapists.add(p);
                }
            }

        }
        else {
            System.out.println("Invalid Lookup Method");
            return;
        }

        if (allmatchingphysiotherapists.isEmpty()) {
            System.out.println("no matching physiotherapist");
        }
        System.out.println("Matching Physiotherapists");
        for (Physiotherapist p : allmatchingphysiotherapists) {
            System.out.println("Physiotherapist ID" + p.getPhysiotherapist_id() +"Physiotherapist Name: " + p.getPhysiotherapist_name());
        }
        System.out.println("Enter Physiotherapist ID to Book");
        int selectedphysiotherapistID = Integer.parseInt(scanner.nextLine());
        Physiotherapist selectedphysiotherapist = null;
        for (Physiotherapist p : allmatchingphysiotherapists)
        {
         if (p.getPhysiotherapist_id() == selectedphysiotherapistID) {
             selectedphysiotherapist = p;
             break;
         }

        }
        if (selectedphysiotherapist == null) {
            System.out.println("Physiotherapist not found");
            return;
        }
        List<String> available_slots = selectedphysiotherapist.getTimeTable();
        if (available_slots.isEmpty()) {
            System.out.println("no Available Slots");
            return;
        }
        System.out.println("Available Slots");
        for (int i = 0; i < available_slots.size(); i++) {
            System.out.println((i + 1 ) +". " +available_slots.get(i));
        }
        System.out.println("Selected a Slot");
        int selectedslotID = Integer.parseInt(scanner.nextLine());
        if (selectedslotID < 1  ||  selectedslotID > available_slots.size()) {
            System.out.println("Invalid Slot ID");
            return;
        }
        String SelectedSlot = available_slots.get(selectedslotID - 1);
        boolean bookingconflict = false;
        for(Appointment appointment : selectedpatient.getAppointments()) {
            if(appointment.getTreatmentDate().equalsIgnoreCase(SelectedSlot)) {
                bookingconflict = true;
                break;
            }
        }
        if(bookingconflict)
        {
            System.out.println("Booking conflict you already have an appointment at that time");
            return;
        }

        System.out.println("Enter the treatment name for confirmation");
        String treatmentName = scanner.nextLine();
        Appointment appointment = new Appointment(selectedpatient , selectedphysiotherapist , treatmentName ,SelectedSlot );
        selectedpatient.AddAppointment(appointment);
        System.out.println("Appointment Added For " +selectedpatient.getPatientName()+" Treatment : " + treatmentName);






    }

}