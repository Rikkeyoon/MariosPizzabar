package main;

import datalag.FakeDBFacade;
import presentation.SystemUI;

/*
 * @author Nina, Rikke og Caroline
 */

public class SP3Gruppe1 {
   
    public static void main(String[] args) {
        SystemUI ui = new SystemUI();
        FakeDBFacade fakeDB = new FakeDBFacade(ui);
        fakeDB.visMenukort();
       
    }

}
