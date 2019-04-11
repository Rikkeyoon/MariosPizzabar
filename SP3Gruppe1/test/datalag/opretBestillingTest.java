package datalag;

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
        String[] input = {"1", "2", "18:00:00"};
        FakeUI ui = new FakeUI(input);
        DBFacade db = new DBFacade(ui);
        
        // act
        db.opretBestilling();
        db.hentBestillinger();
        
        // assert
        assertTrue(ui.output.get(3).contains("1"));
    }
    
    
    
}
