
package datalag;

import org.junit.Test;
import static org.junit.Assert.*;
import presentation.FakeUI;

/*
 * @author Rikke, Caroline og Nina
 */
public class visMenukortTest {
    @Test
    public void testVisMenukort(){
        // arrange
        String[] input = {};
        FakeUI ui = new FakeUI(input);
        DBFacade db = new DBFacade(ui);
        
        // act
        db.visMenukort();
        
        // assert
        assertTrue(ui.output.get(0).contains("Vesuvio"));
        
    }
 
    
}
