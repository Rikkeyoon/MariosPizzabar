package datalag;

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
        String[] input = {"1"};
        FakeUI ui = new FakeUI(input);
        DBFacade db = new DBFacade(ui);
        
        // act
        db.gemBestilling();
        db.hentGemteBestillinger();
        
        // assert
        assertTrue(ui.output.get(0).contains("1"));
    }
    
}
