package datalag;

import businesslogic.Controller;
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
        String[] input = {"2", "1", "0"};
        FakeUI ui = new FakeUI(input);
        DBFacade db = new DBFacade();
        Controller ctrl = new Controller(ui, db);
        
        // act
        ctrl.start();
        
        // assert
        assertTrue(ui.output.get(4).contains("1"));
        
    }
}
