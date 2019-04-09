package datalag;

import org.junit.Test;
import static org.junit.Assert.*;
import presentation.FakeUI;

/*
 *
 * @author Nina, Rikke og Caroline
 */
public class visBestillingerTest {
    
    @Test 
    public void testVisBestillinger() {
        // arrange
        String[] input = {};
        FakeUI ui = new FakeUI(input);
        DBFacade db = new DBFacade(ui);
        
        // act
        db.visBestillinger();
        
        // assert
        assertTrue(ui.output.get(0).contains("1"));
    }
}
