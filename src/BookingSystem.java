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
}