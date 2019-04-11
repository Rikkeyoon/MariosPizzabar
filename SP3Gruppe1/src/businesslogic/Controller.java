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
    private Comparator<Bestilling> compareAfhentTid;
    private int pizzaNr;
    private int antal;
    private LocalTime afhentTid;
  
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
                    db.visMenukort();
                    break;
                case "2":
                    ui.visBestillingsMenu();
                    do {
                        switch (ui.hovedmenuValg()) {
                            case "1":
                                db.visBestillinger();
                                break;
                            case "2":
                                opretBestilling();
                                break;
                            case "3":
                                db.gemBestilling();
                                break;
                            case "4":
                                db.visGemteBestillinger();
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
        Bestilling bestilling = new Bestilling(afhentTid, bestilLinje);
        
        //gem bestilling i DB
        db.opretBestilling(bestilling);
    }
    
    public ArrayList<Bestilling> sorterBestillinger() {
        //sorter bestillingsliste efter den, som skal afhentes først
        Collections.sort(bestillinger, compareAfhentTid);
        return bestillinger;
    }
}




