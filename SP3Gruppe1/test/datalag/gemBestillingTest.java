package datalag;

import businesslogic.Controller;
import org.junit.Test;
import static org.junit.Assert.*;
import presentation.FakeUI;

/**
 *
 * @author Caroline, Rikke og Nina
 */
public class gemBestillingTest {
    
    @Test 
    public void testGemBestilling_VisGemteBestillinger() {
        // arrange
        String[] input = {"2", "2", "5", "3", "18:00", "3", "1", "4", "0"};
        FakeUI ui = new FakeUI(input);
        DBFacade db = new DBFacade();
        Controller ctrl = new Controller(ui, db);
        
        // act
        ctrl.start();
        
        // assert
        assertTrue(ui.output.get(8).contains("Afhentningstidspunkt"));
    }
    
}
