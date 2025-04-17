import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

public class AppointmentTest {
    @Test
    void testAppointment() {
        Patient patient = new Patient("Test" , "01/01/2000" , "Addr" , "123");
        Physiotherapist physiotherapist = new Physiotherapist("dr Test" , "Address" , "000");
        String Treatment = "Message Therapy" ;
        String Slot = "Week 1: Thursday 1 May 2025,  10:00-11:00 , Massage Therapy";
        Appointment appointment = new Appointment(patient , physiotherapist , Treatment , Slot);
        assertEquals("booked" , appointment.getAppointmentStatus());
        assertSame(patient, appointment.getPatient());
        appointment.setStatus("attended");
        assertEquals("attended" , appointment.getAppointmentStatus());
    }
}
