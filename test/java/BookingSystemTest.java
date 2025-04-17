import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.awt.print.Book;
import java.util.List;
import java.util.Scanner;

import static org.junit.jupiter.api.Assertions.*;

public class BookingSystemTest {
    @BeforeEach
    void cleardata()
    {
        BookingSystem.getPatientList().clear();
        BookingSystem.getPhysiotherapistList().clear();
    }
    @Test
    void testAddingandremovingpatient()
    {
        BookingSystem.InitializeData();
        List<Physiotherapist> physiotherapistList = BookingSystem.getPhysiotherapistList();
        assertEquals(1 , physiotherapistList.size());
        assertEquals("Dr Qasim" , physiotherapistList.get(0).getPhysiotherapist_name());


    }
    @Test
    void testpatient()
    {
        List<Patient> patientList = BookingSystem.getPatientList();
        assertTrue(patientList.isEmpty());
        Patient patient = new Patient("Qasim" , "12/05/1998" , "Address" , "+44302939");
        patientList.add(patient);
        assertEquals(1, patientList.size());
    }
}

