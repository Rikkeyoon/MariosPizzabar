package main;

import datalag.DBFacade;
import presentation.SystemUI;

/*
 * @author Nina, Rikke og Caroline
 */

public class SP3Gruppe1 {
   
    public static void main(String[] args) {
        SystemUI ui = new SystemUI();
        DBFacade db = new DBFacade(ui);
        db.visMenukort();
       
    }

}
