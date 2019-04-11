package datalag;

import businesslogic.Controller;
import org.junit.Test;
import static org.junit.Assert.*;
import presentation.FakeUI;

/*
 * @author Rikke, Caroline og Nina
 */
public class opretBestillingTest {
    
    @Test
    public void testOpretBestilling(){
         // arrange
        String[] input = {"2", "2", "4", "3", "12:00", "0"};
        FakeUI ui = new FakeUI(input);
        DBFacade db = new DBFacade();
        Controller ctrl = new Controller(ui, db);
        
        // act
        ctrl.start();
        
        // assert
        assertTrue(ctrl.getBestillinger().size() == 1);
    }
    
    
    
}
