package businesslogic;

import datalag.DBFacade;
import java.util.ArrayList;
import presentation.UI;

/*
 * @author Nina, Rikke og Caroline
 */
public class Controller {

    private UI ui;
    private DBFacade db;
  
    public Controller(UI ui, DBFacade db) {
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
                    db.visBestillinger();
                    do {
                        switch (ui.hovedmenuValg()) {
                            case "1":
                                db.opretBestilling();
                                break;
                            case "2":
                                db.gemBestilling();
                                break;
                            case "3":
                                db.visGemteBestillinger();
                            case "4":
                                quit = true;
                                start();
                                break;
                            case "5":
                                quit = true;
                                break;
                        }
                    } while (!quit);
                    break;
                case "3":
                    quit = true;
                    break;
                default:
                    throw new IllegalArgumentException();
            }
        } while (!quit);
    }
}




