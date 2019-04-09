package datalag;

import org.junit.Test;
import static org.junit.Assert.*;
import presentation.FakeUI;

/**
 *
 * @author Caroline, Rikke og Nina
 */
public class gemBestillingerTest {
    
    @Test 
    public void testGemBestillinger() {
        // arrange
        String[] input = {};
        FakeUI ui = new FakeUI(input);
        DBFacade db = new DBFacade(ui);
        
        // act
        db.gemBestillinger();
        
        // assert
        assertTrue(ui.output.get(0).contains("1"));
    }
    
}
