package businesslogic;

import datalag.DBFacade;
import java.time.LocalTime;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import presentation.UI;

/*
 * @author Nina, Rikke og Caroline
 */
public class Controller {

    private UI ui;
    private DBFacade db;
    private ArrayList<Bestilling> bestillinger;
    private ArrayList<Bestilling> gemteBestillinger;
    private Comparator<Bestilling> compareAfhentTid;
    private int pizzaNr;
    private int antal;
    private LocalTime afhentTid;
    private int bestilNr = 1;
  
    public Controller(UI ui, DBFacade db) {
        this.compareAfhentTid = (Bestilling bestil1, Bestilling bestil2) -> {
            return bestil1.getAfhentTid().compareTo(bestil2.getAfhentTid());
        };
        this.ui = ui;
        this.db = db;
    }

    public void start() {
        boolean quit = false;
        ui.visHovedmenu();

        do {
            switch (ui.hovedmenuValg()) {
                case "1":
                    visMenukort();
                    break;
                case "2":
                    ui.visBestillingsMenu();
                    do {
                        switch (ui.hovedmenuValg()) {
                            case "1":
                                visBestillinger();
                                break;
                            case "2":
                                opretBestilling();
                                break;
                            case "3":
                                fjernBestilling();
                                break;
                            case "4":
                                visGemteBestillinger();
                                break;
                            case "5":
                                quit = true;
                                start();
                                break;
                            case "0":
                                quit = true;
                                break;
                        }
                    } while (!quit);
                    break;
                case "0":
                    quit = true;
                    break;
                default:
                    throw new IllegalArgumentException();
            }
        } while (!quit);
    }
    
    public void opretBestilling() {
        //indlæs pizza nr
        pizzaNr = ui.vælgPizzaNr();
        
        //indlæs antal pizzaer
        antal = ui.vælgAntal();
        
        //indlæs afhentningstidspunkt
        afhentTid = ui.vælgAfhentTid();
        
        //opret bestilling
        Bestillingslinje bestilLinje = new Bestillingslinje(antal, pizzaNr);
        Bestilling bestilling = new Bestilling(bestilNr, afhentTid, bestilLinje);
        
        //gem bestilling i DB
        db.gemBestilling(bestilling);
        db.gemBestillingslinje(bestilling);
        
        //increment bestilNr
        bestilNr++;
    }
    
    private void fjernBestilling() {
        int brugerValg = ui.vælgBestilNrPåBestillingSomGemmes();
        db.gemAfsluttetBestilling(brugerValg);
    }
    
    public ArrayList<Bestilling> sorterBestillinger() {
        //sorter bestillingsliste efter den, som skal afhentes først
        Collections.sort(bestillinger, compareAfhentTid);
        return bestillinger;
    }

    private void visMenukort() {
        ArrayList<Pizza> menukort = db.hentMenukort();
        ui.visMenukort(menukort);
    }

    private void visBestillinger() {
        bestillinger = db.hentBestillinger();
        sorterBestillinger();
        ui.visBestillinger(bestillinger);
    }

    private void visGemteBestillinger() {
        gemteBestillinger = db.hentGemteBestillinger();
        ui.visGemteBestillinger(bestillinger);
    }

    
}




