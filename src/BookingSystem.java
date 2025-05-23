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

    public static void InitializeData()
    {
        //HARDCODED PATIENTS  AT THE START OF THE PROJECT

        Patient patientone = new Patient("Qasim" , "12/05/1998" , "AL10 9WX", "+44887289392");
        Patient patienttwo = new Patient("Ali" , "12/05/1998" , "AL10 9WX", "+44887289392");
        Patient patientthree = new Patient("Hassan" , "12/05/1998" , "AL10 9WX", "+44887289392");
        Patient patientfour= new Patient("Zaid" , "12/05/1998" , "AL10 9WX", "+44887289392");
        Patient patientfive= new Patient("Juniad" , "12/05/1998" , "AL10 9WX", "+44887289392");
        Patient patientsix= new Patient("Iqbal" , "12/05/1998" , "AL10 9WX", "+44887289392");
        Patient patientseven= new Patient("Ilyas" , "12/05/1998" , "AL10 9WX", "+44887289392");
        Patient patienteight= new Patient("Shalom" , "12/05/1998" , "AL10 9WX", "+44887289392");
        Patient patientnine= new Patient("Zubaim" , "12/05/1998" , "AL10 9WX", "+44887289392");
        Patient patientten= new Patient("Naman" , "12/05/1998" , "AL10 9WX", "+44887289392");
       patientList.add(patientone);
       patientList.add(patienttwo);
       patientList.add(patientthree);
       patientList.add(patientfour);
       patientList.add(patientfive);
       patientList.add(patientsix);
       patientList.add(patientseven);
       patientList.add(patienteight);
       patientList.add(patientnine);
       patientList.add(patientten);

        //HARDCODED PHYSIOTHERAPISTS AT THE START OF THE PROJECT
        Physiotherapist p1 = new Physiotherapist("Dr Qasim" , "AL10 9WX" , "+4423909182");
        p1.addexpertise("Physiotherapy");
        p1.addTreatment("Physiotherapy", "Neural Mobilisation");
        p1.addtimetable("Physiotherapy" ,"Neural Mobilisation", "2025-05-01" , "10:00-11:00");



        physiotherapistList.add(p1);

        Physiotherapist p2 = new Physiotherapist("Dr Ali" , "AL10 9WW" , "+4423909182");
        p2.addexpertise("Osteopathy");
        p2.addTreatment("Osteopathy", "Acupuncture" );
        p2.addtimetable("Osteopathy" , "Acupuncture" ,"2025-05-01", "10:00-11:00");
        physiotherapistList.add(p2);

        Physiotherapist p3 = new Physiotherapist("Dr Ayesha" , "AL10 9WZ" , "+4423909182");
        p3.addexpertise("Rehabilitation");
        p3.addTreatment("Rehabilitation", "Pool Rehabilitation");
        p3.addtimetable("Rehabilitation" , "Pool Rehabilitation" , "2025-05-01" , "11:00-12:00" );
        physiotherapistList.add(p3);



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
            System.out.println("4. Change or Cancel Appointment");
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
                       break;
                       case 4:
                           changeorCancelappointment(scanner);
                           break;
                           case 5:
                               attendAppointment(scanner);
                               break;
                               case 6:
                                   printReport(scanner);
                                   break;
                                   case 0:
                                       System.out.println("Goodbye!");
                                       return;
                                       default:
                                           System.out.println("Please enter a valid choice");


            }

        }
    }

    private  static void addPatient(Scanner scanner)
    {
        System.out.println("Enter Patient Name");
        String name = scanner.nextLine();
        System.out.println("Enter Patient DOB Format (DD/MM/YYYY)");
        String dob = scanner.nextLine();
        System.out.println("Enter Patient Address");
        String address = scanner.nextLine();
        System.out.println("Enter Patient Phone Number");
        String phone = scanner.nextLine();
        if(!phone.matches("^((\\+44\\s?7\\d{9})|(07\\d{9}))$"))
        {
            System.out.println("Please enter a valid Uk phone number");
            return;
        }
        if(!dob.matches("^\\d{2}/\\d{2}/\\d{4}$"))
        {
            System.out.println("Please follow Date of Birth format");
            return;
        }
        for (Patient patient : patientList) {
            if(patient.getPhoneNumber().equals(phone))
            {
                System.out.println("Patient Already Exists with this phone number");
                return;
            }
        }



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
        System.out.println("All Patients");
        for (Patient patient : patientList) {
            System.out.println("Patient ID:" + " " + patient.getPatientID() + " " + "Patient Name: " + patient.getPatientName());
        }
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
        System.out.print("Enter a choice: ");
        int choice = Integer.parseInt(scanner.nextLine());
        List <Physiotherapist> allmatchingphysiotherapists= new ArrayList<>();
        List<String> AllExpertise = new ArrayList<>();
        if (choice == 1) {
            for(Physiotherapist p : physiotherapistList) {
                for(String exp : p.getExpertise()) {
                    if(!AllExpertise.contains(exp)) {
                        AllExpertise.add(exp);

                    }
                }
            }
            for(int i = 0; i < AllExpertise.size(); i++) {
                System.out.println((i + 1)+ ". " + AllExpertise.get(i));
            }
            System.out.println("Enter Expertise : ");
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
            System.out.println("Enter Physiotherapist Name : ");
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
            System.out.println("Physiotherapist ID"+ " " + p.getPhysiotherapist_id() +"Physiotherapist Name: " + p.getPhysiotherapist_name());
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

        List<String> FilteredList = new ArrayList<>();
        for(String slot : selectedphysiotherapist.getTimeTable())
        {
            boolean booked = false;
            for (Patient patient : patientList) {
                for(Appointment a : patient.getAppointments()) {
                    if(a.getPhysiotherapist().getPhysiotherapist_id() == selectedphysiotherapistID
                            && a.getTreatmentDate().equalsIgnoreCase(slot)
                            &&  a.getAppointmentStatus().equalsIgnoreCase("booked"))
                    {
                        booked = true;
                        break;
                    }
                }
                if(booked)
                    break;

            }
            if(!booked)
            {
                FilteredList.add(slot);
            }
        }
        if (FilteredList.isEmpty()) {
            System.out.println("no Available slots");
            return;

        }


//        List<String> available_slots = selectedphysiotherapist.getTimeTable();
//        if (available_slots.isEmpty()) {
//            System.out.println("no Available Slots");
//            return;
//        }
        System.out.println("Available Slots");
        for (int i = 0; i < FilteredList.size(); i++) {
            System.out.println((i + 1 ) +". " +FilteredList.get(i));
        }
        System.out.println("Selected a Slot");
        int selectedslotID = Integer.parseInt(scanner.nextLine());
        if (selectedslotID < 1  ||  selectedslotID > FilteredList.size()) {
            System.out.println("Invalid Slot ID");
            return;
        }
        String SelectedSlot = FilteredList.get(selectedslotID - 1);
        String selected_date= SelectedSlot.split(",")[1].trim()+", " + SelectedSlot.split(",")[2].trim();
        String selected_time = SelectedSlot.split(",")[1].trim();
        boolean bookingconflict = false;
        for(Appointment appointment : selectedpatient.getAppointments()) {
            String existingdate = appointment.getTreatmentDate().split(",")[1].trim()+", " + appointment.getTreatmentDate().split(",")[2].trim();
            String existingtime = appointment.getTreatmentDate().split(",")[1].trim();

            if(existingtime.equalsIgnoreCase(selected_time) && appointment.getAppointmentStatus().equalsIgnoreCase("booked")) {
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

     private static void changeorCancelappointment(Scanner scanner) {
        System.out.println("Exisiting Appointments");
        for(Patient patient : patientList) {
            for (Appointment appointment : patient.getAppointments()) {
                System.out.println(appointment.getDetails());
                System.out.println("---------------------");
            }
        }
        System.out.println("Please Enter the booking ID to Cancel Appointment or Change Appointment");
        int bookingID = Integer.parseInt(scanner.nextLine());
        Appointment selectedappointment = null;
        for(Patient patient : patientList) {
            for (Appointment appointment : patient.getAppointments()) {
                if(appointment.bookingId == bookingID) {
                    selectedappointment = appointment;
                    break;
                }
            }
            if(selectedappointment != null) {
                break;
            }

        }
        if (selectedappointment == null) {
            System.out.println("Appointment not found");
            return;
        }
        System.out.println("Appointment Found:");
        System.out.println(selectedappointment.getDetails());
        System.out.println("Select an option");
        System.out.println("1. Change appointment");
        System.out.println("2. Cancel appointment");
        int selectedoption = Integer.parseInt(scanner.nextLine());
        if (selectedoption == 1) {
            selectedappointment.setStatus("Canceled");
            System.out.println("Appointment Canceled Please book a new appointment");
            bookappointment(scanner);
        }
        else if (selectedoption == 2) {
            selectedappointment.setStatus("Canceled");
            System.out.println("Appointment Canceled");
        }
        else {
            System.out.println("Invalid Option");
        }
     }
     private static void attendAppointment(Scanner scanner) {
        for(Patient patient : patientList) {
            for (Appointment appointment : patient.getAppointments()) {
               if(appointment.getAppointmentStatus().equalsIgnoreCase("booked"))
               {
                   System.out.println(appointment.getDetails());
                   System.out.println("--------------------");
               }

            }
        }
        System.out.println("Please Enter the booking ID to Mark as attended Confirmation");
        int bookingID = Integer.parseInt(scanner.nextLine());
        Appointment selectedappointment = null;
        for(Patient patient : patientList) {
            for (Appointment appointment : patient.getAppointments()) {
                if(appointment.bookingId == bookingID) {
                    selectedappointment = appointment;
                    break;
                }
            }
            

        }
         if(selectedappointment == null) {
             System.out.println("Appointment not found");
         }
         else {
             selectedappointment.setStatus("Attended");
             System.out.println("Appointment marked as attended");
         }

     }

     private static void printReport(Scanner scanner) {
        for (Physiotherapist physiotherapist : physiotherapistList) {
            System.out.println("Physiotherapist:" +  physiotherapist.getPhysiotherapist_name());
            boolean have_appointments = false;
            for(Patient patient : patientList) {
                for (Appointment appointment : patient.getAppointments()) {
                    if(appointment.getPhysiotherapist().getPhysiotherapist_id() == physiotherapist.getPhysiotherapist_id()) {
                        System.out.println(appointment.getDetails());
                        have_appointments = true;
                    }
                }
            }
            if(!have_appointments) {
                System.out.println("No appointments found for this physiotherapist");
            }
            System.out.println("---------------------------------------------------");
        }
        SortPhysiotherapist();
     }

     private static void SortPhysiotherapist() {
        List<Physiotherapist> sortedPhysiotherapistList = new ArrayList<>(physiotherapistList);
        sortedPhysiotherapistList.sort((p1, p2) -> Integer.compare(countAttendendAppointments(p2), countAttendendAppointments(p1)));
        System.out.println("------ Physiotherapist List by  Attended Appointment ------");
        for (Physiotherapist p : sortedPhysiotherapistList) {
            System.out.println("Physiotherapist : " +  p.getPhysiotherapist_name() + "- Attended: " + countAttendendAppointments(p));
        }
     }

     private static int countAttendendAppointments(Physiotherapist physiotherapist)
     {
         int count = 0;
         for(Patient patient : patientList) {
             for (Appointment appointment : patient.getAppointments()) {
                 if(appointment.getPhysiotherapist().getPhysiotherapist_id() == physiotherapist.getPhysiotherapist_id() && appointment.getAppointmentStatus().equalsIgnoreCase("Attended")) {
                     count++;
                 }
             }
         }
         return count;

     }

     public static List<Patient> getPatientList() {
        return patientList;
     }

     public static List<Physiotherapist> getPhysiotherapistList() {
        return physiotherapistList;
     }
}