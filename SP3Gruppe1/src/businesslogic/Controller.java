package businesslogic;

import datalag.DBFacade;
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
    Comparator<Bestilling> compareAfhentTid;
  
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
                                db.opretBestilling();
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
    
    public ArrayList<Bestilling> sorterBestillinger(ArrayList<Bestilling> bestillinger) {
        //sorter bestillingsliste efter den, som skal afhentes først
        Collections.sort(bestillinger, compareAfhentTid);
        return bestillinger;
    }
}




