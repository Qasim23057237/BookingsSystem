import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

public class PhysiotherapistTest {

    @Test
    void testExpertiseandtimetable()
    {
        Physiotherapist physiotherapist = new Physiotherapist("Dr Test" , "AddressTest" , "1200");
        physiotherapist.addexpertise("Physiotherapy");
        assertTrue(physiotherapist.getExpertise().contains("Physiotherapy"));
physiotherapist.addTreatment("Physiotherapy" , "Massage Therapy");
        physiotherapist.addtimetable("Physiotherapy" , "Massage Therapy" , "2025-05-01" , "10:00 - 11:00" );
        assertEquals(4, physiotherapist.getTimeTable().size());

        String first = physiotherapist.getTimeTable().get(0);
        assertTrue(first.contains("Massage Therapy"));
        assertTrue(first.contains("WEEK 1"));
        physiotherapist.addtimetable("Physiotherapy" , "Massage Therapy" , "2025-05-01" , "10:00 - 11:00" );
        assertEquals(4, physiotherapist.getTimeTable().size());


    }
}
