import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

public class PatientTest {
@Test
    void testAddandRemovePatients()
{
Patient patient = new Patient("Test" , "01/01/2000" , "Addr" , "123");
Physiotherapist physiotherapist = new Physiotherapist("dr Test" , "Address" , "000");
Appointment appointment = new Appointment(patient , physiotherapist , "Massage Therapy" , "Slot 1");
assertTrue(patient.getAppointments().isEmpty());
patient.AddAppointment(appointment);
assertEquals(1 , patient.getAppointments().size());
patient.removeAppointment(appointment);
assertTrue(patient.getAppointments().isEmpty());


}

}
